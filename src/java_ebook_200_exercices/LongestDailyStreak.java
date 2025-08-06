package java_ebook_200_exercices;

/**
 /// # LongestDailyStreak
 ///
 /// Utility class to calculate the longest consecutive daily login streak.
 ///
 /// ## Overview
 /// This class provides a static method to compute the maximum number of
 /// consecutive `true` values in a boolean array, representing daily user logins.
 ///
 /// ## Example Output
 /// ```text
 /// 2
 /// ```
 ///
 */
public class LongestDailyStreak {

    /**
     /// ## main
     ///
     /// Demonstrates the usage of the `dailyStreak` method with a test case.
     ///
     /// ### Example
     /// ```java
     /// LongestDailyStreak.main(); // Output: 2
     /// ```
     */
    static void main() {
        // Test cases
        System.out.println(dailyStreak(new boolean[] {true, true, false, true }));
    }

    /**
     /// ## dailyStreak
     ///
     /// Calculates the longest streak of consecutive `true` values in a boolean array.
     ///
     /// ### Parameters
     /// - `logins`: A boolean array where each element represents whether the user logged in on a specific day.
     ///
     /// ### Returns
     /// - An `int` representing the longest sequence of consecutive `true` values.
     ///
     /// ### Behavior
     /// - Iterates through the array, counting consecutive `true` values.
     /// - Resets the counter when a `false` is found.
     /// - Updates the maximum streak as needed.
     ///
     /// ### Example
     /// ```java
     /// int streak = LongestDailyStreak.dailyStreak(new boolean[] {
     ///     true, true, false, true
     /// }); // Returns: 2
     /// ```
     */
    public static int dailyStreak(boolean[] logins) {
        int maxStreak = 0;
        int currentStreak = 0;

        for (boolean loggedIn : logins) {
            if (loggedIn) {
                currentStreak++;
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }

        return maxStreak;
    }
}
