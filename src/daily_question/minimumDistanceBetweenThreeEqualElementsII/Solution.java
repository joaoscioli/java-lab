package daily_question.minimumDistanceBetweenThreeEqualElementsII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    /// ### Minimum Distance Between Three Equal Elements II
    ///
    /// Computes the minimum possible distance of a **good tuple** `(i, j, k)`
    /// such that:
    /// - `i`, `j`, and `k` are distinct indices
    /// - `nums[i] == nums[j] == nums[k]`
    ///
    /// ---
    ///
    /// ### 🧠 Key Insight
    ///
    /// For any sorted indices `i < j < k`, the distance:
    ///
    /// ```text
    /// |i - j| + |j - k| + |k - i|
    /// ```
    ///
    /// simplifies to:
    ///
    /// ```text
    /// 2 * (k - i)
    /// ```
    ///
    /// Therefore, minimizing the distance is equivalent to minimizing
    /// the gap between the first and third indices of equal elements.
    ///
    /// ---
    ///
    /// ### ⚙️ Approach
    ///
    /// 1. Group all indices by their corresponding values using a map.
    /// 2. For each value:
    ///    - If it appears fewer than 3 times, skip it.
    ///    - Otherwise, iterate through the indices using a sliding window of size 3.
    /// 3. For each window `(i, j, k)`:
    ///    - Compute `2 * (k - i)`
    ///    - Track the minimum value.
    ///
    /// ---
    ///
    /// ### ⏱ Complexity
    ///
    /// - **Time Complexity:** `O(n)`
    /// - **Space Complexity:** `O(n)`
    ///
    /// ---
    ///
    /// ### 📌 Parameters
    ///
    /// - `nums`: An integer array where `1 <= nums[i] <= n`
    ///
    /// ---
    ///
    /// ### 📌 Returns
    ///
    /// - The minimum distance of a valid good tuple
    /// - `-1` if no such tuple exists
    ///
    /// ---
    ///
    /// ### ✅ Example
    ///
    /// ```java
    /// Input: nums = [1,2,1,1,3]
    /// Output: 6
    /// ```
    ///
    /// Explanation:
    /// The tuple `(0, 2, 3)` produces the minimum distance:
    /// `2 * (3 - 0) = 6`
    ///
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        /// Group indices by value
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int minDistance = Integer.MAX_VALUE;

        /// Process each group of indices
        for (List<Integer> indices : map.values()) {
            /// Skip if fewer than 3 occurrences
            if (indices.size() < 3) continue;

            /// Sliding window of size 3
            for (int i = 0; i <= indices.size() - 3; i++) {
                int left = indices.get(i);
                int right = indices.get(i + 2);

                int distance = 2 * (right - left);
                minDistance = Math.min(minDistance, distance);
            }
        }

        /// Return result or -1 if no valid tuple found
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}