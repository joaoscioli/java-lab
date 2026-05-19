package daily_question.jumpGameIV;

import java.util.*;

/// Solves the **Jump Game IV** problem.
///
/// Given an integer array, this class computes the minimum number of jumps
/// required to move from the first index to the last index.
///
/// From any index `i`, it is possible to jump to:
///
/// - `i + 1`, if it is within the array bounds
/// - `i - 1`, if it is within the array bounds
/// - Any index `j` where `arr[i] == arr[j]` and `i != j`
///
/// The implementation uses **breadth-first search** to guarantee that the
/// first time the last index is reached, the number of steps taken is minimal.
class Solution {

    /// Returns the minimum number of jumps needed to reach the last index.
    ///
    /// This method performs a breadth-first search over the array indices.
    /// Each BFS level represents one jump. To efficiently handle jumps between
    /// equal values, indices are grouped by their corresponding array value.
    ///
    /// After all indices with the same value have been processed, that value is
    /// removed from the map. This prevents repeatedly scanning the same list of
    /// indices and keeps the traversal efficient.
    ///
    /// ## Algorithm
    ///
    /// 1. Group all indices by their value.
    /// 2. Start BFS from index `0`.
    /// 3. For each visited index, explore:
    ///    - all indices with the same value,
    ///    - the next index,
    ///    - the previous index.
    /// 4. Return the current BFS depth when the last index is reached.
    ///
    /// ## Complexity
    ///
    /// - **Time complexity:** `O(n)`, where `n` is the length of `arr`.
    /// - **Space complexity:** `O(n)`, for the map, queue, and visited array.
    ///
    /// @param arr the input array representing the jump graph
    /// @return the minimum number of jumps required to reach the last index,
    ///         or `-1` if the last index cannot be reached
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