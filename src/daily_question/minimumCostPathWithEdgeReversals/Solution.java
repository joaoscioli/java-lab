package daily_question.minimumCostPathWithEdgeReversals;

import java.util.*;

/// ## Minimum Cost Path with Edge Reversals
///
/// This solution computes the minimum cost to travel from node `0` to node
/// `n - 1` in a directed weighted graph, where each node allows reversing
/// one incoming edge at double cost for a single traversal.
///
/// ### Key Insight
/// Although each node has a switch that can be used at most once, explicitly
/// tracking switch usage is unnecessary. Reusing a switch at the same node
/// never improves a shortest path. Therefore, the problem can be modeled
/// as a standard shortest-path problem.
///
/// ### Graph Modeling
/// For each original edge:
/// - `u → v` with cost `w`
///
/// We add:
/// - `u → v` with cost `w`  (normal traversal)
/// - `v → u` with cost `2w` (single-use reversed traversal)
///
/// After building this graph, Dijkstra's algorithm is applied.
///
/// ### Complexity
/// - Time: `O((n + m) log n)`
/// - Space: `O(n + m)`
class Solution {

    /// ## Edge
    ///
    /// Represents a directed edge in the transformed graph.
    /// Each edge contains:
    /// - `to`: destination node
    /// - `cost`: traversal cost
    static class Edge {
        int to;
        int cost;

        /// Creates a directed edge.
        ///
        /// @param to   the destination node
        /// @param cost the traversal cost
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    /// ## minCost
    ///
    /// Computes the minimum total cost to travel from node `0`
    /// to node `n - 1`.
    ///
    /// ### Algorithm
    /// 1. Build an adjacency list where:
    ///    - original edges keep their cost
    ///    - reversed edges have double cost
    /// 2. Run Dijkstra's algorithm from node `0`
    /// 3. Return the shortest distance to node `n - 1`
    ///
    /// ### Notes
    /// - Early termination is used when the destination node is reached.
    /// - If the destination is unreachable, `-1` is returned.
    ///
    /// @param n     number of nodes in the graph
    /// @param edges directed edges in the form `[u, v, w]`
    /// @return the minimum cost to reach node `n - 1`, or `-1` if unreachable
    public int minCost(int n, int[][] edges) {

        /// Adjacency list representation of the graph
        List<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        /// Build the transformed graph
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            graph[u].add(new Edge(v, w));        // normal edge
            graph[v].add(new Edge(u, 2 * w));    // reversed edge
        }

        /// Distance array initialized to infinity
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        /// Min-heap priority queue: {distance, node}
        PriorityQueue<long[]> pq =
                new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0});

        /// Dijkstra's algorithm
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1];

            if (d > dist[u]) continue;

            /// Early exit if destination is reached
            if (u == n - 1) return (int) d;

            for (Edge e : graph[u]) {
                long nd = d + e.cost;
                if (nd < dist[e.to]) {
                    dist[e.to] = nd;
                    pq.offer(new long[]{nd, e.to});
                }
            }
        }

        /// Return result
        return dist[n - 1] == Long.MAX_VALUE ? -1 : (int) dist[n - 1];
    }
}
