package daily_question.maximumWallsDestroyedRobots;

import java.util.Arrays;

/// # Maximum Walls Destroyed by Robots
///
/// This solution computes the **maximum number of unique walls** that can be destroyed
/// by a set of robots positioned on a 1D line.
///
/// Each robot:
/// - Has a fixed position
/// - Can shoot **once**, either **left** or **right**
/// - The bullet travels up to a given distance
/// - The bullet **stops if it hits another robot**
///
/// ## Key Idea
///
/// The problem is solved using **Dynamic Programming (DP)** combined with:
/// - Sorting
/// - Binary Search
/// - Careful handling of overlapping intervals
///
/// Each robot creates **two possible intervals**:
/// - Shooting **left**
/// - Shooting **right**
///
/// The goal is to **choose one direction per robot** such that the total number
/// of **unique walls destroyed** is maximized.
///
/// ---
///
/// ## Approach Overview
///
/// 1. **Sort robots by position**
/// 2. **Sort walls**
/// 3. Use **binary search** to efficiently count walls in any interval
/// 4. Define DP states:
///
/// ```
/// dp[i][0] → maximum walls destroyed considering robots [0..i], with robot i shooting LEFT
/// dp[i][1] → same, but robot i shoots RIGHT
/// ```
///
/// 5. Carefully handle **overlapping intervals** when switching directions
///
/// ---
///
/// ## Binary Search Helpers
///
/// - `lowerBound`: first index where value >= target
/// - `upperBound`: first index where value > target
///
/// Used to count how many walls lie inside a given range `[l, r]` in **O(log n)**.
///
/// ---
///
/// ## DP Transitions
///
/// For each robot `i`:
///
/// ### Shooting RIGHT
/// ```
/// dp[i][1] = max(dp[i-1][0], dp[i-1][1]) + walls in right interval
/// ```
///
/// ### Shooting LEFT (no overlap)
/// ```
/// dp[i][0] = dp[i-1][0] + walls in left interval excluding previous robot
/// ```
///
/// ### Shooting LEFT (handling overlap with previous RIGHT)
/// If the previous robot shot RIGHT, intervals may overlap.
/// We subtract the overlapping walls to avoid double counting.
///
/// ```
/// dp[i][0] = max(
///     dp[i][0],
///     dp[i-1][1] + currentLeftWalls - overlappingWalls
/// )
/// ```
/// ---
///
/// ## Time Complexity
///
/// - Sorting: `O(n log n + m log m)`
/// - DP transitions: `O(n log m)`
///
/// Overall:
/// ```
/// O((n + m) log m)
/// ```
/// ---
///
/// ## Space Complexity
/// ```
/// O(n)
/// ```
/// ---
///
/// ## Notes
/// - A **dummy robot** is added to simplify boundary conditions
/// - Walls and robots may share the same position
/// - Overlap handling is critical to avoid **double counting**
///
class Solution {
    /// Computes the maximum number of unique walls destroyed.
    ///
    /// @param robots   positions of the robots
    /// @param distance maximum shooting distance for each robot
    /// @param walls    positions of the walls
    /// @return maximum number of unique walls destroyed
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;

        // Store robots as {position, distance}
        int[][] x = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            x[i][0] = robots[i];
            x[i][1] = distance[i];
        }

        // Sort robots by position
        Arrays.sort(x, 0, n, (a, b) -> a[0] - b[0]);

        // Sort walls
        Arrays.sort(walls);

        // Dummy robot (sentinel to avoid bounds checking)
        x[n][0] = (int)1e9;
        x[n][1] = 0;

        /// Binary search: lower bound (first index >= target)
        java.util.function.BiFunction<int[], Integer, Integer> lowerBound = (arr, target) -> {
            int l = 0, r = arr.length;
            while (l < r) {
                int mid = (l + r) / 2;
                if (arr[mid] < target) l = mid + 1;
                else r = mid;
            }
            return l;
        };

        /// Binary search: upper bound (first index > target)
        java.util.function.BiFunction<int[], Integer, Integer> upperBound = (arr, target) -> {
            int l = 0, r = arr.length;
            while (l < r) {
                int mid = (l + r) / 2;
                if (arr[mid] <= target) l = mid + 1;
                else r = mid;
            }
            return l;
        };

        /// Counts how many walls lie in the inclusive range [l, r]
        java.util.function.BiFunction<Integer, Integer, Integer> query = (l, r) -> {
            if (l > r) return 0;
            int it1 = upperBound.apply(walls, r);
            int it2 = lowerBound.apply(walls, l);
            return it1 - it2;
        };

        // dp[i][0] = robot i shoots LEFT
        // dp[i][1] = robot i shoots RIGHT
        int[][] dp = new int[n][2];

        // Base case: first robot
        dp[0][0] = query.apply(x[0][0] - x[0][1], x[0][0]);

        if (n > 1) {
            dp[0][1] = query.apply(
                    x[0][0],
                    Math.min(x[1][0] - 1, x[0][0] + x[0][1])
            );
        } else {
            dp[0][1] = query.apply(x[0][0], x[0][0] + x[0][1]);
        }

        // DP transitions
        for (int i = 1; i < n; i++) {

            // Case 1: shoot RIGHT
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]) +
                    query.apply(
                            x[i][0],
                            Math.min(x[i + 1][0] - 1, x[i][0] + x[i][1])
                    );

            // Case 2: shoot LEFT (no overlap with previous LEFT)
            dp[i][0] = dp[i - 1][0] +
                    query.apply(
                            Math.max(x[i][0] - x[i][1], x[i - 1][0] + 1),
                            x[i][0]
                    );

            // Case 3: shoot LEFT with overlap correction
            int leftStart = Math.max(x[i][0] - x[i][1], x[i - 1][0] + 1);
            int leftEnd = x[i][0];

            int overlapStart = leftStart;
            int overlapEnd = Math.min(x[i - 1][0] + x[i - 1][1], x[i][0] - 1);

            int res = dp[i - 1][1]
                    + query.apply(leftStart, leftEnd)
                    - query.apply(overlapStart, overlapEnd);

            dp[i][0] = Math.max(dp[i][0], res);
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}