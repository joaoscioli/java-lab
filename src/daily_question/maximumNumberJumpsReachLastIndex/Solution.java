package daily_question.maximumNumberJumpsReachLastIndex;

/// Provides a solution for computing the maximum number of valid jumps
/// needed to reach the last index of an array.
///
/// A jump from index `i` to index `j` is valid when:
///
/// - `0 <= i < j < nums.length`
/// - `-target <= nums[j] - nums[i] <= target`
///
/// The solution uses dynamic programming to determine the maximum number
/// of jumps required to reach each index.
///
/// ## Time Complexity
///
/// `O(n^2)`, where `n` is the length of `nums`.
///
/// ## Space Complexity
///
/// `O(n)`, due to the dynamic programming array.
class Solution {

    /// Returns the maximum number of valid jumps needed to reach the last index.
    ///
    /// The method uses a dynamic programming array `dp`, where `dp[i]`
    /// represents the maximum number of jumps needed to reach index `i`.
    ///
    /// A value of `-1` means that the index cannot be reached from index `0`.
    ///
    /// For every index `i`, the method checks all previous indices `j`.
    /// If `j` is reachable and the jump from `j` to `i` satisfies the target
    /// constraint, then `dp[i]` is updated with the best possible jump count.
    ///
    /// ## Example
    ///
    /// ```java
    /// int[] nums = {1, 3, 6, 4, 1, 2};
    /// int target = 2;
    ///
    /// int result = new Solution().maximumJumps(nums, target);
    /// // result == 3
    /// ```
    ///
    /// @param nums the input array of integers
    /// @param target the maximum allowed absolute difference between two jumped values
    /// @return the maximum number of jumps needed to reach the last index,
    ///         or `-1` if the last index cannot be reached
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];

        for (int i = 1; i < n; i++) {
            dp[i] = -1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] == -1) {
                    continue;
                }

                long diff = (long) nums[i] - nums[j];

                if (-target <= diff && diff <= target) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n - 1];
    }
}