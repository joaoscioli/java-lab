package daily_question.complementBase10Integer;

class Solution {

    /// # Bitwise Complement of Base-10 Integer
    ///
    /// Computes the **bitwise complement** of a non-negative integer.
    ///
    /// The complement is obtained by flipping every bit in the binary
    /// representation of the number:
    ///
    /// - `0` becomes `1`
    /// - `1` becomes `0`
    ///
    /// However, only the bits **up to the most significant `1`** of the number
    /// are considered. Leading zeros are ignored.
    ///
    /// ## Example
    ///
    /// ```text
    /// n = 5
    /// binary = 101
    /// complement = 010
    /// result = 2
    /// ```
    ///
    /// ## Approach
    ///
    /// 1. **Edge case**:
    ///    - If `n == 0`, the binary representation is `0`,
    ///      and its complement is `1`.
    ///
    /// 2. **Build a bit mask** containing only `1`s with the same
    ///    length as the binary representation of `n`.
    ///
    ///    Example:
    ///    ```text
    ///    n = 5  -> 101
    ///    mask = 111
    ///    ```
    ///
    /// 3. **Apply XOR (`^`) between the mask and the number**.
    ///
    ///    ```text
    ///    111
    ///    101
    ///    ---
    ///    010
    ///    ```
    ///
    /// This effectively flips all bits within the valid range.
    ///
    /// ## Time Complexity
    ///
    /// - **O(log n)** – proportional to the number of bits in `n`.
    ///
    /// ## Space Complexity
    ///
    /// - **O(1)** – uses constant extra space.
    ///
    /// @param n the non-negative integer whose bitwise complement will be computed
    /// @return the complement of `n` considering only its significant bits
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;

        int mask = 0;
        int temp = n;

        while (temp > 0) {
            mask = (mask << 1) | 1;
            temp >>= 1;
        }

        return mask ^ n;
    }
}