package leetcode_challenges.challengerEighteen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/// ## Solution
///
/// Provides an implementation for the **4Sum** problem.
///
/// The goal is to find all **unique quadruplets**
/// `[nums[a], nums[b], nums[c], nums[d]]` such that:
///
/// - `a`, `b`, `c`, and `d` are **distinct indices**
/// - The sum of the four numbers equals the given `target`
///
/// The solution avoids duplicate quadruplets and works efficiently
/// by combining sorting with the two-pointer technique.
class Solution {

    /// ### fourSum
    ///
    /// Returns all unique quadruplets in the array that sum up to the given target.
    ///
    /// #### Algorithm
    /// 1. Sort the input array.
    /// 2. Fix the first element `i` using a loop.
    /// 3. Fix the second element `j` using a nested loop.
    /// 4. Use a **two-pointer approach** (`left`, `right`) to find pairs
    ///    that complete the quadruplet.
    /// 5. Skip duplicate values at each step to ensure uniqueness.
    ///
    /// #### Why `long` is used
    /// The sum is calculated using `long` to prevent **integer overflow**
    /// when dealing with large values.
    ///
    /// #### Complexity
    /// - **Time Complexity:** `O(n³)`
    /// - **Space Complexity:** `O(1)` (excluding the output list)
    ///
    /// #### Example
    /// ```text
    /// nums = [1, 0, -1, 0, -2, 2]
    /// target = 0
    /// Output:
    /// [
    ///   [-2, -1, 1, 2],
    ///   [-2,  0, 0, 2],
    ///   [-1,  0, 0, 1]
    /// ]
    /// ```
    ///
    /// @param nums   the input array of integers
    /// @param target the target sum for the quadruplets
    /// @return a list of all unique quadruplets that sum to `target`
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        // Early exit if there are not enough elements
        if (n < 4) return result;

        // Sort the array to enable two-pointer traversal
        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            // Skip duplicate values for the first index
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicate values for the second index
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(
                                nums[i], nums[j], nums[left], nums[right]
                        ));

                        left++;
                        right--;

                        // Skip duplicate values for the third index
                        while (left < right && nums[left] == nums[left - 1]) left++;

                        // Skip duplicate values for the fourth index
                        while (left < right && nums[right] == nums[right + 1]) right--;

                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}
