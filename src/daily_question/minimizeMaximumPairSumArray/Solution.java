package daily_question.minimizeMaximumPairSumArray;

import java.util.Arrays;

/// # Minimize Maximum Pair Sum in Array
///
/// This package contains a solution to the problem **Minimize Maximum Pair Sum in Array**,
/// where the goal is to optimally pair elements of an even-length array such that the
/// **maximum pair sum is minimized**.
///
/// ## Key Techniques
/// - Sorting
/// - Two Pointers
/// - Greedy Strategy
///
/// The solution is optimized for performance and suitable for large inputs.

/// ## Solution
///
/// Provides a greedy implementation to minimize the maximum pair sum
/// formed by pairing elements of an integer array.
///
/// ### Algorithm Overview
/// 1. Sort the array in ascending order.
/// 2. Pair the smallest element with the largest element.
/// 3. Track the maximum sum among all pairs.
/// 4. Return the minimized maximum pair sum.
///
/// ### Why It Works
/// Pairing the smallest and largest elements balances the sums and prevents
/// any single pair from becoming unnecessarily large.
///
/// ### Time and Space Complexity
/// - **Time Complexity:** `O(n log n)` due to sorting.
/// - **Space Complexity:** `O(1)` extra space (excluding sorting).
///
/// ### Computes the minimized maximum pair sum
///
/// Given an array of integers with even length, this method pairs elements
/// such that the largest pair sum is as small as possible.
///
/// #### Parameters
/// - `nums` — an integer array of even length.
///
/// #### Returns
/// - The minimized maximum pair sum after optimal pairing.
///
/// #### Example
/// ```java
/// int[] nums = {3, 5, 2, 3};
/// int result = new Solution().minPairSum(nums);
/// // reult == 7
/// ```
///
/// #### Notes
/// - The input array is modified due to in-place sorting.
/// - Assumes `nums.length >= 2` and `nums.length` is even.
class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        int maxPairSum = 0;

        while (left < right) {
            int pairSum = nums[left] + nums[right];
            maxPairSum = Math.max(maxPairSum, pairSum);
            left++;
            right--;
        }

        return maxPairSum;
    }
}
