package daily_question.countNumberSpecialCharactersI;

/// Provides a solution for counting special characters in a word.
///
/// A character is considered **special** when both its lowercase and uppercase
/// forms appear at least once in the given string.
///
/// For example:
///
/// ```java
/// numberOfSpecialChars("aaAbcBC") == 3
/// ```
///
/// In this case, the special characters are `a`, `b`, and `c`, because each
/// appears in both lowercase and uppercase form.
class Solution {

    /// Counts the number of special characters in the given word.
    ///
    /// A lowercase English letter is counted as special when the same letter
    /// also appears as an uppercase English letter somewhere in the string.
    ///
    /// The method assumes that the input contains only English alphabetic
    /// characters from `a` to `z` and `A` to `Z`.
    ///
    /// @param word the input string to inspect
    /// @return the number of letters that appear in both lowercase and uppercase form
    public int numberOfSpecialChars(String word) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];

        for (char c : word.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lower[c - 'a'] = true;
            } else {
                upper[c - 'A'] = true;
            }
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (lower[i] && upper[i]) {
                count++;
            }
        }

        return count;
    }
}