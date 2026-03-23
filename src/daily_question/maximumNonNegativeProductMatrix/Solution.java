package daily_question.maximumNonNegativeProductMatrix;

/// # Maximum Non-Negative Product in a Matrix
///
/// Computes the maximum **non-negative product** along a path from the
/// top-left corner `(0, 0)` to the bottom-right corner `(m - 1, n - 1)`
/// in a 2D grid.
///
/// Movement is restricted to:
/// - Right
/// - Down
///
/// The product of a path is the multiplication of all visited cells.
/// If the maximum product is negative, returns `-1`.
///
/// ## Approach
///
/// This problem requires tracking both **maximum** and **minimum** products
/// at each cell because:
///
/// - A **negative number** can turn a small (negative) product into a large positive one.
/// - Therefore, we must keep:
///   - `max[i][j]`: maximum product reaching `(i, j)`
///   - `min[i][j]`: minimum product reaching `(i, j)`
///
/// ## Dynamic Programming Strategy
///
/// For each cell `(i, j)`:
///
/// - If `grid[i][j] >= 0`:
///   - `max = max(prevMax) * grid[i][j]`
///   - `min = min(prevMin) * grid[i][j]`
///
/// - If `grid[i][j] < 0`:
///   - `max = min(prevMin) * grid[i][j]`
///   - `min = max(prevMax) * grid[i][j]`
///
/// Where `prev` refers to values from:
/// - top `(i - 1, j)`
/// - left `(i, j - 1)`
///
/// ## Special Case
///
/// - If the final maximum product is **negative**, return `-1`
/// - Otherwise, return the result modulo `1_000_000_007`
///
/// ## Complexity
///
/// - **Time Complexity:** O(m × n)
/// - **Space Complexity:** O(m × n)
///
/// ## Constraints
///
/// - `1 <= m, n <= 15`
/// - `-4 <= grid[i][j] <= 4`
///
/// ## Example
///
/// ```text
/// Input: grid = [[1,-2,1],[1,-2,1],[3,-4,1]]
/// Output: 8
///
/// Explanation:
/// Path: 1 → 1 → -2 → -4 → 1
/// Product: 8
/// ```
///
/// ## Notes
///
/// - This is a classic **DP with state tracking (min/max)** problem.
/// - Similar pattern appears in problems involving:
///   - Maximum product subarray
///   - Path problems with negative weights
///
/// @param grid the input 2D matrix
/// @return the maximum non-negative product modulo 1e9+7, or -1 if none exists

class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long[][] max = new long[m][n];
        long[][] min = new long[m][n];

        max[0][0] = grid[0][0];
        min[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            max[i][0] = max[i - 1][0] * grid[i][0];
            min[i][0] = max[i][0];
        }

        for (int j = 1; j < n; j++) {
            max[0][j] = max[0][j - 1] * grid[0][j];
            min[0][j] = max[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long val = grid[i][j];

                long a = max[i - 1][j] * val;
                long b = min[i - 1][j] * val;
                long c = max[i][j - 1] * val;
                long d = min[i][j - 1] * val;

                max[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
                min[i][j] = Math.min(Math.min(a, b), Math.min(c, d));
            }
        }

        long result = max[m - 1][n - 1];
        if (result < 0) return -1;

        return (int)(result % 1_000_000_007);
    }
}