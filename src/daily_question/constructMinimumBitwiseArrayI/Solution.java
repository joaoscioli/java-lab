package daily_question.constructMinimumBitwiseArrayI;

import java.util.List;

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int x = nums.get(i);

            if ((x & 1) == 0) {
                ans[i] = -1;
                continue;
            }

            int count = 0;
            int temp = x;
            while ((temp & 1) == 1) {
                count++;
                temp >>= 1;
            }

            ans[i] = x - (1 << (count - 1));
        }

        return ans;
    }
}