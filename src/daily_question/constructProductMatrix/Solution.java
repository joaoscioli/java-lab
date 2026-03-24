package daily_question.constructProductMatrix;

/// ## Solution: Construct Product Matrix
///
/// This class provides a method to construct a **product matrix** from a given
/// 2D integer matrix. Each element in the resulting matrix contains the product
/// of all elements in the original matrix **except itself**, modulo `12345`.
///
/// ### 💡 Approach
///
/// Instead of using division (which is not reliable under non-prime modulo),
/// the solution uses a **prefix and suffix product technique**:
///
/// - Flatten the 2D matrix into a 1D array.
/// - Compute prefix products (product of all elements before index `i`).
/// - Compute suffix products (product of all elements after index `i`).
/// - Multiply prefix and suffix values for each position.
///
/// This ensures an efficient computation without recomputing products repeatedly.
///
/// ### ⚙️ Complexity
///
/// - **Time Complexity:** `O(n * m)`
/// - **Space Complexity:** `O(n * m)`
///
/// Where `n` is the number of rows and `m` is the number of columns.
///
/// ### ⚠️ Notes
///
/// - All operations are performed modulo `12345`.
/// - Division is avoided due to modulo constraints.
///
/// ---
class Solution {

    /// ### constructProductMatrix
    ///
    /// Constructs the product matrix where each element contains the product
    /// of all other elements in the grid except itself, modulo `12345`.
    ///
    /// ### Parameters
    /// - `grid`: A 2D integer matrix of size `n x m`.
    ///
    /// ### Returns
    /// - A 2D matrix of the same size where each position contains the required product.
    ///
    /// ### Steps
    /// 1. Flatten the 2D grid into a 1D array.
    /// 2. Compute prefix products.
    /// 3. Compute suffix products.
    /// 4. Combine prefix and suffix to form the result.
    /// 5. Map the result back to a 2D matrix.
    ///
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int size = n * m;
        int MOD = 12345;

        // Flatten the grid into a 1D array
        int[] arr = new int[size];
        int idx = 0;
        for (int[] row : grid) {
            for (int val : row) {
                arr[idx++] = val % MOD;
            }
        }

        // Compute prefix products
        int[] prefix = new int[size];
        prefix[0] = 1;
        for (int i = 1; i < size; i++) {
            prefix[i] = (prefix[i - 1] * arr[i - 1]) % MOD;
        }

        // Compute suffix products
        int[] suffix = new int[size];
        suffix[size - 1] = 1;
        for (int i = size - 2; i >= 0; i--) {
            suffix[i] = (suffix[i + 1] * arr[i + 1]) % MOD;
        }

        // Build the result matrix
        int[][] result = new int[n][m];
        idx = 0;
        for (int i = 0; i < size; i++) {
            int val = (prefix[i] * suffix[i]) % MOD;
            result[i / m][i % m] = val;
        }

        return result;
    }
}