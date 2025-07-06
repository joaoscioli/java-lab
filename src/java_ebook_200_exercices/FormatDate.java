package java_ebook_200_exercices;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/// # FormatDate
///
/// This program demonstrates how to retrieve and format the current date using
/// Java's modern date and time API (`java.time`). It uses `LocalDateTime` to
/// get the current date and `DateTimeFormatter` to format it into a
/// human-readable string.
///
/// ## Overview
/// The program:
/// 1. Retrieves the current system date and time using `LocalDateTime.now()`.
/// 2. Formats the date using a pattern with `DateTimeFormatter.ofPattern(...)`.
/// 3. Displays the formatted date string.
///
/// ## Formatting Pattern
/// The pattern used is:
/// ```java
/// "EEEE, MMMM dd, yyyy"
/// ```
/// Which produces a result like:
/// ```text
/// Friday, September 20, 2024
/// ```
///
/// ## Output Example
/// ```text
/// Formatted Date: Friday, September 20, 2024
/// ```
///
/// ## Use Cases
/// - Displaying localized or user-friendly dates
/// - Logging, reporting, or UI elements that require date formatting
/// - Formatting dates for email headers, file names, or exports
///
/// ## See Also
/// - [`LocalDateTime`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/LocalDateTime.html)
/// - [`DateTimeFormatter`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/format/DateTimeFormatter.html)
///
public class FormatDate {
    public static void main(String[] args) {

        // Get the current date and time
        LocalDateTime currentDate = LocalDateTime.now();

        // Format the date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy");
        String formattedDate = currentDate.format(formatter);

        // Display the result
        System.out.println("Formatted Date: " + formattedDate);
    }
}
