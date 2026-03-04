package leetcode_challenges.challengerFiftyEight;

/// # Length of Last Word
///
/// Calculates the length of the last word in a given string.
///
/// A **word** is defined as a maximal substring consisting of
/// non-space characters only.
///
/// ## How It Works
///
/// The algorithm scans the string from right to left:
///
/// 1. Skips any trailing spaces.
/// 2. Counts characters until a space is found or the beginning
///    of the string is reached.
///
/// This ensures the correct length is returned even if:
/// - The string contains trailing spaces.
/// - The string contains multiple spaces between words.
/// - The string contains only one word.
///
/// ## Example
///
/// ```
/// Input:  "Hello World"
/// Output: 5
///
/// Input:  "   fly me   to   the moon  "
/// Output: 4
/// ```
///
/// ## Time Complexity
///
/// - **O(n)** — In the worst case, the entire string is scanned.
///
/// ## Space Complexity
///
/// - **O(1)** — Only a few integer variables are used.
///
/// @param s the input string containing words separated by spaces
/// @return the length of the last word in the string
public class Solution {

    /// Stores the input string (not required for algorithm correctness,
    /// but maintained as part of the class state).
    private String s;

    /// Returns the length of the last word in the given string.
    ///
    /// @param s the input string
    /// @return the length of the last word
    public int lengthOfLastWord(String s) {
        this.s = s;
        int i = s.length() - 1;
        int length = 0;

        // Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Count the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}