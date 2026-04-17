package daily_question.MinimumAbsoluteDistanceBetweenMirrorPairs;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> expected = new HashMap<>();
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (expected.containsKey(num)) {
                minDist = Math.min(minDist, i - expected.get(num));
            }

            int rev = reverse(num);

            expected.put(rev, i);
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }

    private int reverse(int x) {
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + (x % 10);
            x /= 10;
        }
        return rev;
    }
}
