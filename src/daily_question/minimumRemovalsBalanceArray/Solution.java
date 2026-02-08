package daily_question.minimumRemovalsBalanceArray;

import java.util.Arrays;

/// ## Minimum Removals to Balance an Array
///
/// This class provides a solution to determine the minimum number of elements
/// that must be removed from an integer array so that the remaining elements
/// form a **balanced array**.
///
/// A balanced array is defined as one where:
/// - The maximum element is at most `k` times the minimum element.
/// - An array with a single element is always considered balanced.
///
/// The algorithm uses sorting combined with a **sliding window** technique
/// to efficiently find the largest valid subarray that satisfies the condition.
///
/// ### Approach
/// 1. Sort the input array in ascending order.
/// 2. Use two pointers (`l` and `r`) to maintain a sliding window.
/// 3. Expand the window by moving `r`.
/// 4. Shrink the window from the left (`l`) whenever the balance condition
///    `nums[r] <= nums[l] * k` is violated.
/// 5. Track the maximum valid window size.
/// 6. The result is the total number of elements minus the size of the
///    largest balanced subarray.
///
/// ### Time Complexity
/// - Sorting: `O(n log n)`
/// - Sliding window scan: `O(n)`
/// - Overall: `O(n log n)`
///
/// ### Space Complexity
/// - `O(1)` extra space (excluding sorting overhead).
///
/// ### Example
/// ```text
/// Input: nums = [1, 3, 6, 2], k = 2
/// Sorted: [1, 2, 3, 6]
/// Largest balanced subarray: [1, 2, 3]
/// Output: 1
/// ```
public class Solution {

    /// Computes the minimum number of elements that must be removed so that
    /// the remaining array is balanced.
    ///
    /// @param nums the input array of integers
    /// @param k the maximum allowed ratio between the maximum and minimum elements
    /// @return the minimum number of removals required to balance the array
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int maxWindow = 1;
        int l = 0;

        for (int r = 0; r < n; r++) {
            while ((long) nums[r] > (long) nums[l] * k) {
                l++;
            }
            maxWindow = Math.max(maxWindow, r - l + 1);
        }

        return n - maxWindow;
    }
}
