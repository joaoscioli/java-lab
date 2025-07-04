package java_ebook_200_exercices;

/// # CheckLeapYear
///
/// This program checks whether a given year is a **leap year** based on the rules
/// defined in the Gregorian calendar.
///
/// ## Overview
/// A **leap year** occurs:
/// - Every year that is evenly divisible by 4;
/// - **Except** years that are evenly divisible by 100;
/// - **Unless** the year is also evenly divisible by 400.
///
/// The program defines a method `isLeapYear(int year)` that applies this logic,
/// and then calls it with an example year.
///
/// ## Method
/// ```java
/// public static boolean isLeapYear(int year)
/// ```
/// Returns `true` if the year is a leap year; otherwise, returns `false`.
///
/// ## Example
/// - **Input:** `2024`
/// - **Output:**
/// ```text
/// 2024 is a leap year.
/// ```
///
/// ## Use Cases
/// - Validating calendar data
/// - Working with date/time logic in applications
/// - Implementing scheduling or recurring event systems
///
/// ## See Also
/// - [Leap year rules – Wikipedia](https://en.wikipedia.org/wiki/Leap_year#Gregorian_calendar)
/// - [`java.time.Year#isLeap()`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/Year.html#isLeap())
///
public class CheckLeapYear {
    // Method to check if a year is a leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {

        // Example year to check
        int yearToCheck = 2024;

        // Check if the year is a leap year
        if (isLeapYear(yearToCheck)) {
            System.out.println(yearToCheck + " is a leap year.");
        } else {
            System.out.println(yearToCheck + " is not a leap year.");
        }
    }
}
