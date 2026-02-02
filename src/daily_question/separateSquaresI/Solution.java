package daily_question.separateSquaresI;

/// ## Solution
///
/// Computes the `y` coordinate of a horizontal line that splits the
/// **total area of multiple axis-aligned squares into two equal halves**.
///
/// Each square is defined by:
/// - `s[0]`: x-coordinate of the bottom-left corner (not used in this solution)
/// - `s[1]`: y-coordinate of the bottom-left corner
/// - `s[2]`: side length of the square
///
/// Overlapping areas are **counted multiple times**, since each square
/// contributes independently to the total area.
///
/// This solution applies a **binary search on the y-axis** to locate the
/// split line with high precision.
class Solution {

    /// ### separateSquares
    ///
    /// Finds a horizontal line such that the total area of all squares
    /// below the line equals half of the total area.
    ///
    /// #### Algorithm
    /// 1. Determine the global vertical range `[low, high]` spanned by all squares.
    /// 2. Compute the total area as the sum of individual square areas.
    /// 3. Perform a binary search on `y` within `[low, high]`.
    /// 4. For each candidate `y`, compute the area below the line.
    /// 5. Narrow the search range until the desired precision is reached.
    ///
    /// #### Precision
    /// The search stops when `high - low <= 1e-6`, ensuring sufficient accuracy
    /// for floating-point results.
    ///
    /// #### Complexity
    /// - **Time Complexity:** `O(n log R)`
    ///   where `n` is the number of squares and `R` is the vertical range.
    /// - **Space Complexity:** `O(1)`
    ///
    /// @param squares an array where each element is `[x, y, sideLength]`
    /// @return the y-coordinate that splits the total area in half
    public double separateSquares(int[][] squares) {

        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;
        double totalArea = 0.0;

        // Compute vertical bounds and total area
        for (int[] s : squares) {
            low = Math.min(low, s[1]);
            high = Math.max(high, s[1] + s[2]);
            totalArea += (double) s[2] * s[2];
        }

        double halfArea = totalArea / 2.0;

        // Binary search on the y-axis
        while (high - low > 1e-6) {
            double mid = (low + high) / 2.0;
            double areaBelow = areaBelowLine(squares, mid);

            if (areaBelow < halfArea) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }

    /// ### areaBelowLine
    ///
    /// Computes the total area of all squares that lies **below**
    /// a given horizontal line `y`.
    ///
    /// For each square:
    /// - Only the vertical overlap with the line is considered.
    /// - The contribution is `overlapHeight * sideLength`.
    ///
    /// #### Notes
    /// - If the line is completely below the square, contribution is `0`.
    /// - If the line is above the square, the full square area is counted.
    ///
    /// @param squares the input array of squares
    /// @param y the y-coordinate of the horizontal line
    /// @return the total area below the line
    private double areaBelowLine(int[][] squares, double y) {

        double area = 0.0;

        for (int[] s : squares) {
            double bottom = s[1];
            double side = s[2];

            // Clamp the vertical contribution between [0, side]
            double height = Math.min(Math.max(y - bottom, 0), side);
            area += height * side;
        }

        return area;
    }
}
