package java_ebook_200_exercices;

import java.util.Scanner;

class DecimalToBinaryConverter {

    /// # DecimalToBinaryConverter
    ///
    /// This program converts a **decimal** (base-10) integer into its **binary** (base-2) representation.
    ///
    /// ## Features
    /// - Prompts the user for a non-negative decimal integer.
    /// - Converts the number to binary using division by 2.
    /// - Displays the binary equivalent as a string.
    ///
    /// ## Example
    /// ```
    /// Enter a decimal number: 10
    /// The binary equivalent of 10 is: 1010
    /// ```
    ///
    /// ## Notes
    /// - Handles the case when the input is `0` (returns "0").
    /// - Does not support negative integers (prints an error message if input is negative).
    ///
    /// ## How it works
    /// The binary conversion is performed by dividing the decimal number by 2 repeatedly
    /// and recording the remainder at each step. The binary result is built in reverse and
    /// then reversed for correct representation.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a decimal number: ");
        int decimalNumber = scanner.nextInt();
        if (decimalNumber < 0) {
            System.out.println("Please enter a valid non-negative integer.");
            return;
        }

        String binaryEquivalent = decimalToBinary(decimalNumber);
        System.out.println("The binary equivalent of " + decimalNumber + " is: " + binaryEquivalent);
    }

    /// Converts a non-negative decimal integer to its binary representation.
    ///
    /// @param num the decimal number to convert
    /// @return a `String` representing the binary form of the input number
    private static String decimalToBinary(int num) {
        if (num == 0) {
            return "0";
        }

        StringBuilder binary = new StringBuilder();
        int n = num;

        while (n > 0) {
            binary.insert(0, n % 2);
            n /= 2;
        }
        return binary.toString();
    }
}
