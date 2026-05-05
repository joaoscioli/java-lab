package daily_question.RotateImage;

/// Provides a solution for rotating a square matrix by 90 degrees clockwise.
///
/// The rotation is performed **in-place**, meaning the original matrix is
/// modified directly without allocating another matrix.
///
/// The algorithm works in two main steps:
///
/// 1. **Transpose the matrix**
///    - Swap `matrix[i][j]` with `matrix[j][i]`.
///    - This converts rows into columns.
///
/// 2. **Reverse each row**
///    - After transposition, reversing every row completes the
///      90-degree clockwise rotation.
///
/// ## Example
///
/// ```java
/// int[][] matrix = {
///     {1, 2, 3},
///     {4, 5, 6},
///     {7, 8, 9}
/// };
///
/// new Solution().rotate(matrix);
///
/// // matrix becomes:
/// // {
/// //     {7, 4, 1},
/// //     {8, 5, 2},
/// //     {9, 6, 3}
/// // }
/// ```
///
/// ## Complexity
///
/// - Time complexity: `O(n²)`, where `n` is the number of rows and columns.
/// - Space complexity: `O(1)`, since the matrix is modified in-place.
class Solution {

    /// Rotates the given `n x n` matrix by 90 degrees clockwise in-place.
    ///
    /// This method first transposes the matrix across its main diagonal,
    /// then reverses each row to produce the clockwise rotation.
    ///
    /// ## Parameters
    ///
    /// - `matrix`: The square matrix to rotate. It must have the same number
    ///   of rows and columns.
    ///
    /// ## Example
    ///
    /// ```java
    /// int[][] matrix = {
    ///     {5, 1, 9, 11},
    ///     {2, 4, 8, 10},
    ///     {13, 3, 6, 7},
    ///     {15, 14, 12, 16}
    /// };
    ///
    /// new Solution().rotate(matrix);
    ///
    /// // matrix becomes:
    /// // {
    /// //     {15, 13, 2, 5},
    /// //     {14, 3, 4, 1},
    /// //     {12, 6, 8, 9},
    /// //     {16, 7, 10, 11}
    /// // }
    /// ```
    ///
    /// ## Complexity
    ///
    /// - Time complexity: `O(n²)`.
    /// - Space complexity: `O(1)`.
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}