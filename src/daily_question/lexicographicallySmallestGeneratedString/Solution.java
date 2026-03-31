package daily_question.lexicographicallySmallestGeneratedString;

import java.util.Arrays;

class Solution {

    /// ### generateString
    ///
    /// Generates the lexicographically smallest string based on constraints defined
    /// by two input strings:
    ///
    /// - `S`: A pattern string consisting of characters `'T'` and `'F'`
    /// - `t`: A target substring
    ///
    /// ### Problem Interpretation
    ///
    /// - For every index `i` where `S[i] == 'T'`, the substring of length `t.length()`
    ///   starting at position `i` in the result **must match exactly** the string `t`.
    /// - For every index `i` where `S[i] == 'F'`, the substring starting at `i`
    ///   **must NOT match** `t`.
    ///
    /// The resulting string must be the **lexicographically smallest possible**
    /// string that satisfies all constraints. If it is impossible, return an empty string.
    ///
    /// ---
    ///
    /// ### Approach
    ///
    /// 1. **Initialize Result Array**
    ///    - Create a character array `ans` of size `n + m - 1` filled with `'?'`,
    ///      where `n = S.length()` and `m = t.length()`.
    ///
    /// 2. **Apply 'T' Constraints**
    ///    - For each `i` where `S[i] == 'T'`, enforce that the substring starting
    ///      at `i` matches `t`.
    ///    - If a conflict occurs (existing character differs), return `""`.
    ///
    /// 3. **Fill Remaining Positions**
    ///    - Replace all remaining `'?'` with `'a'` to ensure the smallest lexicographic result.
    ///
    /// 4. **Handle 'F' Constraints**
    ///    - For each `i` where `S[i] == 'F'`, check if the substring equals `t`.
    ///    - If it does, attempt to modify one character (preferably the rightmost flexible one)
    ///      to break the match while keeping the result minimal.
    ///    - If no modification is possible, return `""`.
    ///
    /// 5. **Return Result**
    ///    - Convert the character array to a string and return it.
    ///
    /// ---
    ///
    /// ### Parameters
    /// - `S` : Pattern string indicating constraints (`'T'` = must match, `'F'` = must not match)
    /// - `t` : Target substring to enforce or avoid
    ///
    /// ### Returns
    /// - The lexicographically smallest valid string satisfying all constraints
    /// - Returns an empty string (`""`) if no valid solution exists
    ///
    /// ---
    ///
    /// ### Complexity
    ///
    /// - **Time Complexity:** `O(n * m)`
    ///   - Each constraint may require checking or filling up to `m` characters
    ///
    /// - **Space Complexity:** `O(n + m)`
    ///   - For the result array and auxiliary structures
    ///
    /// ---
    ///
    /// ### Example
    ///
    /// ```text
    /// Input:
    ///   S = "TFT"
    ///   t = "ab"
    ///
    /// Output:
    ///   "abab"
    /// ```
    ///
    /// ### Notes
    ///
    /// - The algorithm prioritizes lexicographical minimality by defaulting to `'a'`
    ///   and only increasing characters when necessary.
    /// - Conflicts during constraint application immediately invalidate the solution.
    ///
    public String generateString(String S, String t) {
        char[] s = S.toCharArray();
        int n = s.length;
        int m = t.length();
        char[] ans = new char[n + m - 1];
        Arrays.fill(ans, '?');

        for (int i = 0; i < n; i++) {
            if (s[i] != 'T') {
                continue;
            }
            for (int j = 0; j < m; j++) {
                char v = ans[i + j];
                if (v != '?' && v != t.charAt(j)) {
                    return "";
                }
                ans[i + j] = t.charAt(j);
            }
        }

        char[] oldAns = ans.clone();
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == '?') {
                ans[i] = 'a';
            }
        }

        for (int i = 0; i < n; i++) {
            if (s[i] != 'F') {
                continue;
            }
            if (!new String(ans, i, m).equals(t)) {
                continue;
            }
            boolean ok = false;
            for (int j = i + m - 1; j >= i; j--) {
                if (oldAns[j] == '?') {
                    ans[j] = 'b';
                    ok = true;
                    break;
                }
            }
            if (!ok) {
                return "";
            }
        }

        return new String(ans);
    }
}