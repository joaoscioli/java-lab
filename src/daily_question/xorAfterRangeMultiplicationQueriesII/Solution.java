package daily_question.xorAfterRangeMultiplicationQueriesII;

import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;

    /// ### Fast Modular Exponentiation
    ///
    /// Computes `(base ^ exp) % MOD` using binary exponentiation.
    ///
    /// **Time Complexity:** `O(log exp)`
    ///
    /// @param base The base value.
    /// @param exp The exponent value.
    /// @return The result of `(base^exp) % MOD`.
    private long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }

    /// ### Modular Multiplicative Inverse
    ///
    /// Computes the modular inverse of `n` under modulo `MOD` using
    /// **Fermat's Little Theorem**:
    ///
    /// `n^(-1) ≡ n^(MOD-2) (mod MOD)`
    ///
    /// **Assumption:** `MOD` is prime.
    ///
    /// @param n The number to invert.
    /// @return Modular inverse of `n`.
    private long modInv(long n) {
        return power(n, MOD - 2);
    }

    /// ### XOR After Range Multiplication Queries II
    ///
    /// Applies a sequence of queries to the input array `nums`, where each query
    /// multiplies elements at positions:
    ///
    /// `i = l, l + k, l + 2k, ..., ≤ r`
    ///
    /// by a value `v`, under modulo `1e9 + 7`.
    ///
    /// ---
    ///
    /// ### Optimization Strategy (√ Decomposition)
    ///
    /// Queries are divided into two categories:
    ///
    /// #### 1. Heavy Queries (`k >= sqrt(n)`)
    /// - Affect relatively few elements.
    /// - Processed directly using iteration.
    ///
    /// #### 2. Light Queries (`k < sqrt(n)`)
    /// - Affect many elements.
    /// - Grouped by `k` and processed using a **difference array with step `k`**.
    ///
    /// ---
    ///
    /// ### Key Technique for Light Queries
    ///
    /// - Use a multiplicative difference array `diff[]`
    /// - Apply updates at:
    ///   - `diff[l] *= v`
    ///   - `diff[next] *= inverse(v)` to stop propagation
    /// - Propagate values using:
    ///
    /// ```
    /// diff[i] *= diff[i - k]
    /// ```
    ///
    /// This efficiently simulates range updates with step size `k`.
    ///
    /// ---
    ///
    /// ### Final Step
    ///
    /// After applying all transformations:
    /// - Compute the **bitwise XOR** of all elements in `nums`
    ///
    /// ---
    ///
    /// ### Complexity
    ///
    /// - Time: `O((n + q) * sqrt(n))`
    /// - Space: `O(n)`
    ///
    /// ---
    ///
    /// @param nums The input array.
    /// @param queries Each query is `[l, r, k, v]`.
    /// @return The XOR of all elements after processing all queries.
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int limit = (int) Math.sqrt(n);

        Map<Integer, List<int[]>> lightK = new HashMap<>();

        // Process queries
        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];

            // Heavy case: direct update
            if (k >= limit) {
                for (int i = l; i <= r; i += k) {
                    nums[i] = (int) ((1L * nums[i] * v) % MOD);
                }
            } else {
                // Light case: group by k
                lightK.computeIfAbsent(k, x -> new ArrayList<>()).add(q);
            }
        }

        // Process light k groups
        for (Map.Entry<Integer, List<int[]>> entry : lightK.entrySet()) {
            int k = entry.getKey();
            List<int[]> queryList = entry.getValue();

            long[] diff = new long[n];
            Arrays.fill(diff, 1L);

            // Apply difference updates
            for (int[] q : queryList) {
                int l = q[0], r = q[1], v = q[3];

                diff[l] = (diff[l] * v) % MOD;

                int steps = (r - l) / k;
                int next = l + (steps + 1) * k;
                if (next < n) {
                    diff[next] = (diff[next] * modInv(v)) % MOD;
                }
            }

            // Propagate updates and apply to nums
            for (int i = 0; i < n; i++) {
                if (i >= k) {
                    diff[i] = (diff[i] * diff[i - k]) % MOD;
                }
                nums[i] = (int) ((1L * nums[i] * diff[i]) % MOD);
            }
        }

        // Compute final XOR
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }

        return ans;
    }
}