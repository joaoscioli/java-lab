package daily_question.determineWhetherMatrixCanBeObtainedByRotation;

/// # Determine Whether Matrix Can Be Obtained By Rotation
///
/// This class provides a solution to determine whether a given square binary
/// matrix can be transformed into a target matrix by applying a series of
/// 90-degree clockwise rotations.
///
/// ## Approach
///
/// The algorithm performs at most four rotations (0°, 90°, 180°, 270°).
/// After each rotation, it checks if the current matrix matches the target.
/// If a match is found at any step, the method returns `true`.
///
/// ## Complexity
///
/// - **Time Complexity:** O(n²)
///   - Each rotation and comparison takes O(n²), repeated up to 4 times.
/// - **Space Complexity:** O(n²)
///   - A new matrix is created during each rotation.
///
/// ## Constraints
///
/// - `1 <= n <= 10`
/// - `mat` and `target` are n x n binary matrices.
///
/// @author
class Solution {

    /// ## findRotation
    ///
    /// Determines whether the input matrix can be rotated (in 90-degree increments)
    /// to match the target matrix.
    ///
    /// ### Parameters
    /// - `mat`: The original n x n binary matrix.
    /// - `target`: The desired n x n binary matrix.
    ///
    /// ### Returns
    /// - `true` if `mat` can be rotated to match `target`
    /// - `false` otherwise
    ///
    /// ### Strategy
    /// - Try all four possible rotations.
    /// - After each rotation, compare matrices.
    /// - Return early if a match is found.
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            if (areEqual(mat, target)) return true;
            mat = rotate(mat);
        }
        return false;
    }

    /// ## rotate
    ///
    /// Rotates the given matrix 90 degrees clockwise.
    ///
    /// ### Parameters
    /// - `mat`: The input n x n matrix.
    ///
    /// ### Returns
    /// - A new matrix representing the rotated version of `mat`.
    ///
    /// ### Details
    /// - The transformation follows:
    ///   `rotated[j][n - 1 - i] = mat[i][j]`
    private int[][] rotate(int[][] mat) {
        int n = mat.length;
        int[][] rotated = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - 1 - i] = mat[i][j];
            }
        }
        return rotated;
    }

    /// ## areEqual
    ///
    /// Compares two matrices for equality.
    ///
    /// ### Parameters
    /// - `a`: First matrix.
    /// - `b`: Second matrix.
    ///
    /// ### Returns
    /// - `true` if both matrices are identical
    /// - `false` otherwise
    ///
    /// ### Details
    /// - Performs element-wise comparison.
    private boolean areEqual(int[][] a, int[][] b) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }
}