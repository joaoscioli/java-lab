package daily_question.maximumAreaLongestDiagonalRectangle;

class Solution {

    /// # areaOfMaxDiagonal
    ///
    /// Computes the **area of the rectangle** that has the **longest diagonal**
    /// among a list of given dimensions.
    ///
    /// Each rectangle is represented by a pair:
    /// - `length` = `dimensions[i][0]`
    /// - `width`  = `dimensions[i][1]`
    ///
    /// The diagonal is compared using its **squared value** (`L² + W²`) to avoid
    /// floating-point operations.
    ///
    /// ## Selection Criteria
    /// 1. The rectangle with the **largest diagonal** (by squared value) is chosen.
    /// 2. If multiple rectangles share the same diagonal length,
    ///    the one with the **largest area** (`L * W`) is selected.
    ///
    /// ## Parameters
    /// - `dimensions`
    ///   A 2D integer array where each entry contains
    ///   `[length, width]` of a rectangle.
    ///
    /// ## Returns
    /// The **maximum area** among the rectangles that share the **longest diagonal**.
    ///
    /// ## Example
    /// ```java
    /// int[][] dims = { {9, 3}, {8, 6}, {5, 12} };
    /// int result = new Solution().areaOfMaxDiagonal(dims);
    /// // result = 60
    /// ```
    ///
    /// ## Throws
    /// This method does not throw checked exceptions, but assumes
    /// valid non-negative dimensions.
    ///
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiag = 0;
        int maxArea = 0;

        for (int[] d : dimensions) {
            int L = d[0];
            int W = d[1];

            int diag = L * L + W * W;
            int area = L * W;

            if (diag > maxDiag) {
                maxDiag = diag;
                maxArea = area;
            } else if (diag == maxDiag) {
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}
