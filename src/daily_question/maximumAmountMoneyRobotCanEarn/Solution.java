package daily_question.maximumAmountMoneyRobotCanEarn;

///
/// ## Maximum Amount of Money Robot Can Earn
///
/// This class provides a solution to compute the maximum amount of money
/// a robot can collect while traversing a 2D grid of coins.
///
/// ### Problem Overview
/// - The robot starts at the top-left corner `(0, 0)` of a grid.
/// - It can only move **right** or **down**.
/// - Each cell contains a value (positive or negative).
/// - The robot is allowed to **ignore up to 2 negative cells**, meaning:
///   - If it steps on a negative cell, it may choose not to subtract its value.
///   - This can be done at most **2 times**.
///
/// ### Approach
/// This solution uses **Dynamic Programming (3D DP)**:
///
/// - `dp[i][j][k]` represents the **maximum money** collected
///   at position `(i, j)` having skipped `k` negative cells.
///
/// - Dimensions:
///   - `i`: row index
///   - `j`: column index
///   - `k`: number of skipped negative values (0 to 2)
///
/// ### State Transitions
/// From each cell `(i, j)`:
///
/// - Move **right** → `(i, j+1)`
/// - Move **down** → `(i+1, j)`
///
/// For each move:
/// - Add the cell value normally.
/// - If the value is negative and skips are available (`k < 2`),
///   optionally skip it (do not add the negative value).
///
/// ### Initialization
/// - All DP values are initialized to `Integer.MIN_VALUE`.
/// - Starting point:
///   - `dp[0][0][0] = coins[0][0]`
///   - If starting cell is negative, it can be skipped:
///     `dp[0][0][1] = 0`
///
/// ### Result
/// The result is the maximum value among:
/// - `dp[m-1][n-1][0]`
/// - `dp[m-1][n-1][1]`
/// - `dp[m-1][n-1][2]`
///
/// ### Time Complexity
/// - `O(m * n * 3)`
///
/// ### Space Complexity
/// - `O(m * n * 3)`
///
/// @author
///   Generated documentation
///
class Solution {

    ///
    /// ### Computes the Maximum Amount
    ///
    /// Calculates the maximum money the robot can collect while moving
    /// from the top-left to the bottom-right of the grid.
    ///
    /// @param coins a 2D array where each cell contains a positive or negative integer
    /// @return the maximum amount of money the robot can collect
    ///
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;

        int[][][] dp = new int[m][n][3];

        // Initialize DP array with minimum values
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }

        // Starting position
        dp[0][0][0] = coins[0][0];
        if (coins[0][0] < 0) {
            dp[0][0][1] = 0; // Skip the negative value
        }

        // Fill DP table
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                for (int k = 0; k < 3; k++) {
                    if (dp[i][j][k] == Integer.MIN_VALUE) continue;

                    // Move right
                    if (j + 1 < n) {
                        int val = coins[i][j + 1];

                        dp[i][j + 1][k] = Math.max(
                                dp[i][j + 1][k],
                                dp[i][j][k] + val
                        );

                        // Skip negative value if possible
                        if (val < 0 && k < 2) {
                            dp[i][j + 1][k + 1] = Math.max(
                                    dp[i][j + 1][k + 1],
                                    dp[i][j][k]
                            );
                        }
                    }

                    // Move down
                    if (i + 1 < m) {
                        int val = coins[i + 1][j];

                        dp[i + 1][j][k] = Math.max(
                                dp[i + 1][j][k],
                                dp[i][j][k] + val
                        );

                        // Skip negative value if possible
                        if (val < 0 && k < 2) {
                            dp[i + 1][j][k + 1] = Math.max(
                                    dp[i + 1][j][k + 1],
                                    dp[i][j][k]
                            );
                        }
                    }
                }
            }
        }

        // Return the best result at the destination
        return Math.max(
                dp[m - 1][n - 1][0],
                Math.max(dp[m - 1][n - 1][1], dp[m - 1][n - 1][2])
        );
    }
}