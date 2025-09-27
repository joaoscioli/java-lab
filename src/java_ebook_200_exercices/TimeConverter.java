package java_ebook_200_exercices;

/// # TimeConverter
///
/// The `TimeConverter` class provides a utility method to convert a given
/// number of minutes into a human-readable string formatted in hours and minutes.
///
/// ## Features
/// - Converts total minutes into hours and remaining minutes.
/// - Returns the result as a formatted string.
/// - Includes an example in the `main` method.
///
public class TimeConverter {

    /// Converts a given number of total minutes into hours and minutes.
    ///
    /// ## Parameters
    /// - `totalMinutes`: The total amount of minutes to be converted.
    ///
    /// ## Returns
    /// A string representing the conversion result in the format:
    /// `"{hours} hours and {minutes} minutes"`.
    ///
    /// ## Example
    /// ```java
    /// String result = TimeConverter.convertMinutesToHoursAndMinutes(135);
    /// System.out.println(result);
    /// // Output: 2 hours and 15 minutes
    /// ```
    public static String convertMinutesToHoursAndMinutes(int totalMinutes) {
        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;
        return hours + " hours and " + minutes + " minutes";
    }

    /// Example usage of the `convertMinutesToHoursAndMinutes` method.
    ///
    /// Demonstrates converting 135 minutes into hours and minutes.
    ///
    /// ## Output
    /// ```
    /// 135 minutes is equivalent to: 2 hours and 15 minutes
    /// ```
    public static void main(String[] args) {
        int totalMinutes = 135;
        String convertedTime = convertMinutesToHoursAndMinutes(totalMinutes);
        System.out.println(totalMinutes + " minutes is equivalent to: " + convertedTime);
    }
}
