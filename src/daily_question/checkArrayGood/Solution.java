package daily_question.checkArrayGood;

import java.util.Arrays;

class Solution {
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
