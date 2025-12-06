package daily_question.adjacentIncreasingSubarraysDetectionI;

import java.util.List;

public class Solution {

    /// Checks whether the list contains two adjacent strictly increasing
    /// subarrays, each of length `k`.
    ///
    /// An increasing subarray means:
    /// nums[i] < nums[i+1] < ... < nums[i+k-1]
    ///
    /// Two subarrays are "adjacent" when the second starts exactly after
    /// the first:
    ///  - first  at index i
    ///  - second at index i + k
    ///
    /// Example:
    /// nums = [1, 2, 3, 4, 5, 6], k = 2
    /// Subarrays: [1,2] [3,4] → increasing → return true
    ///
    /// Time Complexity: O(n * k)
    /// Space Complexity: O(1)
    ///
    /// @param nums List of integers to analyze
    /// @param k    Length of each increasing subarray
    /// @return true if two adjacent increasing subarrays of size k exist
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();

        for (int i = 0; i + 2 * k <= n; i++) {
            if (isIncreasing(nums, i, k) && isIncreasing(nums, i + k, k)) {
                return true;
            }
        }
        return false;
    }

    /// Checks if the segment nums[start .. start + k - 1]
    /// is strictly increasing.
    ///
    /// @param nums  Full list
    /// @param start Starting index
    /// @param k     Number of elements to check
    /// @return true if the k-length subarray is strictly increasing
    private boolean isIncreasing(List<Integer> nums, int start, int k) {
        for (int i = start; i < start + k - 1; i++) {
            if (nums.get(i) >= nums.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}