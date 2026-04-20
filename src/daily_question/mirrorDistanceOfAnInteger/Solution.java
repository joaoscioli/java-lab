package daily_question.mirrorDistanceOfAnInteger;

class Solution {

    /// ### Mirror Distance of an Integer
    ///
    /// Computes the **mirror distance** of a given integer `n`.
    ///
    /// The mirror distance is defined as:
    /// ```
    /// |n - reverse(n)|
    /// ```
    /// where `reverse(n)` is the integer obtained by reversing the digits of `n`.
    ///
    /// ---
    ///
    /// ### Example
    /// ```java
    /// Input: n = 25
    /// reverse(25) = 52
    /// Output: 27
    /// ```
    ///
    /// ---
    ///
    /// ### Parameters
    /// - `n` : the input integer (assumed to be non-negative)
    ///
    /// ### Returns
    /// - the absolute difference between `n` and its reversed value
    ///
    /// ### Complexity
    /// - Time: `O(d)` where `d` is the number of digits in `n`
    /// - Space: `O(1)`
    ///
    public int mirrorDistance(int n) {
        int reversed = reverse(n);
        return Math.abs(n - reversed);
    }

    /// ### Reverse Integer
    ///
    /// Reverses the digits of a non-negative integer.
    ///
    /// ---
    ///
    /// ### Example
    /// ```java
    /// Input: 123
    /// Output: 321
    /// ```
    ///
    /// ---
    ///
    /// ### Parameters
    /// - `x` : the integer to reverse
    ///
    /// ### Returns
    /// - the reversed integer
    ///
    /// ### Notes
    /// - This method assumes `x >= 0`
    /// - Leading zeros in the reversed result are naturally removed
    ///
    /// ### Complexity
    /// - Time: `O(d)` where `d` is the number of digits
    /// - Space: `O(1)`
    ///
    private int reverse(int x) {
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + (x % 10);
            x /= 10;
        }
        return rev;
    }
}