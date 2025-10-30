package daily_question.SmallestNumberWithAllSetBits;

public class Solution {

    /// # Smallest Number With All Set Bits
    ///
    /// Given an integer `n`, this method finds the **smallest positive integer** that is **greater than or equal to `n`**
    /// and has **all bits set to 1** in its binary representation.
    ///
    /// ---
    ///
    /// ## Example
    /// ```java
    /// Input: n = 5
    /// Output: 7
    /// Explanation:
    /// Binary representation of 5 = 101
    /// The next number with all bits set (111) is 7.
    /// ```
    ///
    /// ---
    ///
    /// ## Algorithm
    /// 1. Initialize `k = 1`, representing the number of bits.
    /// 2. Use the expression `(1 << k) - 1` to generate a number with all bits set to 1 for `k` bits.
    ///    - For example:
    ///      - `k = 1 → (1 << 1) - 1 = 1` → binary `1`
    ///      - `k = 2 → (1 << 2) - 1 = 3` → binary `11`
    ///      - `k = 3 → (1 << 3) - 1 = 7` → binary `111`
    /// 3. Increment `k` until the generated number is **greater than or equal to `n`**.
    /// 4. Return `(1 << k) - 1` as the result.
    ///
    /// ---
    ///
    /// ## Parameters
    /// - `n` — The input integer.
    ///
    /// ## Returns
    /// - The smallest integer greater than or equal to `n` whose binary representation consists only of `1`s.
    ///
    /// ---
    ///
    /// ## Complexity
    /// - **Time complexity:** `O(log n)` — The loop runs once per bit required to exceed `n`.
    /// - **Space complexity:** `O(1)` — Constant space usage.
    ///
    /// ---
    ///
    /// ## Example Usage
    /// ```java
    /// Solution solution = new Solution();
    /// int result = solution.smallestNumber(10);
    /// System.out.println(result); // Output: 15
    /// ```
    ///
    /// Explanation:
    /// Binary of 10 = 1010 → next number with all bits set = 1111 (15)
    ///
    public int smallestNumber(int n) {
        int k = 1;
        while (((1 << k) - 1) < n) {
            k++;
        }
        return (1 << k) - 1;
    }
}
