package daily_question.twoFurthestHousesWithDifferentColors;

class Solution {

    /// ### Two Furthest Houses With Different Colors
    ///
    /// Given an array `colors`, where each element represents the color of a house,
    /// this method returns the **maximum distance** between two houses that have **different colors**.
    ///
    /// The distance between two houses at indices `i` and `j` is defined as:
    /// ```
    /// |i - j|
    /// ```
    ///
    /// ---
    ///
    /// ### Approach
    /// - The maximum distance will always involve either:
    ///   - the first house (`index 0`) and the farthest house from the end with a different color
    ///   - or the last house (`index n - 1`) and the farthest house from the beginning with a different color
    ///
    /// - Iterate from both ends to find:
    ///   - the farthest index from the left with a different color than `colors[0]`
    ///   - the farthest index from the right with a different color than `colors[n - 1]`
    ///
    /// - Return the maximum of these two distances.
    ///
    /// ---
    ///
    /// ### Example 1
    /// ```java
    /// Input: colors = [1,1,1,6,1,1,1]
    /// Output: 3
    /// Explanation:
    /// Houses at index 0 and 3 have different colors.
    /// Distance = |0 - 3| = 3
    /// ```
    ///
    /// ### Example 2
    /// ```java
    /// Input: colors = [1,8,3,8,3]
    /// Output: 4
    /// Explanation:
    /// Houses at index 0 and 4 have different colors.
    /// Distance = |0 - 4| = 4
    /// ```
    ///
    /// ### Example 3
    /// ```java
    /// Input: colors = [0,1]
    /// Output: 1
    /// ```
    ///
    /// ---
    ///
    /// ### Parameters
    /// - `colors` : an integer array where `colors[i]` is the color of the i-th house
    ///
    /// ### Returns
    /// - the maximum distance between two houses with different colors
    ///
    /// ---
    ///
    /// ### Constraints
    /// - `2 <= colors.length <= 100`
    /// - `0 <= colors[i] <= 100`
    /// - At least two houses have different colors
    ///
    /// ---
    ///
    /// ### Complexity
    /// - Time: `O(n)`
    /// - Space: `O(1)`
    ///
    public int maxDistance(int[] colors) {
        int n = colors.length;

        int max = 0;

        // Compare with first house
        for (int i = n - 1; i >= 0; i--) {
            if (colors[i] != colors[0]) {
                max = Math.max(max, i);
                break;
            }
        }

        // Compare with last house
        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[n - 1]) {
                max = Math.max(max, n - 1 - i);
                break;
            }
        }

        return max;
    }
}