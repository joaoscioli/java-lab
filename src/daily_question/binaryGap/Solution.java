package daily_question.binaryGap;

///
/// ## Overview
///
/// Computes the maximum distance between two consecutive `1` bits
/// in the binary representation of a given integer.
///
/// The distance is defined as the difference in positions between
/// two adjacent set bits (`1`s).
///
/// ## Approach
///
/// - Iterates through each bit of the integer using bitwise operations
/// - Tracks the position of the last encountered `1`
/// - Updates the maximum gap whenever a new `1` is found
/// - Uses right shift (`>>`) to traverse all bits efficiently
///
/// ## Time Complexity
///
/// - **O(log n)**, since the number of bits in `n` is proportional to `log₂(n)`
///
/// ## Space Complexity
///
/// - **O(1)**, constant extra space
///
class Solution {

    ///
    /// ### binaryGap
    ///
    /// Calculates the maximum distance between consecutive `1`s
    /// in the binary representation of the input integer.
    ///
    /// #### Parameters
    /// - `n`: A positive integer
    ///
    /// #### Returns
    /// - The maximum gap between two consecutive `1` bits
    ///
    /// #### Details
    /// - Uses bitwise AND (`& 1`) to check the least significant bit
    /// - Maintains the position index while shifting the number
    /// - Updates the maximum gap dynamically during traversal
    ///
    public int binaryGap(int n) {
        int lastOne = -1;
        int maxGap = 0;
        int position = 0;

        while (n > 0) {
            if ((n & 1) == 1) {
                if (lastOne != -1) {
                    maxGap = Math.max(maxGap, position - lastOne);
                }
                lastOne = position;
            }
            position++;
            n >>= 1;
        }

        return maxGap;
    }
}