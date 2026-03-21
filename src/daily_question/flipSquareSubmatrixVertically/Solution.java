package daily_question.flipSquareSubmatrixVertically;

class Solution {

    /// ### Reverse a Square Submatrix Vertically
    ///
    /// This method flips a **k × k square submatrix** within a given 2D grid
    /// by reversing the order of its rows (vertical flip).
    ///
    /// The submatrix is defined by its **top-left corner** `(x, y)` and
    /// its **size** `k`.
    ///
    /// ---
    ///
    /// ### 🔧 How It Works
    ///
    /// - Iterates over the first half of the rows in the submatrix.
    /// - For each row `i`, swaps it with its corresponding row from the bottom.
    /// - Only elements within the column range `[y, y + k)` are affected.
    ///
    /// ---
    ///
    /// ### 📥 Parameters
    ///
    /// - `grid` : The original `m x n` integer matrix.
    /// - `x`    : Row index of the top-left corner of the submatrix.
    /// - `y`    : Column index of the top-left corner of the submatrix.
    /// - `k`    : Size (side length) of the square submatrix.
    ///
    /// ---
    ///
    /// ### 📤 Returns
    ///
    /// - The updated matrix after performing the vertical flip on the submatrix.
    ///
    /// ---
    ///
    /// ### ⚙️ Complexity
    ///
    /// - **Time Complexity:** `O(k²)`
    ///   Each element in the `k × k` submatrix is processed once.
    ///
    /// - **Space Complexity:** `O(1)`
    ///   The operation is performed in-place without extra memory.
    ///
    /// ---
    ///
    /// ### ✅ Example
    ///
    /// ```text
    /// Input:
    /// grid = [
    ///   [1, 2, 3, 4],
    ///   [5, 6, 7, 8],
    ///   [9,10,11,12],
    ///   [13,14,15,16]
    /// ]
    /// x = 1, y = 0, k = 3
    ///
    /// Output:
    /// [
    ///   [1, 2, 3, 4],
    ///   [13,14,15, 8],
    ///   [9,10,11,12],
    ///   [5, 6, 7,16]
    /// ]
    /// ```
    ///
    /// ---
    ///
    /// ### 🧠 Notes
    ///
    /// - The transformation is done **in-place**, modifying the original grid.
    /// - Only rows inside the defined submatrix are reversed.
    /// - Columns outside `[y, y + k)` remain unchanged.
    ///
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int i = 0; i < k / 2; i++) {
            int topRow = x + i;
            int bottomRow = x + k - 1 - i;

            for (int j = y; j < y + k; j++) {
                int temp = grid[topRow][j];
                grid[topRow][j] = grid[bottomRow][j];
                grid[bottomRow][j] = temp;
            }
        }

        return grid;
    }
}