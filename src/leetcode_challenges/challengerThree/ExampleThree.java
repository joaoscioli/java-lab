package leetcode_challenges.challengerThree;

import java.util.HashSet;

/// # ExampleThree
///
/// Utility class that provides a method to calculate the length of the longest substring
/// without repeating characters in a given string.
///
/// ## Features
/// - Handles empty and `null` strings by returning `0`.
/// - Uses a sliding-window-like approach with nested loops.
/// - Returns the maximum length of a substring where all characters are unique.
///
/// ## Example
/// ```java
/// int result = ExampleThree.maiorSubstringSemRepeticao("abcabcbb");
/// System.out.println(result); // 3
/// ```
public class ExampleThree {

    /// Calculates the length of the longest substring without repeating characters.
    ///
    /// ## Parameters
    /// - `s`: the input string to analyze.
    ///
    /// ## Returns
    /// - The length of the longest substring with all distinct characters.
    /// - Returns `0` if the string is `null` or empty.
    ///
    /// ## Example
    /// ```java
    /// ExampleThree.maiorSubstringSemRepeticao("abcabcbb"); // returns 3
    /// ExampleThree.maiorSubstringSemRepeticao("bbbbb");    // returns 1
    /// ExampleThree.maiorSubstringSemRepeticao("pwwkew");   // returns 3
    /// ```
    public static int maiorSubstringSemRepeticao(String s) {
        // Base case: empty string returns 0
        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxLength = 0;  // Stores the maximum length found

        // Outer loop: test each position as the start of a substring
        for (int start = 0; start < s.length(); start++) {
            HashSet<Character> set = new HashSet<>();   // New set for each start
            // Inner loop: expand the window until repetition or end of string
            for (int end = start; end < s.length(); end++) {
                char current = s.charAt(end);   // Current character
                // If the character is already in the set, stop this window
                if (set.contains(current)) {
                    break;
                }
                // Otherwise, add to set and update max length
                set.add(current);
                int currentLength = end - start + 1; // Length of current window
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;   // Return the maximum length found
    }

    /// Demonstrates the usage of `maiorSubstringSemRepeticao` with sample strings.
    ///
    /// ## Example
    /// ```java
    /// ExampleThree.main();
    /// ```
    ///
    /// ### Output
    /// ```text
    /// 3
    /// 1
    /// 3
    /// ```
    static void main() {
        System.out.println(maiorSubstringSemRepeticao("abcabcbb")); // Deve imprimir 3
        System.out.println(maiorSubstringSemRepeticao("bbbbb"));    // Deve imprimir 1
        System.out.println(maiorSubstringSemRepeticao("pwwkew"));   // Deve imprimir 3
    }
}
