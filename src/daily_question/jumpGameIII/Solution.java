package daily_question.jumpGameIII;

/// Provides a depth-first search solution for the Jump Game III problem.
///
/// The goal is to determine whether it is possible to reach any index whose
/// value is `0`, starting from a given index.
///
/// From each position `i`, the next valid moves are:
///
/// - `i + arr[i]`
/// - `i - arr[i]`
///
/// A `visited` array is used to avoid revisiting indexes and prevent infinite
/// recursion caused by cycles in the jump graph.
class Solution {

    /// Determines whether it is possible to reach an index with value `0`
    /// starting from the given index.
    ///
    /// This method initializes the visited-state tracking array and delegates
    /// the search to a depth-first search helper.
    ///
    /// @param arr the array of non-negative integers representing jump lengths
    /// @param start the index from which the search begins
    /// @return `true` if an index containing `0` can be reached; otherwise `false`
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return dfs(arr, start, visited);
    }

    /// Performs a depth-first search from the given index.
    ///
    /// The search stops and returns `false` when the current index is outside
    /// the bounds of the array or has already been visited. It returns `true`
    /// when the current index contains `0`.
    ///
    /// Otherwise, the current index is marked as visited, and the search
    /// continues recursively in both possible jump directions.
    ///
    /// @param arr the array of non-negative integers representing jump lengths
    /// @param index the current index being explored
    /// @param visited tracks whether each index has already been explored
    /// @return `true` if an index containing `0` is reachable from `index`;
    ///         otherwise `false`
    private boolean dfs(int[] arr, int index, boolean[] visited) {
        if (index < 0 || index >= arr.length || visited[index]) {
            return false;
        }

        if (arr[index] == 0) {
            return true;
        }

        visited[index] = true;

        return dfs(arr, index + arr[index], visited)
                || dfs(arr, index - arr[index], visited);
    }
}