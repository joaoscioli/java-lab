package daily_question.MinimumJumpsReachEndPrimeTeleportation;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/// Solves the minimum jumps problem with optional prime-based teleportation.
///
/// The algorithm models the array as an unweighted graph where each index can move to:
///
/// - the previous index;
/// - the next index;
/// - any index whose value is divisible by the prime value at the current index.
///
/// A breadth-first search is used to guarantee the minimum number of jumps.
///
/// Prime factorization is optimized with a precomputed smallest prime factor table.
class Solution {
    /// Maximum supported value in the input array.
    ///
    /// This value defines the upper bound for the smallest prime factor sieve.
    private static final int MAX_VALUE = 1_000_000;

    /// Precomputed smallest prime factor for every value from `0` to `MAX_VALUE`.
    ///
    /// For a prime number `p`, `SMALLEST_PRIME_FACTOR[p] == p`.
    private static final int[] SMALLEST_PRIME_FACTOR = buildSmallestPrimeFactor();

    /// Returns the minimum number of jumps required to reach the last index.
    ///
    /// From each index, it is possible to jump to:
    ///
    /// - `index - 1`, if it exists;
    /// - `index + 1`, if it exists;
    /// - every index whose value is divisible by `nums[index]`, but only when
    ///   `nums[index]` is prime.
    ///
    /// Prime teleportation for the same prime value is processed only once to avoid
    /// repeated work and keep the BFS efficient.
    ///
    /// @param nums the array of positive integers
    /// @return the minimum number of jumps needed to reach the last index, or `-1`
    ///         if the last index cannot be reached
    public int minJumps(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return 0;
        }

        Set<Integer> primeValues = new HashSet<>();

        for (int value : nums) {
            if (isPrime(value)) {
                primeValues.add(value);
            }
        }

        if (primeValues.isEmpty()) {
            return n - 1;
        }

        Map<Integer, List<Integer>> divisibleByPrime = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int value = nums[i];

            while (value > 1) {
                int prime = SMALLEST_PRIME_FACTOR[value];

                if (primeValues.contains(prime)) {
                    divisibleByPrime
                            .computeIfAbsent(prime, key -> new ArrayList<>())
                            .add(i);
                }

                while (value % prime == 0) {
                    value /= prime;
                }
            }
        }

        boolean[] visited = new boolean[n];
        Set<Integer> usedPrimeTeleportation = new HashSet<>();

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visited[0] = true;

        int jumps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int count = 0; count < size; count++) {
                int index = queue.poll();

                if (index == n - 1) {
                    return jumps;
                }

                int previous = index - 1;
                int next = index + 1;

                if (previous >= 0 && !visited[previous]) {
                    visited[previous] = true;
                    queue.offer(previous);
                }

                if (next < n && !visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }

                int value = nums[index];

                if (isPrime(value) && usedPrimeTeleportation.add(value)) {
                    List<Integer> teleportTargets = divisibleByPrime.remove(value);

                    if (teleportTargets != null) {
                        for (int target : teleportTargets) {
                            if (!visited[target]) {
                                visited[target] = true;
                                queue.offer(target);
                            }
                        }
                    }
                }
            }

            jumps++;
        }

        return -1;
    }

    /// Builds the smallest prime factor table using a sieve.
    ///
    /// The returned array stores the smallest prime divisor for each number from
    /// `0` to `MAX_VALUE`.
    ///
    /// For example:
    ///
    /// - `smallestPrimeFactor[2] == 2`;
    /// - `smallestPrimeFactor[6] == 2`;
    /// - `smallestPrimeFactor[15] == 3`.
    ///
    /// @return an array containing the smallest prime factor for each supported value
    private static int[] buildSmallestPrimeFactor() {
        int[] smallestPrimeFactor = new int[MAX_VALUE + 1];

        for (int value = 2; value <= MAX_VALUE; value++) {
            if (smallestPrimeFactor[value] == 0) {
                smallestPrimeFactor[value] = value;

                if ((long) value * value <= MAX_VALUE) {
                    for (int multiple = value * value; multiple <= MAX_VALUE; multiple += value) {
                        if (smallestPrimeFactor[multiple] == 0) {
                            smallestPrimeFactor[multiple] = value;
                        }
                    }
                }
            }
        }

        return smallestPrimeFactor;
    }

    /// Checks whether a value is prime.
    ///
    /// The check uses the precomputed smallest prime factor table.
    /// A value is prime when it is at least `2` and its smallest prime factor is
    /// the value itself.
    ///
    /// @param value the value to check
    /// @return `true` if the value is prime, otherwise `false`
    private static boolean isPrime(int value) {
        return value >= 2 && SMALLEST_PRIME_FACTOR[value] == value;
    }
}