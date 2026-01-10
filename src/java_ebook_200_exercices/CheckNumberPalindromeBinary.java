package java_ebook_200_exercices;

/// ## CheckNumberPalindromeBinary
///
/// Utility class responsible for checking whether a given integer
/// is a **palindrome when represented in binary format**.
///
/// A binary palindrome is a number whose binary representation
/// reads the same forwards and backwards.
///
/// ### Example
/// ```text
/// Input: 9
/// Binary: 1001
/// Output: true
/// ```
///
/// ### Notes
/// - This implementation leverages Java's built-in binary conversion.
/// - The algorithm operates in **O(n)** time, where *n* is the number of bits.
/// - Space complexity is **O(n)** due to string manipulation.
public class CheckNumberPalindromeBinary {

    /// ### isBinaryPalindrome
    ///
    /// Determines whether a given integer is a palindrome
    /// in its binary representation.
    ///
    /// #### Algorithm
    /// 1. Convert the integer to its binary string representation.
    /// 2. Reverse the binary string.
    /// 3. Compare the original and reversed strings.
    ///
    /// #### Parameters
    /// - `number` — the integer value to be checked
    ///
    /// #### Returns
    /// - `true` if the binary representation is a palindrome
    /// - `false` otherwise
    ///
    /// #### Example
    /// ```java
    /// isBinaryPalindrome(9); // returns true (1001)
    /// ```
    public static boolean isBinaryPalindrome(int number) {
        String binaryRepresentation = Integer.toBinaryString(number); // Convert to binary
        String reversedBinary = new StringBuilder(binaryRepresentation)
                .reverse()
                .toString(); // Reverse binary string

        return binaryRepresentation.equals(reversedBinary);
    }

    /// ### main
    ///
    /// Demonstrates the usage of `isBinaryPalindrome` by checking
    /// whether a predefined integer is a binary palindrome and
    /// printing the result to the console.
    ///
    /// #### Output
    /// ```text
    /// 9 is a binary palindrome! 🎉
    /// ```
    void main() {
        int numberToCheck = 9; // Example input

        if (isBinaryPalindrome(numberToCheck)) {
            System.out.printf(
                    "%d is a binary palindrome! \uD83C\uDF89%n",
                    numberToCheck
            );
        } else {
            System.out.printf(
                    "%d is not a palindrome. \uD83D\uDE22%n",
                    numberToCheck
            );
        }
    }
}
