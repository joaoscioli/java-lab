package daily_question.minimumOperationsMakeUniValueGrid;

import java.util.Arrays;

class Solution {
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
