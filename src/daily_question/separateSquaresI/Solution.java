package daily_question.separateSquaresI;

class Solution {
    public double separateSquares(int[][] squares) {
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;
        double totalArea = 0.0;

        for (int[] s : squares) {
            low = Math.min(low, s[1]);
            high = Math.max(high, s[1] + s[2]);
            totalArea += (double) s[2] * s[2];
        }

        double halfArea = totalArea / 2.0;

        while (high - low > 1e-6) {
            double mid = (low + high) / 2.0;
            double areaBelow = areaBelowLine(squares, mid);

            if (areaBelow < halfArea) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private double areaBelowLine(int[][] squares, double y) {
        double area = 0.0;

        for (int[] s : squares) {
            double bottom = s[1];
            double side = s[2];

            double height = Math.min(Math.max(y - bottom, 0), side);
            area += height * side;
        }

        return area;
    }
}