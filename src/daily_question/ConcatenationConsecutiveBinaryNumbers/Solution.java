package daily_question.ConcatenationConsecutiveBinaryNumbers;

/// ## Solution
///
/// Provides a solution to the **"Concatenation of Consecutive Binary Numbers"** problem.
///
/// Given an integer `n`, this method:
///
/// 1. Converts every integer from `1` to `n` into its binary representation.
/// 2. Concatenates those binary representations in order.
/// 3. Returns the decimal value of the resulting binary number modulo `1_000_000_007`.
///
/// ### Key Idea
///
/// Instead of building a binary string (which would be inefficient),
/// the solution constructs the result using **bit manipulation**:
///
/// - Each new number `i` is appended to the result by:
///   - Left-shifting the current result by the number of bits in `i`.
///   - Using a bitwise OR (`|`) to add `i`.
///
/// ### Optimization
///
/// The number of bits increases only when `i` is a power of two.
/// This is efficiently detected using:
///
/// ```
/// (i & (i - 1)) == 0
/// ```
///
/// This expression is true **if and only if** `i` is a power of two.
///
/// ### Why Modulo is Needed
///
/// The concatenated value grows exponentially.
/// To prevent overflow and meet problem constraints,
/// the result is taken modulo:
///
/// ```
/// 1_000_000_007
/// ```
///
/// ### Time Complexity
/// - **O(n)**
///   Each number from `1` to `n` is processed once.
///
/// ### Space Complexity
/// - **O(1)**
///   Only a few variables are used.
///
/// ### Example
///
/// ```
/// Input:
/// n = 3
///
/// Binary representations:
/// 1 -> "1"
/// 2 -> "10"
/// 3 -> "11"
///
/// Concatenated:
/// "11011"
///
/// Output:
/// 27
/// ```
class Solution {

    /// Returns the decimal value of the binary string formed by
    /// concatenating the binary representations of integers from `1` to `n`,
    /// modulo `1_000_000_007`.
    ///
    /// @param n the upper bound of consecutive integers (starting from 1)
    /// @return the concatenated binary result modulo `1_000_000_007`
    ///
    /// @throws IllegalArgumentException if `n` is less than 1
    public int concatenatedBinary(int n) {
        long res = 0;
        int mod = 1_000_000_007;
        int bits = 0;

        for (int i = 1; i <= n; i++) {

            // If i is a power of 2, increase bit length
            if ((i & (i - 1)) == 0) {
                bits++;
            }

            // Left shift current result and append i
            res = ((res << bits) | i) % mod;
        }

        return (int) res;
    }
}