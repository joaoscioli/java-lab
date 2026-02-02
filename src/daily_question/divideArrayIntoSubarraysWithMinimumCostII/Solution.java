package daily_question.divideArrayIntoSubarraysWithMinimumCostII;

import java.util.TreeMap;

class Solution {
    TreeMap<Integer, Integer> small = new TreeMap<>();
    TreeMap<Integer, Integer> large = new TreeMap<>();
    long sumSmall = 0;
    int sizeSmall = 0;

    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        long ans = Long.MAX_VALUE;

        int left = 2;
        int right = Math.min(n - 1, 1 + dist);

        for (int i = left; i <= right; i++) {
            add(nums[i], k - 2);
        }

        for (int i1 = 1; i1 < n; i1++) {

            if (sizeSmall == k - 2) {
                ans = Math.min(ans, nums[0] + nums[i1] + sumSmall);
            }

            if (right + 1 < n) {
                right++;
                add(nums[right], k - 2);
            }

            if (left < n) {
                remove(nums[left], k - 2);
                left++;
            }
        }

        return ans;
    }

    private void add(int x, int need) {
        if (sizeSmall < need) {
            addSmall(x);
        } else if (!small.isEmpty() && x < small.lastKey()) {
            addSmall(x);
            moveSmallToLarge();
        } else {
            addLarge(x);
        }
    }

    private void remove(int x, int need) {
        if (small.containsKey(x)) {
            removeSmall(x);
        } else {
            removeLarge(x);
        }

        if (sizeSmall < need && !large.isEmpty()) {
            moveLargeToSmall();
        }
    }

    private void addSmall(int x) {
        small.put(x, small.getOrDefault(x, 0) + 1);
        sumSmall += x;
        sizeSmall++;
    }

    private void removeSmall(int x) {
        decrement(small, x);
        sumSmall -= x;
        sizeSmall--;
    }

    private void addLarge(int x) {
        large.put(x, large.getOrDefault(x, 0) + 1);
    }

    private void removeLarge(int x) {
        decrement(large, x);
    }

    private void moveSmallToLarge() {
        int x = small.lastKey();
        removeSmall(x);
        addLarge(x);
    }

    private void moveLargeToSmall() {
        int x = large.firstKey();
        removeLarge(x);
        addSmall(x);
    }

    private void decrement(TreeMap<Integer, Integer> map, int x) {
        map.put(x, map.get(x) - 1);
        if (map.get(x) == 0) map.remove(x);
    }
}
