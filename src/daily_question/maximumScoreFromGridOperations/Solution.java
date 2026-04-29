package daily_question.maximumScoreFromGridOperations;

///
/// ## Overview
///
/// Computes the maximum score achievable from grid operations using
/// a dynamic programming approach optimized for column-wise traversal.
///
/// The algorithm iterates through the grid columns while maintaining
/// two DP arrays to track cumulative scores from different traversal
/// directions (top-down and bottom-up).
///
/// ## Approach
///
/// - Uses two dynamic programming arrays:
///   - `dp1`: Tracks scores when traversing from top to bottom
///   - `dp2`: Tracks scores when traversing from bottom to top
/// - Iterates column by column, updating the best possible score
/// - Maintains rolling variables (`prev1`, `prev2`, `res`) to store
///   intermediate maximum values
///
/// ## Time Complexity
///
/// - **O(n²)**, where `n` is the grid dimension
///
/// ## Space Complexity
///
/// - **O(n)** for the DP arrays
///
class Solution {

    ///
    /// ### maximumScore
    ///
    /// Calculates the maximum score obtainable from the grid.
    ///
    /// #### Parameters
    /// - `grid`: A square matrix of integers representing scores
    ///
    /// #### Returns
    /// - The maximum achievable score as a `long`
    ///
    /// #### Details
    /// - Iterates through each column except the last
    /// - Uses helper function `score` to compute cumulative values
    /// - Combines results from forward and backward traversals
    ///
    public long maximumScore(int[][] grid) {
        int n = grid.length;
        long[] dp1 = new long[n];
        long[] dp2 = new long[n];
        long res = 0, prev1 = 0, prev2 = 0;
        int i = 0;

        while (i < n - 1) {
            long curr = score(grid, dp1, i, prev1, 0, 1, n);
            prev1 = Math.max(res, prev2);
            prev2 = score(grid, dp2, i + 1, res, n - 1, -1, -1);
            res = Math.max(prev1, curr);
            i++;
        }

        return Math.max(res, prev2);
    }

    ///
    /// ### score
    ///
    /// Computes the cumulative score for a given column traversal.
    ///
    /// #### Parameters
    /// - `grid`: The input matrix
    /// - `dp`: DP array storing intermediate results
    /// - `col`: Current column index
    /// - `prev`: Previous accumulated value
    /// - `row`: Starting row index
    /// - `dir`: Direction of traversal (`1` for down, `-1` for up)
    /// - `stop`: Boundary condition for traversal
    ///
    /// #### Returns
    /// - The maximum cumulative score for the given traversal
    ///
    /// #### Details
    /// - Iterates through rows in the specified direction
    /// - Updates DP values in-place
    /// - Maintains a running maximum score
    ///
    long score(int[][] grid, long[] dp, int col, long prev, int row, int dir, int stop) {
        long max = 0;

        while (row != stop) {
            max = Math.max(max, prev);
            prev = dp[row];
            max += grid[row][col];
            dp[row] = max;
            row += dir;
        }

        return max;
    }
}