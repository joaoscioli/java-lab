package daily_question.findLargestAreaSquareInsideTwoRectangles;

class Solution {

    /// ## Find Largest Square Area Inside Two Rectangles
    ///
    /// Given multiple axis-aligned rectangles defined by their bottom-left
    /// and top-right coordinates, this method finds the **largest possible
    /// square area** that can be formed inside the **intersection of any two
    /// rectangles**.
    ///
    /// ### Approach
    /// - For every pair of rectangles `(i, j)`:
    ///   1. Compute the overlapping region by:
    ///      - `xLeft  = max(left x-coordinates)`
    ///      - `yBottom = max(bottom y-coordinates)`
    ///      - `xRight = min(right x-coordinates)`
    ///      - `yTop   = min(top y-coordinates)`
    ///   2. If the rectangles overlap:
    ///      - Compute the intersection width and height.
    ///      - The largest square side inside the intersection is
    ///        `min(width, height)`.
    ///      - Update the maximum square area.
    ///
    /// ### Key Observation
    /// - A valid square exists **only if both width and height of the
    ///   intersection are positive**.
    /// - The square must be axis-aligned with the rectangles.
    ///
    /// ### Example
    /// ```
    /// bottomLeft = [[1,1], [2,2]]
    /// topRight   = [[4,4], [5,5]]
    /// Output: 4
    /// ```
    ///
    /// ### Time Complexity
    /// - **O(n²)** — all pairs of rectangles are checked.
    ///
    /// ### Space Complexity
    /// - **O(1)** — only constant extra space is used.
    ///
    /// @param bottomLeft array of bottom-left coordinates for each rectangle
    /// @param topRight   array of top-right coordinates for each rectangle
    /// @return the maximum square area found within any rectangle intersection
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                /// Compute overlapping boundaries
                int xLeft = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int yBottom = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                int xRight = Math.min(topRight[i][0], topRight[j][0]);
                int yTop = Math.min(topRight[i][1], topRight[j][1]);

                /// Check if there is a valid intersection
                if (xRight > xLeft && yTop > yBottom) {
                    long width = (long) xRight - xLeft;
                    long height = (long) yTop - yBottom;

                    /// The largest possible square side
                    long side = Math.min(width, height);

                    /// Update maximum square area
                    maxArea = Math.max(maxArea, side * side);
                }
            }
        }

        return maxArea;
    }
}
