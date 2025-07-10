package java_ebook_200_exercices;

import java.time.LocalDate;

/// # CompareValueTwoDates
///
/// Demonstrates how to compare two `LocalDate` instances in Java.
///
/// ## Description
/// This program creates two specific dates and compares them using the `isBefore()`, `isAfter()`, and `equals()` methods.
/// It then prints a message indicating the chronological relationship between the two dates.
///
/// ## Features
/// - Uses `LocalDate.of()` to create date instances.
/// - Compares dates with:
///   - `isBefore()`
///   - `isAfter()`
///   - `equals()` (via `else`)
/// - Prints the result to the console.
///
/// ## Example Output
/// ```
/// 2022-01-01 is earlier than 2023-01-01
/// ```
///
public class CompareValueTwoDates {
    public static void main(String[] args) {

        // Parse the example dates
        LocalDate date1 = LocalDate.of(2022, 1, 1);
        LocalDate date2 = LocalDate.of(2023, 1, 1);

        // Compare dates
        if (date1.isBefore(date2)) {
            System.out.println(date1 + " is earlier than " + date2);
        } else if (date1.isAfter(date2)) {
            System.out.println(date1 + " is later than " + date2);
        } else {
            System.out.println(date1 + " is equal to " + date2);
        }
    }
}
