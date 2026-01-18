package daily_question.largestMagicSquare;

class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] row = new int[m][n + 1];
        int[][] col = new int[m + 1][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i][j + 1] = row[i][j] + grid[i][j];
                col[i + 1][j] = col[i][j] + grid[i][j];
            }
        }

        for (int k = Math.min(m, n); k >= 2; k--) {
            for (int i = 0; i + k <= m; i++) {
                for (int j = 0; j + k <= n; j++) {

                    int target = row[i][j + k] - row[i][j];
                    boolean ok = true;

                    for (int r = 0; r < k && ok; r++) {
                        if (row[i + r][j + k] - row[i + r][j] != target)
                            ok = false;
                    }

                    for (int c = 0; c < k && ok; c++) {
                        if (col[i + k][j + c] - col[i][j + c] != target)
                            ok = false;
                    }

                    if (ok) {
                        int d1 = 0, d2 = 0;
                        for (int t = 0; t < k; t++) {
                            d1 += grid[i + t][j + t];
                            d2 += grid[i + t][j + k - 1 - t];
                        }
                        if (d1 == target && d2 == target)
                            return k;
                    }
                }
            }
        }
        return 1;
    }
}