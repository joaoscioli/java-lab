package daily_question.minimumDistanceTargetElement;

/// # Minimum Distance to Target Element
///
/// This class provides a solution to find the minimum distance between a given
/// `start` index and any index `i` such that `nums[i] == target`.
///
/// The distance is defined as the absolute difference:
///
/// `|i - start|`
///
/// ## Approach
///
/// The algorithm iterates through the array and:
///
/// - Checks each element to see if it matches the `target`
/// - Computes the absolute distance from the `start` index
/// - Keeps track of the minimum distance found
///
/// ## Complexity
///
/// - **Time Complexity:** O(n)
/// - **Space Complexity:** O(1)
///
/// ## Constraints
///
/// - `1 <= nums.length <= 1000`
/// - `1 <= nums[i] <= 10^4`
/// - `0 <= start < nums.length`
/// - `target` is guaranteed to exist in `nums`
///
/// ## Example
///
/// ```
/// Input: nums = [1,2,3,4,5], target = 5, start = 3
/// Output: 1
/// Explanation: The index of target is 4, so |4 - 3| = 1.
/// ```
class Solution {

    /// ## getMinDistance
    ///
    /// Returns the minimum absolute distance between the `start` index
    /// and any index `i` where `nums[i] == target`.
    ///
    /// ### Parameters
    ///
    /// - `nums`: An array of integers
    /// - `target`: The value to search for
    /// - `start`: The reference index
    ///
    /// ### Returns
    ///
    /// The minimum value of `|i - start|` such that `nums[i] == target`
    ///
    /// ### Notes
    ///
    /// - It is guaranteed that at least one occurrence of `target` exists in `nums`
    /// - Uses `Math.abs` to compute absolute distance
    public int getMinDistance(int[] nums, int target, int start) {
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                int distance = Math.abs(i - start);
                minDistance = Math.min(minDistance, distance);
            }
        }

        return minDistance;
    }
}