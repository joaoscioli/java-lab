package java_ebook_200_exercices;

/// # CheckNumberStrongNumber
///
/// This class provides utility methods to determine whether a given number
/// is a **Strong Number** — a number in which the sum of the factorials
/// of its digits equals the number itself.
///
/// ## Definition
/// A **Strong Number** is defined as:
/// \[
/// \text{Strong Number} = \sum (\text{factorial of each digit})
/// \]
/// Example:
/// \( 145 = 1! + 4! + 5! = 1 + 24 + 120 = 145 \)
///
/// ## Example Output
/// ```
/// 145 is a strong number: true
/// ```
///
/// ## Author
/// Great Designer Software
///
public class CheckNumberStrongNumber {

    /// ### Calculates the factorial of a given number.
    ///
    /// This method multiplies all integers from 1 up to the given number `n`
    /// to compute its factorial.
    ///
    /// #### Parameters
    /// - `n`: The integer whose factorial is to be computed.
    ///
    /// #### Returns
    /// - The factorial value of the given number.
    ///
    /// #### Example
    /// ```
    /// calculateFactorial(5); // returns 120
    /// ```
    public static int calculateFactorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /// ### Determines whether a number is a Strong Number.
    ///
    /// A Strong Number is one where the sum of the factorials of its digits
    /// equals the original number.
    ///
    /// #### Parameters
    /// - `num`: The integer value to be checked.
    ///
    /// #### Returns
    /// - `true` if the number is a Strong Number.
    /// - `false` otherwise.
    ///
    /// #### Example
    /// ```
    /// isStrongNumber(145); // returns true
    /// ```
    public static boolean isStrongNumber(int num) {
        int originalNumber = num;
        int digitFactorialSum = 0;

        // Calculate the sum of the factorials of each digit
        while (num > 0) {
            int digit = num % 10; // Get the last digit
            digitFactorialSum += calculateFactorial(digit);
            num /= 10; // Remove the last digit
        }

        // Compare the result with the original number
        return digitFactorialSum == originalNumber;
    }

    /// ### Entry point for demonstration.
    ///
    /// Demonstrates checking whether a number (in this case, `145`)
    /// is a Strong Number and prints the result to the console.
    ///
    /// #### Example Output
    /// ```
    /// 145 is a strong number: true
    /// ```
    public static void main(String[] args) {
        int testNumber = 145;
        boolean result = isStrongNumber(testNumber);
        System.out.println(testNumber + " is a strong number: " + result);
    }
}
