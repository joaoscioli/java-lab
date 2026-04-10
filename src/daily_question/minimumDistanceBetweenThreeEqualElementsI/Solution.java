package daily_question.minimumDistanceBetweenThreeEqualElementsI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/// ## Solution
///
/// Computes the **minimum distance** of a "good tuple" `(i, j, k)`
/// such that:
/// - `i`, `j`, and `k` are distinct indices
/// - `nums[i] == nums[j] == nums[k]`
///
/// ### Distance Definition
/// The distance of a tuple is defined as:
/// ```
/// |i - j| + |j - k| + |k - i|
/// ```
///
/// For ordered indices `i < j < k`, this simplifies to:
/// ```
/// 2 * (k - i)
/// ```
///
/// ### Approach
/// 1. Group all indices by their values using a `HashMap`.
/// 2. For each group of indices:
///    - If it contains fewer than 3 elements, skip it.
///    - Otherwise, iterate over consecutive triples.
/// 3. For each triple, compute the distance using:
///    ```
///    2 * (third - first)
///    ```
/// 4. Track and return the minimum distance found.
///
/// ### Complexity
/// - **Time Complexity:** `O(n²)` in the worst case (small constraints make this acceptable)
/// - **Space Complexity:** `O(n)`
///
/// ### Parameters
/// - `nums`: An integer array where `1 <= nums[i] <= n`
///
/// ### Returns
/// - The minimum distance of a valid tuple, or `-1` if no such tuple exists.
public class Solution {

    /// ### minimumDistance
    ///
    /// Finds the minimum possible distance among all valid "good tuples".
    ///
    /// @param nums the input integer array
    /// @return the minimum distance, or `-1` if no valid tuple exists
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        /// Group indices by their corresponding values
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int minDistance = Integer.MAX_VALUE;

        /// Evaluate each group of indices
        for (List<Integer> indices : map.values()) {
            if (indices.size() < 3) continue;

            /// Check consecutive triples to minimize distance
            for (int i = 0; i <= indices.size() - 3; i++) {
                int first = indices.get(i);
                int third = indices.get(i + 2);

                int distance = 2 * (third - first);
                minDistance = Math.min(minDistance, distance);
            }
        }

        /// Return result or -1 if no valid tuple was found
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}