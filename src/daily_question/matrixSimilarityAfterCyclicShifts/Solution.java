package daily_question.matrixSimilarityAfterCyclicShifts;

/// # Matrix Similarity After Cyclic Shifts
///
/// Determines whether a matrix remains identical after applying `k` cyclic shift operations.
///
/// ## Problem Summary
///
/// Given an `m x n` integer matrix:
/// - Even-indexed rows (`0, 2, 4, ...`) are cyclically shifted **to the left**
/// - Odd-indexed rows (`1, 3, 5, ...`) are cyclically shifted **to the right**
///
/// This process is repeated `k` times.
///
/// The goal is to verify whether the matrix returns to its **original configuration**
/// after all shifts.
///
/// ---
///
/// ## Key Insight
///
/// Cyclic shifts repeat every `n` steps (where `n` is the number of columns).
/// Therefore, instead of simulating all `k` operations, we reduce:
///
/// ```
/// k = k % n
/// ```
///
/// Then, for each element, we check whether it matches the value that would
/// land in its position after the shifts.
///
/// ---
///
/// ## Index Transformation
///
/// For a given row `i` and column `j`:
///
/// - **Even row (`i % 2 == 0`)** → left shift:
///   - Element originally at `(i, j)` moves to `(i, (j - k) % n)`
///   - To verify, we compare:
///     ```
///     mat[i][j] == mat[i][(j + k) % n]
///     ```
///
/// - **Odd row (`i % 2 != 0`)** → right shift:
///   - Element originally at `(i, j)` moves to `(i, (j + k) % n)`
///   - To verify, we compare:
///     ```
///     mat[i][j] == mat[i][(j - k + n) % n]
///     ```
///
/// ---
///
/// ## Approach
///
/// 1. Compute `k % n` to eliminate redundant full rotations
/// 2. Iterate through each cell in the matrix
/// 3. For each position, compute the expected source index
/// 4. Compare values directly without modifying the matrix
/// 5. If any mismatch is found, return `false`
///
/// ---
///
/// ## Complexity
///
/// - **Time Complexity:** `O(m * n)`
/// - **Space Complexity:** `O(1)` (in-place verification, no extra space)
///
/// ---
///
/// ## Example
///
/// ```
/// Input:
/// mat = [[1,2,1,2],
///        [5,5,5,5],
///        [6,3,6,3]]
/// k = 2
///
/// Output:
/// true
/// ```
///
/// ---
///
/// ## Notes
///
/// - Works efficiently due to modular arithmetic
/// - Avoids unnecessary matrix transformations
/// - Each row behaves independently as a circular array
///
class Solution {

    /// ## areSimilar
    ///
    /// Checks whether the matrix remains unchanged after applying `k` cyclic shifts.
    ///
    /// ### Parameters
    /// - `mat`: A 2D integer matrix (`m x n`)
    /// - `k`: Number of cyclic shift operations
    ///
    /// ### Returns
    /// - `true` if the matrix is identical after all shifts
    /// - `false` otherwise
    ///
    /// ### Strategy
    /// - Normalize `k` using modulo
    /// - Compare each element with its expected shifted counterpart
    ///
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        k = k % n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int newIndex;

                if (i % 2 == 0) {
                    newIndex = (j + k) % n;
                } else {
                    newIndex = (j - k + n) % n;
                }

                if (mat[i][j] != mat[i][newIndex]) {
                    return false;
                }
            }
        }

        return true;
    }
}