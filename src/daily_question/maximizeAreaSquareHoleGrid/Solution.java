package daily_question.maximizeAreaSquareHoleGrid;

import java.util.Arrays;

class Solution {
    public static int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxH = maxConsecutive(hBars);
        int maxV = maxConsecutive(vBars);

        int side = Math.min(maxH, maxV);
        return side * side;
    }

    private static int maxConsecutive(int[] bars) {
        Arrays.sort(bars);

        int maxStreak = 1;
        int currentStreak = 1;

        for (int i = 1; i < bars.length; i++) {
            if (bars[i] == bars[i - 1] + 1) {
                currentStreak++;
            } else {
                currentStreak = 1;
            }
            maxStreak = Math.max(maxStreak, currentStreak);
        }

        // tamanho do intervalo = barras consecutivas removidas + 1
        return maxStreak + 1;
    }

    public static void main(String[] args) {
        System.out.println(maximizeSquareHoleArea(
                2, 1,
                new int[]{2, 3},
                new int[]{2}
        )); // Output: 4
    }
}
