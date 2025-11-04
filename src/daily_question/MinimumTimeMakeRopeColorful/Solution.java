package daily_question.MinimumTimeMakeRopeColorful;

/// # Minimum Time to Make Rope Colorful
///
/// Given a rope represented by a string `colors`, where each character represents
/// the color of a balloon, and an integer array `neededTime` where `neededTime[i]`
/// is the time required to remove the `i-th` balloon, the goal is to make the rope
/// *colorful*.  
///
/// A rope is considered colorful if **no two consecutive balloons** have the same color.  
/// To achieve this, we can remove some balloons, and the objective is to **minimize
/// the total removal time**.
///
/// ## Approach
/// The algorithm iterates through the rope and compares each balloon with the previous one:
/// - If two consecutive balloons have the same color, remove the one that requires
///   **less time**, keeping the balloon with the higher removal time.
/// - If the colors differ, continue without removal.
///
/// The variable `totalTime` accumulates the total removal time,
/// and `prevTime` tracks the removal time of the previous balloon.
///
/// ## Time Complexity
/// - **O(n)** — The algorithm makes a single pass through the string `colors`.
///
/// ## Space Complexity
/// - **O(1)** — Uses only constant extra space.
///
/// ## Example
/// ```java
/// String colors = "abaac";
/// int[] neededTime = {1, 2, 3, 4, 5};
/// Solution solution = new Solution();
/// int result = solution.minCost(colors, neededTime);
/// // Output: 3
/// ```
///
/// Explanation:
/// - Balloons at indices (2, 3) both have color `'a'`.
/// - Remove the balloon with time `3`, keeping the one with time `4`.
/// - Total removal time = 3.
///
/// ## References
/// - LeetCode Problem: [1578. Minimum Time to Make Rope Colorful](https://leetcode.com/problems/minimum-time-to-make-rope-colorful/)
public class Solution {

    /// Computes the minimum total time required to remove balloons such that
    /// no two consecutive balloons have the same color.
    ///
    /// @param colors The string representing the colors of the balloons.
    /// @param neededTime The array where `neededTime[i]` represents the time to remove the `i-th` balloon.
    /// @return The minimum total time needed to make the rope colorful.
    public int minCost(String colors, int[] neededTime) {
        int totalTime = 0;       // Accumulates the total removal time
        int prevTime = neededTime[0]; // Keeps track of the previous balloon’s removal time

        // Iterate through each balloon starting from index 1
        for (int i = 1; i < colors.length(); i++) {
            // Case 1: Two consecutive balloons with the same color
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                // Add the smaller removal time to the total (remove the cheaper balloon)
                totalTime += Math.min(prevTime, neededTime[i]);

                // Keep the larger removal time for the next comparison (keep the more expensive balloon)
                prevTime = Math.max(prevTime, neededTime[i]);
            } else {
                // Case 2: Different colors → no removal needed
                prevTime = neededTime[i];
            }
        }

        return totalTime;
    }
}
