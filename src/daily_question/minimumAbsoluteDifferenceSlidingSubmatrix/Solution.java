package daily_question.minimumAbsoluteDifferenceSlidingSubmatrix;

import java.util.*;

/// # Minimum Absolute Difference in Sliding Submatrix
///
/// Computes the minimum absolute difference between any two **distinct values**
/// within every `k x k` submatrix of a given 2D grid.
///
/// ## Approach
///
/// For each possible `k x k` submatrix:
///
/// 1. Collect all elements into a `Set` to ensure **distinct values only**.
/// 2. If there is only one (or zero) distinct value, the result is `0`.
/// 3. Convert the set into a list and sort it.
/// 4. Compute the minimum difference between **adjacent elements** in sorted order.
///
/// Sorting ensures that the smallest absolute difference is found between neighbors.
///
/// ## Complexity
///
/// - Time Complexity:
///   - For each submatrix: `O(k^2 log k)`
///   - Total: `O(m * n * k^2 log k)`
///
/// - Space Complexity:
///   - `O(k^2)` for storing elements of each submatrix.
///
/// ## Constraints
///
/// - `1 <= m, n <= 30`
/// - `1 <= k <= min(m, n)`
///
/// ## Notes
///
/// - Using a `Set` is essential to ignore duplicate values,
///   since the problem requires differences between **distinct values only**.
/// - Early exit is applied when only one distinct value exists.
///
/// @param grid the input 2D integer matrix
/// @param k the size of the submatrix (k x k)
/// @return a 2D matrix where each cell contains the minimum absolute difference
///         for the corresponding submatrix
class Solution {

    /// Computes the minimum absolute difference for each k x k submatrix.
    ///
    /// @param grid the input matrix
    /// @param k the submatrix size
    /// @return the result matrix with computed minimum differences
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] ans = new int[m - k + 1][n - k + 1];

        // Iterate over all possible k x k submatrices
        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {

                // Use a set to keep only distinct values
                Set<Integer> set = new HashSet<>();

                // Collect elements from the current submatrix
                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        set.add(grid[x][y]);
                    }
                }

                // If only one distinct value exists, min difference is 0
                if (set.size() <= 1) {
                    ans[i][j] = 0;
                    continue;
                }

                // Convert set to list and sort
                List<Integer> list = new ArrayList<>(set);
                Collections.sort(list);

                int minDiff = Integer.MAX_VALUE;

                // Compute minimum difference between adjacent elements
                for (int p = 1; p < list.size(); p++) {
                    minDiff = Math.min(minDiff, list.get(p) - list.get(p - 1));
                }

                ans[i][j] = minDiff;
            }
        }

        return ans;
    }
}