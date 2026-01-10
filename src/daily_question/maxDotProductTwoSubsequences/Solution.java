package daily_question.maxDotProductTwoSubsequences;

import java.util.Arrays;

/// ## Max Dot Product of Two Subsequences
///
/// This class provides a solution to compute the **maximum dot product**
/// between **non-empty subsequences** of two integer arrays.
///
/// A subsequence is derived by deleting zero or more elements without
/// changing the order of the remaining elements.
///
/// ### Problem Summary
/// Given two integer arrays `nums1` and `nums2`, return the maximum possible
/// dot product between a subsequence of `nums1` and a subsequence of `nums2`.
///
/// The subsequences **must not be empty**.
///
/// ### Key Insight
/// This is a **Dynamic Programming** problem that resembles a variation of
/// the **Longest Common Subsequence (LCS)**, but instead of maximizing length,
/// we maximize the **dot product value**.
///
/// ### Constraints Consideration
/// - Values may be negative
/// - The optimal solution may consist of a single pair
/// - We must carefully initialize DP values to avoid invalid empty states
class Solution {

    /// ### maxDotProduct
    ///
    /// Computes the maximum dot product between two non-empty subsequences
    /// derived from the input arrays.
    ///
    /// #### Dynamic Programming Definition
    /// `dp[i][j]` represents the **maximum dot product** achievable using:
    /// - the first `i` elements of `nums1`
    /// - the first `j` elements of `nums2`
    ///
    /// #### State Transition
    /// For each pair `(i, j)`:
    /// - Take only the current product
    /// - Extend a previous subsequence by adding the current product
    /// - Skip an element from either array
    ///
    /// ```text
    /// dp[i][j] = max(
    ///     nums1[i-1] * nums2[j-1],
    ///     dp[i-1][j-1] + nums1[i-1] * nums2[j-1],
    ///     dp[i-1][j],
    ///     dp[i][j-1]
    /// )
    /// ```
    ///
    /// #### Parameters
    /// - `nums1` — first integer array
    /// - `nums2` — second integer array
    ///
    /// #### Returns
    /// - The maximum dot product obtainable from any non-empty subsequences
    ///
    /// #### Time Complexity
    /// - **O(n × m)** where `n = nums1.length` and `m = nums2.length`
    ///
    /// #### Space Complexity
    /// - **O(n × m)** due to the DP table
    ///
    /// #### Notes
    /// - A negative infinity sentinel value is used to prevent invalid empty states
    /// - `Integer.MIN_VALUE / 2` avoids overflow during addition
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int NEG_INF = Integer.MIN_VALUE / 2; // Prevent overflow on addition
        int[][] dp = new int[n + 1][m + 1];

        // Initialize DP table with negative infinity
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], NEG_INF);
        }

        // Build DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                int product = nums1[i - 1] * nums2[j - 1];

                dp[i][j] = Math.max(
                        product, // start new subsequence
                        Math.max(
                                dp[i - 1][j - 1] + product, // extend subsequence
                                Math.max(
                                        dp[i - 1][j], // skip nums1 element
                                        dp[i][j - 1]  // skip nums2 element
                                )
                        )
                );
            }
        }

        return dp[n][m];
    }
}
