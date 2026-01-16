package daily_question.maximumSquareAreaRemovingFencesFromField;

import java.util.*;

public class Solution {
    private static final long MOD = 1_000_000_007;

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Set<Integer> hDistances = computeDistances(hFences, m);
        Set<Integer> vDistances = computeDistances(vFences, n);

        long maxSide = -1;
        for (int d : hDistances) {
            if (vDistances.contains(d)) {
                maxSide = Math.max(maxSide, d);
            }
        }

        if (maxSide == -1) return -1;
        return (int) ((maxSide * maxSide) % MOD);
    }

    private Set<Integer> computeDistances(int[] fences, int limit) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int f : fences) list.add(f);
        list.add(limit);

        Collections.sort(list);

        Set<Integer> distances = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                distances.add(list.get(j) - list.get(i));
            }
        }
        return distances;
    }
}
