package daily_question.transformedArray;

class Solution {

    /// ## Construct Transformed Array
    ///
    /// Transforms a circular integer array based on the value of each element.
    ///
    /// For each index `i` in the input array:
    ///
    /// - If `nums[i] == 0`, the resulting value at index `i` is `0`.
    /// - If `nums[i] > 0`, move `nums[i]` steps to the **right** (clockwise)
    ///   in the circular array and take the value at the landing index.
    /// - If `nums[i] < 0`, move `|nums[i]|` steps to the **left**
    ///   (counterclockwise) in the circular array and take the value at the landing index.
    ///
    /// Circular behavior is handled using modulo arithmetic to ensure
    /// indices always remain within bounds.
    ///
    /// ### Example
    ///
    /// ```text
    /// Input:  nums = [1, -1, 0, 2]
    /// Output: result = [-1, 1, 0, -1]
    /// ```
    ///
    /// ### Algorithm
    ///
    /// 1. Iterate through each index `i` of the array.
    /// 2. If the current value is zero, assign `0` to the result.
    /// 3. Otherwise, compute the destination index using safe modulo normalization.
    /// 4. Assign the value from the computed index to the result array.
    ///
    /// ### Time Complexity
    ///
    /// - **O(n)** — each element is processed exactly once.
    ///
    /// ### Space Complexity
    ///
    /// - **O(n)** — a new array of the same size is created for the result.
    ///
    /// @param nums the input integer array treated as circular
    /// @return a new array containing the transformed values
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                result[i] = 0;
            } else {
                int nextIndex = ((i + nums[i]) % n + n) % n;
                result[i] = nums[nextIndex];
            }
        }

        return result;
    }
}
