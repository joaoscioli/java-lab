package java_ebook_200_exercices;

/// # PerfectNumber
/// This class provides a method to determine whether a given integer
/// is a *perfect number*.
///
/// A **perfect number** is a positive integer that is equal to the sum
/// of its proper positive divisors (excluding the number itself).
///
/// For example:
/// - `6 = 1 + 2 + 3`
/// - `28 = 1 + 2 + 4 + 7 + 14`
///
/// These numbers are considered perfect because their divisors sum up to the number itself.
public class PerfectNumber {

    /// ## isPerfectNumber
    /// Checks whether a given integer is a *perfect number*.
    ///
    /// ### Parameters
    /// - `number` — the integer to check for perfection.
    ///
    /// ### Returns
    /// - `true` if the number is perfect.
    /// - `false` otherwise.
    ///
    /// ### Algorithm
    /// 1. Excludes values less than 2, since 1 and negative numbers cannot be perfect.
    /// 2. Computes the sum of all proper divisors of the given number.
    /// 3. Uses the square root optimization to avoid redundant divisor checks.
    /// 4. Compares the sum of divisors with the original number to determine perfection.
    ///
    /// ### Example
    /// ```java
    /// PerfectNumber.isPerfectNumber(28); // returns true
    /// PerfectNumber.isPerfectNumber(12); // returns false
    /// ```
    ///
    /// ### Time Complexity
    /// - **O(√n)** — because the algorithm iterates only up to the square root of `n`.
    ///
    /// ### Space Complexity
    /// - **O(1)** — uses a constant amount of additional memory.
    public static boolean isPerfectNumber(int number) {
        if (number < 2) {
            return false; // 1 and below cannot be perfect numbers
        }

        // Calculate the sum of proper divisors
        int sumOfDivisors = 1; // Start with 1, as 1 is a divisor of any number
        int sqrt = (int) Math.sqrt(number);

        for (int i = 2; i <= sqrt; i++) {
            if (number % i == 0) {
                sumOfDivisors += i;
                if (i != number / i) {
                    sumOfDivisors += number / i;
                }
            }
        }

        // Check if the sum of the divisors equals the original number
        return sumOfDivisors == number;
    }

    /// ## main
    /// Demonstrates the use of `isPerfectNumber` by testing the number `28`.
    ///
    /// ### Example Output
    /// ```
    /// Is 28 a perfect number? true
    /// ```
    public static void main(String[] args) {
        int testNumber = 28;
        boolean result = isPerfectNumber(testNumber);
        System.out.println("Is " + testNumber + " a perfect number? " + result);
    }
}
