package daily_question.findUniqueBinaryString;

/// # Find Unique Binary String
///
/// Returns a binary string of length **n** that does **not appear** in the input array.
///
/// The method uses the **diagonalization technique** inspired by **Cantor's Diagonal Argument**.
/// For each string `nums[i]`, the algorithm reads the bit at position `i` and flips it
/// (`0 → 1`, `1 → 0`).
/// By constructing the result this way, the generated string will differ from every
/// string in the input at least in one position.
///
/// ## Algorithm
///
/// 1. Let `n` be the number of binary strings.
/// 2. Iterate from `0` to `n - 1`.
/// 3. For each `i`:
///    - Read the `i`-th bit of `nums[i]`.
///    - Flip the bit (`0` becomes `1`, `1` becomes `0`).
///    - Append it to the result.
/// 4. Return the constructed string.
///
/// Because the resulting string differs from each `nums[i]` at index `i`,
/// it is guaranteed **not to exist in the input array**.
///
/// ## Complexity
///
/// - **Time Complexity:** `O(n)`
/// - **Space Complexity:** `O(n)` for the resulting string.
///
/// ## Example
///
/// ```text
/// Input:
/// nums = ["01", "10"]
///
/// Construction:
/// nums[0][0] = '0' → '1'
/// nums[1][1] = '0' → '1'
///
/// Output:
/// "11"
/// ```
///
/// ## Parameters
///
/// - `nums` — An array of **n unique binary strings**, each with length **n**.
///
/// ## Returns
///
/// A binary string of length **n** that does **not appear** in `nums`.
///
class Solution {

    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char bit = nums[i].charAt(i);
            result.append(bit == '0' ? '1' : '0');
        }

        return result.toString();
    }
}