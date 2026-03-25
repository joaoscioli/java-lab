package daily_question.equalSumGridPartitionI;

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
