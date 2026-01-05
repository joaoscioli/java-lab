package daily_question.MaximumMatrixSum;

import javax.print.DocFlavor;
import java.io.IO;

public class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long totalAbs = 0;
        int negativeCount = 0;
        int minAbs = Integer.MAX_VALUE;

        for (int[] row : matrix) {
            for (int val : row) {
                totalAbs += Math.abs(val);
                if (val < 0) negativeCount++;
                minAbs = Math.min(minAbs, Math.abs(val));
            }
        }

        if (negativeCount % 2 == 0) {
            return totalAbs;
        }
        return totalAbs - 2L * minAbs;
    }

    void main() {
        int[][] matrix = {{1,-1},{-1,1}};
        IO.println(maxMatrixSum(matrix));
    }
}
