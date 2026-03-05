package daily_question.checkIfStringContainsAllBinaryCodeSizeK;

/// ## Solution
///
/// Provides a solution to the **"Check If a String Contains All Binary Codes of Size K"** problem.
///
/// Given a binary string `s` and an integer `k`, this method determines
/// whether every possible binary code of length `k` appears as a substring
/// of `s`.
///
/// ### Key Insight
///
/// - There are exactly `2^k` possible binary strings of length `k`.
/// - We can treat each substring of length `k` as a binary number.
/// - Using a **sliding window + rolling hash (bitmask technique)**,
///   we efficiently track all distinct substrings of size `k`.
///
/// ### Optimization
///
/// Instead of extracting substrings (which would be expensive),
/// we maintain a rolling integer `hash`:
///
/// - Left shift the current hash.
/// - Remove overflow bits using a mask.
/// - Add the new bit.
///
/// The mask:
///
/// ```
/// (totalNeeded - 1)
/// ```
///
/// keeps only the last `k` bits.
///
/// ### Early Pruning
///
/// If the string length is too small to contain all possible
/// binary substrings of size `k`, we return `false` immediately:
///
/// ```
/// s.length() < k + 2^k - 1
/// ```
///
/// ### Time Complexity
/// - **O(n)**
///   Each character is processed once.
///
/// ### Space Complexity
/// - **O(2^k)**
///   A boolean array tracks which binary codes have been seen.
///
/// ### Example
///
/// ```
/// Input:
/// s = "00110110"
/// k = 2
///
/// Possible binary codes of size 2:
/// "00", "01", "10", "11"
///
/// Output:
/// true
/// ```
class Solution {

    /// Returns `true` if every possible binary code of length `k`
    /// exists as a substring in the given binary string.
    ///
    /// @param s the input binary string
    /// @param k the size of binary codes to check
    /// @return `true` if all `2^k` binary codes appear in `s`,
    ///         otherwise `false`
    ///
    /// @throws IllegalArgumentException if `k` is negative
    /// @throws NullPointerException if `s` is null
    public boolean hasAllCodes(String s, int k) {
        int totalNeeded = 1 << k;

        if (s.length() < k + totalNeeded - 1) {
            return false;
        }

        boolean[] seen = new boolean[totalNeeded];
        int count = 0;
        int hash = 0;

        for (int i = 0; i < s.length(); i++) {
            hash = ((hash << 1) & (totalNeeded - 1)) | (s.charAt(i) - '0');

            if (i >= k - 1) {
                if (!seen[hash]) {
                    seen[hash] = true;
                    count++;

                    if (count == totalNeeded) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}