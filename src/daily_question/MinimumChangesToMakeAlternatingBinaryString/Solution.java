package daily_question.MinimumChangesToMakeAlternatingBinaryString;

/// # Minimum Changes to Make Alternating Binary String
///
/// This class provides a solution for determining the **minimum number of
/// character changes required to transform a binary string into an alternating
/// binary pattern**.
///
/// A binary string is **alternating** when no two adjacent characters are equal.
///
/// Valid alternating patterns include:
///
/// | Pattern | Example |
/// |--------|---------|
/// | Start with `0` | `010101` |
/// | Start with `1` | `101010` |
///
/// Since only two alternating patterns are possible, the algorithm compares
/// the input string against both patterns and counts the number of mismatches.
///
/// ## Algorithm
///
/// For a string of length `n`, two possible valid patterns exist:
///
/// 1. Pattern starting with `'0'` → `010101...`
/// 2. Pattern starting with `'1'` → `101010...`
///
/// For each character index:
///
/// - Compute the **expected character** for both patterns.
/// - If the current character does not match the expected one,
///   increment the mismatch counter.
///
/// The final answer is the **minimum mismatch count** between the two patterns.
///
/// ## Time Complexity
///
/// `O(n)`
///
/// The string is traversed once.
///
/// ## Space Complexity
///
/// `O(1)`
///
/// Only a few integer counters are used.
///
/// ## Key Insight
///
/// Because only **two alternating patterns are possible**, the optimal
/// transformation can be found by simply counting mismatches against
/// both patterns and choosing the smaller value.
///
/// @author
/// Algorithm study implementation
class Solution {

    /// Computes the **minimum number of operations** required to transform
    /// the given binary string into an **alternating binary string**.
    ///
    /// Each operation consists of **changing a character (`0` → `1` or `1` → `0`)**.
    ///
    /// The method compares the input string against both possible alternating
    /// patterns and returns the minimum number of mismatches.
    ///
    /// @param s a binary string containing only `'0'` and `'1'`
    /// @return the minimum number of character changes required
    public int minOperations(String s) {

        int mismatchStartWith0 = 0;
        int mismatchStartWith1 = 0;

        for (int i = 0; i < s.length(); i++) {

            char expectedFor0Pattern = (i % 2 == 0) ? '0' : '1';
            char expectedFor1Pattern = (i % 2 == 0) ? '1' : '0';

            if (s.charAt(i) != expectedFor0Pattern) {
                mismatchStartWith0++;
            }

            if (s.charAt(i) != expectedFor1Pattern) {
                mismatchStartWith1++;
            }
        }

        return Math.min(mismatchStartWith0, mismatchStartWith1);
    }
}