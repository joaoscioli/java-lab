package daily_question.FindMinimumOperationsMakeElementsDivisibleThree;

/// # Solution
///
/// Provides a method to compute the minimum number of operations required
/// to make all elements of an integer array divisible by three.
///
/// Each operation consists of adding or subtracting **1** from any element.
/// For any number `n`, if `n % 3 != 0`, exactly **one operation** is enough
/// to adjust it to the nearest multiple of 3.
///
/// ## Example
/// ```java
/// int[] nums = {1, 2, 3, 4};
/// // Elements not divisible by 3 are: 1, 2, 4
/// // Minimum operations = 3
/// new Solution().minimumOperations(nums); // returns 3
/// ```
public class Solution {

    /// Computes the minimum number of `+1` or `-1` operations required
    /// to make every element in the input array divisible by **3**.
    ///
    /// Each element that is not divisible by 3 contributes **exactly 1 operation**,
    /// because adding or subtracting one will always reach the nearest multiple of 3.
    ///
    /// ## Parameters
    /// - `nums`: The array of integers to evaluate.
    ///
    /// ## Returns
    /// - The total number of operations needed so all elements become divisible by 3.
    ///
    /// ## Complexity
    /// - **Time:** O(n) — iterates once through the array.
    /// - **Space:** O(1) — constant extra memory.
    public int minimumOperations(int[] nums) {
        int ops = 0;
        for (int n : nums) {
            if (n % 3 != 0) ops++;
        }
        return ops;
    }
}
