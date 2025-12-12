package leetcode_challenges.challengerTwelfth;

public class Solution {

    /// ## intToRoman
    ///
    /// Converts an integer into its **Roman numeral** representation using
    /// the standard Roman numeral rules and the greedy subtraction method.
    ///
    /// This method supports numbers in the range **1 to 3999**, which is the
    /// conventional upper limit for Roman numerals. Any value outside this
    /// range results in an `IllegalArgumentException`.
    ///
    /// ### Parameters
    /// - `num` — A positive integer between 1 and 3999.
    ///
    /// ### Returns
    /// A `String` containing the Roman numeral representation of the given
    /// integer.
    ///
    /// ### Throws
    /// - `IllegalArgumentException`
    ///   Thrown when the input is less than 1 or greater than 3999.
    ///
    /// ### Algorithm
    /// The method uses a **greedy approach**:
    /// - It subtracts the largest possible Roman numeral value from the input
    ///   number repeatedly.
    /// - For each subtraction, the corresponding Roman symbol is appended to
    ///   the resulting string.
    ///
    /// The symbols and values are processed in descending order to ensure the
    /// resulting numeral is both valid and minimal.
    ///
    /// ### Example
    /// ```java
    /// intToRoman(1994); // returns "MCMXCIV"
    /// ```
    ///
    /// Example explanation:
    /// - 1000 → M
    /// - 900 → CM
    /// - 90 → XC
    /// - 4 → IV
    ///
    /// Combined: **MCMXCIV**
    public String intToRoman(int num) {
        if (num <= 0 || num > 3999) {
            throw new IllegalArgumentException(
                    "Invalid input. Please provide a valid positive integer within the range 1 to 3999."
            );
        }

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

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                result.append(romanSymbols[i]);
                num -= values[i];
            }
        }
        return result.toString();
    }
}
