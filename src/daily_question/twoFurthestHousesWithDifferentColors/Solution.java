package daily_question.twoFurthestHousesWithDifferentColors;

public class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;

        int max = 0;

        // Compare with first house
        for (int i = n - 1; i >= 0; i--) {
            if (colors[i] != colors[0]) {
                max = Math.max(max, i);
                break;
            }
        }

        // Compare with last house
        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[n - 1]) {
                max = Math.max(max, n - 1 - i);
                break;
            }
        }

        return max;
    }
}
