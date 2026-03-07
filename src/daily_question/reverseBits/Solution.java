package daily_question.reverseBits;

class Solution {

    /// # reverseBits
    ///
    /// Reverses the order of bits in a 32-bit unsigned integer.
    ///
    /// ## Overview
    ///
    /// This method iterates through all **32 bits** of the input integer `n`
    /// and constructs a new integer whose bits are in the **reverse order**.
    ///
    /// The algorithm processes the bits from **least significant bit (LSB)**
    /// to **most significant bit (MSB)** and builds the result from left to right.
    ///
    /// ## Algorithm
    ///
    /// The process repeats 32 times:
    ///
    /// 1. Shift the `result` one bit to the left to make room for the next bit.
    /// 2. Extract the least significant bit of `n` using `n & 1`.
    /// 3. Append that bit to `result` using the bitwise OR operator.
    /// 4. Shift `n` one bit to the right using an **unsigned right shift (`>>>`)**
    ///    to bring the next bit into position.
    ///
    /// ## Bit Operations Used
    ///
    /// - `<<` — Left shift, moves bits to the left and inserts `0`.
    /// - `&` — Bitwise AND, used to extract the least significant bit.
    /// - `|` — Bitwise OR, used to append the extracted bit to the result.
    /// - `>>>` — Unsigned right shift, shifts bits right while inserting `0`
    ///   at the most significant position.
    ///
    /// ## Time Complexity
    ///
    /// - **O(1)** — Always performs exactly **32 iterations**.
    ///
    /// ## Space Complexity
    ///
    /// - **O(1)** — Uses only a constant amount of additional memory.
    ///
    /// ## Parameters
    ///
    /// - `n` — A 32-bit integer whose bits will be reversed.
    ///
    /// ## Returns
    ///
    /// - An integer representing the value obtained after reversing the
    ///   bit order of `n`.
    ///
    /// ## Example
    ///
    /// ```text
    /// Input:  n = 00000010100101000001111010011100
    /// Output:     00111001011110000010100101000000
    /// ```
    ///
    /// The least significant bit becomes the most significant bit,
    /// and the entire sequence of bits is reversed.
    ///
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1;

            result |= (n & 1);

            n >>>= 1;
        }

        return result;
    }
}