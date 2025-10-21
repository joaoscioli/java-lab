package java_ebook_200_exercices;

/// # ConvertDaysToYearsMonthsDays
///
/// This class provides a utility method to convert a total number of days into an approximate
/// breakdown of years, months, and days.
///
/// It assumes:
/// - 1 year = 365 days
/// - 1 month = 30 days
///
/// This simplified conversion is useful for general estimations but not for calendar-accurate
/// calculations (e.g., leap years or variable month lengths are not considered).
///
/// ## Example
/// ```java
/// int totalDays = 1000;
/// int[] result = ConvertDaysToYearsMonthsDays.convertDaysToYearsMonthsDays(totalDays);
/// System.out.printf("%d days is approximately %d years, %d months, and %d days.%n",
///     totalDays, result[0], result[1], result[2]);
/// // Output: 1000 days is approximately 2 years, 9 months, and 0 days.
/// ```
///
/// @since Java 17
public class ConvertDaysToYearsMonthsDays {

    /// Converts a given number of days into years, months, and remaining days.
    ///
    /// The method divides the total days by 365 to determine the number of years,
    /// then calculates the remaining days to estimate the number of months (based on 30 days per month)
    /// and finally returns the leftover days.
    ///
    /// ## Parameters
    /// - `days`: The total number of days to be converted.
    ///
    /// ## Returns
    /// An integer array containing:
    /// - `years`: the number of full years
    /// - `months`: the number of remaining months
    /// - `days`: the number of leftover days
    ///
    /// ## Example
    /// ```java
    /// int[] result = ConvertDaysToYearsMonthsDays.convertDaysToYearsMonthsDays(800);
    /// // result = [2, 2, 10]
    /// ```
    public static int[] convertDaysToYearsMonthsDays(int days) {
        int years = days / 365;
        int remainingDaysAfterYears = days % 365;
        int months = remainingDaysAfterYears / 30;
        int remainingDaysAfterMonths = remainingDaysAfterYears % 30;
        return new int[] { years, months, remainingDaysAfterMonths };
    }

    /// Demonstrates the conversion of a sample number of days (1000) into years, months, and days.
    ///
    /// Prints the formatted result to the console.
    public static void main(String[] args) {
        int totalDays = 1000;
        int[] result = convertDaysToYearsMonthsDays(totalDays);
        System.out.printf(
                "%d days is approximately %d years, %d months, and %d days.%n",
                totalDays, result[0], result[1], result[2]
        );
    }
}
