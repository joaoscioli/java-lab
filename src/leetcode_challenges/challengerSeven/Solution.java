package leetcode_challenges.challengerSeven;

/// # Reverse Integer
///
/// This class provides a solution to the classic *Reverse Integer* problem,
/// which involves reversing the digits of a 32-bit signed integer.
///
/// ## Problem Description
/// Given a signed 32-bit integer `x`, return `x` with its digits reversed.
/// If reversing `x` causes the value to go outside the signed 32-bit integer range
/// `[-2³¹, 2³¹ - 1]`, then return `0`.
///
/// **Assumption:** The environment does not allow you to store 64-bit integers.
///
/// ## Example
/// ```java
/// Input: x = 123
/// Output: 321
///
/// Input: x = -123
/// Output: -321
///
/// Input: x = 120
/// Output: 21
/// ```
///
/// ## Constraints
/// - `-2³¹ <= x <= 2³¹ - 1`
///
/// ## Implementation Details
/// The algorithm repeatedly extracts the last digit of `x` and appends it to `rev`,
/// checking for overflow before each multiplication or addition.
///
/// The overflow check ensures the result remains within the 32-bit signed integer range.
///
/// ## Time Complexity
/// **O(log₁₀(n))** — proportional to the number of digits in `x`.
///
/// ## Space Complexity
/// **O(1)** — uses constant extra space.
///
public class Solution {

    /// Reverses the digits of a 32-bit signed integer.
    ///
    /// If the reversed integer overflows, the method returns `0`.
    ///
    /// @param x The integer to be reversed.
    /// @return The reversed integer, or `0` if overflow occurs.
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            // Check for overflow before performing the next operation
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;

            rev = rev * 10 + pop;
        }
        return rev;
    }
}
