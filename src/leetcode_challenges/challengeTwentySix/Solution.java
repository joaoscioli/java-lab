package leetcode_challenges.challengeTwentySix;

/// # Remove Element
///
/// Removes all occurrences of a specified value from an integer array **in-place**.
///
/// The method modifies the input array by replacing matched elements
/// with the last valid element in the current range and reducing the
/// effective size of the array.
///
/// The order of elements may change as a result of this operation.
///
/// ## How It Works
///
/// The algorithm maintains:
///
/// - `n` → the current effective length of the array
/// - `i` → the current index being inspected
///
/// While `i < n`:
///
/// - If `nums[i] == val`:
///   - Replace `nums[i]` with `nums[n - 1]`
///   - Decrement `n` (shrink the valid portion)
///   - Do **not** increment `i`, because the swapped element
///     must be evaluated
///
/// - Otherwise:
///   - Increment `i`
///
/// The process continues until all occurrences of `val`
/// are removed from the first `n` positions.
///
/// ## Example
///
/// ```
/// Input:  nums = [3,2,2,3], val = 3
/// Output: 2
/// Modified nums (first 2 elements): [2,2]
/// ```
///
/// ## Time Complexity
///
/// - **O(n)** — Each element is processed at most once.
///
/// ## Space Complexity
///
/// - **O(1)** — The operation is performed in-place.
///
/// @param nums the input array of integers
/// @param val the value to remove from the array
/// @return the new length of the array after removing all occurrences of val
class Solution {

    /// Removes all occurrences of {@code val} from {@code nums} in-place.
    ///
    /// @param nums the input array
    /// @param val the value to be removed
    /// @return the number of remaining elements after removal
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i = 0;

        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }

        return n;
    }
}