package daily_question.JumpGameV;

/// Solves the **Jump Game V** problem using depth-first search with memoization.
///
/// Given an array of integers and a maximum jump distance `d`, this class computes
/// the maximum number of indices that can be visited starting from any position.
///
/// A jump is valid when:
///
/// - The target index is at most `d` positions away.
/// - The target value is strictly smaller than the current value.
/// - Every position crossed before reaching the target is also strictly smaller;
///   the search stops when a value greater than or equal to the current value is found.
///
/// The algorithm treats each index as the start of a descending path and caches
/// the best result for each index to avoid recomputation.
class Solution {
    /// The input array containing the height or value at each index.
    private int[] arr;

    /// The maximum allowed jump distance to the left or right.
    private int d;

    /// Memoization array where `memo[i]` stores the maximum number of indices
    /// that can be visited starting from index `i`.
    ///
    /// A value of `0` means that the result for the index has not been computed yet.
    private int[] memo;

    /// Returns the maximum number of indices that can be visited in the array.
    ///
    /// The method initializes the internal state and evaluates every index as a
    /// possible starting point. For each index, it uses `dfs(int)` to compute the
    /// longest valid jump sequence starting from that position.
    ///
    /// @param arr the array of values used to determine valid jumps
    /// @param d the maximum distance allowed for a single jump
    /// @return the maximum number of indices that can be visited from any starting index
    public int maxJumps(int[] arr, int d) {
        this.arr = arr;
        this.d = d;
        this.memo = new int[arr.length];

        int answer = 1;

        for (int i = 0; i < arr.length; i++) {
            answer = Math.max(answer, dfs(i));
        }

        return answer;
    }

    /// Computes the longest valid jump sequence starting from the given index.
    ///
    /// This method searches both directions:
    ///
    /// - To the right, up to `d` positions away.
    /// - To the left, up to `d` positions away.
    ///
    /// The search in a direction stops as soon as a value greater than or equal
    /// to the current value is found, because no position beyond that point can
    /// be reached in that direction.
    ///
    /// Results are cached in `memo` so each index is computed only once.
    ///
    /// @param index the starting index for the depth-first search
    /// @return the maximum number of indices that can be visited starting from `index`
    private int dfs(int index) {
        if (memo[index] != 0) {
            return memo[index];
        }

        int best = 1;

        // Jump to the right
        for (int next = index + 1; next <= Math.min(index + d, arr.length - 1); next++) {
            if (arr[next] >= arr[index]) {
                break;
            }

            best = Math.max(best, 1 + dfs(next));
        }

        // Jump to the left
        for (int next = index - 1; next >= Math.max(index - d, 0); next--) {
            if (arr[next] >= arr[index]) {
                break;
            }

            best = Math.max(best, 1 + dfs(next));
        }

        memo[index] = best;
        return best;
    }
}
