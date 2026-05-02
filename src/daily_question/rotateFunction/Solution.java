package daily_question.rotateFunction;

public class Solution {

    /// # maxRotateFunction
    ///
    /// Computes the maximum value of the rotation function **F(k)** for a given integer array.
    ///
    /// The rotation function is defined as:
    ///
    /// ```
    /// F(k) = 0 * arr_k[0] + 1 * arr_k[1] + ... + (n - 1) * arr_k[n - 1]
    /// ```
    ///
    /// Where `arr_k` is the array `nums` rotated `k` positions clockwise.
    ///
    /// ## Approach
    ///
    /// Instead of recomputing the rotation function from scratch for each rotation,
    /// this implementation uses a recurrence relation:
    ///
    /// ```
    /// F(k) = F(k-1) + sum(nums) - n * nums[n - k]
    /// ```
    ///
    /// Steps:
    /// - Compute the total sum of the array.
    /// - Compute the initial value `F(0)`.
    /// - Iteratively compute `F(k)` using the recurrence relation.
    /// - Track and return the maximum value.
    ///
    /// ## Time Complexity
    /// - **O(n)** — Single pass to compute sum and F(0), and another pass for all rotations.
    ///
    /// ## Space Complexity
    /// - **O(1)** — Uses constant extra space.
    ///
    /// ## Parameters
    /// - `nums`: An array of integers.
    ///
    /// ## Returns
    /// - The maximum value of the rotation function across all possible rotations.
    ///
    /// ## Example
    /// ```
    /// Input: nums = [4, 3, 2, 6]
    /// Output: 26
    ///
    /// Explanation:
    /// F(0) = 0*4 + 1*3 + 2*2 + 3*6 = 25
    /// F(1) = 0*6 + 1*4 + 2*3 + 3*2 = 16
    /// F(2) = 0*2 + 1*6 + 2*4 + 3*3 = 23
    /// F(3) = 0*3 + 1*2 + 2*6 + 3*4 = 26
    /// Max = 26
    /// ```
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;

        int sum = 0;
        int f0 = 0;

        // Compute sum and F(0)
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f0 += i * nums[i];
        }

        int max = f0;
        int current = f0;

        // Compute F(k) using recurrence
        for (int k = 1; k < n; k++) {
            current = current + sum - n * nums[n - k];
            max = Math.max(max, current);
        }

        return max;
    }
}