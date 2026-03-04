package leetcode_challenges.challengerTwentyTwo;

import java.util.ArrayList;
import java.util.List;

/// # Generate Parentheses
///
/// Generates all combinations of well-formed parentheses
/// for a given number of pairs `n`.
///
/// A combination is considered valid if:
/// - The number of opening and closing parentheses is equal.
/// - At no point does the number of closing parentheses
///   exceed the number of opening parentheses.
///
/// ## Example
///
/// ```
/// Input:  n = 3
/// Output: ["((()))","(()())","(())()","()(())","()()()"]
/// ```
///
/// ## Approach
///
/// This solution uses **backtracking** to build combinations incrementally.
///
/// It maintains:
///
/// - `open`  → number of opening parentheses used
/// - `close` → number of closing parentheses used
/// - `sb`    → current combination being built
///
/// ### Backtracking Rules
///
/// 1. If `open == n` and `close == n`:
///    - A valid combination is complete.
///    - Add it to the result list.
///
/// 2. If `open < n`:
///    - Add `"("` and recurse.
///
/// 3. If `close < open`:
///    - Add `")"` and recurse.
///
/// After each recursive call, the last character is removed
/// (backtracked) to explore other possibilities.
///
/// ## Time Complexity
///
/// - **O(4^n / √n)** — Corresponds to the nth Catalan number.
///
/// ## Space Complexity
///
/// - **O(n)** — Recursion depth and StringBuilder size.
/// - Output space is proportional to the number of valid combinations.
///
/// @param n the number of pairs of parentheses
/// @return a list containing all valid combinations
class Solution {

    /// Generates all valid parentheses combinations for {@code n} pairs.
    ///
    /// @param n number of parentheses pairs
    /// @return list of well-formed parentheses strings
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        backtrack(sb, 0, 0, n, result);

        return result;
    }

    /// Backtracking helper method that builds combinations recursively.
    ///
    /// @param sb current string being constructed
    /// @param open number of opening parentheses used
    /// @param close number of closing parentheses used
    /// @param n total number of pairs required
    /// @param result list that stores valid combinations
    public void backtrack(StringBuilder sb, int open, int close, int n, List<String> result) {
        if (open == n && close == n) {
            result.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append("(");
            backtrack(sb, open + 1, close, n, result);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(")");
            backtrack(sb, open, close + 1, n, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}