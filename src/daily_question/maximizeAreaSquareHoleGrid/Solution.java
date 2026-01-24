package daily_question.maximizeAreaSquareHoleGrid;

import java.util.Arrays;

class Solution {

    /// ## Maximize Area of Square Hole in a Grid
    ///
    /// A grid of size `n × m` contains horizontal and vertical bars.
    /// Some of these bars are removed, creating holes in the grid.
    ///
    /// This method computes the **maximum possible area of a square hole**
    /// that can be formed by removing **consecutive horizontal and vertical bars**.
    ///
    /// ### Key Insight
    /// - Removing `k` **consecutive bars** creates an opening of size `k + 1`.
    /// - The largest square that can fit inside the grid hole has a side length:
    ///   ```
    ///   min(maxHorizontalGap, maxVerticalGap)
    ///   ```
    ///
    /// ### Approach
    /// 1. Find the maximum number of **consecutive removed horizontal bars**.
    /// 2. Find the maximum number of **consecutive removed vertical bars**.
    /// 3. Convert these streaks into gap sizes (`streak + 1`).
    /// 4. The square side is the minimum of the two gaps.
    ///
    /// ### Example
    /// ```
    /// n = 2, m = 1
    /// hBars = [2, 3]
    /// vBars = [2]
    ///
    /// Horizontal gap = 3
    /// Vertical gap   = 2
    /// Square area    = 4
    /// ```
    ///
    /// ### Time Complexity
    /// - **O(h log h + v log v)** — sorting the removed bars.
    ///
    /// ### Space Complexity
    /// - **O(1)** — aside from sorting overhead.
    ///
    /// @param n     number of horizontal segments in the grid
    /// @param m     number of vertical segments in the grid
    /// @param hBars indices of removed horizontal bars
    /// @param vBars indices of removed vertical bars
    /// @return the maximum possible square hole area
    public static int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxH = maxConsecutive(hBars);
        int maxV = maxConsecutive(vBars);

        /// The largest square side is limited by the smaller gap
        int side = Math.min(maxH, maxV);
        return side * side;
    }

    /// ### Maximum Consecutive Bars Helper
    ///
    /// Determines the maximum number of **consecutive removed bars**
    /// in a sorted array.
    ///
    /// ### Logic
    /// - Sort the array.
    /// - Track the longest streak where `bars[i] = bars[i - 1] + 1`.
    /// - Convert the streak length into a gap size by returning `streak + 1`.
    ///
    /// @param bars array of removed bar indices
    /// @return the size of the largest continuous gap
    private static int maxConsecutive(int[] bars) {
        Arrays.sort(bars);

        int maxStreak = 1;
        int currentStreak = 1;

        for (int i = 1; i < bars.length; i++) {
            if (bars[i] == bars[i - 1] + 1) {
                currentStreak++;
            } else {
                currentStreak = 1;
            }
            maxStreak = Math.max(maxStreak, currentStreak);
        }

        /// Gap size = number of consecutive removed bars + 1
        return maxStreak + 1;
    }

    /// ### Example Execution
    ///
    /// Demonstrates how the method works with a sample input.
    public static void main(String[] args) {
        System.out.println(maximizeSquareHoleArea(
                2, 1,
                new int[]{2, 3},
                new int[]{2}
        )); // Output: 4
    }
}
