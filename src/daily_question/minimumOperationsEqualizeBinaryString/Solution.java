package daily_question.minimumOperationsEqualizeBinaryString;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Solution {
    int[] parent;
    boolean[] visited;
    int n;

    public int minOperations(String s, int k) {
        n = s.length();
        int zeros = 0;

        for (char c : s.toCharArray()) {
            if (c == '0') zeros++;
        }

        if (zeros == 0) return 0;

        int maxState = n;
        parent = new int[maxState + 2];
        visited = new boolean[maxState + 1];

        for (int i = 0; i <= maxState + 1; i++) {
            parent[i] = i;
        }

        Queue<Integer> q = new ArrayDeque<>();
        int[] dist = new int[maxState + 1];
        Arrays.fill(dist, -1);

        q.offer(zeros);
        dist[zeros] = 0;
        remove(zeros);

        while (!q.isEmpty()) {
            int m = q.poll();

            int c1 = Math.max(0, k - n + m);
            int c2 = Math.min(m, k);

            int left = m + k - 2 * c2;
            int right = m + k - 2 * c1;

            if ((left & 1) != (m + k) % 2) left++;

            for (int nxt = find(left); nxt <= right; nxt = find(nxt)) {
                dist[nxt] = dist[m] + 1;
                q.offer(nxt);
                remove(nxt);
            }
        }
        return dist[0];
    }

    private int find(int x) {
        if (x > n) return x;
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void remove(int x) {
        visited[x] = true;
        parent[x] = find(x + 2);
    }
}
