package daily_question.FindMinimumRotatedSortedArrayII;

/// Solves the **Find Minimum in Rotated Sorted Array II** problem.
///
/// The input array is assumed to be sorted in non-decreasing order and then
/// rotated at an unknown pivot. The array may contain duplicate values.
///
/// This implementation uses a modified binary search. When `nums[mid]` and
/// `nums[right]` are equal, the search space is reduced by decrementing
/// `right`, since either value could represent the minimum.
///
/// ## Complexity
///
/// | Case | Time Complexity | Space Complexity |
/// |------|-----------------|------------------|
/// | Average | `O(log n)` | `O(1)` |
/// | Worst case | `O(n)` | `O(1)` |
///
/// The worst case happens when many duplicate values make it impossible to
/// determine which side contains the minimum.
///
/// @see <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/">
/// Find Minimum in Rotated Sorted Array II
/// </a>
class Solution {
    /// Returns the minimum value in a rotated sorted array that may contain duplicates.
    ///
    /// The method compares the middle element with the rightmost element:
    ///
    /// - If `nums[mid] > nums[right]`, the minimum must be to the right of `mid`.
    /// - If `nums[mid] < nums[right]`, the minimum is at `mid` or to the left of it.
    /// - If `nums[mid] == nums[right]`, the algorithm safely discards `nums[right]`
    ///   by decrementing `right`.
    ///
    /// ## Example
    ///
    /// ```java
    /// int[] nums = {2, 2, 2, 0, 1};
    /// int minimum = new Solution().findMin(nums);
    /// // minimum == 0
    /// ```
    ///
    /// @param nums the rotated sorted array, possibly containing duplicate values
    /// @return the minimum value in `nums`
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right--;
            }
        }

        return nums[left];
    }
}