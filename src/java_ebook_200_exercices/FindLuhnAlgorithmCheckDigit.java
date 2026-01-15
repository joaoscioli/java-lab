package java_ebook_200_exercices;

/// # FindLuhnAlgorithmCheckDigit
///
/// Utility class responsible for calculating the **Luhn check digit**
/// for a given numeric input.
///
/// ## About the Luhn Algorithm
/// The **Luhn Algorithm** (also known as *modulus 10*) is widely used to:
/// - Validate credit card numbers
/// - Validate IMEI numbers
/// - Generate check digits for identification numbers
///
/// ## How it works (high level)
/// 1. Starting from the left, double every second digit depending on the length.
/// 2. If the result is greater than 9, subtract 9.
/// 3. Sum all digits.
/// 4. The check digit is the number needed to make the total divisible by 10.
///
/// ## Example
/// ```text
/// Input:  123456789
/// Output: Check Digit = 3
/// Full Number: 1234567893
/// ```
public class FindLuhnAlgorithmCheckDigit {

    /// ## calculateLuhnCheckDigit
    ///
    /// Calculates the **Luhn check digit** for a given numeric input.
    ///
    /// ### Parameters
    /// - `input` (`long`):
    ///   The partial number (without the check digit).
    ///
    /// ### Returns
    /// - `int`:
    ///   The calculated check digit (0–9).
    ///
    /// ### Algorithm Details
    /// - Converts the input number to a string to process digit by digit.
    /// - Alternates digit doubling based on the parity of the input length.
    /// - Subtracts 9 from any doubled digit greater than 9.
    /// - Computes the final check digit using modulo 10 arithmetic.
    ///
    /// ### Time Complexity
    /// - **O(n)**, where `n` is the number of digits.
    ///
    /// ### Space Complexity
    /// - **O(1)** (ignoring input string conversion).
    ///
    /// ### Example
    /// ```java
    /// int checkDigit = calculateLuhnCheckDigit(123456789L);
    /// // checkDigit == 3
    /// ```
    public static int calculateLuhnCheckDigit(long input) {
        String inputStr = Long.toString(input);
        int totalSum = 0;

        // Determines how the digit doubling alternates
        boolean isEvenPosition = inputStr.length() % 2 == 0;

        // Iterate over each digit
        for (int i = 0; i < inputStr.length(); i++) {
            int digit = Character.getNumericValue(inputStr.charAt(i));

            if (isEvenPosition) {
                // Double digits in even indexes
                if (i % 2 == 0) {
                    digit *= 2;
                    if (digit > 9) {
                        digit -= 9;
                    }
                }
            } else {
                // Double digits in odd indexes
                if (i % 2 != 0) {
                    digit *= 2;
                    if (digit > 9) {
                        digit -= 9;
                    }
                }
            }

            totalSum += digit;
        }

        // Compute the final Luhn check digit
        return (10 - (totalSum % 10)) % 10;
    }

    /// ## main
    ///
    /// Demonstrates how to use the **Luhn check digit calculator**.
    ///
    /// ### Steps
    /// 1. Defines a partial number.
    /// 2. Calculates the Luhn check digit.
    /// 3. Appends the digit to form the full number.
    /// 4. Prints the result to the console.
    ///
    /// ### Example Output
    /// ```text
    /// Partial Number: 123456789
    /// Check Digit: 3
    /// Full Number with Check Digit: 1234567893
    /// ```
    public static void main(String[] args) {
        long partialNumber = 123456789;
        int checkDigit = calculateLuhnCheckDigit(partialNumber);
        String fullNumber = partialNumber + "" + checkDigit;

        System.out.println("Partial Number: " + partialNumber);
        System.out.println("Check Digit: " + checkDigit);
        System.out.println("Full Number with Check Digit: " + fullNumber);
    }
}
