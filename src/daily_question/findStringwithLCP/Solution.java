package daily_question.findStringwithLCP;

class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;

        for (int i = 0; i < n; i++) {
            if (lcp[i][i] != n - i) return "";
            for (int j = 0; j < n; j++) {
                if (lcp[i][j] != lcp[j][i]) return "";
            }
        }

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lcp[i][j] > 0) {
                    union(parent, i, j);
                }
            }
        }

        char[] res = new char[n];
        int[] map = new int[n];
        for (int i = 0; i < n; i++) map[i] = -1;

        char cur = 'a';

        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            if (map[root] == -1) {
                if (cur > 'z') return "";
                map[root] = cur++;
            }
            res[i] = (char) map[root];
        }

        int[][] calc = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (res[i] == res[j]) {
                    calc[i][j] = 1;
                    if (i + 1 < n && j + 1 < n) {
                        calc[i][j] += calc[i + 1][j + 1];
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (calc[i][j] != lcp[i][j]) return "";
            }
        }

        return new String(res);
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    private void union(int[] parent, int a, int b) {
        int pa = find(parent, a);
        int pb = find(parent, b);
        if (pa != pb) parent[pa] = pb;
    }
}