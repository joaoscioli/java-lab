package daily_question.checkStringsCanMadeEqualWithOperationsII;

/// # Check if Strings Can Be Made Equal With Operations II
///
/// This class provides a solution to determine whether two strings can be made equal
/// by performing a specific swap operation any number of times.
///
/// ## Problem Summary
///
/// Given two strings `s1` and `s2` of equal length, you may perform the following operation:
/// - Choose two indices `i` and `j` such that `i < j` and `(j - i)` is even,
///   then swap the characters at those positions.
///
/// The goal is to check whether it is possible to transform `s1` into `s2` using
/// any number of such operations.
///
/// ## Key Insight
///
/// The allowed operation preserves the parity of indices:
/// - Characters at **even indices** can only be swapped with other even indices.
/// - Characters at **odd indices** can only be swapped with other odd indices.
///
/// Therefore, the problem reduces to verifying:
/// - The frequency of characters at even indices in `s1` matches those in `s2`.
/// - The frequency of characters at odd indices in `s1` matches those in `s2`.
///
/// ## Approach
///
/// - Use two frequency arrays:
///   - `even[]` for characters at even indices
///   - `odd[]` for characters at odd indices
/// - Increment counts for `s1` and decrement for `s2`
/// - If all counts return to zero, the strings can be made equal
///
/// ## Complexity
///
/// - Time Complexity: `O(n)`
/// - Space Complexity: `O(1)` (fixed-size arrays of length 26)
///
class Solution {

    /// ## checkStrings
    ///
    /// Determines whether two strings can be made equal using the allowed swap operations.
    ///
    /// ### Parameters
    /// - `s1`: The original string
    /// - `s2`: The target string
    ///
    /// ### Returns
    /// - `true` if `s1` can be transformed into `s2`
    /// - `false` otherwise
    ///
    /// ### Example
    /// ```java
    /// Input: s1 = "abcdba", s2 = "cabdab"
    /// Output: true
    /// ```
    ///
    /// ```java
    /// Input: s1 = "abe", s2 = "bea"
    /// Output: false
    /// ```
    ///
    public boolean checkStrings(String s1, String s2) {
        int[] even = new int[26];
        int[] odd = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            if (i % 2 == 0) {
                even[s1.charAt(i) - 'a']++;
                even[s2.charAt(i) - 'a']--;
            } else {
                odd[s1.charAt(i) - 'a']++;
                odd[s2.charAt(i) - 'a']--;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (even[i] != 0 || odd[i] != 0) {
                return false;
            }
        }

        return true;
    }
}