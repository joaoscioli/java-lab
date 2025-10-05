package java_ebook_200_exercices;

/// # SimpleInterestCalculator
///
/// A utility class that provides a method to calculate **Simple Interest** based on
/// the principal amount, interest rate, and time period.
///
/// The formula used for calculation is:
/// ```text
/// Simple Interest = (Principal × Rate × Time) / 100
/// ```
///
/// ## Example
/// ```java
/// double interest = SimpleInterestCalculator.calculateSimpleInterest(1000.0, 5.0, 2.0);
/// System.out.println("Simple Interest: $" + interest);
/// // Output: Simple Interest: $100.0
/// ```
///
/// ## Throws
/// - `IllegalArgumentException` — if any of the parameters are non-positive values.
///
public class SimpleInterestCalculator {

    /// Calculates the **simple interest** based on the provided principal amount,
    /// annual interest rate, and time period (in years).
    ///
    /// ## Parameters
    /// - `principal` — the initial amount of money invested or loaned.
    /// - `rate` — the annual interest rate (as a percentage).
    /// - `time` — the time period in years for which the interest is calculated.
    ///
    /// ## Returns
    /// The calculated simple interest as a `double` value.
    ///
    /// ## Throws
    /// - `IllegalArgumentException` — if any of the inputs are zero or negative.
    ///
    /// ## Example
    /// ```java
    /// double result = SimpleInterestCalculator.calculateSimpleInterest(1500.0, 4.5, 3.0);
    /// System.out.println(result); // 202.5
    /// ```
    public static double calculateSimpleInterest(double principal, double rate, double time)
            throws IllegalArgumentException {

        if (principal <= 0.0 || rate <= 0.0 || time <= 0.0) {
            throw new IllegalArgumentException("Invalid inputs. Please provide valid positive numbers.");
        }

        return (principal * rate * time) / 100.0;
    }

    /// Demonstrates how to use the `calculateSimpleInterest` method.
    ///
    /// Prints the principal, rate, time, and calculated interest to the console.
    ///
    /// ## Example Output
    /// ```text
    /// Principal Amount: $1000.00
    /// Interest Rate: 5.00%
    /// Investment Time: 2.00 years
    /// Simple Interest: $100.00
    /// ```
    public static void main(String[] args) {
        double principalAmount = 1000.0;
        double interestRate = 5.0;
        double investmentTime = 2.0;

        try {
            double interestAmount = calculateSimpleInterest(principalAmount, interestRate, investmentTime);
            System.out.printf("Principal Amount: $%.2f%n", principalAmount);
            System.out.printf("Interest Rate: %.2f%%%n", interestRate);
            System.out.printf("Investment Time: %.2f years%n", investmentTime);
            System.out.printf("Simple Interest: $%.2f%n", interestAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
