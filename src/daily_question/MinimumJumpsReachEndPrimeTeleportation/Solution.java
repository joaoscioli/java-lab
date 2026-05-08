package daily_question.MinimumJumpsReachEndPrimeTeleportation;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
    private static final int MAX_VALUE = 1_000_000;
    private static final int[] SMALLEST_PRIME_FACTOR = buildSmallestPrimeFactor();

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

    private static boolean isPrime(int value) {
        return value >= 2 && SMALLEST_PRIME_FACTOR[value] == value;
    }
}