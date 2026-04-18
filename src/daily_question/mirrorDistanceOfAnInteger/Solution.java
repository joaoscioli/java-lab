package daily_question.mirrorDistanceOfAnInteger;

/// ## Complexity
///
/// - **Time Complexity:** O(d)
///   - `d` = number of digits in `n`
/// - **Space Complexity:** O(1)
class Solution {

    /// ## mirrorDistance
    ///
    /// Calculates the mirror distance of an integer.
    ///
    /// ### Parameters
    /// - `n`: a positive integer
    ///
    /// ### Returns
    /// - The absolute difference between `n` and its reversed value
    public int mirrorDistance(int n) {
        int reversed = reverse(n);
        return Math.abs(n - reversed);
    }

    /// ## reverse
    ///
    /// Reverses the digits of a non-negative integer.
    ///
    /// ### Parameters
    /// - `x`: integer to reverse
    ///
    /// ### Returns
    /// - The integer formed by reversing the digits of `x`
    ///
    /// ### Notes
    /// - Leading zeros in the reversed number are automatically removed
    ///
    /// ### Example
    /// ```java
    /// reverse(120) → 21
    /// reverse(100) → 1
    /// ```
    private int reverse(int x) {
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + (x % 10);
            x /= 10;
        }
        return rev;
    }
}