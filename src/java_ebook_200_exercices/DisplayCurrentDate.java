package java_ebook_200_exercices;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/// # DisplayCurrentDate
///
/// This class demonstrates how to obtain and format the current date in Java.
///
/// ## Features
/// - Uses `LocalDate.now()` to get the current system date.
/// - Formats the date into the `MM/dd/yyyy` format using `DateTimeFormatter`.
/// - Outputs the formatted date to the console.
///
/// ## Example Output
/// ```
/// Current Date: 09/20/2024
/// ```
///
/// ## See Also
/// - [`LocalDate`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/LocalDate.html)
/// - [`DateTimeFormatter`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html)
public class DisplayCurrentDate {
    public static void main(String[] args) {

        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Format the current date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = currentDate.format(formatter);

        // Display the result
        System.out.println("Current Date: " + formattedDate);
    }
}
