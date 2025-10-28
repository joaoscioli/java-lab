package leetcode_challenges.challengerFive;

/// # Solution — Longest Palindromic Substring
///
/// This class provides an implementation of the classic **Longest Palindromic Substring** problem,
/// commonly found on platforms such as [LeetCode](https://leetcode.com/).
///
/// The goal is to find the **longest palindromic substring** within a given string `s`.
/// A *palindrome* is a string that reads the same forward and backward, such as `"aba"` or `"abba"`.
///
/// ## Algorithm Overview
/// The algorithm uses the **"Expand Around Center"** technique:
/// for each character in the string, it considers two possible centers:
/// - One for **odd-length palindromes** (a single character center);
/// - One for **even-length palindromes** (a pair of adjacent equal characters).
///
/// It then expands outward from each center while the characters on both sides are equal.
/// The longest expansion found determines the longest palindromic substring.
///
/// ## Time Complexity
/// - **O(n²)** — since each character can be the center of a palindrome and may expand across the entire string.
/// - **O(1)** extra space.
///
/// ## Example
/// ```java
/// Solution solution = new Solution();
/// String result = solution.longestPalindrome("babad");
/// System.out.println(result); // "bab" or "aba"
/// ```
///
/// @author
/// Inspired by common LeetCode solutions.
///
/// @since 1.0
public class Solution {

    /// Returns the **longest palindromic substring** within the given string.
    ///
    /// ## Parameters
    /// - `s`: The input string to analyze.
    ///
    /// ## Returns
    /// - The longest substring of `s` that is a palindrome.
    /// - Returns an empty string `""` if the input is `null` or empty.
    ///
    /// ## Example
    /// ```java
    /// Solution solution = new Solution();
    /// String result = solution.longestPalindrome("cbbd");
    /// System.out.println(result); // "bb"
    /// ```
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);       // Odd-length palindrome
            int len2 = expandAroundCenter(s, i, i + 1);   // Even-length palindrome
            int len = Math.max(len1, len2);

            if (len > end - start) {
                // Update the bounds of the current longest palindrome
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    /// Expands around the given center indices (`left` and `right`)
    /// to find the length of the palindrome centered there.
    ///
    /// ## Parameters
    /// - `s`: The string to expand within.
    /// - `left`: The left index of the potential palindrome center.
    /// - `right`: The right index of the potential palindrome center.
    ///
    /// ## Returns
    /// - The length of the palindrome found by expanding around the center.
    ///
    /// ## Example
    /// ```java
    /// int len = expandAroundCenter("babad", 2, 2); // returns 3 ("aba")
    /// ```
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // Palindrome length
    }
}
