package daily_question.findAllPossibleStableBinaryArraysI;

class Solution {

    /// Constant used to apply modulo operations to avoid integer overflow.
    private static final int MOD = 1_000_000_007;

    /// Memoization table used for dynamic programming.
    ///
    /// Dimensions:
    /// - `z` → remaining zeros
    /// - `o` → remaining ones
    /// - `last` → last placed bit (`0` or `1`)
    /// - `streak` → current length of the consecutive sequence of the same bit
    ///
    /// Stores the number of valid stable arrays that can be formed from the
    /// given state.
    private Integer[][][][] memo;

    /// Calculates the number of **stable binary arrays** that can be formed
    /// using a given number of `0`s and `1`s with a constraint on the maximum
    /// allowed consecutive identical values.
    ///
    /// A binary array is considered **stable** if no more than `limit`
    /// identical elements appear consecutively.
    ///
    /// This method initializes the memoization structure and starts the
    /// recursive depth-first search by attempting to place either `0` or `1`
    /// as the first element.
    ///
    /// ### Parameters
    /// - `zero` : Number of `0`s available to place in the array
    /// - `one`  : Number of `1`s available to place in the array
    /// - `limit`: Maximum allowed length of consecutive equal values
    ///
    /// ### Returns
    /// The total number of valid stable arrays modulo `1_000_000_007`.
    ///
    /// ### Approach
    /// The algorithm uses **DFS with memoization (top-down dynamic programming)**.
    /// Each state is defined by:
    /// - remaining zeros
    /// - remaining ones
    /// - last placed bit
    /// - current consecutive streak
    ///
    /// Results are cached to avoid recomputation.
    ///
    /// ### Time Complexity
    /// `O(zero * one * limit)`
    ///
    /// ### Space Complexity
    /// `O(zero * one * limit)`
    public int numberOfStableArrays(int zero, int one, int limit) {
        memo = new Integer[zero + 1][one + 1][2][limit + 1];
        long res = 0;

        if (zero > 0)
            res += dfs(zero - 1, one, 0, 1, limit);

        if (one > 0)
            res += dfs(zero, one - 1, 1, 1, limit);

        return (int)(res % MOD);
    }

    /// Performs a **depth-first search with memoization** to count the number
    /// of valid stable binary arrays that can be constructed from the
    /// remaining elements.
    ///
    /// The recursion explores the possibility of placing either `0` or `1`
    /// depending on:
    /// - how many remain
    /// - the last placed value
    /// - the current streak length
    ///
    /// If the streak reaches the specified limit, the same value cannot
    /// be placed again consecutively.
    ///
    /// ### Parameters
    /// - `z` : Remaining number of `0`s
    /// - `o` : Remaining number of `1`s
    /// - `last` : The last placed value (`0` or `1`)
    /// - `streak` : Current length of consecutive occurrences of `last`
    /// - `limit` : Maximum allowed consecutive identical values
    ///
    /// ### Returns
    /// The number of valid stable arrays that can be formed from this state.
    ///
    /// ### Base Case
    /// When both `z` and `o` are `0`, a valid array configuration has been formed.
    private int dfs(int z, int o, int last, int streak, int limit) {
        if (z == 0 && o == 0)
            return 1;

        if (memo[z][o][last][streak] != null)
            return memo[z][o][last][streak];

        long ways = 0;

        if (last == 0) {
            if (z > 0 && streak < limit)
                ways += dfs(z - 1, o, 0, streak + 1, limit);

            if (o > 0)
                ways += dfs(z, o - 1, 1, 1, limit);

        } else {
            if (o > 0 && streak < limit)
                ways += dfs(z, o - 1, 1, streak + 1, limit);

            if (z > 0)
                ways += dfs(z - 1, o, 0, 1, limit);
        }

        ways %= MOD;
        return memo[z][o][last][streak] = (int) ways;
    }
}