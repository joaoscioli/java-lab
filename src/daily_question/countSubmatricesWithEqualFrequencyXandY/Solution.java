package daily_question.countSubmatricesWithEqualFrequencyXandY;

class Solution {

    /// ### Overview
    /// Counts the number of submatrices that:
    /// - Include the top-left cell `(0, 0)`
    /// - Contain an equal number of `'X'` and `'Y'`
    /// - Contain at least one `'X'`
    ///
    /// ### Approach
    /// The solution uses **2D prefix sums** to efficiently evaluate all valid submatrices
    /// that start at `(0, 0)` and end at `(i, j)`.
    ///
    /// Two prefix matrices are constructed:
    ///
    /// 1. **sum[][]**
    ///    - Transforms the grid into numeric values:
    ///      - `'X' → +1`
    ///      - `'Y' → -1`
    ///      - `'.' → 0`
    ///    - Allows checking if a submatrix has equal numbers of `'X'` and `'Y'`
    ///      by verifying if the total sum is `0`.
    ///
    /// 2. **countX[][]**
    ///    - Tracks the number of `'X'` characters in each submatrix.
    ///    - Ensures the submatrix contains **at least one `'X'`**.
    ///
    /// ### Key Insight
    /// Since every valid submatrix must include `(0, 0)`, we only need to evaluate
    /// prefix submatrices of the form `(0,0) → (i,j)`, reducing complexity significantly.
    ///
    /// ### Algorithm
    /// 1. Build the prefix sum matrices `sum` and `countX`.
    /// 2. Iterate over all possible bottom-right corners `(i, j)`.
    /// 3. For each submatrix:
    ///    - Check if `sum[i+1][j+1] == 0` (equal 'X' and 'Y')
    ///    - Check if `countX[i+1][j+1] > 0` (at least one 'X')
    /// 4. Count all valid submatrices.
    ///
    /// ### Complexity
    /// - Time Complexity: **O(m × n)**
    /// - Space Complexity: **O(m × n)**
    ///
    /// ### Parameters
    /// - `grid`: A 2D character matrix where each cell is `'X'`, `'Y'`, or `'.'`
    ///
    /// ### Returns
    /// - The number of valid submatrices satisfying all conditions
    ///
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] sum = new int[m + 1][n + 1];
        int[][] countX = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = 0;
                if (grid[i][j] == 'X') val = 1;
                else if (grid[i][j] == 'Y') val = -1;

                sum[i + 1][j + 1] = val
                        + sum[i][j + 1]
                        + sum[i + 1][j]
                        - sum[i][j];

                countX[i + 1][j + 1] = (grid[i][j] == 'X' ? 1 : 0)
                        + countX[i][j + 1]
                        + countX[i + 1][j]
                        - countX[i][j];
            }
        }

        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int total = sum[i + 1][j + 1];
                int xCount = countX[i + 1][j + 1];

                if (total == 0 && xCount > 0) {
                    result++;
                }
            }
        }

        return result;
    }
}