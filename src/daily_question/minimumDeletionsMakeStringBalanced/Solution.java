package daily_question.minimumDeletionsMakeStringBalanced;

/// ## Solution
///
/// Provides an efficient algorithm to compute the **minimum number of deletions**
/// required to make a string balanced.
///
/// A string is considered **balanced** if there is no pair of indices `(i, j)` such that:
/// - `i < j`
/// - `s[i] == 'b'`
/// - `s[j] == 'a'`
///
/// In other words, all `'a'` characters must appear **before** any `'b'` characters.
///
/// ---
public class Solution {

    /// ### minimumDeletions
    ///
    /// Computes the minimum number of deletions needed to make the input string balanced.
    ///
    /// #### Approach
    /// This method uses a **greedy dynamic programming strategy** while iterating
    /// through the string from left to right.
    ///
    /// Two values are maintained:
    /// - `bCount`: the number of `'b'` characters encountered so far
    /// - `deletions`: the minimum deletions required up to the current position
    ///
    /// When an `'a'` is encountered after one or more `'b'`s, there are two choices:
    /// 1. Delete the current `'a'`
    /// 2. Delete all previously seen `'b'` characters
    ///
    /// The algorithm chooses the option with the smaller cost.
    ///
    /// #### Algorithm
    /// - Iterate through each character in the string
    /// - If the character is `'b'`, increment `bCount`
    /// - If the character is `'a'`:
    ///   - Update `deletions` to `min(deletions + 1, bCount)`
    /// - Return `deletions` after processing the entire string
    ///
    /// #### Example
    /// Input: `"aababbab"`
    /// Output: `2`
    ///
    /// #### Time Complexity
    /// - **O(n)**, where `n` is the length of the string
    ///
    /// #### Space Complexity
    /// - **O(1)**, using only constant extra space
    ///
    /// #### Parameters
    /// - `s`: a string consisting only of characters `'a'` and `'b'`
    ///
    /// #### Returns
    /// - The minimum number of deletions required to make the string balanced
    ///
    /// @param s the input string
    /// @return the minimum number of deletions
    ///
    public int minimumDeletions(String s) {
        int bCount = 0;
        int deletions = 0;

        for (char c : s.toCharArray()) {
            if (c == 'b') {
                bCount++;
            } else {
                deletions = Math.min(deletions + 1, bCount);
            }
        }
        return deletions;
    }
}
