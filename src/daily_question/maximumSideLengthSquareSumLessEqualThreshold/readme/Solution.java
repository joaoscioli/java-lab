package daily_question.maximumSideLengthSquareSumLessEqualThreshold.readme;

class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] prefix = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = mat[i - 1][j - 1]
                        + prefix[i - 1][j]
                        + prefix[i][j - 1]
                        - prefix[i - 1][j - 1];
            }
        }

        int left = 0;
        int right = Math.min(m, n);
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (existsSquare(prefix, m, n, mid, threshold)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private boolean existsSquare(int[][] prefix, int m, int n, int size, int threshold) {
        for (int i = 0; i + size <= m; i++) {
            for (int j = 0; j + size <= n; j++) {
                int sum = prefix[i + size][j + size]
                        - prefix[i][j + size]
                        - prefix[i + size][j]
                        + prefix[i][j];

                if (sum <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }
}
