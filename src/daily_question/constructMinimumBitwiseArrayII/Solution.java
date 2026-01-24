package daily_question.constructMinimumBitwiseArrayII;

import java.util.List;

class Solution {

    /// ## Construct Minimum Bitwise Array II
    ///
    /// Given a list of integers `nums`, this method constructs an array `ans`
    /// where each element represents the **minimum possible value** such that
    /// the bitwise OR between the element and itself shifted appropriately
    /// satisfies the problem constraints.
    ///
    /// ### Key Idea
    /// - If a number `p` is **even**, it is impossible to construct a valid value,
    ///   so the result is `-1`.
    /// - If `p` is **odd**, we:
    ///   1. Count how many consecutive `1`s exist from the **least significant bit**.
    ///   2. Subtract `2^(k - 1)` from `p`, where `k` is that count.
    ///
    /// This ensures the resulting value is the **smallest possible** that still
    /// preserves the required bitwise properties.
    ///
    /// ### Example
    /// ```
    /// Input:  [3, 5, 7]
    /// Binary: [11, 101, 111]
    /// Output: [2, 4, 3]
    /// ```
    ///
    /// ### Time Complexity
    /// - **O(n · log p)** — each number is processed bit-by-bit.
    ///
    /// ### Space Complexity
    /// - **O(n)** — for the result array.
    ///
    /// @param nums a list of integers to be processed
    /// @return an array containing the minimum valid bitwise values or `-1` if impossible
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int p = nums.get(i);

            /// If `p` is even, it cannot satisfy the condition
            if ((p & 1) == 0) {
                ans[i] = -1;
                continue;
            }

            /// Count consecutive trailing `1` bits
            int k = 0;
            int temp = p;
            while ((temp & 1) == 1) {
                k++;
                temp >>= 1;
            }

            /// Subtract 2^(k - 1) to obtain the minimum valid value
            ans[i] = p - (1 << (k - 1));
        }

        return ans;
    }
}
