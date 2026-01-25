package daily_question.minimumASCIIDeleteSumTwoStrings;

/// ## Minimum ASCII Delete Sum for Two Strings
///
/// This class solves the problem of finding the **minimum total ASCII value**
/// of characters that must be deleted from two strings in order to make
/// them equal.
///
/// Instead of directly minimizing deletions, the solution **maximizes the
/// ASCII sum of the common subsequence** shared by both strings.
///
/// ---
///
/// ### Key Insight
/// If we keep a common subsequence with maximum ASCII sum:
///
/// ```text
/// minimumDeleteSum = (sum of s1 + sum of s2) - 2 * (max common ASCII sum)
/// ```
///
/// This transforms the problem into a variation of the **Longest Common
/// Subsequence (LCS)** problem, where:
/// - The objective is to maximize the ASCII value sum, not the length.
///
/// ---
///
/// ### Dynamic Programming Definition
/// Let:
/// ```text
/// dp[i][j]
/// ```
/// represent the **maximum ASCII sum of a common subsequence**
/// between:
/// - the first `i` characters of `s1`
/// - the first `j` characters of `s2`
///
/// ---
///
/// ### Transition Rules
/// - If `s1[i-1] == s2[j-1]`:
///   ```text
///   dp[i][j] = dp[i-1][j-1] + ASCII(s1[i-1])
///   ```
/// - Otherwise:
///   ```text
///   dp[i][j] = max(dp[i-1][j], dp[i][j-1])
///   ```
///
/// ---
///
/// ### Complexity
/// - **Time Complexity**: `O(n * m)`
/// - **Space Complexity**: `O(n * m)`
///
/// where:
/// - `n` is the length of `s1`
/// - `m` is the length of `s2`
///
/// ---
///
/// ### Notes
/// - ASCII values are derived directly from Java `char` types.
/// - The DP table is 1-indexed to simplify boundary conditions.
/// - This approach guarantees an optimal solution.
public class Solution {

    /// Computes the minimum total ASCII value of characters that must be deleted
    /// from two strings to make them equal.
    ///
    /// @param s1 first input string
    /// @param s2 second input string
    /// @return minimum ASCII delete sum required to make {@code s1} and {@code s2} equal
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        /// dp[i][j] stores the maximum ASCII sum of a common subsequence
        /// between the first i characters of s1 and the first j characters of s2.
        int[][] dp = new int[n + 1][m + 1];

        /// Build the DP table.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        /// Compute the total ASCII sum of both strings.
        int totalSum = 0;
        for (char c : s1.toCharArray()) totalSum += c;
        for (char c : s2.toCharArray()) totalSum += c;

        /// The result is the total sum minus twice the kept common subsequence sum.
        return totalSum - 2 * dp[n][m];
    }
}
