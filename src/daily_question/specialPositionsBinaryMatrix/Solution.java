package daily_question.specialPositionsBinaryMatrix;

/// ## Solution
///
/// Provides a solution to the **"Special Positions in a Binary Matrix"** problem.
///
/// A position `(i, j)` in a binary matrix is considered **special** if:
/// - `mat[i][j] == 1`
/// - All other elements in row `i` are `0`
/// - All other elements in column `j` are `0`
///
/// ### Approach
///
/// The algorithm works in two main phases:
///
/// 1. **Counting Phase**
///    - Traverse the matrix once.
///    - Count how many `1`s appear in each row.
///    - Count how many `1`s appear in each column.
///
/// 2. **Validation Phase**
///    - Traverse the matrix again.
///    - For each cell containing `1`, check:
///      - The corresponding row count is exactly `1`.
///      - The corresponding column count is exactly `1`.
///    - If both conditions are satisfied, increment the special position counter.
///
/// ### Time Complexity
/// - **O(m × n)**
///   The matrix is traversed twice.
///
/// ### Space Complexity
/// - **O(m + n)**
///   Additional arrays are used to store row and column counts.
///
/// ### Example
///
/// ```
/// Input:
/// mat = [
///   [1,0,0],
///   [0,0,1],
///   [1,0,0]
/// ]
///
/// Output:
/// 1
/// ```
///
/// Only one position satisfies the special position conditions.
class Solution {

    /// Counts the number of special positions in a binary matrix.
    ///
    /// @param mat a 2D binary matrix containing only `0`s and `1`s
    /// @return the number of special positions in the matrix
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        // Counting phase
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        int specialPositions = 0;

        // Validation phase
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 &&
                        rowCount[i] == 1 &&
                        colCount[j] == 1) {
                    specialPositions++;
                }
            }
        }

        return specialPositions;
    }
}