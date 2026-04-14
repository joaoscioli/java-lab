package daily_question.minimumTotalDistanceTraveled;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/// # Minimum Total Distance Traveled
///
/// Computes the minimum total distance required for all robots to reach a factory
/// where they can be repaired, considering factory capacity constraints.
///
/// ## Approach
///
/// The solution uses:
/// - **Sorting** to align robots and factories along the X-axis
/// - **Dynamic Programming (DP)** to compute the optimal assignment
///
/// ### Key Idea
/// Robots and factories are sorted by position to ensure optimal pairing
/// without crossing assignments (which would increase total distance).
///
/// A 2D DP table is used where:
///
/// ```
/// dp[i][j] = minimum distance to repair first i robots using first j factories
/// ```
///
/// For each factory, we try assigning `k` robots (up to its capacity),
/// accumulating the movement cost.
///
/// ## Time Complexity
///
/// - Sorting: `O(n log n + m log m)`
/// - DP: `O(n * m * limit)`
///
/// ## Space Complexity
///
/// - `O(n * m)` for the DP table
///
/// ## Constraints
///
/// - Each robot must be assigned to exactly one factory
/// - Each factory has a limited repair capacity
/// - It is guaranteed that all robots can be repaired
///
class Solution {

    /// ## minimumTotalDistance
    ///
    /// Calculates the minimum total distance required for all robots
    /// to reach factories and be repaired.
    ///
    /// ### Parameters
    ///
    /// - `robot`: A list of unique integers representing robot positions on the X-axis
    /// - `factory`: A 2D array where:
    ///   - `factory[j][0]` = position of the factory
    ///   - `factory[j][1]` = maximum number of robots it can repair
    ///
    /// ### Returns
    ///
    /// - The minimum total distance (as `long`) required to repair all robots
    ///
    /// ### Notes
    ///
    /// - Robots can move in either direction
    /// - Movement cost is the absolute distance between positions
    /// - Factories stop accepting robots after reaching their limit
    ///
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        // Sort robots and factories by position
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

        int n = robot.size();
        int m = factory.length;

        // dp[i][j] = min distance to fix first i robots using first j factories
        long[][] dp = new long[n + 1][m + 1];

        // Initialize DP table with large values
        for (long[] row : dp) Arrays.fill(row, Long.MAX_VALUE);
        dp[0][0] = 0;

        // Iterate through factories
        for (int j = 1; j <= m; j++) {
            int pos = factory[j - 1][0];
            int limit = factory[j - 1][1];

            // Iterate through robots
            for (int i = 0; i <= n; i++) {
                // Case 1: Skip current factory
                dp[i][j] = dp[i][j - 1];

                long cost = 0;

                // Case 2: Assign k robots to current factory
                for (int k = 1; k <= limit && k <= i; k++) {
                    int robotIndex = i - k;

                    // Incrementally add movement cost
                    cost += Math.abs(robot.get(robotIndex) - pos);

                    if (dp[i - k][j - 1] != Long.MAX_VALUE) {
                        dp[i][j] = Math.min(
                                dp[i][j],
                                dp[i - k][j - 1] + cost
                        );
                    }
                }
            }
        }

        return dp[n][m];
    }
}