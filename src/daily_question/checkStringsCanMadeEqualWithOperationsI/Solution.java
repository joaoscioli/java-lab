package daily_question.checkStringsCanMadeEqualWithOperationsI;

import java.util.Arrays;

/// # Solution
///
/// Provides a method to determine whether two strings of length 4 can be made equal
/// using a constrained swap operation.
///
/// ## Problem Summary
/// Given two strings `s1` and `s2`, both of length 4, you may perform any number of
/// operations where you swap characters at indices `i` and `j` such that `j - i = 2`.
///
/// This effectively allows swaps only between:
/// - indices `(0, 2)`
/// - indices `(1, 3)`
///
/// ## Key Insight
/// The string can be divided into two independent groups:
/// - Even indices: `{0, 2}`
/// - Odd indices: `{1, 3}`
///
/// Since swaps are only allowed within these groups, characters cannot move between them.
/// Therefore, for the strings to be made equal:
/// - The multiset of characters at even indices must match
/// - The multiset of characters at odd indices must match
///
/// ## Approach
/// 1. Extract characters at even and odd indices for both strings
/// 2. Sort each group
/// 3. Compare corresponding groups between `s1` and `s2`
///
/// ## Complexity
/// - Time Complexity: `O(1)` (fixed input size)
/// - Space Complexity: `O(1)`
///
/// ## Example
/// ```
/// Input:  s1 = "abcd", s2 = "cdab"
/// Output: true
/// ```
///
/// ## Constraints
/// - `s1.length == s2.length == 4`
/// - Strings contain only lowercase English letters
///
class Solution {

    /// ## canBeEqual
    ///
    /// Determines whether two strings can be made equal using the allowed swap operation.
    ///
    /// ### Parameters
    /// - `s1`: The source string
    /// - `s2`: The target string
    ///
    /// ### Returns
    /// - `true` if `s1` can be transformed into `s2`
    /// - `false` otherwise
    ///
    /// ### Details
    /// The method compares sorted character groups at:
    /// - even indices (0, 2)
    /// - odd indices (1, 3)
    ///
    /// If both groups match between the two strings, transformation is possible.
    ///
    public boolean canBeEqual(String s1, String s2) {
        char[] s1Even = {s1.charAt(0), s1.charAt(2)};
        char[] s1Odd  = {s1.charAt(1), s1.charAt(3)};

        char[] s2Even = {s2.charAt(0), s2.charAt(2)};
        char[] s2Odd  = {s2.charAt(1), s2.charAt(3)};

        Arrays.sort(s1Even);
        Arrays.sort(s1Odd);
        Arrays.sort(s2Even);
        Arrays.sort(s2Odd);

        return Arrays.equals(s1Even, s2Even) &&
                Arrays.equals(s1Odd, s2Odd);
    }
}