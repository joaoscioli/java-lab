package daily_question.minimumRemovalsBalanceArray;

import java.util.Arrays;

public class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int maxWindow = 1;
        int l = 0;

        for (int r = 0; r < n; r++) {
            while ((long) nums[r] > (long) nums[l] * k) {
                l++;
            }
            maxWindow = Math.max(maxWindow, r - l + 1);
        }

        return n - maxWindow;
    }
}
