package java_ebook_200_exercices;

import java.util.ArrayList;
import java.util.List;

/// # CheckNumberSmithNumber
///
/// Utility class that provides methods to determine whether a given number
/// is a **Smith Number**.
///
/// A **Smith Number** is a composite number whose sum of digits is equal
/// to the sum of the digits of its prime factors (excluding the number itself).
///
/// ## Example
/// - `728` → digits sum = `7 + 2 + 8 = 17`
/// - prime factors = `2 × 2 × 2 × 7 × 13` → digit sum = `2 + 2 + 2 + 7 + 1 + 3 = 17`
///
/// Despite matching sums, the number must **not be prime** to be a Smith Number.
///
/// ## Responsibilities
/// - Prime number validation
/// - Digit sum calculation
/// - Prime factor decomposition
/// - Smith Number verification
public class CheckNumberSmithNumber {

    /// ## isPrime
    ///
    /// Checks whether a given number is a prime number.
    ///
    /// A number is considered prime if it is greater than 1
    /// and divisible only by 1 and itself.
    ///
    /// ### Algorithm
    /// - Iterates from `2` up to `sqrt(num)`
    /// - If any divisor is found, the number is not prime
    ///
    /// ### Time Complexity
    /// - **O(√n)**
    ///
    /// @param num the number to be checked
    /// @return `true` if the number is prime, otherwise `false`
    public static boolean isPrime(long num) {
        if (num < 2) return false;

        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    /// ## sumOfDigits
    ///
    /// Calculates the sum of all digits of a given number.
    ///
    /// ### Example
    /// - Input: `728`
    /// - Output: `17`
    ///
    /// ### Algorithm
    /// - Extracts digits using modulo (`% 10`)
    /// - Removes last digit using integer division (`/ 10`)
    ///
    /// ### Time Complexity
    /// - **O(d)**, where `d` is the number of digits
    ///
    /// @param num the number whose digits will be summed
    /// @return the sum of the digits
    public static long sumOfDigits(long num) {
        long sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    /// ## primeFactors
    ///
    /// Computes the list of prime factors of a given number.
    ///
    /// Factors are returned **with repetition**, preserving
    /// the multiplicity of each prime factor.
    ///
    /// ### Example
    /// - Input: `728`
    /// - Output: `[2, 2, 2, 7, 13]`
    ///
    /// ### Algorithm
    /// - Iteratively divides the number by increasing integers
    /// - Stops when the square root of the remaining number is exceeded
    ///
    /// ### Time Complexity
    /// - **O(√n)**
    ///
    /// @param num the number to be factorized
    /// @return a list containing the prime factors
    public static List<Long> primeFactors(long num) {
        List<Long> factors = new ArrayList<>();

        for (long i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                factors.add(i);
                num /= i;
            }
        }

        if (num > 1) {
            factors.add(num);
        }
        return factors;
    }

    /// ## isSmithNumber
    ///
    /// Determines whether a given number is a **Smith Number**.
    ///
    /// ### Conditions
    /// - The number must be **composite**
    /// - The sum of its digits must be equal to the sum of the digits
    ///   of its prime factors
    ///
    /// ### Implementation Details
    /// - Uses Java Streams to sum digit values of prime factors
    /// - Explicitly excludes prime numbers
    ///
    /// @param num the number to be evaluated
    /// @return `true` if the number is a Smith Number, otherwise `false`
    public static boolean isSmithNumber(long num) {
        long originalSum = sumOfDigits(num);
        long primeFactorSum =
                primeFactors(num)
                        .stream()
                        .mapToLong(CheckNumberSmithNumber::sumOfDigits)
                        .sum();

        return originalSum != primeFactorSum && !isPrime(num);
    }

    /// ## main
    ///
    /// Demonstrates the usage of the Smith Number validation.
    ///
    /// ### Example Output
    /// ```
    /// Is 728 a Smith number? false
    /// ```
    ///
    /// This method serves only as a simple execution example.
    static void main() {
        long number = 728;
        System.out.println("Is " + number + " a Smith number? " + isSmithNumber(number));
    }
}
