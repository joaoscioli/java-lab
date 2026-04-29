package daily_question.binaryNumberAlternatingBits;

///
/// ## Overview
///
/// Determines whether a given integer has alternating bits in its
/// binary representation.
///
/// A number has alternating bits if no two adjacent bits are the same,
/// meaning the bits strictly alternate between `0` and `1`.
///
/// ## Approach
///
/// - Extracts the least significant bit (LSB) as the initial reference
/// - Iteratively shifts the number to the right
/// - Compares each current bit with the previous one
/// - If two consecutive bits are equal, returns `false`
/// - If all bits alternate, returns `true`
///
/// ## Time Complexity
///
/// - **O(log n)**, where `n` is the input integer
///
/// ## Space Complexity
///
/// - **O(1)**, constant extra space
///
class Solution {

    ///
    /// ### hasAlternatingBits
    ///
    /// Checks whether the binary representation of the input integer
    /// consists of alternating bits.
    ///
    /// #### Parameters
    /// - `n`: A positive integer
    ///
    /// #### Returns
    /// - `true` if the bits alternate (e.g., `1010`, `0101`)
    /// - `false` otherwise
    ///
    /// #### Details
    /// - Uses bitwise AND (`& 1`) to extract the current bit
    /// - Uses right shift (`>>`) to traverse all bits
    /// - Compares each bit with the previous one during iteration
    ///
    public boolean hasAlternatingBits(int n) {
        int prev = n & 1;
        n >>= 1;

        while (n > 0) {
            int curr = n & 1;
            if (curr == prev) return false;
            prev = curr;
            n >>= 1;
        }
        return true;
    }
}