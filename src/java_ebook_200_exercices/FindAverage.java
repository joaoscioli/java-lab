package java_ebook_200_exercices;

/// # FindAverage
///
/// This class provides a simple method to calculate the average of two numbers.
///
/// ## Features
/// - Computes the sum of two given numbers.
/// - Divides the result by 2 to obtain the arithmetic mean.
///
/// ## Example
/// ```java
/// double result = FindAverage.findAverage(10.0, 20.0);
/// System.out.println(result); // 15.0
/// ```
///
/// ## Output
/// ```text
/// The average of 10.0 and 20.0 is: 15.0
/// ```
public class FindAverage {

    /// ## findAverage
    ///
    /// Calculates the arithmetic mean of two numbers.
    ///
    /// ### Parameters
    /// - `num1`: The first number to be averaged.
    /// - `num2`: The second number to be averaged.
    ///
    /// ### Returns
    /// - The average of `num1` and `num2` as a `double`.
    ///
    /// ### Example
    /// ```java
    /// double avg = FindAverage.findAverage(5.0, 15.0);
    /// System.out.println(avg); // 10.0
    /// ```
    public static double findAverage(double num1, double num2) {

        // Calculate the sum of the two numbers
        double total = num1 + num2;

        // Calculate the average by dividing the sum by 2
        return total / 2.0;
    }

    /// ## main
    ///
    /// Entry point of the program. Demonstrates the usage of the `findAverage` method.
    ///
    /// ### Example
    /// ```java
    /// // Expected output:
    /// // The average of 10.0 and 20.0 is: 15.0
    /// ```
    public static void main(String[] args) {
        double number1 = 10.0;
        double number2 = 20.0;
        double result = findAverage(number1, number2);
        System.out.println("The average of " + number1 + " and " + number2 + " is: " + result);
    }
}
