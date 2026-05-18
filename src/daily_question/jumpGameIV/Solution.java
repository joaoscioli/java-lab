package daily_question.jumpGameIV;

import java.util.*;

class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;

        if (n == 1) {
            return 0;
        }

        Map<Integer, List<Integer>> indexesByValue = new HashMap<>();

        for (int i = 0; i < n; i++) {
            indexesByValue
                    .computeIfAbsent(arr[i], value -> new ArrayList<>())
                    .add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.offer(0);
        visited[0] = true;

        int steps = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                int index = queue.poll();

                if (index == n - 1) {
                    return steps;
                }

                List<Integer> nextIndexes = indexesByValue.get(arr[index]);

                if (nextIndexes != null) {
                    for (int nextIndex : nextIndexes) {
                        if (!visited[nextIndex]) {
                            visited[nextIndex] = true;
                            queue.offer(nextIndex);
                        }
                    }

                    indexesByValue.remove(arr[index]);
                }

                int nextIndex = index + 1;

                if (nextIndex < n && !visited[nextIndex]) {
                    visited[nextIndex] = true;
                    queue.offer(nextIndex);
                }

                int previousIndex = index - 1;

                if (previousIndex >= 0 && !visited[previousIndex]) {
                    visited[previousIndex] = true;
                    queue.offer(previousIndex);
                }
            }

            steps++;
        }

        return -1;
    }
}