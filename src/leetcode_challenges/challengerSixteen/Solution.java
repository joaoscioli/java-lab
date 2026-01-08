package leetcode_challenges.challengerSixteen;

import java.util.Arrays;

/// # Solution
///
/// Provides an efficient implementation to solve the **Three Sum Closest**
/// problem.
///
/// Given an integer array and a target value, the algorithm finds three
/// numbers whose sum is closest to the target.
///
/// The solution uses:
/// - **Sorting**
/// - **Two-pointer technique**
///
/// This guarantees optimal performance compared to brute force approaches.
///
/// ## Problem Summary
/// Find three integers in the array such that the sum is closest to a given
/// target. Return the sum of the three integers.
///
/// It is guaranteed that exactly one solution exists.
///
/// ## Algorithm
/// 1. Sort the input array.
/// 2. Fix one element at index `i`.
/// 3. Use two pointers:
///    - `left` starting at `i + 1`
///    - `right` starting at the end of the array.
/// 4. Compute the current sum:
///    ```text
///    nums[i] + nums[left] + nums[right]
///    ```
/// 5. Update the closest sum if the current sum is closer to the target.
/// 6. Move pointers based on comparison with the target:
///    - If current sum < target → move `left` forward.
///    - If current sum > target → move `right` backward.
///    - If equal → exact match found, return immediately.
/// 7. Repeat until all combinations are evaluated.
///
/// ## Time Complexity
/// - **O(n log n)** for sorting.
/// - **O(n²)** for the two-pointer traversal.
/// - Overall: **O(n²)**.
///
/// ## Space Complexity
/// - **O(1)** extra space (ignoring sort stack overhead).
///
/// ## Constraints
/// - `3 <= nums.length`
/// - Values may be negative or positive.
/// - Exactly one closest sum always exists.
///
/// ## Example
/// ```text
/// Input:
/// nums = [-1, 2, 1, -4]
/// target = 1
///
/// Output:
/// 2
///
/// Explanation:
/// (-1 + 2 + 1) = 2 is the closest sum to 1.
/// ```
///
/// @author
/// Great Designer Software
class Solution {

    /// ## threeSumClosest
    ///
    /// Computes the sum of three integers in the array that is closest
    /// to the specified target value.
    ///
    /// The method sorts the array and applies a two-pointer search strategy
    /// to efficiently explore valid combinations.
    ///
    /// ### Parameters
    /// - `nums` — The input array of integers. Must contain at least 3 elements.
    /// - `target` — The target value to approximate.
    ///
    /// ### Returns
    /// - The sum of three integers whose total is closest to `target`.
    ///
    /// ### Throws
    /// - `IllegalArgumentException` — If `nums` has fewer than 3 elements
    ///   (recommended validation if added).
    ///
    /// ### Example
    /// ```java
    /// int result = new Solution().threeSumClosest(
    ///     new int[]{-1, 2, 1, -4},
    ///     1
    /// );
    /// // result == 2
    /// ```
    ///
    /// ### Complexity
    /// - **Time:** O(n²)
    /// - **Space:** O(1)
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                // Update closest sum if needed
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                if (currentSum < target) {
                    left++;
                } else if (currentSum > target) {
                    right--;
                } else {
                    // Exact match found
                    return currentSum;
                }
            }
        }

        return closestSum;
    }
}
