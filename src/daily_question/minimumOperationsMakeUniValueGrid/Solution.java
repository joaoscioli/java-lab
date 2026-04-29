package daily_question.minimumOperationsMakeUniValueGrid;

import java.util.Arrays;

/// ## Solution
///
/// Provides a method to compute the minimum number of operations required
/// to make all elements in a 2D grid equal, given a fixed step size `x`.
///
/// ### Problem Summary
/// You are given a 2D grid of integers. In one operation, you can add or subtract
/// a fixed value `x` from any element in the grid.
///
/// The goal is to make all elements in the grid equal using the minimum number
/// of operations. If it is not possible, return `-1`.
///
/// ### Approach
/// 1. Flatten the 2D grid into a 1D array.
/// 2. Check feasibility:
///    - All elements must have the same remainder when divided by `x`.
///    - If not, return `-1`.
/// 3. Sort the flattened array.
/// 4. Choose the median value as the target:
///    - The median minimizes the sum of absolute differences.
/// 5. Calculate the number of operations required to convert all values
///    to the median using steps of size `x`.
///
/// ### Time Complexity
/// - `O(n log n)` due to sorting
///
/// ### Space Complexity
/// - `O(n)` for the flattened array
class Solution {

    /// ### minOperations
    ///
    /// Computes the minimum number of operations required to make all values
    /// in the grid equal using increments or decrements of size `x`.
    ///
    /// ### Parameters
    /// - `grid`: A 2D array of integers representing the grid.
    /// - `x`: The fixed value that can be added or subtracted in one operation.
    ///
    /// ### Returns
    /// - The minimum number of operations required to make all elements equal.
    /// - Returns `-1` if it is impossible.
    ///
    /// ### Example
    /// ```java
    /// int[][] grid = {
    ///     {2, 4},
    ///     {6, 8}
    /// };
    /// int x = 2;
    ///
    /// Solution sol = new Solution();
    /// int result = sol.minOperations(grid, x);
    /// // result = 4
    /// ```
    ///
    /// ### Notes
    /// - The key observation is that all elements must be congruent modulo `x`.
    /// - The optimal target value is the median of the flattened array.
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;

        int[] flat = new int[total];
        int idx = 0;
        for (int[] row : grid) {
            for (int val : row) {
                flat[idx++] = val;
            }
        }

        int remainder = flat[0] % x;
        for (int val : flat) {
            if (val % x != remainder) {
                return -1;
            }
        }

        Arrays.sort(flat);
        int median = flat[total / 2];

        int operations = 0;
        for (int val : flat) {
            operations += Math.abs(val - median) / x;
        }

        return operations;
    }
}