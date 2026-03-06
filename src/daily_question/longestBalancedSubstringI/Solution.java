package daily_question.longestBalancedSubstringI;

/// # Longest Balanced Substring I
///
/// This class implements a **brute-force solution** to find the length of the
/// longest **balanced substring** in a given lowercase string.
///
/// A substring is considered **balanced** if:
///
/// - Every character that appears in the substring occurs the **same number of times**.
/// - Characters that do not appear are ignored.
///
/// Example:
///
/// | Substring | Balanced? | Explanation |
/// |------------|----------|-------------|
/// | `"aabb"` | ✔ | `a=2`, `b=2` |
/// | `"abc"` | ✔ | `a=1`, `b=1`, `c=1` |
/// | `"aab"` | ✘ | `a=2`, `b=1` |
///
/// ## Algorithm
///
/// The algorithm checks **every possible substring**:
///
/// 1. Select a starting index.
/// 2. Expand the substring one character at a time.
/// 3. Maintain a frequency array for the 26 lowercase letters.
/// 4. Verify if the substring is balanced.
///
/// Because every substring is evaluated, this is a **baseline brute-force approach**.
///
/// ## Time Complexity
///
/// `O(n³)`
///
/// - `O(n²)` substrings
/// - `O(26)` balance check for each step
///
/// ## Space Complexity
///
/// `O(1)`
///
/// Only a fixed array of size 26 is used.
///
/// This implementation is useful as a **reference solution** before applying
/// optimized approaches.
///
/// @author
/// Algorithm study implementation
class Solution {

    /// Computes the length of the **longest balanced substring** in the input string.
    ///
    /// The method iterates over all possible substrings and checks whether
    /// each substring satisfies the **balanced frequency condition**.
    ///
    /// @param s the input string containing lowercase English letters
    /// @return the length of the longest balanced substring
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;

        for (int start = 0; start < n; start++) {
            int[] freq = new int[26]; // frequency of each lowercase letter

            for (int end = start; end < n; end++) {
                char c = s.charAt(end);
                freq[c - 'a']++;

                if (isBalanced(freq)) {
                    maxLen = Math.max(maxLen, end - start + 1);
                }
            }
        }

        return maxLen;
    }

    /// Determines whether the current substring is **balanced**.
    ///
    /// A substring is balanced if **all characters that appear**
    /// have the **same frequency**.
    ///
    /// Steps:
    ///
    /// 1. Identify the frequency of the first character that appears.
    /// 2. Compare all other non-zero frequencies against this value.
    /// 3. If any differ, the substring is not balanced.
    ///
    /// @param freq an array representing the frequency of each lowercase letter
    /// @return `true` if the substring is balanced, otherwise `false`
    private boolean isBalanced(int[] freq) {
        int target = 0;

        for (int f : freq) {
            if (f != 0) {
                target = f;
                break;
            }
        }

        for (int f : freq) {
            if (f != 0 && f != target) {
                return false;
            }
        }

        return target != 0;
    }
}