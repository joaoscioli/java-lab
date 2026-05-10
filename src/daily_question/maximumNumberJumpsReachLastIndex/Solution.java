package daily_question.maximumNumberJumpsReachLastIndex;

class Solution {
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
