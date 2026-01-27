package daily_question.minimumCostPathWithEdgeReversals;

import java.util.*;

class Solution {
    static class Edge {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public int minCost(int n, int[][] edges) {
        List<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, 2 * w));
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<long[]> pq =
                new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1];

            if (d > dist[u]) continue;
            if (u == n - 1) return (int) d;

            for (Edge e : graph[u]) {
                long nd = d + e.cost;
                if (nd < dist[e.to]) {
                    dist[e.to] = nd;
                    pq.offer(new long[]{nd, e.to});
                }
            }
        }

        return dist[n - 1] == Long.MAX_VALUE ? -1 : (int) dist[n - 1];
    }
}
