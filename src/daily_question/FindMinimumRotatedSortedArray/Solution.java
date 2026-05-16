package daily_question.FindMinimumRotatedSortedArray;

package daily_question.FindMinimumRotatedSortedArray;

/// Provides a solution for finding the minimum element in a rotated sorted array.
///
/// The array is assumed to have been sorted in ascending order and then rotated
/// at an unknown pivot. For example, `[4, 5, 6, 7, 0, 1, 2]`.
///
/// This implementation uses binary search to locate the smallest element in
/// `O(log n)` time.
///
/// ## Example
///
/// ```java
/// Solution solution = new Solution();
/// int minimum = solution.findMin(new int[] {4, 5, 6, 7, 0, 1, 2});
/// // minimum == 0
/// ```
class Solution {

    /// Finds the minimum element in a rotated sorted array.
    ///
    /// The method compares the middle element with the rightmost element to
    /// determine which half of the array contains the rotation point.
    ///
    /// If `nums[mid] > nums[right]`, the minimum element must be in the right
    /// half, so the search starts after `mid`.
    ///
    /// Otherwise, the minimum element is at `mid` or in the left half, so the
    /// search continues from `left` to `mid`.
    ///
    /// ## Complexity
    ///
    /// - Time complexity: `O(log n)`
    /// - Space complexity: `O(1)`
    ///
    /// @param nums the rotated sorted array of integers
    /// @return the minimum element in `nums`
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}