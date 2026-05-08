package daily_question.jumpGameIX;

import java.util.Arrays;

/// Provides a solution for computing the maximum reachable value for each
/// position in the Jump Game IX problem.
///
/// The algorithm partitions the input array into independent components.
/// Each component contains a contiguous range of values where every position
/// shares the same resulting maximum value.
///
/// A component ends at index `i` when the maximum value seen in the current
/// component is less than or equal to the minimum value that appears in the
/// remaining suffix. At that point, no later value can affect the current
/// component, so the answer for all indexes in the component is finalized.
class Solution {

    /// Computes the maximum value assigned to each position in `nums`.
    ///
    /// For each index, the returned array contains the maximum value of the
    /// component to which that index belongs. Components are formed by scanning
    /// from left to right while tracking:
    ///
    /// - the maximum value in the current component;
    /// - the minimum value in the suffix that starts after the current index.
    ///
    /// When the current component maximum is less than or equal to the next
    /// suffix minimum, the current component is complete and all positions in
    /// that range receive the same maximum value.
    ///
    /// @param nums the input array of integers
    /// @return an array where each position contains the maximum value of its
    ///         corresponding component
    ///
    /// @implNote
    /// This method first builds a suffix-minimum array, where `suffixMin[i]`
    /// stores the minimum value in `nums[i..n - 1]`. It then performs a single
    /// left-to-right pass to identify component boundaries and fill the result.
    ///
    /// @implSpec
    /// The input array must contain at least one element.
    ///
    /// @apiNote
    /// The original input array is not modified.
    ///
    /// @throws ArrayIndexOutOfBoundsException if `nums` is empty
    /// @throws NullPointerException if `nums` is `null`
    public int[] maxValue(int[] nums) {
        int n = nums.length;

        int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }

        int[] ans = new int[n];

        int componentStart = 0;
        int componentMax = nums[0];

        for (int i = 0; i < n; i++) {
            componentMax = Math.max(componentMax, nums[i]);

            if (i == n - 1 || componentMax <= suffixMin[i + 1]) {
                Arrays.fill(ans, componentStart, i + 1, componentMax);

                if (i + 1 < n) {
                    componentStart = i + 1;
                    componentMax = nums[i + 1];
                }
            }
        }

        return ans;
    }
}