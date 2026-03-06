package daily_question.longestBalancedSubstringII;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/// # Longest Balanced Substring II
///
/// This class provides a solution for finding the **longest balanced substring**
/// in a string composed only of the characters `a`, `b`, and `c`.
///
/// A substring is considered **balanced** when:
/// - It contains an equal number of two or three distinct characters.
/// - The substring is continuous within the original string.
///
/// The algorithm evaluates three scenarios:
///
/// 1. **Single-character sequences**
///    - Finds the longest continuous block of `a`, `b`, or `c`.
///
/// 2. **Two-character balance**
///    - Finds substrings where the count of two characters (e.g., `a` and `b`)
///      is equal while ignoring other characters.
///
/// 3. **Three-character balance**
///    - Finds substrings where `a`, `b`, and `c` appear the same number of times.
///
/// ## Algorithm Strategy
///
/// - Linear scan for single-character runs.
/// - Prefix-difference technique for two-character balancing.
/// - Encoded prefix-state hashing for three-character balancing.
///
/// ## Time Complexity
///
/// `O(n)`
///
/// The string is processed multiple times but each pass is linear.
///
/// ## Space Complexity
///
/// `O(n)`
///
/// Auxiliary structures store prefix states.
///
/// @author
/// Example algorithm implementation for balanced substring detection
class Solution {

    /// Computes the length of the **longest balanced substring** in the input string.
    ///
    /// The function evaluates:
    ///
    /// - Longest block of identical characters
    /// - Balanced substrings between any **two characters**
    /// - Balanced substrings among **all three characters**
    ///
    /// @param s the input string containing only `a`, `b`, and `c`
    /// @return the length of the longest balanced substring
    public int longestBalanced(String s) {
        char[] c = s.toCharArray();
        int n = c.length;

        int cur_a = 0, cur_b = 0, cur_c = 0;
        int max_a = 0, max_b = 0, max_c = 0;

        // Track longest continuous sequence of each character
        for (int i = 0; i < n; i++) {
            if (c[i] == 'a') {
                cur_a = (i > 0 && c[i-1] == 'a') ? cur_a + 1 : 1;
                max_a = Math.max(max_a, cur_a);
            } else if (c[i] == 'b') {
                cur_b = (i > 0 && c[i-1] == 'b') ? cur_b + 1 : 1;
                max_b = Math.max(max_b, cur_b);
            } else {
                cur_c = (i > 0 && c[i-1] == 'c') ? cur_c + 1 : 1;
                max_c = Math.max(max_c, cur_c);
            }
        }

        int res = Math.max(Math.max(max_a, max_b), max_c);

        // Evaluate balanced substrings with two characters
        res = Math.max(res, find2(c, 'a', 'b'));
        res = Math.max(res, find2(c, 'a', 'c'));
        res = Math.max(res, find2(c, 'b', 'c'));

        // Evaluate balanced substrings with three characters
        res = Math.max(res, find3(c));

        return res;
    }

    /// Finds the longest substring where two characters occur the **same number of times**.
    ///
    /// This method uses a **prefix difference technique**:
    ///
    /// - `diff` tracks the difference between the counts of `x` and `y`
    /// - If the same difference appears again, the substring between those indices
    ///   has equal counts of the two characters.
    ///
    /// Characters outside `{x, y}` reset the search window.
    ///
    /// @param c the character array of the input string
    /// @param x first character to balance
    /// @param y second character to balance
    /// @return the maximum length of a balanced substring containing `x` and `y`
    private int find2(char[] c, char x, char y) {
        int n = c.length, max_len = 0;
        int[] first = new int[2 * n + 1];
        Arrays.fill(first, -2);

        int clear_idx = -1, diff = n;
        first[diff] = -1;

        for (int i = 0; i < n; i++) {
            if (c[i] != x && c[i] != y) {
                clear_idx = i;
                diff = n;
                first[diff] = clear_idx;
            } else {
                if (c[i] == x) diff++;
                else diff--;

                if (first[diff] < clear_idx) {
                    first[diff] = i;
                } else {
                    max_len = Math.max(max_len, i - first[diff]);
                }
            }
        }

        return max_len;
    }

    /// Finds the longest substring where **`a`, `b`, and `c` appear equally**.
    ///
    /// The method encodes the prefix state using a **numeric hash**:
    ///
    /// - `a` increments the state by `1_000_001`
    /// - `b` decrements by `1_000_000`
    /// - `c` decrements by `1`
    ///
    /// If the same state appears twice, the substring between them
    /// contains equal counts of `a`, `b`, and `c`.
    ///
    /// A hash map stores the **first occurrence** of each state.
    ///
    /// @param c the character array of the input string
    /// @return the maximum length of a substring balanced across `a`, `b`, and `c`
    private int find3(char[] c) {
        long state = Long.MAX_VALUE / 2;
        Map<Long, Integer> first = new HashMap<>();
        first.put(state, -1);

        int max_len = 0;

        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'a') state += 1_000_001;
            else if (c[i] == 'b') state -= 1_000_000;
            else state--;

            if (first.containsKey(state)) {
                max_len = Math.max(max_len, i - first.get(state));
            } else {
                first.put(state, i);
            }
        }

        return max_len;
    }
}