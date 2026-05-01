package daily_question.maximumPathScoreGrid;

import java.util.Arrays;

class Solution {

    /// ### maxPathScore
    ///
    /// Computes the **maximum path score** from the top-left corner `(0,0)` to the
    /// bottom-right corner `(m-1, n-1)` in a 2D grid.
    ///
    /// The movement is restricted to:
    /// - Right `(i, j+1)`
    /// - Down `(i+1, j)`
    ///
    /// ---
    ///
    /// ### Rules
    ///
    /// - Each cell contributes its value to the total score.
    /// - You may include **at most `k` positive cells** in the path.
    /// - Negative and zero values do not consume this limit.
    /// - If no valid path satisfies the constraint, return `-1`.
    ///
    /// ---
    ///
    /// ### Approach
    ///
    /// This solution uses **Dynamic Programming (DP)** with state compression:
    ///
    /// - `prev[j][c]`: Maximum score reaching column `j` using `c` positive cells
    ///   from the previous row.
    /// - `curr[j][c]`: Current row state.
    ///
    /// For each cell:
    /// - Determine if it consumes a "positive slot" (`need = 1 if value > 0`).
    /// - Transition from:
    ///   - Top (`prev[j]`)
    ///   - Left (`curr[j-1]`)
    /// - Keep track of the best possible score.
    ///
    /// Invalid states are represented using a large negative sentinel value.
    ///
    /// ---
    ///
    /// ### Time Complexity
    ///
    /// - `O(m * n * k)`
    ///
    /// ### Space Complexity
    ///
    /// - `O(n * k)` (optimized from full 3D DP)
    ///
    /// ---
    ///
    /// ### Parameters
    ///
    /// - `grid`: 2D integer matrix representing the score of each cell.
    /// - `k`: Maximum number of positive cells allowed in the path.
    ///
    /// ---
    ///
    /// ### Returns
    ///
    /// - The maximum achievable score under constraints.
    /// - Returns `-1` if no valid path exists.
    ///
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        final int NEG = -1_000_000_000;

        int[][] prev = new int[n][k + 1];
        for (int j = 0; j < n; j++) {
            Arrays.fill(prev[j], NEG);
        }

        for (int i = 0; i < m; i++) {
            int[][] curr = new int[n][k + 1];
            for (int j = 0; j < n; j++) {
                Arrays.fill(curr[j], NEG);
            }

            for (int j = 0; j < n; j++) {
                int gain = grid[i][j];
                int need = gain > 0 ? 1 : 0;

                int limit = Math.min(k, i + j);

                if (i == 0 && j == 0) {
                    curr[0][0] = 0;
                    continue;
                }

                for (int c = need; c <= limit; c++) {
                    int best = NEG;

                    if (i > 0 && prev[j][c - need] != NEG) {
                        best = Math.max(best, prev[j][c - need] + gain);
                    }

                    if (j > 0 && curr[j - 1][c - need] != NEG) {
                        best = Math.max(best, curr[j - 1][c - need] + gain);
                    }

                    curr[j][c] = best;
                }
            }

            prev = curr;
        }

        int ans = NEG;
        for (int c = 0; c <= k; c++) {
            ans = Math.max(ans, prev[n - 1][c]);
        }

        return ans < 0 ? -1 : ans;
    }
}