package daily_question.FourDivisors;

public class Solution {

    /// ## sumFourDivisors
    ///
    /// Calculates the total sum of divisors for all integers in the array `nums`
    /// that have **exactly four divisors**.
    ///
    /// For each element, the algorithm invokes `getFourDivisorsSum(n)`, which
    /// determines if the number has exactly four divisors and returns their sum.
    ///
    /// ### Parameters
    /// - `nums`: An array of integers to be evaluated.
    ///
    /// ### Returns
    /// - The total sum of divisors of all values in `nums` that have exactly four divisors.
    ///
    /// ### Example
    /// ```java
    /// int[] nums = {21, 4, 7};
    /// Solution sol = new Solution();
    /// int result = sol.sumFourDivisors(nums); // result = 32
    /// ```
    ///
    /// ### Complexity
    /// - **Time Complexity:** O(N * √M),
    ///   where `N` is the array length and `M` is the maximum number in `nums`.
    /// - **Space Complexity:** O(1).
    public int sumFourDivisors(int[] nums) {
        int total = 0;

        for (int n : nums) {
            total += getFourDivisorsSum(n);
        }

        return total;
    }

    /// ## getFourDivisorsSum
    ///
    /// Helper method that determines whether the integer `n` has **exactly four divisors**.
    /// If so, returns the sum of these divisors; otherwise, returns `0`.
    ///
    /// The method iterates up to `sqrt(n)`, identifying divisor pairs `(i, n / i)`,
    /// counting and summing them. If at any point the count exceeds four,
    /// the method stops early and returns zero.
    ///
    /// ### Parameters
    /// - `n`: The integer to evaluate.
    ///
    /// ### Returns
    /// - The sum of the four divisors of `n`, if `n` has exactly four divisors.
    /// - `0` otherwise.
    ///
    /// ### Notes
    /// - Perfect squares contribute only one divisor when `i == n/i`.
    /// - Early termination is used for efficiency when divisor count exceeds four.
    private int getFourDivisorsSum(int n) {
        int sum = 0;
        int count = 0;

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                int j = n / i;

                if (i == j) {
                    count++;
                    sum += i;
                } else {
                    count += 2;
                    sum += i + j;
                }
                if (count > 4) return 0;
            }
        }
        return count == 4 ? sum : 0;
    }
}
