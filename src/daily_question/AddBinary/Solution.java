package daily_question.AddBinary;

/// ## Solution
///
/// Provides a solution to the **"Add Binary"** problem.
///
/// Given two binary strings `a` and `b`, this method returns their sum
/// as a binary string.
///
/// The addition is performed manually from **right to left** (least
/// significant bit to most significant bit), simulating the traditional
/// binary addition process with a carry value.
///
/// ### Approach
///
/// The algorithm follows these steps:
///
/// 1. Initialize two pointers:
///    - `i` at the end of string `a`
///    - `j` at the end of string `b`
///
/// 2. Maintain a `carry` variable to handle overflow when the sum of bits
///    exceeds `1`.
///
/// 3. Iterate while:
///    - There are remaining digits in `a`, OR
///    - There are remaining digits in `b`, OR
///    - There is a remaining carry.
///
/// 4. For each iteration:
///    - Add the current bits (if available) and the carry.
///    - Append `sum % 2` to the result.
///    - Update `carry = sum / 2`.
///
/// 5. Reverse the result since bits are appended in reverse order.
///
/// ### Time Complexity
/// - **O(max(n, m))**
///   Where `n` and `m` are the lengths of `a` and `b`.
///
/// ### Space Complexity
/// - **O(max(n, m))**
///   For storing the resulting binary string.
///
/// ### Example
///
/// ```
/// Input:
/// a = "1010"
/// b = "1011"
///
/// Output:
/// "10101"
/// ```
///
/// Explanation:
/// ```
///   1010
/// + 1011
/// -------
///  10101
/// ```
class Solution {

    /// Adds two binary strings and returns their sum as a binary string.
    ///
    /// @param a the first binary string
    /// @param b the second binary string
    /// @return the binary sum of `a` and `b`
    ///
    /// @throws NullPointerException if either input string is null
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            result.append(sum % 2);
            carry = sum / 2;
        }

        return result.reverse().toString();
    }
}