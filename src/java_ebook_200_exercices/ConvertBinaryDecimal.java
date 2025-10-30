package java_ebook_200_exercices;

public class ConvertBinaryDecimal {

    /// # Convert Binary to Decimal
    ///
    /// This class provides a method to convert a binary string (composed of `'0'` and `'1'`)
    /// into its corresponding **decimal (base-10)** representation.
    ///
    /// ---
    ///
    /// ## Example
    /// ```java
    /// Input:  "1101"
    /// Output: 13
    /// Explanation: (1 × 2³) + (1 × 2²) + (0 × 2¹) + (1 × 2⁰) = 8 + 4 + 0 + 1 = 13
    /// ```
    ///
    /// ---
    ///
    /// ## Method Details
    /// The conversion is handled by Java’s built-in method `Integer.parseInt(binaryString, 2)`,
    /// which interprets the input string as a base-2 number.
    ///
    /// Before conversion, the method validates that the string contains only `'0'` and `'1'`.
    /// If invalid characters are detected, an `IllegalArgumentException` is thrown.
    ///
    /// ---
    ///
    /// ## Parameters
    /// - `binaryString` — A string containing only binary digits (`0` and `1`).
    ///
    /// ## Returns
    /// - An `int` representing the decimal value of the binary input.
    ///
    /// ## Throws
    /// - `IllegalArgumentException` — If the input string contains characters other than `'0'` or `'1'`.
    ///
    /// ---
    ///
    /// ## Complexity
    /// - **Time complexity:** `O(n)`, where `n` is the length of the binary string.
    /// - **Space complexity:** `O(1)`.
    ///
    /// ---
    ///
    /// ## Example Usage
    /// ```java
    /// public static void main(String[] args) {
    ///     String binaryNumber = "1101";
    ///
    ///     try {
    ///         int decimalResult = binaryToDecimal(binaryNumber);
    ///         System.out.printf("The decimal equivalent of binary %s is %d%n", binaryNumber, decimalResult);
    ///     } catch (IllegalArgumentException e) {
    ///         System.out.println(e.getMessage());
    ///     }
    /// }
    /// // Output: The decimal equivalent of binary 1101 is 13
    /// ```
    ///
    public static int binaryToDecimal(String binaryString) throws IllegalArgumentException {

        // Check if the input string contains only '0' and '1'
        if (!binaryString.matches("[01]+")) {
            throw new IllegalArgumentException("Invalid input. Please provide a valid binary string.");
        }

        // Convert binary string to decimal
        return Integer.parseInt(binaryString, 2);
    }

    public static void main(String[] args) {
        String binaryNumber = "1101";

        try {
            int decimalResult = binaryToDecimal(binaryNumber);
            System.out.printf("The decimal equivalent of binary %s is %d%n", binaryNumber, decimalResult);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
