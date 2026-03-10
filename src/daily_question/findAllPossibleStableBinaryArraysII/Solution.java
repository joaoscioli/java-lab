package daily_question.findAllPossibleStableBinaryArraysII;

class Solution {

    /// # Find All Possible Stable Binary Arrays II
    ///
    /// This method calculates the number of **stable binary arrays** that can be
    /// formed using a given number of `0`s and `1`s while respecting a maximum
    /// consecutive repetition limit.
    ///
    /// A binary array is considered **stable** if:
    /// - It contains exactly `zero` occurrences of `0`.
    /// - It contains exactly `one` occurrences of `1`.
    /// - No subarray longer than `limit` contains only the same value.
    ///
    /// In other words, there cannot be more than `limit` consecutive `0`s
    /// or more than `limit` consecutive `1`s.
    ///
    /// ---
    ///
    /// ## Approach
    ///
    /// The solution uses **dynamic programming** with two DP tables:
    ///
    /// - `dp0[i][j]` → number of valid arrays using `i` zeros and `j` ones
    ///   that **end with `0`**.
    /// - `dp1[i][j]` → number of valid arrays using `i` zeros and `j` ones
    ///   that **end with `1`**.
    ///
    /// The transitions work as follows:
    ///
    /// - To end with `0`, append `0` to sequences that previously ended with
    ///   either `0` or `1`.
    /// - To end with `1`, append `1` to sequences that previously ended with
    ///   either `0` or `1`.
    ///
    /// However, if adding another element would create a sequence longer
    /// than `limit`, those invalid cases are subtracted from the DP value.
    ///
    /// The subtraction ensures that sequences exceeding the allowed
    /// consecutive limit are excluded.
    ///
    /// ---
    ///
    /// ## Initialization
    ///
    /// - Arrays containing only `0`s are valid only up to length `limit`.
    /// - Arrays containing only `1`s are valid only up to length `limit`.
    ///
    /// These base cases populate the first column (`dp0`) and first row (`dp1`)
    /// of the DP tables.
    ///
    /// ---
    ///
    /// ## Result
    ///
    /// The final result is the sum of arrays that end in `0`
    /// and arrays that end in `1`:
    ///
    /// ```text
    /// result = dp0[zero][one] + dp1[zero][one]
    /// ```
    ///
    /// The result is returned modulo **1_000_000_007** to prevent overflow.
    ///
    /// ---
    ///
    /// ## Complexity
    ///
    /// - **Time Complexity:** `O(zero × one)`
    /// - **Space Complexity:** `O(zero × one)`
    ///
    /// ---
    ///
    /// ## Parameters
    ///
    /// - `zero` — Total number of `0`s that must appear in the array.
    /// - `one` — Total number of `1`s that must appear in the array.
    /// - `limit` — Maximum number of identical consecutive elements allowed.
    ///
    /// ---
    ///
    /// ## Returns
    ///
    /// The total number of **stable binary arrays** satisfying the constraints,
    /// modulo `1_000_000_007`.
    ///
    static final int MOD = 1000000007;

    public int numberOfStableArrays(int zero, int one, int limit) {
        long[][] dp0 = new long[zero + 1][one + 1];
        long[][] dp1 = new long[zero + 1][one + 1];

        for (int i = 1; i <= Math.min(zero, limit); i++) {
            dp0[i][0] = 1;
        }

        for (int j = 1; j <= Math.min(one, limit); j++) {
            dp1[0][j] = 1;
        }

        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {
                if (i == 0 && j == 0) continue;

                if (i > 0 && j > 0) {
                    dp0[i][j] = (dp0[i - 1][j] + dp1[i - 1][j]) % MOD;
                    if (i - limit - 1 >= 0) {
                        dp0[i][j] = (dp0[i][j] - dp1[i - limit - 1][j] + MOD) % MOD;
                    }

                    dp1[i][j] = (dp1[i][j - 1] + dp0[i][j - 1]) % MOD;
                    if (j - limit - 1 >= 0) {
                        dp1[i][j] = (dp1[i][j] - dp0[i][j - limit - 1] + MOD) % MOD;
                    }
                }
            }
        }

        return (int)((dp0[zero][one] + dp1[zero][one]) % MOD);
    }
}