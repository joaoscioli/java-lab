package daily_question.checkArrayGood;

import java.util.Arrays;

/// Provides a solution for checking whether an integer array is a _good array_.
///
/// A good array is expected to contain the integers from `1` to `n - 1` exactly
/// once, and the integer `n` exactly twice, where `n` is the largest value in
/// the array.
///
/// For example, the array `[1, 3, 3, 2]` is good because, after sorting, it
/// becomes `[1, 2, 3, 3]`.
class Solution {

    /// Determines whether the given array is a good array.
    ///
    /// The method sorts the input array in ascending order and then validates
    /// that:
    ///
    /// - the array length is equal to `n + 1`, where `n` is the largest value;
    /// - every value from `1` to `n - 1` appears in the expected position;
    /// - the largest value `n` appears as the final duplicate value.
    ///
    /// This method mutates the input array because it calls `Arrays.sort(nums)`.
    ///
    /// @param nums the array of integers to validate
    /// @return `true` if `nums` is a good array; otherwise, `false`
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);

        int n = nums[nums.length - 1];

        if (nums.length != n + 1) {
            return false;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != i + 1) {
                return false;
            }
        }

        return nums[nums.length - 1] == n;
    }
}