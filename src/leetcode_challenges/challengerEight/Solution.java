package leetcode_challenges.challengerEight;

public class Solution {
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

}
