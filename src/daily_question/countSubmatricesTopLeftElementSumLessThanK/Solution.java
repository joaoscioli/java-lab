package daily_question.countSubmatricesTopLeftElementSumLessThanK;

class Solution {

    /// ## Count Submatrices with Top-Left Element and Sum ≤ k
    ///
    /// This method counts how many submatrices:
    /// - Include the top-left element `(0,0)`
    /// - Have a total sum less than or equal to `k`
    ///
    /// ---
    ///
    /// ## Approach
    ///
    /// Instead of checking all possible submatrices, we leverage the fact that:
    /// - Every valid submatrix must start at `(0,0)`
    /// - Each submatrix is uniquely defined by its bottom-right corner `(i, j)`
    ///
    /// We transform the input matrix into a **2D prefix sum matrix in-place**, where:
    ///
    /// ```text
    /// grid[i][j] = sum of elements from (0,0) to (i,j)
    /// ```
    ///
    /// Using the prefix sum formula:
    ///
    /// ```text
    /// grid[i][j] = grid[i][j]
    ///            + grid[i-1][j]
    ///            + grid[i][j-1]
    ///            - grid[i-1][j-1]
    /// ```
    ///
    /// After computing each prefix sum:
    /// - If `grid[i][j] <= k`, it means the submatrix `(0,0)` to `(i,j)` is valid
    /// - Increment the count
    ///
    /// ---
    ///
    /// ## Complexity
    ///
    /// - **Time Complexity:** `O(m * n)`
    /// - **Space Complexity:** `O(1)` (in-place modification)
    ///
    /// ---
    ///
    /// ## Notes
    ///
    /// - The input matrix is modified in-place to store prefix sums
    /// - If original values are needed later, consider copying the matrix first
    ///
    /// ---
    ///
    /// ## Example
    ///
    /// ```java
    /// Input:
    /// grid = [[7,2,9],
    ///         [1,5,0],
    ///         [2,6,6]], k = 20
    ///
    /// Output:
    /// 6
    /// ```
    ///
    /// ---
    ///
    /// @param grid A 2D integer matrix
    /// @param k The maximum allowed sum of the submatrix
    /// @return The number of valid submatrices starting at (0,0) with sum ≤ k
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i > 0) grid[i][j] += grid[i - 1][j];
                if (j > 0) grid[i][j] += grid[i][j - 1];
                if (i > 0 && j > 0) grid[i][j] -= grid[i - 1][j - 1];

                if (grid[i][j] <= k) {
                    count++;
                }
            }
        }

        return count;
    }
}