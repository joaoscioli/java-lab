package daily_question.countNumberTrapezoidsI;

import java.util.*;

public class Solution {
    static final long MOD = 1_000_000_007;

    /// # Count Number of Horizontal Trapezoids I
    ///
    /// Computes the number of **distinct horizontal trapezoids** that can be
    /// formed from a set of 2D points.
    ///
    /// A *horizontal trapezoid* is a convex quadrilateral that contains
    /// **at least one pair of horizontal parallel sides**, i.e., two sides
    /// with identical `y`-coordinates.
    ///
    /// ---
    ///
    /// ## 🧠 Approach
    ///
    /// The algorithm relies on the following geometric observation:
    ///
    /// > A horizontal trapezoid is formed whenever we choose
    /// > **two horizontal segments** lying on **two different y-levels**.
    ///
    /// Steps:
    ///
    /// 1. **Group points by y-coordinate**.
    ///    Points sharing the same y form possible horizontal segments.
    ///
    /// 2. For each y-level with `cnt ≥ 2`, compute:
    ///    \[
    ///    \text{pairs}(y) = \binom{cnt}{2}
    ///    \]
    ///    representing how many horizontal line segments can be formed.
    ///
    /// 3. Let these segment counts be \(v_1, v_2, \dots, v_k\).
    ///    Every pair of *distinct* y-levels forms trapezoids:
    ///
    ///    \[
    ///    \sum_{i<j} v_i \cdot v_j
    ///    \]
    ///
    /// 4. This is efficiently computed using:
    ///
    ///    \[
    ///    \frac{(\sum v)^2 - \sum v^2}{2}
    ///    \]
    ///
    /// 5. Since the result may be very large, all operations are done modulo
    ///    **1,000,000,007**, using the multiplicative inverse of 2 (`500000004`).
    ///
    /// ---
    ///
    /// ## ✔️ Example
    ///
    /// Given:
    /// ```text
    /// points = [[1,0],[2,0],[3,0],[2,2],[3,2]]
    /// ```
    ///
    /// - y=0 has 3 points → 3 horizontal segments
    /// - y=2 has 2 points → 1 horizontal segment
    /// - Total trapezoids = 3 × 1 = 3
    ///
    /// ---
    ///
    /// ## ⏱ Complexity
    ///
    /// - **Time:** O(n)
    /// - **Space:** O(n)
    ///
    /// Where `n` = number of points.
    ///
    /// ---
    ///
    /// @param points a 2D array where each entry is `[x, y]`
    /// @return number of unique horizontal trapezoids (mod 1e9+7)
    ///
    public int countTrapezoids(int[][] points) {
        // Group by y-coordinate
        Map<Integer, Integer> countByY = new HashMap<>();
        for (int[] p : points) {
            countByY.merge(p[1], 1, Integer::sum);
        }

        List<Long> pairs = new ArrayList<>();

        for (int cnt : countByY.values()) {
            if (cnt >= 2) {
                long c = (long) cnt * (cnt - 1) / 2; // C(cnt, 2)
                pairs.add(c % MOD);
            }
        }
        if (pairs.size() < 2) return 0;

        long sum = 0, sumSq = 0;

        for (long v : pairs) {
            sum = (sum + v) % MOD;
            sumSq = (sumSq + (v * v) % MOD) % MOD;
        }

        // Formula: (sum^2 - sumSq) / 2
        long result = (sum * sum % MOD - sumSq + MOD) % MOD;

        // divide by 2 using modular inverse of 2 (500000004)
        result = result * 500000004 % MOD;

        return (int) result;
    }
}
