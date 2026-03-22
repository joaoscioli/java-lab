package leetcode_challenges.challengerSeventy;
/// # Climbing Stairs
///
/// Computes the number of distinct ways to climb to the top of a staircase
/// with `n` steps, where each move can be either **1 step** or **2 steps**.
///
/// ## Approach
///
/// This problem follows a **dynamic programming** pattern and is equivalent
/// to the Fibonacci sequence:
///
/// - To reach step `n`, you can come from:
///   - Step `n - 1` (taking 1 step)
///   - Step `n - 2` (taking 2 steps)
///
/// Therefore:
///
/// ```text
/// f(n) = f(n - 1) + f(n - 2)
/// ```
///
/// Instead of using recursion, this implementation uses an **iterative approach**
/// with constant space by keeping track of only the last two computed values.
///
/// ## Algorithm
///
/// 1. Handle base cases where `n <= 2`
/// 2. Initialize:
///    - `prev2 = 1` (ways to reach step 1)
///    - `prev1 = 2` (ways to reach step 2)
/// 3. Iterate from `3` to `n`, updating the current number of ways
/// 4. Return the final computed value
///
/// ## Complexity
///
/// - **Time Complexity:** O(n)
/// - **Space Complexity:** O(1)
///
/// ## Constraints
///
/// - `1 <= n <= 45`
///
/// ## Example
///
/// ```text
/// Input: n = 3
/// Output: 3
///
/// Explanation:
/// 1. 1 + 1 + 1
/// 2. 1 + 2
/// 3. 2 + 1
/// ```
///
/// ## Notes
///
/// - This is a classic interview problem that demonstrates understanding
///   of dynamic programming and state transitions.
/// - It can also be solved using recursion with memoization or matrix exponentiation.
///
/// @param n the total number of steps in the staircase
/// @return the number of distinct ways to reach the top
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int prev2 = 1;
        int prev1 = 2;

        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}