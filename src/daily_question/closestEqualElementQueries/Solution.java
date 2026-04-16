package daily_question.closestEqualElementQueries;

import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> result = new ArrayList<>();

        for (int idx : queries) {
            int val = nums[idx];
            List<Integer> list = map.get(val);

            if (list.size() == 1) {
                result.add(-1);
                continue;
            }

            int pos = Collections.binarySearch(list, idx);

            int prev = list.get((pos - 1 + list.size()) % list.size());
            int next = list.get((pos + 1) % list.size());

            int dist1 = Math.min(Math.abs(idx - prev), n - Math.abs(idx - prev));
            int dist2 = Math.min(Math.abs(idx - next), n - Math.abs(idx - next));

            result.add(Math.min(dist1, dist2));
        }

        return result;
    }
}