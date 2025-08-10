package java_ebook_200_exercices;

import java.util.Arrays;

public class TemperatureRecord {
    // Method to record the temperatures
    public static int[][] recordTemps(int[][] record, int[][] current) {
        for (int i = 0; i < current.length; i++) {
            int[] dailyTemps = current[i];

            // Update record low if current daily low is lower
            if (dailyTemps[0] < record[i][0]) {
                record[i][0] = dailyTemps[0];
            }

            // Update record high if current daily high is higher
            if (dailyTemps[1] > record[i][1]) {
                record[i][1] = dailyTemps[1];
            }
        }
        return record;
    }

    public static void main(String[] args) {

        // Initial record temperatures
        int[][] records = {

                {34, 82}, {24, 82}, {20, 89}, {5, 88}, {9, 88}, {26, 89}, {27, 83}

        };

        // Current week's temperatures
        int[][] currentWeekTemps = {
                {44, 72}, {19, 70}, {40, 69}, {39, 68}, {33, 64}, {36, 70}, {38, 69}
        };

        // Updating the record temperatures
        int[][] updatedRecords = recordTemps(records, currentWeekTemps);

        // Output: [[34, 82], [19, 82], [20, 89], [5, 88], [9, 88], [26, 89], [27, 83]]
        System.out.println(Arrays.deepToString(updatedRecords));
    }
}
