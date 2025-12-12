package java_ebook_200_exercices;

public class ConvertDecimalRomanNumerals {

    /// ## decimalToRoman
    ///
    /// Converts a decimal (integer) value into its **Roman numeral** representation.
    ///
    /// This method supports values from **1 to 3999**, which is the standard range
    /// for Roman numerals. If the input is outside this range, an
    /// `IllegalArgumentException` is thrown.
    ///
    /// ### Parameters
    /// - `num` — A positive integer between 1 and 3999.
    ///
    /// ### Returns
    /// A `String` containing the Roman numeral equivalent of the provided number.
    ///
    /// ### Throws
    /// - `IllegalArgumentException`
    ///   Thrown when `num` is less than 1 or greater than 3999.
    ///
    /// ### Roman Numeral Logic
    /// This method uses a greedy subtraction approach:
    /// - It repeatedly subtracts the largest possible Roman numeral value from
    ///   the number and appends the corresponding symbol to the result.
    ///
    /// ### Example
    /// ```java
    /// decimalToRoman(1984); // returns "MCMLXXXIV"
    /// ```
    ///
    /// Output:
    /// ```
    /// The Roman numeral representation of 1984 is: MCMLXXXIV
    /// ```
    public static String decimalToRoman(int num) throws IllegalArgumentException {
        if (num <= 0 || num > 3999) {
            throw new IllegalArgumentException(
                    "Invalid input. Please provide a valid positive integer within the range 1 to 3999."
            );
        }

        // Define Roman numeral symbols and their corresponding values
        String[] romanSymbols = {
                "M", "CM", "D", "CD",
                "C", "XC", "L", "XL",
                "X", "IX", "V", "IV", "I"
        };

        int[] values = {
                1000, 900, 500, 400,
                100, 90, 50, 40,
                10, 9, 5, 4, 1
        };

        StringBuilder result = new StringBuilder();

        // Convert decimal to Roman numeral using greedy approach
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                result.append(romanSymbols[i]);
                num -= values[i];
            }
        }

        return result.toString();
    }

    /// ## main
    ///
    /// Demonstrates the usage of the `decimalToRoman` method by converting the
    /// decimal number **1984** to its Roman numeral equivalent and printing the result.
    void main() {
        int decimalNumber = 1984;
        try {
            String romanNumeral = decimalToRoman(decimalNumber);
            System.out.printf("The Roman numeral representation of " + decimalNumber + " is: " + romanNumeral);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
