package daily_question.largestMagicSquare;

class Solution {

    /// ## Largest Magic Square
    ///
    /// A **magic square** is a square grid where:
    /// - All rows have the same sum
    /// - All columns have the same sum
    /// - Both diagonals have the same sum
    ///
    /// This method finds the **largest size `k`** of a magic square
    /// that exists within the given 2D grid.
    ///
    /// ### Optimization Strategy
    /// - Use **prefix sums** for rows and columns to compute row/column
    ///   sums in **O(1)** time.
    /// - Iterate over possible square sizes from **largest to smallest**
    ///   to allow early termination as soon as a valid magic square is found.
    ///
    /// ### Approach
    /// 1. Precompute prefix sums:
    ///    - `row[i][j]` stores the sum of row `i` up to column `j - 1`
    ///    - `col[i][j]` stores the sum of column `j` up to row `i - 1`
    /// 2. For each possible square size `k` (starting from the largest):
    ///    - Check every `k × k` subgrid.
    ///    - Use the first row as the target sum.
    ///    - Validate all rows and columns using prefix sums.
    ///    - Validate both diagonals explicitly.
    ///
    /// ### Key Observation
    /// - Any single cell is trivially a magic square of size `1`.
    ///
    /// ### Example
    /// ```
    /// Input:
    /// grid = [[7,1,4,5,6],
    ///         [2,5,1,6,4],
    ///         [1,5,4,3,2],
    ///         [1,2,7,3,4]]
    ///
    /// Output: 3
    /// ```
    ///
    /// ### Time Complexity
    /// - **O(min(m, n) · m · n)** — checking all square sizes and positions.
    ///
    /// ### Space Complexity
    /// - **O(m · n)** — prefix sum arrays.
    ///
    /// @param grid a 2D integer matrix
    /// @return the size of the largest magic square found
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        /// Prefix sums for rows and columns
        int[][] row = new int[m][n + 1];
        int[][] col = new int[m + 1][n];

        /// Build prefix sum tables
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i][j + 1] = row[i][j] + grid[i][j];
                col[i + 1][j] = col[i][j] + grid[i][j];
            }
        }

        /// Try square sizes from largest to smallest
        for (int k = Math.min(m, n); k >= 2; k--) {
            for (int i = 0; i + k <= m; i++) {
                for (int j = 0; j + k <= n; j++) {

                    /// Target sum: first row of the square
                    int target = row[i][j + k] - row[i][j];
                    boolean ok = true;

                    /// Check all rows
                    for (int r = 0; r < k && ok; r++) {
                        if (row[i + r][j + k] - row[i + r][j] != target)
                            ok = false;
                    }

                    /// Check all columns
                    for (int c = 0; c < k && ok; c++) {
                        if (col[i + k][j + c] - col[i][j + c] != target)
                            ok = false;
                    }

                    /// Check both diagonals
                    if (ok) {
                        int d1 = 0, d2 = 0;
                        for (int t = 0; t < k; t++) {
                            d1 += grid[i + t][j + t];
                            d2 += grid[i + t][j + k - 1 - t];
                        }

                        if (d1 == target && d2 == target)
                            return k;
                    }
                }
            }
        }

        /// At minimum, a single cell is always a magic square
        return 1;
    }
}
