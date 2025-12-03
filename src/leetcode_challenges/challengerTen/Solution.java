package leetcode_challenges.challengerTen;

class Solution {

    /// # Regular Expression Matching
    ///
    /// Implements full regular expression matching between an input string `s`
    /// and a pattern `p`, supporting the special characters:
    ///
    /// - `.` — matches any single character
    /// - `*` — matches zero or more occurrences of the preceding character
    ///
    /// The match must consume the **entire string**, not a substring.
    ///
    /// ---
    ///
    /// ## 🧠 Approach
    ///
    /// The solution uses **Dynamic Programming (DP)** with a 2D table:
    ///
    /// - `dp[i][j]` indicates whether `s[0..i-1]` matches `p[0..j-1]`.
    /// - The algorithm handles patterns that include `*` by considering:
    ///   - **Zero occurrences**: ignore `x*`
    ///   - **One or more occurrences**: match repeated characters
    ///
    /// This ensures all combinations are evaluated in `O(n × m)` time.
    ///
    /// ---
    ///
    /// ## ✔️ Supported Patterns
    ///
    /// - **Literal characters**
    /// - **`.` wildcard**
    /// - **`*` repetition operator**
    ///   *(always applies to the immediately preceding element)*
    ///
    /// ---
    ///
    /// ## 📘 Examples
    ///
    /// ```java
    /// isMatch("aa", "a");      // false
    /// isMatch("aa", "a*");     // true
    /// isMatch("ab", ".*");     // true
    /// ```
    ///
    /// ---
    ///
    /// ## 🕒 Complexity
    ///
    /// - **Time complexity:** O(n × m)
    /// - **Space complexity:** O(n × m)
    ///
    /// Where:
    /// - `n` = length of `s`
    /// - `m` = length of `p`
    ///
    /// ---
    ///
    /// @param s the input string to match
    /// @param p the pattern including normal characters, `.` and `*`
    /// @return `true` if the entire string `s` matches the pattern `p`
    ///
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;

        // Handle patterns like a*, a*b*, a*b*c*
        for (int j = 2; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                // Case 1: normal character or '.'
                if (pc == sc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                // Case 2: pattern contains '*'
                else if (pc == '*') {

                    // zero occurrences of p[j-2]
                    dp[i][j] = dp[i][j - 2];

                    char prev = p.charAt(j - 2);

                    // one or more occurrences
                    if (prev == sc || prev == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }

        return dp[n][m];
    }
}
