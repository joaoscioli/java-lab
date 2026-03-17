package daily_question.largestSubmatrixWithRearrangements;

import java.util.Arrays;

/// ## Largest Submatrix With Rearrangements
///
/// Computes the **maximum possible area of a submatrix containing only `1`s**
/// after optimally **rearranging the columns** of a binary matrix.
///
/// ### Problem Overview
///
/// Given a binary matrix `matrix` of size `m x n`, you may rearrange the **columns
/// in any order**. After rearranging, the goal is to find the **largest rectangular
/// submatrix consisting entirely of `1`s**.
///
/// The key observation is that while column order can change, the **vertical
/// accumulation of `1`s per column remains valid**. By computing the height of
/// consecutive `1`s ending at each cell, each row can be treated as a **histogram**.
///
/// After computing these heights, sorting them in descending order simulates the
/// optimal column rearrangement that maximizes rectangle width.
///
/// ### Approach
///
/// 1. **Build a height matrix**
///    - `height[i][j]` stores the number of consecutive `1`s ending at position `(i, j)`.
///
/// 2. **For each row**
///    - Copy and sort the row heights.
///    - Sorting represents rearranging the columns optimally.
///
/// 3. **Compute candidate areas**
///    - For each possible width `w`, compute:
///
///      `area = height * width`
///
///    - Track the maximum area found.
///
/// ### Example
///
/// Input:
///
/// ```
/// matrix = [
///   [0,0,1],
///   [1,1,1],
///   [1,0,1]
/// ]
/// ```
///
/// Height matrix:
///
/// ```
/// [0,0,1]
/// [1,1,2]
/// [2,0,3]
/// ```
///
/// After sorting each row's heights and evaluating possible widths,
/// the largest submatrix area found is:
///
/// ```
/// 4
/// ```
///
/// ### Complexity
///
/// | Metric | Complexity |
/// |------|-------------|
/// | Time | `O(m * n log n)` |
/// | Space | `O(m * n)` |
///
/// Sorting occurs once per row, while the height matrix stores the
/// vertical accumulation of `1`s.
///
/// ### Constraints
///
/// - `1 ≤ m * n ≤ 100000`
/// - `matrix[i][j]` is either `0` or `1`.
///
/// @param matrix a binary matrix where each element is either `0` or `1`
/// @return the maximum area of a submatrix containing only `1`s after
///         optimally rearranging the columns
class Solution {

    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = 0;

        int[][] height = new int[m][n];

        for (int j = 0; j < n; j++) {
            height[0][j] = matrix[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    height[i][j] = height[i - 1][j] + 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int[] row = height[i].clone();
            Arrays.sort(row);

            for (int j = 0; j < n; j++) {
                int h = row[n - 1 - j];
                int width = j + 1;
                maxArea = Math.max(maxArea, h * width);
            }
        }

        return maxArea;
    }
}