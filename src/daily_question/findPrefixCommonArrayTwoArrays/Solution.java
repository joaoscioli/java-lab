package daily_question.findPrefixCommonArrayTwoArrays;

/// Provides a solution for computing the prefix common array of two integer arrays.
///
/// The prefix common array `C` is defined such that `C[i]` represents the number
/// of distinct values that appear in both prefixes:
///
/// - `A[0..i]`
/// - `B[0..i]`
///
/// This implementation assumes that both arrays have the same length and contain
/// values in the range `1` to `n`, where `n` is the length of the arrays.
class Solution {

    /// Computes the prefix common array for two arrays.
    ///
    /// For each index `i`, this method counts how many values have appeared at
    /// least once in both `A[0..i]` and `B[0..i]`.
    ///
    /// The algorithm uses a frequency array to track how many times each value
    /// has been seen while scanning both arrays from left to right. When the
    /// frequency of a value becomes `2`, that value has appeared in both prefixes
    /// and is counted as common.
    ///
    /// ## Example
    ///
    /// ```java
    /// int[] A = {1, 3, 2, 4};
    /// int[] B = {3, 1, 2, 4};
    ///
    /// int[] result = new Solution().findThePrefixCommonArray(A, B);
    /// // result: [0, 2, 3, 4]
    /// ```
    ///
    /// ## Complexity
    ///
    /// - Time complexity: `O(n)`, where `n` is the length of the arrays.
    /// - Space complexity: `O(n)`, due to the auxiliary frequency array.
    ///
    /// @param A the first integer array
    /// @param B the second integer array
    /// @return ana array where each position contains the number of common values
    ///         between the prefixes of `A` and `B` up to that index
    int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] result = new int[n];
        int[] frequency = new int[n + 1];

        int common = 0;

        for (int i = 0; i < n; i++) {
            frequency[A[i]]++;

            if (frequency[A[i]] == 2) {
                common++;
            }

            frequency[B[i]]++;

            if (frequency[B[i]] == 2) {
                common++;
            }

            result[i] = common;
        }

        return result;
    }
}