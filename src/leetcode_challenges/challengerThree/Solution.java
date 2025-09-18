package leetcode_challenges.challengerThree;

import java.util.HashMap;

/// # Solution
///
/// Utility class that implements an optimized algorithm to find the length of the
/// longest substring without repeating characters in a given string.
///
/// ## Features
/// - Handles empty and `null` strings by returning `0`.
/// - Uses a sliding window technique with a `HashMap` for efficient lookups.
/// - Achieves linear time complexity `O(n)` where `n` is the length of the string.
///
/// ## Example
/// ```java
/// int result = Solution.lengthOfLongestSubstring("abcabcbb");
/// System.out.println(result); // 3
/// ```
public class Solution {

    /// Returns the length of the longest substring without repeating characters.
    ///
    /// ## Parameters
    /// - `s`: the input string to analyze.
    ///
    /// ## Returns
    /// - The length of the longest substring with distinct characters.
    /// - Returns `0` if the string is `null` or empty.
    ///
    /// ## Complexity
    /// - Time: `O(n)` because each character is processed at most twice (left and right pointers).
    /// - Space: `O(min(n, charset))` due to the `HashMap` used for storing character indices.
    ///
    /// ## Example
    /// ```java
    /// Solution.lengthOfLongestSubstring("abcabcbb"); // returns 3
    /// Solution.lengthOfLongestSubstring("bbbbb");    // returns 1
    /// Solution.lengthOfLongestSubstring("pwwkew");   // returns 3
    /// Solution.lengthOfLongestSubstring("");         // returns 0
    /// Solution.lengthOfLongestSubstring("dvdf");     // returns 3
    /// ```
    public static int lengthOfLongestSubstring(String s) {
        // Base case: empty string returns 0
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>(); // Maps character to last position
        int maxLength = 0; // Maximum length found
        int left = 0;      // Start of the sliding window

        // Single loop: right is the end of the window
        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right); // Current character

            // If character is already in window, move left pointer
            if (map.containsKey(current) && map.get(current) >= left) {
                left = map.get(current) + 1;  // Move left after last occurrence
            }

            // Update position of the current character
            map.put(current, right);

            // Update maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    /// Demonstrates the usage of `lengthOfLongestSubstring` with sample strings.
    ///
    /// ## Example
    /// ```java
    /// Solution.main();
    /// ```
    ///
    /// ### Output
    /// ```text
    /// 3
    /// 1
    /// 3
    /// 0
    /// 3
    /// ```
    static void main() {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // Deve imprimir 3
        System.out.println(lengthOfLongestSubstring("bbbbb"));    // Deve imprimir 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));   // Deve imprimir 3
        System.out.println(lengthOfLongestSubstring(""));         // Deve imprimir 0
        System.out.println(lengthOfLongestSubstring("dvdf"));     // Deve imprimir 3
    }
}
