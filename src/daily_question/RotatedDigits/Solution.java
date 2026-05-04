package daily_question.RotatedDigits;

class Solution {
    /// # rotatedDigits
    ///
    /// Counts how many numbers in the range `[1, n]` are **good numbers**.
    ///
    /// A number is considered **good** if:
    /// - After rotating each digit by 180 degrees, the number becomes **valid**, and
    /// - The resulting number is **different** from the original.
    ///
    /// ## Digit Rotation Rules
    ///
    /// | Digit | Rotates To | Valid |
    /// |------|-----------|--------|
    /// | 0    | 0         | ✅     |
    /// | 1    | 1         | ✅     |
    /// | 8    | 8         | ✅     |
    /// | 2    | 5         | ✅     |
    /// | 5    | 2         | ✅     |
    /// | 6    | 9         | ✅     |
    /// | 9    | 6         | ✅     |
    /// | 3,4,7 | -        | ❌ (invalid) |
    ///
    /// ## Key Idea
    ///
    /// A number is **good** if:
    /// - It contains **at least one digit** from `{2, 5, 6, 9}` (so it changes after rotation),
    /// - And **only digits** from `{0,1,2,5,6,8,9}` (so it remains valid).
    ///
    /// ## Approach
    ///
    /// - Iterate through all numbers from `1` to `n`.
    /// - For each number:
    ///   - Check each digit:
    ///     - If it contains an invalid digit → discard.
    ///     - Track if it contains at least one "changing" digit `{2,5,6,9}`.
    /// - Count numbers that satisfy both conditions.
    ///
    /// ## Time Complexity
    /// - **O(n * d)** where `d` is the number of digits (≤ 5 for n ≤ 10⁴).
    ///
    /// ## Space Complexity
    /// - **O(1)** — constant extra space.
    ///
    /// ## Parameters
    /// - `n`: Upper bound of the range.
    ///
    /// ## Returns
    /// - The count of good numbers in `[1, n]`.
    ///
    /// ## Example
    /// ```
    /// Input: n = 10
    /// Output: 4
    ///
    /// Explanation:
    /// Good numbers: 2, 5, 6, 9
    /// ```
    public int rotatedDigits(int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (isGood(i)) {
                count++;
            }
        }

        return count;
    }

    /// ## isGood
    ///
    /// Helper method to determine if a number is a **good number**.
    ///
    /// ## Rules
    /// - Returns `false` if any digit is invalid (3, 4, 7).
    /// - Returns `true` only if:
    ///   - At least one digit is in `{2,5,6,9}` (changes after rotation),
    ///   - All digits are valid.
    ///
    /// ## Parameters
    /// - `num`: The number to check.
    ///
    /// ## Returns
    /// - `true` if the number is good, otherwise `false`.
    private boolean isGood(int num) {
        boolean hasChanged = false;

        while (num > 0) {
            int digit = num % 10;

            // Invalid digits
            if (digit == 3 || digit == 4 || digit == 7) {
                return false;
            }

            // Digits that change after rotation
            if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                hasChanged = true;
            }

            num /= 10;
        }

        return hasChanged;
    }
}