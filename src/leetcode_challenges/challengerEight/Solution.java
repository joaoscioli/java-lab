package leetcode_challenges.challengerEight;

public class Solution {

    /// ### Function: `myAtoi(String s)`
    ///
    /// Converts a string into a 32-bit signed integer, simulating the behavior of the C/C++ `atoi` function.
    ///
    /// #### Steps:
    /// 1. **Trim leading whitespace** — Ignore all leading spaces.
    /// 2. **Check for sign** — Determine if the number is positive or negative based on the first non-space character.
    /// 3. **Convert digits** — Read numeric characters until a non-digit is encountered.
    /// 4. **Handle overflow/underflow** — Clamp the result to the 32-bit signed integer range `[-2³¹, 2³¹ - 1]`.
    /// 5. **Return** — Apply the sign and return the result.
    ///
    /// #### Example:
    /// ```java
    /// myAtoi("   -42"); // ➜ -42
    /// myAtoi("4193 with words"); // ➜ 4193
    /// myAtoi("words and 987"); // ➜ 0
    /// myAtoi("-91283472332"); // ➜ -2147483648 (Integer.MIN_VALUE)
    /// ```
    ///
    /// #### Constraints:
    /// - `0 <= s.length <= 200`
    /// - `s` may contain spaces, signs ('+', '-'), digits, letters, and symbols.
    ///
    public int myAtoi(String s) {
        // Step 1: Ignore leading whitespace
        int i = 0;
        int n = s.length();
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Check if string is empty after trimming
        if (i == n) {
            return 0;
        }

        // Step 3: Determine sign
        int sign = 1;
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        // Step 4: Convert digits to integer
        int result = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Step 5: Check for overflow before multiplying by 10
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        // Step 6: Apply sign and return
        return result * sign;
    }

    /// ### Test Example
    ///
    /// Demonstrates the usage of the `myAtoi()` method.
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.myAtoi("42")); // ➜ 42
        System.out.println(solution.myAtoi("   -42")); // ➜ -42
        System.out.println(solution.myAtoi("1337c0d3")); // ➜ 1337
        System.out.println(solution.myAtoi("0-1")); // ➜ 0
        System.out.println(solution.myAtoi("words and 987")); // ➜ 0
        System.out.println(solution.myAtoi("-91283472332")); // ➜ -2147483648
    }
}
