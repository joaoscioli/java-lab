package daily_question.minimumTimeVisitingAllPoints;

/// # Solution
///
/// Implements an algorithm to compute the **minimum time required to visit all points**
/// on a 2D plane **in the given order**, following the movement rules defined by the problem.
///
/// ## Movement Rules
/// In one second, it is possible to:
/// - Move **vertically** by one unit
/// - Move **horizontally** by one unit
/// - Move **diagonally** by one unit (covering both axes simultaneously)
///
/// ## Key Insight
/// The optimal time between two consecutive points is determined by:
///
/// ```text
/// max(|x₂ - x₁|, |y₂ - y₁|)
/// ```
///
/// This works because diagonal movement allows reducing both horizontal and vertical
/// distances at the same time.
///
/// ## Time Complexity
/// - **O(n)** — where `n` is the number of points
///
/// ## Space Complexity
/// - **O(1)** — constant extra space
///
public class Solution {

    /// ## minTimeToVisitAllPoints
    ///
    /// Calculates the minimum time (in seconds) required to visit all points
    /// in the order provided.
    ///
    /// ### Algorithm
    /// - Iterate through each consecutive pair of points
    /// - Compute the horizontal distance `dx`
    /// - Compute the vertical distance `dy`
    /// - Add `max(dx, dy)` to the total time
    ///
    /// ### Parameters
    /// - `points` — a 2D array where each element represents a point
    ///   in the format `[x, y]`
    ///
    /// ### Returns
    /// - The minimum time (in seconds) required to visit all points
    ///
    /// ### Example
    /// ```java
    /// int[][] points = {{1,1}, {3,4}, {-1,0}};
    /// int result = new Solution().minTimeToVisitAllPoints(points);
    /// // result = 7
    /// ```
    ///
    public int minTimeToVisitAllPoints(int[][] points) {
        int totalTime = 0;

        for (int i = 1; i < points.length; i++) {
            int dx = Math.abs(points[i][0] - points[i - 1][0]);
            int dy = Math.abs(points[i][1] - points[i - 1][1]);

            totalTime += Math.max(dx, dy);
        }

        return totalTime;
    }
}
