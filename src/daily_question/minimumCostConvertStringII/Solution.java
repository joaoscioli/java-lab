package daily_question.minimumCostConvertStringII;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    private static final long INF = (long) 1e18;

    public long minimumCost(
            String source,
            String target,
            String[] original,
            String[] changed,
            int[] cost
    ) {

        int n = source.length();

        Map<String, Integer> id = new HashMap<>();
        int idx = 0;

        for (int i = 0; i < original.length; i++) {
            if (!id.containsKey(original[i])) id.put(original[i], idx++);
            if (!id.containsKey(changed[i])) id.put(changed[i], idx++);
        }

        int m = idx;
        long[][] dist = new long[m][m];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < original.length; i++) {
            int u = id.get(original[i]);
            int v = id.get(changed[i]);
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        for (int k = 0; k < m; k++) {
            for (int i = 0; i < m; i++) {
                if (dist[i][k] == INF) continue;
                for (int j = 0; j < m; j++) {
                    if (dist[k][j] == INF) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        long[] dp = new long[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == INF) continue;

            if (source.charAt(i) == target.charAt(i)) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i]);
            }

            for (String X : id.keySet()) {
                int len = X.length();
                if (i + len > n) continue;

                if (!matches(source, X, i)) continue;

                int yId = id.getOrDefault(
                        target.substring(i, i + len),
                        -1
                );
                if (yId == -1) continue;

                long cst = dist[id.get(X)][yId];
                if (cst < INF) {
                    dp[i + len] = Math.min(dp[i + len], dp[i] + cst);
                }
            }
        }

        return dp[n] >= INF ? -1 : dp[n];
    }

    private boolean matches(String s, String p, int start) {
        for (int i = 0; i < p.length(); i++) {
            if (s.charAt(start + i) != p.charAt(i)) return false;
        }
        return true;
    }
}