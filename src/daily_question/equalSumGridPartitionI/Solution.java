package daily_question.equalSumGridPartitionI;

/// # Equal Sum Grid Partition I
///
/// Determines whether it is possible to partition a 2D grid of positive integers
/// into two **non-empty** sections using exactly one **horizontal** or **vertical cut**
/// such that the sum of elements in both sections is equal.
///
/// ---
///
/// ## Approach
///
/// The solution is based on **prefix sum accumulation**:
///
/// 1. Compute the **total sum** of the grid.
/// 2. If the total is **odd**, partitioning into two equal parts is impossible.
/// 3. Otherwise, the target for each partition is `total / 2`.
/// 4. Try all possible:
///    - **Horizontal cuts** → accumulate row sums.
///    - **Vertical cuts** → accumulate column sums.
/// 5. If any prefix sum equals the target, a valid partition exists.
///
/// ---
///
/// ## Algorithm Steps
///
/// - Traverse the grid once to:
///   - Compute the total sum.
///   - Compute column-wise sums.
/// - Check horizontal partitions using row prefix sums.
/// - Check vertical partitions using column prefix sums.
///
/// ---
///
/// ## Complexity
///
/// - **Time Complexity:** `O(m * n)`
/// - **Space Complexity:** `O(n)` (for column sums)
///
/// ---
///
/// ## Constraints
///
/// - `1 <= m, n`
/// - `2 <= m * n <= 100000`
/// - `1 <= grid[i][j] <= 100000`
///
/// ---
///
/// ## Example
///
/// ```text
/// Input:
/// grid = [[1,4],
///         [2,3]]
///
/// Output:
/// true
///
/// Explanation:
/// A horizontal cut after the first row gives:
/// Top sum = 1 + 4 = 5
/// Bottom sum = 2 + 3 = 5
/// ```
///
/// ---
///
/// ## Edge Cases
///
/// - No valid cut exists → return `false`.
/// - Single row or column still works as long as both partitions are non-empty.
///
/// ---
///
/// ## Notes
///
/// - Uses `long` to avoid overflow due to large constraints.
/// - Early exit is applied as soon as a valid partition is found.
///
/// @param grid a 2D matrix of positive integers
/// @return {@code true} if a valid equal-sum partition exists; {@code false} otherwise
///

class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        long total = 0;
        long[] colSum = new long[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += grid[i][j];
                colSum[j] += grid[i][j];
            }
        }

        if (total % 2 != 0) return false;

        long target = total / 2;

        long rowPrefix = 0;
        for (int i = 0; i < m - 1; i++) {
            long rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += grid[i][j];
            }
            rowPrefix += rowSum;

            if (rowPrefix == target) return true;
        }

        long colPrefix = 0;
        for (int j = 0; j < n - 1; j++) {
            colPrefix += colSum[j];
            if (colPrefix == target) return true;
        }

        return false;
    }
}