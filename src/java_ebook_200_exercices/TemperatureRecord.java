package java_ebook_200_exercices;

import java.util.Arrays;

/**
 /// # TemperatureRecord
 ///
 /// Utility class for maintaining and updating record high and low temperatures.
 ///
 /// ## Overview
 /// This class provides a method to compare historical temperature records with
 /// current readings and update the records if new extremes are found.
 ///
 /// Each temperature record consists of:
 /// - **Index 0** → Record low.
 /// - **Index 1** → Record high.
 ///
 /// ## Example Output
 /// ```text
 /// [[34, 82], [19, 82], [20, 89], [5, 88], [9, 88], [26, 89], [27, 83]]
 /// ```
 ///
 */
public class TemperatureRecord {

    /**
     /// ## recordTemps
     ///
     /// Compares current temperatures with the existing record temperatures
     /// and updates the records if new highs or lows are detected.
     ///
     /// ### Parameters
     /// - `record`: A 2D `int` array representing existing record temperatures.
     ///   - `record[i][0]`: Record low for day `i`.
     ///   - `record[i][1]`: Record high for day `i`.
     /// - `current`: A 2D `int` array representing the current week's temperatures.
     ///   - `current[i][0]`: Current low for day `i`.
     ///   - `current[i][1]`: Current high for day `i`.
     ///
     /// ### Returns
     /// - The updated 2D `int` array of record temperatures.
     ///
     /// ### Behavior
     /// - If the current low is **less** than the record low, update the record low.
     /// - If the current high is **greater** than the record high, update the record high.
     ///
     /// ### Example
     /// ```java
     /// int[][] records = { {34, 82}, {24, 82} };
     /// int[][] current = { {30, 85}, {19, 80} };
     /// int[][] updated = TemperatureRecord.recordTemps(records, current);
     /// // updated = [ [30, 85], [19, 82] ]
     /// ```
     */
    public static int[][] recordTemps(int[][] record, int[][] current) {
        for (int i = 0; i < current.length; i++) {
            int[] dailyTemps = current[i];

            if (dailyTemps[0] < record[i][0]) {
                record[i][0] = dailyTemps[0];
            }

            if (dailyTemps[1] > record[i][1]) {
                record[i][1] = dailyTemps[1];
            }
        }
        return record;
    }

    /**
     /// ## main
     ///
     /// Demonstrates how to update temperature records using `recordTemps`.
     ///
     /// ### Example
     /// ```java
     /// TemperatureRecord.main(new String[]{});
     /// // Output:
     /// // [[34, 82], [19, 82], [20, 89], [5, 88], [9, 88], [26, 89], [27, 83]]
     /// ```
     */
    public static void main(String[] args) {
        int[][] records = {
                {34, 82}, {24, 82}, {20, 89}, {5, 88}, {9, 88}, {26, 89}, {27, 83}
        };

        int[][] currentWeekTemps = {
                {44, 72}, {19, 70}, {40, 69}, {39, 68}, {33, 64}, {36, 70}, {38, 69}
        };

        int[][] updatedRecords = recordTemps(records, currentWeekTemps);

        System.out.println(Arrays.deepToString(updatedRecords));
    }
}
