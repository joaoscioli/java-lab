package daily_question.countSubmatricesWithEqualFrequencyXandY;

class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] sum = new int[m + 1][n + 1];
        int[][] countX = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = 0;
                if (grid[i][j] == 'X') val = 1;
                else if (grid[i][j] == 'Y') val = -1;

                sum[i + 1][j + 1] = val
                        + sum[i][j + 1]
                        + sum[i + 1][j]
                        - sum[i][j];

                countX[i + 1][j + 1] = (grid[i][j] == 'X' ? 1 : 0)
                        + countX[i][j + 1]
                        + countX[i + 1][j]
                        - countX[i][j];
            }
        }

        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int total = sum[i + 1][j + 1];
                int xCount = countX[i + 1][j + 1];

                if (total == 0 && xCount > 0) {
                    result++;
                }
            }
        }

        return result;
    }
}