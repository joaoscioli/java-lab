package java_ebook_200_exercices;

public class LongestDailyStreak {
    static void main() {
        // Test cases
        System.out.println(dailyStreak(new boolean[] {true, true, false, true }));  // Outputs: 2

    }

    public static int dailyStreak(boolean[] logins) {
        int maxStreak = 0;
        int currentStreak = 0;

        for (boolean loggedIn : logins) {
            if (loggedIn) {
                currentStreak++;    // Increase current streak if logged in
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;  // Update max streak if needed
                }
            } else {
                currentStreak = 0;  // Reset current streak if not logged in
            }
        }
        return maxStreak;   // Return the longest streak found
    }
}
