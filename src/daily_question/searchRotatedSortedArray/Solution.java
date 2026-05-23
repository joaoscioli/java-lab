package daily_question.searchRotatedSortedArray;

/// Provides a solution for searching a target value in a rotated sorted array.
///
/// The array is assumed to have been originally sorted in ascending order and
/// then rotated at an unknown pivot. This implementation uses a modified binary
/// search to determine which half of the current search range is sorted and
/// narrows the search accordingly.
///
/// ## Example
///
/// ```java
/// Solution solution = new Solution();
/// int index = solution.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0);
/// // index == 4
/// ```
///
/// ## Complexity
///
/// - Time complexity: `O(log n)`
/// - Space complexity: `O(1)`
class Solution {

    /// Searches for the given target value in a rotated sorted array.
    ///
    /// At each step, the method checks whether the left or right half of the
    /// current range is sorted. It then decides whether the target can be inside
    /// that sorted half and discards the other half.
    ///
    /// ## Parameters
    ///
    /// - `nums`: the rotated sorted array to search in
    /// - `target`: the value to search for
    ///
    /// ## Returns
    ///
    /// The index of `target` if it exists in `nums`; otherwise, `-1`.
    ///
    /// ## Assumptions
    ///
    /// - `nums` is sorted in ascending order before rotation.
    /// - `nums` does not contain duplicate values.
    ///
    /// @param nums the rotated sorted array
    /// @param target the value to search for
    /// @return the index of the target value, or `-1` if it is not found
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                return middle;
            }

            // Left half is sorted
            if (nums[left] <= nums[middle]) {
                if (nums[left] <= target && target < nums[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
            // Right half is sorted
            else {
                if (nums[middle] < target && target <= nums[right]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }

        return -1;
    }
}