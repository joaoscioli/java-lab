package leetcode_challenges.challengerFifteen;

import java.io.IO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/// ## Solution
///
/// Implementation of the **3Sum** problem.
///
/// Given an integer array `nums`, the goal is to find all **unique triplets**
/// `[nums[i], nums[j], nums[k]]` such that:
///
/// - `i`, `j`, and `k` are distinct indices
/// - `nums[i] + nums[j] + nums[k] == 0`
///
/// The solution ensures that:
/// - No duplicate triplets are included in the result
/// - The algorithm runs efficiently using sorting and the two-pointer technique
public class Solution {

    /// ### threeSum
    ///
    /// Finds all unique triplets in the array whose sum is zero.
    ///
    /// #### Algorithm
    /// 1. Sort the input array.
    /// 2. Iterate through the array fixing the first element `i`.
    /// 3. Use two pointers (`left` and `right`) to search for pairs
    ///    that complete the triplet.
    /// 4. Skip duplicate values for all pointers to avoid repeated triplets.
    ///
    /// #### Key Points
    /// - Sorting enables efficient duplicate removal and pointer movement.
    /// - Duplicate checks are applied at:
    ///   - The fixed index `i`
    ///   - The `left` pointer
    ///   - The `right` pointer
    ///
    /// #### Complexity
    /// - **Time Complexity:** `O(n²)`
    /// - **Space Complexity:** `O(1)` (excluding the output list)
    ///
    /// #### Example
    /// ```text
    /// Input:  nums = [-1, 0, 1, 2, -1, -4]
    /// Output: [[-1, -1, 2], [-1, 0, 1]]
    /// ```
    ///
    /// @param nums the input array of integers
    /// @return a list of all unique triplets that sum to zero
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        // Sort the array to enable two-pointer traversal
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate values for the fixed index
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicate values for the left pointer
                    while (left < right && nums[left] == nums[left + 1]) left++;

                    // Skip duplicate values for the right pointer
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                }
                else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return res;
    }

    /// ### main
    ///
    /// Simple execution entry point used for local testing.
    ///
    /// It initializes a sample array and prints the result
    /// of the `threeSum` method.
    void main() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        IO.println(threeSum(nums));
    }
}
