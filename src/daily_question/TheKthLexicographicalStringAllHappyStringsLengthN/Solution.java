package daily_question.TheKthLexicographicalStringAllHappyStringsLengthN;

/// # Solution
///
/// Computes the **k-th lexicographical happy string** of length `n`.
///
/// A **happy string** is defined as:
/// - A string composed only of the characters `'a'`, `'b'`, and `'c'`.
/// - No two adjacent characters are equal.
///
/// The algorithm generates valid strings using **backtracking** in
/// **lexicographical order** and counts them until the `k`-th string is found.
///
/// If fewer than `k` happy strings exist, an empty string is returned.
///
/// ## Algorithm
///
/// The approach uses **Depth-First Search (DFS)** with backtracking:
///
/// 1. Start with an empty string.
/// 2. Append characters `'a'`, `'b'`, and `'c'` in lexicographical order.
/// 3. Skip any character equal to the previous character to maintain the
///    happy string constraint.
/// 4. Once the current string length reaches `n`, increment a counter.
/// 5. When the counter equals `k`, store the result and stop further recursion.
///
/// Since strings are generated in lexicographical order, the `k`-th generated
/// string is the desired answer.
///
/// ## Complexity
///
/// - **Time Complexity:** `O(3 × 2^(n-1))` in the worst case.
/// - **Space Complexity:** `O(n)` due to recursion depth and the temporary string.
///
/// ## Constraints
///
/// - `1 ≤ n ≤ 10`
/// - `1 ≤ k ≤ 100`
class Solution {

    /// Tracks how many valid happy strings have been generated so far.
    private int count = 0;

    /// Stores the resulting k-th happy string when found.
    private String result = "";

    /// ## getHappyString
    ///
    /// Returns the **k-th lexicographical happy string** of length `n`.
    ///
    /// If the total number of happy strings is less than `k`,
    /// the method returns an empty string.
    ///
    /// ### Parameters
    /// - `n` — the desired length of the happy string
    /// - `k` — the lexicographical index (1-based)
    ///
    /// ### Returns
    /// The `k`-th happy string in lexicographical order, or `""`
    /// if such a string does not exist.
    public String getHappyString(int n, int k) {
        backtrack(new StringBuilder(), n, k);
        return result;
    }

    /// ## backtrack
    ///
    /// Recursively builds candidate strings using backtracking.
    ///
    /// At each step, the method attempts to append one of the characters
    /// `'a'`, `'b'`, or `'c'`, ensuring that it does not match the previous
    /// character in order to maintain the happy string condition.
    ///
    /// When the constructed string reaches length `n`, it is counted as a
    /// valid happy string. If it corresponds to the `k`-th string, the
    /// result is stored and recursion stops early.
    ///
    /// ### Parameters
    /// - `current` — the string currently being constructed
    /// - `n` — target length of the happy string
    /// - `k` — target lexicographical index
    private void backtrack(StringBuilder current, int n, int k) {

        if (current.length() == n) {
            count++;
            if (count == k) {
                result = current.toString();
            }
            return;
        }

        for (char c : new char[]{'a', 'b', 'c'}) {

            if (current.length() > 0 &&
                    current.charAt(current.length() - 1) == c) {
                continue;
            }

            current.append(c);
            backtrack(current, n, k);

            if (!result.isEmpty()) return;

            current.deleteCharAt(current.length() - 1);
        }
    }
}