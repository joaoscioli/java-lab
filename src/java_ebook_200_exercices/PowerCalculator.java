package java_ebook_200_exercices;

/// # PowerCalculator
///
/// A utility class for calculating powers of numbers using different approaches.
///
/// This class demonstrates two ways of calculating powers:
/// - Using the built-in `Math.pow` method for floating-point numbers.
/// - Using a manual loop-based method for integer exponents.
///
/// ## Example
/// ```java
/// double result1 = PowerCalculator.calculatePowerWithPow(2.0, 3.0); // 8.0
/// int result2 = PowerCalculator.calculatePowerWithIntegerExponent(2, 3); // 8
/// ```
public class PowerCalculator {

    /// Calculates the power of a base raised to an exponent using `Math.pow`.
    ///
    /// ## Parameters
    /// - `base`: The base value (double).
    /// - `exponent`: The exponent value (double).
    ///
    /// ## Returns
    /// The result of raising `base` to the power of `exponent` as a `double`.
    ///
    /// ## Example
    /// ```java
    /// double result = PowerCalculator.calculatePowerWithPow(2.0, 3.0);
    /// // result = 8.0
    /// ```
    public static double calculatePowerWithPow(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    /// Calculates the power of an integer base raised to an integer exponent using a loop.
    ///
    /// This method does not use `Math.pow`, making it suitable for simple integer exponentiation.
    ///
    /// ## Parameters
    /// - `base`: The base value (int).
    /// - `exponent`: The exponent value (int, must be non-negative).
    ///
    /// ## Returns
    /// The result of raising `base` to the power of `exponent` as an `int`.
    ///
    /// ## Example
    /// ```java
    /// int result = PowerCalculator.calculatePowerWithIntegerExponent(2, 3);
    /// // result = 8
    /// ```
    public static int calculatePowerWithIntegerExponent(int base, int exponent) {
        int result = 1;

        for (int i = 0; i < exponent; i++) {
            result *= base; // Multiply base exponent times
        }
        return result;
    }

    /// Main method demonstrating both approaches to calculating powers.
    ///
    /// ## Example Output
    /// ```
    /// 2.0 to the power of 3.0 using Math.pow(): 8.0
    /// 2 to the power of 3 using the integer method: 8
    /// ```
    public static void main(String[] args) {
        double baseNumberDouble = 2.0;
        double exponentNumberDouble = 3.0;
        double resultWithPow = calculatePowerWithPow(baseNumberDouble, exponentNumberDouble);

        System.out.printf("%.1f to the power of %.1f using Math.pow(): %.1f%n",
                baseNumberDouble, exponentNumberDouble, resultWithPow);

        int baseNumberInt = 2;
        int exponentNumberInt = 3;
        int resultWithIntegerPow = calculatePowerWithIntegerExponent(baseNumberInt, exponentNumberInt);

        System.out.printf("%d to the power of %d using the integer method: %d%n",
                baseNumberInt, exponentNumberInt, resultWithIntegerPow);
    }
}
