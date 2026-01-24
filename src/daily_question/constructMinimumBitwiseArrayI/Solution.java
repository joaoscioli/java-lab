package daily_question.constructMinimumBitwiseArrayI;

import java.util.List;

/// ## minBitwiseArray
///
/// Computes the minimum possible bitwise array based on the given list of integers.
///
/// For each number `x` in the input list:
/// - If `x` is **even**, it is **impossible** to construct a valid value, so `-1` is returned.
/// - If `x` is **odd**, the algorithm finds the **minimum number** `y` such that:
///   ```
///   y | (y + 1) = x
///   ```
///
/// ### 💡 Core Idea
/// For odd numbers, the solution removes the **highest power of two**
/// from the trailing sequence of `1`s in the binary representation of `x`.
///
/// This ensures:
/// - The result is the **smallest possible valid value**
/// - The bitwise OR condition still holds
///
/// ---
///
/// ### 🧠 Bitwise Logic
/// - Count how many consecutive `1`s appear starting from the least significant bit.
/// - Subtract `2^(count - 1)` from `x` to obtain the minimal valid value.
///
/// ---
///
/// ### ⏱️ Time & Space Complexity
/// - **Time Complexity:** `O(n * k)`
///   - `n` = number of elements
///   - `k` = number of trailing `1`s (at most 32 for integers)
/// - **Space Complexity:** `O(n)` for the result array
///
/// ---
///
/// ### 📌 Example
/// ```text
/// Input:  [3, 5, 7]
/// Binary: [11, 101, 111]
///
/// Output: [1, 4, 3]
/// ```
///
/// ---
///
/// @param **nums** A list of integers representing the target bitwise OR values.
/// @return An array where each element is the minimum valid value, or `-1` if impossible.

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int x = nums.get(i);

            // Even numbers cannot be represented using y | (y + 1)
            if ((x & 1) == 0) {
                ans[i] = -1;
                continue;
            }

            // Count trailing 1s in the binary representation
            int count = 0;
            int temp = x;
            while ((temp & 1) == 1) {
                count++;
                temp >>= 1;
            }

            // Remove the highest power of two from the trailing ones
            ans[i] = x - (1 << (count - 1));
        }

        return ans;
    }
}
