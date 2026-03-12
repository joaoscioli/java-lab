package daily_question.maximizeSpanningTreeStabilityUpgrades;

import java.util.ArrayList;
import java.util.List;

class Solution {

    /// ## Disjoint Set Union (Union-Find)
    ///
    /// A data structure used to efficiently track and merge connected components
    /// in the graph while building the spanning tree.
    ///
    /// It supports two main operations:
    ///
    /// - **find(x)**: Finds the representative (root) of the set containing `x`
    ///   using path compression.
    /// - **union(a, b)**: Merges the sets containing `a` and `b` using union by rank.
    ///
    /// This structure ensures nearly constant time complexity for connectivity
    /// operations, which is essential for handling graphs with up to `10^5` nodes
    /// and edges.
    static class DSU {

        /// Parent array where `parent[i]` stores the parent of node `i`.
        int[] parent;

        /// Rank array used to keep tree depth small during unions.
        int[] rank;

        /// Number of connected components currently in the graph.
        int components;

        /// ### Constructor
        ///
        /// Initializes the DSU structure for `n` nodes.
        ///
        /// Each node starts as its own parent (separate component).
        ///
        /// **Parameters**
        /// - `n` — total number of nodes in the graph.
        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            components = n;

            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        /// ### Find Operation
        ///
        /// Finds the root of the set containing `x`.
        ///
        /// Path compression is applied to flatten the structure
        /// and improve future query performance.
        ///
        /// **Parameters**
        /// - `x` — node whose set representative should be found.
        ///
        /// **Returns**
        /// - The root representative of the set containing `x`.
        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        /// ### Union Operation
        ///
        /// Attempts to merge the sets containing nodes `a` and `b`.
        ///
        /// If both nodes already belong to the same component,
        /// the operation fails because it would create a cycle.
        ///
        /// Union by rank ensures that the resulting tree remains shallow.
        ///
        /// **Parameters**
        /// - `a` — first node
        /// - `b` — second node
        ///
        /// **Returns**
        /// - `true` if the sets were merged successfully
        /// - `false` if `a` and `b` were already connected
        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if (pa == pb) return false;

            if (rank[pa] < rank[pb]) parent[pa] = pb;
            else if (rank[pa] > rank[pb]) parent[pb] = pa;
            else {
                parent[pb] = pa;
                rank[pa]++;
            }

            components--;
            return true;
        }
    }

    /// ## Maximum Spanning Tree Stability
    ///
    /// Computes the **maximum possible stability** of a spanning tree.
    ///
    /// The **stability** of a spanning tree is defined as the **minimum edge strength**
    /// among all edges included in the tree.
    ///
    /// Some edges are mandatory (`musti = 1`) and must always be included in the tree.
    /// Optional edges (`musti = 0`) may be upgraded at most once, doubling their strength.
    ///
    /// The algorithm performs a **binary search on the stability value**, checking
    /// whether a spanning tree can be constructed where every edge has strength
    /// at least equal to the candidate stability.
    ///
    /// **Algorithm Overview**
    ///
    /// 1. Determine the maximum possible strength among edges.
    /// 2. Perform binary search on the possible stability range.
    /// 3. For each candidate stability, verify if a valid spanning tree can be built.
    /// 4. Return the largest feasible stability value.
    ///
    /// **Parameters**
    /// - `n` — number of nodes in the graph
    /// - `edges` — list of edges `[u, v, strength, must]`
    /// - `k` — maximum number of upgrades allowed
    ///
    /// **Returns**
    /// - The maximum possible stability value
    /// - `-1` if it is impossible to construct a valid spanning tree
    ///
    /// **Time Complexity**
    /// - `O(E log S)`
    ///
    /// where:
    /// - `E` = number of edges
    /// - `S` = maximum possible edge strength
    public int maxStability(int n, int[][] edges, int k) {

        int maxS = 0;
        for (int[] e : edges)
            maxS = Math.max(maxS, e[2]);

        int left = 1, right = maxS * 2;
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canBuild(n, edges, k, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    /// ## Feasibility Check for a Given Stability
    ///
    /// Determines whether it is possible to construct a valid spanning tree
    /// where every edge has **effective strength ≥ target**.
    ///
    /// **Validation Steps**
    ///
    /// 1. Include all mandatory edges first.
    ///    - If any mandatory edge has strength `< target`, the configuration fails.
    ///    - If mandatory edges form a cycle, a spanning tree is impossible.
    ///
    /// 2. Use optional edges that already satisfy the target strength.
    ///
    /// 3. Use optional edges that can reach the target after a single upgrade.
    ///    - Each upgrade doubles the edge strength.
    ///    - The total number of upgrades must not exceed `k`.
    ///
    /// 4. Verify that exactly `n - 1` edges were used.
    ///
    /// **Parameters**
    /// - `n` — number of nodes
    /// - `edges` — list of graph edges
    /// - `k` — maximum allowed upgrades
    /// - `target` — candidate stability value
    ///
    /// **Returns**
    /// - `true` if a valid spanning tree can be built
    /// - `false` otherwise
    ///
    /// **Time Complexity**
    /// - `O(E α(N))`, where `α` is the inverse Ackermann function.
    private boolean canBuild(int n, int[][] edges, int k, int target) {

        DSU dsu = new DSU(n);
        int upgrades = 0;
        int usedEdges = 0;

        List<int[]> optional = new ArrayList<>();

        /// Process mandatory edges first
        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];

            if (must == 1) {

                if (s < target) return false;

                if (!dsu.union(u, v))
                    return false;

                usedEdges++;
            } else {
                optional.add(e);
            }
        }

        /// Use optional edges that already meet the target strength
        for (int[] e : optional) {
            int u = e[0], v = e[1], s = e[2];

            if (s >= target) {
                if (dsu.union(u, v))
                    usedEdges++;
            }
        }

        /// Use optional edges that can reach target after an upgrade
        for (int[] e : optional) {
            int u = e[0], v = e[1], s = e[2];

            if (s < target && s * 2 >= target) {
                if (dsu.union(u, v)) {
                    upgrades++;
                    usedEdges++;
                    if (upgrades > k)
                        return false;
                }
            }
        }

        return usedEdges == n - 1;
    }
}