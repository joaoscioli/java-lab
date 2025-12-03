package daily_question.maximumAreaLongestDiagonalRectangle;

class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiag = 0;
        int maxArea = 0;

        for (int[] d : dimensions) {
            int L = d[0];
            int W = d[1];

            int diag = L * L + W * W;
            int area = L * W;

            if (diag > maxDiag) {
                maxDiag = diag;
                maxArea = area;
            } else if (diag == maxDiag) {
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}
