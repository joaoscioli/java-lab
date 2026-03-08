package daily_question.minimumNumberFlipsMakeBinaryStringAlternating;

class Solution {

    /// # Minimum Number of Flips to Make a Binary String Alternating
    ///
    /// Calculates the minimum number of **bit flips** required to transform a binary
    /// string into an **alternating string** (`0101...` or `1010...`).
    ///
    /// The algorithm also considers **rotations** of the string. A rotation moves the
    /// first character to the end of the string. Since rotations can produce different
    /// arrangements, the method evaluates all possible rotations efficiently.
    ///
    /// ## Approach
    ///
    /// 1. **Double the string**
    ///    - The string is concatenated with itself (`s + s`) to simulate all
    ///      possible rotations.
    ///
    /// 2. **Sliding window**
    ///    - A window of size `n` (original string length) moves across the doubled
    ///      string to represent each rotation.
    ///
    /// 3. **Two alternating patterns**
    ///    - Pattern A: `010101...`
    ///    - Pattern B: `101010...`
    ///
    ///    Two counters track how many flips are needed to match each pattern:
    ///    - `diff1` → mismatches with pattern `0101...`
    ///    - `diff2` → mismatches with pattern `1010...`
    ///
    /// 4. **Window adjustment**
    ///    - When the window exceeds size `n`, the leftmost character is removed
    ///      from the mismatch counts.
    ///
    /// 5. **Track minimum**
    ///    - For every valid window (length `n`), the minimum flips required for
    ///      either pattern is recorded.
    ///
    /// ## Parameters
    ///
    /// - `s` — A binary string consisting only of `'0'` and `'1'`.
    ///
    /// ## Returns
    ///
    /// The **minimum number of flips** required to make the string alternating
    /// after considering all possible rotations.
    ///
    /// ## Time Complexity
    ///
    /// `O(n)` — Each character is processed at most twice due to the sliding window.
    ///
    /// ## Space Complexity
    ///
    /// `O(n)` — Due to the creation of the doubled string (`s + s`).
    ///
    /// ## Example
    ///
    /// ```text
    /// Input:  s = "111000"
    /// Output: 2
    ///
    /// Explanation:
    /// One optimal rotation produces a string where only two bits need to be flipped
    /// to match an alternating pattern.
    /// ```
    ///
    /// ## Key Idea
    ///
    /// By doubling the string and using a sliding window, we avoid explicitly
    /// generating all rotations, achieving an efficient linear-time solution.
    public int minFlips(String s) {
        int n = s.length();
        String ss = s + s;

        int diff1 = 0;
        int diff2 = 0;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < ss.length(); i++) {

            char expected1 = (i % 2 == 0) ? '0' : '1';
            char expected2 = (i % 2 == 0) ? '1' : '0';

            if (ss.charAt(i) != expected1) diff1++;
            if (ss.charAt(i) != expected2) diff2++;

            if (i >= n) {
                char prev = ss.charAt(i - n);

                char prevExpected1 = ((i - n) % 2 == 0) ? '0' : '1';
                char prevExpected2 = ((i - n) % 2 == 0) ? '1' : '0';

                if (prev != prevExpected1) diff1--;
                if (prev != prevExpected2) diff2--;
            }

            if (i >= n - 1) {
                ans = Math.min(ans, Math.min(diff1, diff2));
            }
        }

        return ans;
    }
}