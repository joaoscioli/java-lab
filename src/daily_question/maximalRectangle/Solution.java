package daily_question.maximalRectangle;

import java.util.Stack;

public class Solution {

    /// ## Maximal Rectangle in a Binary Matrix
    ///
    /// Computes the area of the largest rectangle containing only `'1'`s
    /// in a binary matrix.
    ///
    /// ### Core Idea
    /// - Treat each row as the **base of a histogram**.
    /// - Build cumulative heights of consecutive `'1'`s column-wise.
    /// - For each histogram, compute the largest rectangle using a
    ///   **monotonic increasing stack**.
    ///
    /// This reduces the 2D problem into repeated applications of the
    /// **Largest Rectangle in Histogram** problem.
    ///
    /// ### Algorithm
    /// 1. Iterate row by row.
    /// 2. Update histogram heights:
    ///    - If `matrix[r][c] == '1'`, increment height.
    ///    - Otherwise, reset height to `0`.
    /// 3. For each histogram, compute the maximum rectangle area.
    /// 4. Track and return the global maximum.
    ///
    /// ### Time Complexity
    /// - **O(rows × cols)**
    ///
    /// ### Space Complexity
    /// - **O(cols)** for histogram heights and stack.
    ///
    /// ### Parameters
    /// - `matrix`: A 2D binary matrix (`'0'` or `'1'`).
    ///
    /// ### Returns
    /// - The area of the largest rectangle consisting only of `'1'`s.
    ///
    /// ### Edge Cases
    /// - Empty or null matrix → returns `0`.
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for (char[] row : matrix) {
            // Build histogram heights
            for (int c = 0; c < cols; c++) {
                heights[c] = (row[c] == '1') ? heights[c] + 1 : 0;
            }

            // Compute max rectangle in current histogram
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    /// ## Largest Rectangle in Histogram
    ///
    /// Computes the maximum rectangular area in a histogram using a
    /// **monotonic increasing stack**.
    ///
    /// ### Invariant
    /// - Stack stores indices of bars in **increasing height order**.
    ///
    /// ### Key Insight
    /// When a lower bar is found:
    /// - The bar at the top of the stack is the **smallest height**
    ///   for a rectangle extending:
    ///   - Right boundary → current index `i`
    ///   - Left boundary → index after the new stack top
    ///
    /// A sentinel height (`0`) is appended to ensure all bars
    /// are processed.
    ///
    /// ### Time Complexity
    /// - **O(n)**, where `n` is the number of bars.
    ///
    /// ### Space Complexity
    /// - **O(n)** for the stack.
    ///
    /// ### Parameters
    /// - `heights`: Histogram bar heights.
    ///
    /// ### Returns
    /// - The maximum rectangular area in the histogram.
    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {
            int currentHeight = (i == heights.length) ? 0 : heights[i];

            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
