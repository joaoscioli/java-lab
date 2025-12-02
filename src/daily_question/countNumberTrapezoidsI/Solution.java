package daily_question.countNumberTrapezoidsI;

import java.util.*;

public class Solution {
    static final long MOD = 1_000_000_007;

    public int countTrapezoids(int[][] points) {
        // Group by y-coordinate
        Map<Integer, Integer> countByY = new HashMap<>();
        for (int[] p : points) {
            countByY.merge(p[1], 1, Integer::sum);
        }

        List<Long> pairs = new ArrayList<>();

        for (int cnt : countByY.values()) {
            if (cnt >= 2) {
                long c = (long) cnt * (cnt - 1) / 2; // C(cnt, 2)
                pairs.add(c % MOD);
            }
        }
        if (pairs.size() < 2) return 0;

        long sum = 0, sumSq = 0;

        for (long v : pairs) {
            sum = (sum + v) % MOD;
            sumSq = (sumSq + (v * v) % MOD) % MOD;
        }
        // Formula: (sum^2 - sumSq) / 2
        long result = (sum * sum % MOD - sumSq + MOD) % MOD;

        // multiply by modular inverse of 2 (500000004)
        result = result * 500000004 % MOD;

        return (int) result;
    }
}
