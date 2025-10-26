package java_ebook_200_exercices;

/// # CheckNumberPerfectSquare
///
/// This class provides a method to determine whether a given number is a **perfect square**.
///
/// A *perfect square* is a non-negative number that is the square of an integer.
/// For example, 1, 4, 9, 16, and 25 are all perfect squares.
///
/// ## Example
/// ```java
/// double testNumber = 25.0;
/// boolean result = CheckNumberPerfectSquare.isPerfectSquare(testNumber);
/// System.out.printf("Is %.1f a perfect square? %b%n", testNumber, result);
/// ```
///
/// **Output:**
/// ```text
/// Is 25.0 a perfect square? true
/// ```
///
/// @since 1.0
public class CheckNumberPerfectSquare {

    /// Checks whether a given number is a perfect square.
    ///
    /// The method first validates that the number is **non-negative**, then computes
    /// its square root and compares it to the nearest lower integer using `Math.floor()`.
    /// If the square root is an integer (no fractional part), the number is a perfect square.
    ///
    /// ## Parameters
    /// - `number`: The number to check.
    ///
    /// ## Returns
    /// - `true` if the number is a perfect square.
    /// - `false` otherwise.
    ///
    /// ## Example
    /// ```java
    /// boolean result = CheckNumberPerfectSquare.isPerfectSquare(16);
    /// System.out.println(result); // true
    /// ```
    public static boolean isPerfectSquare(double number) {

        // Check if the number is a non-negative value
        if (number < 0) {
            return false;
        }

        // Calculate the square root of the number
        double squareRoot = Math.sqrt(number);

        // Check if the square of the integer part of the square root is equal to the original number
        return squareRoot == Math.floor(squareRoot);
    }

    /// Demonstrates the usage of the `isPerfectSquare` method.
    ///
    /// The method tests whether the number `25.0` is a perfect square and
    /// prints the result to the console.
    public static void main(String[] args) {
        double testNumber = 25.0;
        boolean result = isPerfectSquare(testNumber);

        System.out.printf("Is %.1f a perfect square? %b%n", testNumber, result);
    }
}
