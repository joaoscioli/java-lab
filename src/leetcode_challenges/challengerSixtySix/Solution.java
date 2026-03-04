package leetcode_challenges.challengerSixtySix;

/// # Plus One
///
/// Increments a large integer represented as an array of digits.
///
/// The digits are ordered from most significant to least significant.
/// Each element in the array contains a single digit (0–9), and the
/// integer does not contain leading zeros.
///
/// ## How It Works
///
/// The algorithm iterates from right to left (least significant digit).
///
/// - If the current digit is less than 9:
///   - Increment it by one.
///   - Return the updated array immediately (no carry needed).
///
/// - If the digit is 9:
///   - Set it to 0.
///   - Continue to propagate the carry to the next digit.
///
/// If all digits are 9 (e.g., `[9,9,9]`), the method:
///
/// - Creates a new array with length `n + 1`.
/// - Sets the first element to `1`.
/// - Returns the new array (e.g., `[1,0,0,0]`).
///
/// ## Time Complexity
///
/// - **O(n)** — In the worst case, all digits are processed.
///
/// ## Space Complexity
///
/// - **O(1)** — If no new array is created.
/// - **O(n)** — If a new array is required (all digits are 9).
///
/// @param digits an array representing a non-negative integer
/// @return the resulting array after incrementing the integer by one
class Solution {

    /// Increments the integer represented by the given digit array.
    ///
    /// @param digits the digit array (most significant digit first)
    /// @return the incremented digit array
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}