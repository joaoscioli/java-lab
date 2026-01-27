package daily_question.minimumDifferenceBetweenHighestLowestKScores;

import java.util.Arrays;

/// ## Minimum Difference Between Highest and Lowest of K Scores
///
/// This solution computes the minimum possible difference between the
/// highest and lowest scores among any group of `k` students.
///
/// ### Key Insight
/// After sorting the array, the optimal group of `k` scores will always
/// form a contiguous subarray. This allows the problem to be solved using
/// a sliding window approach.
///
/// ### Approach
/// 1. If `k == 1`, the difference is `0` since all values are equal.
/// 2. Sort the scores in ascending order.
/// 3. Slide a window of size `k` across the sorted array and compute
///    the difference between the first and last elements of each window.
/// 4. Track and return the minimum difference found.
///
/// ### Complexity
/// - Time: `O(n log n)` due to sorting
/// - Space: `O(1)` auxiliary space
class Solution {

    /// ## minimumDifference
    ///
    /// Returns the minimum possible difference between the highest and
    /// lowest values among any selection of `k` elements.
    ///
    /// ### Example
    /// Input: `nums = [9, 4, 1, 7]`, `k = 2`
    /// Output: `2`
    /// Explanation: Selecting `[1, 3]` yields the minimum difference.
    ///
    /// @param nums an array of integer scores
    /// @param k    the number of scores to select
    /// @return the minimum possible difference
    public int minimumDifference(int[] nums, int k) {

        /// A single element always has zero difference
        if (k == 1) return 0;

        /// Sort the array to enable sliding window comparison
        Arrays.sort(nums);

        /// Track the minimum difference found
        int minDiff = Integer.MAX_VALUE;

        /// Sliding window of size k
        for (int i = 0; i + k - 1 < nums.length; i++) {
            minDiff = Math.min(minDiff, nums[i + k - 1] - nums[i]);
        }

        return minDiff;
    }
}
