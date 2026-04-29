package daily_question.champagnerTower;

///
/// ## Overview
///
/// Simulates the flow of champagne poured into a pyramid of glasses
/// and determines how full a specific glass is after pouring.
///
/// Each glass can hold up to 1 unit of liquid. Any excess is split
/// evenly and passed to the two glasses directly below.
///
/// ## Approach
///
/// - Uses a 2D dynamic programming array (`dp`) to represent the amount
///   of champagne in each glass
/// - Initializes the top glass with the total poured amount
/// - Iteratively propagates excess liquid row by row
/// - For each glass:
///   - If it exceeds capacity ( > 1 ), the overflow is split equally
///     between the two glasses below
/// - Caps the result at `1.0`, since a glass cannot exceed full capacity
///
/// ## Time Complexity
///
/// - **O(n²)**, where `n` is the `query_row`
///
/// ## Space Complexity
///
/// - **O(1)** (bounded 100×100 array, effectively constant space)
///
class Solution {

    ///
    /// ### champagneTower
    ///
    /// Computes how full a specific glass is in the champagne tower
    /// after pouring a given amount.
    ///
    /// #### Parameters
    /// - `poured`: Total units of champagne poured into the top glass
    /// - `query_row`: Target row index (0-based)
    /// - `query_glass`: Target glass index within the row (0-based)
    ///
    /// #### Returns
    /// - A `double` representing how full the glass is:
    ///   - `0.0` → empty
    ///   - `1.0` → completely full
    ///   - Between `0.0` and `1.0` → partially filled
    ///
    /// #### Details
    /// - Uses a fixed-size DP table (100x100) as per problem constraints
    /// - Propagates overflow only when a glass exceeds capacity
    /// - Ensures the returned value does not exceed 1.0
    ///
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[100][100];
        dp[0][0] = poured;

        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] > 1) {
                    double excess = (dp[i][j] - 1) / 2.0;
                    dp[i + 1][j] += excess;
                    dp[i + 1][j + 1] += excess;
                }
            }
        }

        return Math.min(1.0, dp[query_row][query_glass]);
    }
}