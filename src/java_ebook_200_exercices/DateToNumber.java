package java_ebook_200_exercices;

/// # DateToNumber
///
/// This class demonstrates how to retrieve the current system time in **milliseconds**
/// since the Unix Epoch (January 1, 1970, 00:00:00 GMT).
///
/// The program uses `System.currentTimeMillis()` to obtain the numerical representation
/// of the current date and time as a `long` value.
///
/// ## Example
/// ```java
/// long millisecondsSinceEpoch = System.currentTimeMillis();
/// System.out.println("Current Time in milliseconds since Unix Epoch: " + millisecondsSinceEpoch);
/// ```
///
/// ## Output
/// ```text
/// Current Time in milliseconds since Unix Epoch: 1726202472472
/// ```
///
/// ## Notes
/// - The returned value is useful for time calculations, measuring elapsed time, or creating unique timestamps.
/// - The value will change every time the program is executed.
public class DateToNumber {
    public static void main(String[] args) {

        // Get the current time in milliseconds since Unix Epoch
        long millisecondsSinceEpoch = System.currentTimeMillis();

        // Print the numerical representation in milliseconds
        System.out.println("Current Time in milliseconds since Unix Epoch: " + millisecondsSinceEpoch);
    }
}
