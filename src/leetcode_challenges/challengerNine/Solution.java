package leetcode_challenges.challengerNine;

public class Solution {

    /// ## isPalindrome
    ///
    /// Determines whether a given integer is a palindrome.
    ///
    /// A palindrome number reads the same backward as forward.
    /// This implementation avoids converting the integer to a string
    /// and instead reverses only half of the digits, improving performance
    /// and preventing overflow.
    ///
    /// ### Rules & Notes
    /// - Negative numbers are **not** palindromes.
    /// - Numbers ending with `0` (except `0` itself) are not palindromes.
    /// - The algorithm reverses *half* of the number for efficiency.
    /// - For numbers with an odd number of digits, the middle digit
    ///   is discarded before comparison.
    ///
    /// ### Parameters
    /// - `x` — The integer to check.
    ///
    /// ### Returns
    /// - `true` if `x` is a palindrome.
    /// - `false` otherwise.
    ///
    /// ### Example
    /// ```java
    /// Solution solution = new Solution();
    /// solution.isPalindrome(121);   // returns true
    /// solution.isPalindrome(-121);  // returns false
    /// solution.isPalindrome(10);    // returns false
    /// ```
    public boolean isPalindrome(int x) {
        // Números negativos ou terminando em 0 (mas não zero)
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;

        // Construímos só a metade do número
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // Se tiver número ímpar de dígitos, removemos o dígito central
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
