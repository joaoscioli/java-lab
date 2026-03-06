package daily_question.countBinarySubstrings;

/// # Count Binary Substrings
///
/// This class provides a solution for the classic **binary substring counting problem**.
///
/// A valid substring must:
///
/// - Contain **only two consecutive groups of characters**
/// - Have the **same number of `0`s and `1`s**
/// - All `0`s and `1`s must appear in **contiguous blocks**
///
/// Example:
///
/// | Substring | Valid | Explanation |
/// |-----------|------|-------------|
/// | `"0011"`  | ✔ | two groups `00` and `11`, same size |
/// | `"01"`    | ✔ | one `0` and one `1` |
/// | `"001"`   | ✘ | group sizes differ |
///
/// For example:
///
/// ```text
/// Input:  "00110011"
/// Output: 6
///
/// Valid substrings:
/// "0011", "01", "1100", "10", "0011", "01"
/// ```
///
/// ## Algorithm
///
/// Instead of checking every substring, the algorithm tracks
/// **consecutive group lengths**.
///
/// It maintains:
///
/// - `curr` → length of the current group
/// - `prev` → length of the previous group
///
/// When the character changes:
///
/// 1. The number of valid substrings between the two groups is
///    `min(prev, curr)`.
/// 2. The current group becomes the previous group.
/// 3. A new group starts.
///
/// Finally, the last pair of groups is evaluated.
///
/// ## Time Complexity
///
/// `O(n)`
///
/// The string is scanned exactly once.
///
/// ## Space Complexity
///
/// `O(1)`
///
/// Only a few integer variables are used.
///
/// ## Key Insight
///
/// Every valid substring must be formed from **two adjacent groups
/// of characters**, and the number of such substrings equals the
/// **minimum size between the two groups**.
///
/// @author
/// Algorithm study implementation
class Solution {

    /// Counts the number of **valid binary substrings** in the input string.
    ///
    /// The method iterates through the string while tracking the size of
    /// consecutive character groups and summing the valid substring counts
    /// formed between adjacent groups.
    ///
    /// @param s a binary string containing only `'0'` and `'1'`
    /// @return the number of valid binary substrings
    public int countBinarySubstrings(String s) {
        int prev = 0, curr = 1, count = 0;

        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == s.charAt(i - 1)) {
                curr++;
            } else {
                count += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            }

        }

        count += Math.min(prev, curr);
        return count;
    }
}