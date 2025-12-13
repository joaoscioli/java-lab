package leetcode_challenges.challengerThirteen;

import java.util.Map;

public class Solution {

    /// Converts a Roman numeral string into its integer value.
    ///
    /// ## Conversion Rules
    /// - Roman numerals are processed from left to right.
    /// - If a symbol has a smaller value than the following symbol,
    ///   its value is subtracted instead of added.
    /// - This naturally handles all valid subtractive cases:
    ///   - IV (4), IX (9)
    ///   - XL (40), XC (90)
    ///   - CD (400), CM (900)
    ///
    /// ## Constraints
    /// - `1 <= s.length <= 15`
    /// - The input is guaranteed to be a valid Roman numeral
    ///   within the range `[1, 3999]`.
    ///
    /// ## Time Complexity
    /// - **O(n)** where `n` is the length of the string.
    ///
    /// ## Space Complexity
    /// - **O(1)** — fixed-size symbol mapping.
    ///
    /// @param s the Roman numeral string
    /// @return the integer value represented by the Roman numeral
    public int romanToInt(String s) {

        Map<Character, Integer> values = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int current = values.get(s.charAt(i));

            if (i + 1 < s.length() && current < values.get(s.charAt(i + 1))) {
                result -= current;
            } else {
                result += current;
            }
        }

        return result;
    }
}
