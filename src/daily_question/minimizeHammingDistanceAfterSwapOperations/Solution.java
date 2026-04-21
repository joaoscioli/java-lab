package daily_question.minimizeHammingDistanceAfterSwapOperations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        UnionFind uf = new UnionFind(n);

        for (int[] swap : allowedSwaps) {
            uf.union(swap[0], swap[1]);
        }


        Map<Integer, List<Integer>> groups;
        groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        int hamming = 0;

        for (List<Integer> group : groups.values()) {
            Map<Integer, Integer> count = new HashMap<>();

            for (int idx : group) {
                count.put(source[idx], count.getOrDefault(source[idx], 0) + 1);
            }

            for (int idx : group) {
                int val = target[idx];
                if (count.getOrDefault(val, 0) > 0) {
                    count.put(val, count.get(val) - 1);
                } else {
                    hamming++;
                }
            }
        }

        return hamming;

    }
    class UnionFind {
        int[] parent;

        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA != rootB) {
                parent[rootA] = rootB;
            }
        }
    }
}