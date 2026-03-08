package leetcode_challenges.challengerThirtyFive;

/// # Search Insert Position
///
/// Performs a **binary search** on a sorted integer array to find the position
/// of a given target value. If the target is not present in the array,
/// the method returns the index where the target should be inserted in order
/// to maintain the sorted order.
///
/// ## Algorithm
///
/// The algorithm uses the **binary search technique**, which reduces the search
/// space by half on every iteration.
///
/// Steps:
/// 1. Initialize two pointers:
///    - `left` at the start of the array.
///    - `right` at the end of the array.
/// 2. While `left <= right`:
///    - Compute the middle index.
///    - If the middle value equals the target, return the index.
///    - If the middle value is less than the target, search the right half.
///    - Otherwise, search the left half.
/// 3. If the target is not found, `left` represents the correct insertion position.
///
/// ## Time Complexity
///
/// - **O(log n)** — Because the search space is halved at every iteration.
///
/// ## Space Complexity
///
/// - **O(1)** — The algorithm uses constant extra space.
///
/// ## Example
///
/// ```java
/// int[] nums = {1, 3, 5, 6};
/// int target = 5;
/// int result = new Solution().searchInsert(nums, target);
/// // result = 2
/// ```
///
/// If the target does not exist:
///
/// ```java
/// int[] nums = {1, 3, 5, 6};
/// int target = 2;
/// int result = new Solution().searchInsert(nums, target);
/// // result = 1 (insertion position)
/// ```
///
/// ## Parameters
///
/// - `nums` — A **sorted array of distinct integers**.
/// - `target` — The integer value to search for.
///
/// ## Returns
///
/// Returns the **index of the target** if found.
/// Otherwise, returns the **index where the target should be inserted**
/// to maintain sorted order.
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}