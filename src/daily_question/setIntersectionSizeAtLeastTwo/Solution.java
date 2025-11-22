package daily_question.setIntersectionSizeAtLeastTwo;

import java.util.*;

public class Solution {

    /// ## intersectionSizeTwo
    ///
    /// Computes the minimum size of a set **S** such that every interval in the input
    /// contains **at least two** elements from **S**.
    ///
    /// This is the official LeetCode problem
    /// **"Set Intersection Size At Least Two" (Hard)**.
    ///
    /// ### Approach Overview
    /// The algorithm uses a greedy strategy:
    ///
    /// 1. **Sort intervals** by:
    ///    - `end` ascending
    ///    - if tied, `start` descending
    ///    This ensures that we consider tighter intervals first.
    ///
    /// 2. Maintain two integers:
    ///    - `p1` → last added point
    ///    - `p2` → second-to-last added point
    ///
    /// 3. For each interval:
    ///    - If both `p1` and `p2` lie inside the interval, do nothing.
    ///    - If only `p1` lies inside the interval, add one more point (`end`).
    ///    - If none lie inside, add the two largest possible points:
    ///      `end - 1` and `end`.
    ///
    /// This greedy method guarantees the minimal size of the resulting set.
    ///
    /// ### Parameters
    /// - `intervals` — A list of integer intervals `[start, end]`.
    ///
    /// ### Returns
    /// - The minimal size of a set that intersects every interval in at least two points.
    ///
    /// ### Time Complexity
    /// - **O(n log n)** due to sorting.
    ///
    /// ### Space Complexity
    /// - **O(1)** extra space (sorting is in-place).
    ///
    /// ### Example
    /// ```java
    /// int[][] intervals = {
    ///     {1, 3},
    ///     {1, 4},
    ///     {2, 5},
    ///     {3, 5}
    /// };
    ///
    /// Solution s = new Solution();
    /// int result = s.intersectionSizeTwo(intervals);
    /// // result = 3
    /// ```
    public int intersectionSizeTwo(int[][] intervals) {

        // 1. Ordenar por end crescente e start decrescente quando empatar
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) {
                return b[0] - a[0]; // start desc
            }
            return a[1] - b[1];     // end asc
        });

        // Dois últimos números adicionados ao set final
        int p1 = -1_000_000_000; // último ponto
        int p2 = -1_000_000_000; // penúltimo ponto

        int count = 0; // tamanho do conjunto final

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            boolean containsP1 = (p1 >= start && p1 <= end);
            boolean containsP2 = (p2 >= start && p2 <= end);

            if (containsP1 && containsP2) {
                continue;
            }

            if (containsP1) {
                count += 1;

                p2 = p1;
                p1 = end;
            } else {
                count += 2;

                p2 = end - 1;
                p1 = end;
            }
        }

        return count;
    }
}
