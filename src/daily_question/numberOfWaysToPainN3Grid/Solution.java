package daily_question.numberOfWaysToPainN3Grid;

/**
 * /// # Solution
 * ///
 * /// This class provides a dynamic programming solution to the problem
 * /// **"Number of Ways to Paint an n × 3 Grid"**.
 * ///
 * /// The task is to count how many valid ways exist to paint the grid
 * /// using three colors, such that no two adjacent cells
 * /// (horizontally or vertically) share the same color.
 */
public class Solution {

    /**
     * /// ## numOfWays
     * ///
     * /// Computes the number of valid ways to paint an `n × 3` grid.
     * ///
     * /// ### Key Insight
     * /// Each row can be classified into two patterns:
     * /// - **Same-color pattern (`same`)**: the first and third cells
     * ///   have the same color, and the middle cell has a different color.
     * /// - **All-different pattern (`diff`)**: all three cells
     * ///   have different colors.
     * ///
     * /// Tracking these two states is sufficient to compute the solution.
     * ///
     * /// ### State Transition
     * /// ```text
     * /// newSame = 3 × same + 2 × diff
     * /// newDiff = 2 × same + 2 × diff
     * /// ```
     * ///
     * /// The result is taken modulo **1,000,000,007** to prevent overflow.
     * ///
     * /// ### Algorithm
     * /// 1. Initialize the base case for one row
     * /// 2. Iterate from row 2 to `n`
     * /// 3. Update `same` and `diff` using the transition rules
     * /// 4. Return the total number of valid configurations
     * ///
     * /// ### Time Complexity
     * /// - **O(n)**
     * ///
     * /// ### Space Complexity
     * /// - **O(1)** (constant extra space)
     * ///
     * /// ### Example
     * /// ```text
     * /// Input:  n = 1
     * /// Output: 12
     * /// ```
     *
     * /// @param n the number of rows in the grid
     * /// @return the number of valid ways to paint the grid modulo 1,000,000,007
     */
    public int numOfWays(int n) {
        long MOD = 1_000_000_007;

        // Base cases for the first row
        long same = 6;
        long diff = 6;

        for (int i = 2; i <= n; i++) {
            long newSame = (3 * same + 2 * diff) % MOD;
            long newDiff = (2 * same + 2 * diff) % MOD;

            same = newSame;
            diff = newDiff;
        }

        return (int) ((same + diff) % MOD);
    }
}
