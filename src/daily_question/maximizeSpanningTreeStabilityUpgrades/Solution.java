package daily_question.maximizeSpanningTreeStabilityUpgrades;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static class DSU {
        int[] parent, rank;
        int components;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            components = n;

            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

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

    private boolean canBuild(int n, int[][] edges, int k, int target) {

        DSU dsu = new DSU(n);
        int upgrades = 0;
        int usedEdges = 0;

        List<int[]> optional = new ArrayList<>();

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

        for (int[] e : optional) {
            int u = e[0], v = e[1], s = e[2];

            if (s >= target) {
                if (dsu.union(u, v))
                    usedEdges++;
            }
        }

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