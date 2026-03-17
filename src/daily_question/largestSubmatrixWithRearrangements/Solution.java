package daily_question.largestSubmatrixWithRearrangements;

import java.util.Arrays;

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = 0;

        int[][] height = new int[m][n];

        for (int j = 0; j < n; j++) {
            height[0][j] = matrix[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    height[i][j] = height[i - 1][j] + 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int[] row = height[i].clone();
            Arrays.sort(row);

            for (int j = 0; j < n; j++) {
                int h = row[n - 1 - j];
                int width = j + 1;
                maxArea = Math.max(maxArea, h * width);
            }
        }

        return maxArea;
    }
}