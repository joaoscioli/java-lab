package daily_question.sumOfDistances;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    /// ## Sum of Distances
    ///
    /// Computes an array where each element represents the sum of absolute
    /// distances between the current index and all other indices with the same value.
    ///
    /// For each index `i`, the result is:
    ///
    /// ```
    /// result[i] = Σ |i - j|  for all j where nums[j] == nums[i] and j != i
    /// ```
    ///
    /// ### Strategy
    ///
    /// 1. **Group Indices by Value**
    ///    - Use a `HashMap<Integer, List<Integer>>` to store all indices
    ///      where each value appears.
    ///
    /// 2. **Prefix Sum Optimization**
    ///    - For each group of indices, compute a prefix sum array.
    ///    - This allows efficient calculation of distances in `O(1)` per index.
    ///
    /// 3. **Distance Calculation**
    ///    - For each index in the group:
    ///
    ///      - **Left contribution** (indices before current):
    ///        ```
    ///        left = i * idx - sum(previous indices)
    ///        ```
    ///
    ///      - **Right contribution** (indices after current):
    ///        ```
    ///        right = sum(next indices) - (count of next indices * idx)
    ///        ```
    ///
    ///      - Total:
    ///        ```
    ///        result[idx] = left + right
    ///        ```
    ///
    /// This avoids the naive `O(n²)` approach and reduces it to linear time.
    ///
    /// ### Parameters
    ///
    /// - `nums` — An integer array where values may repeat.
    ///
    /// ### Returns
    ///
    /// - `long[]` — An array where each position contains the sum of distances
    ///   to all other indices with the same value.
    ///
    /// ### Example
    ///
    /// ```java
    /// Input: nums = [1, 3, 1, 1, 2]
    /// Output: [5, 0, 3, 4, 0]
    /// ```
    ///
    /// ### Complexity
    ///
    /// - Time: `O(n)` — Each index is processed a constant number of times.
    /// - Space: `O(n)` — For storing groups and prefix sums.
    ///
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] result = new long[n];

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for (List<Integer> indices : map.values()) {
            int size = indices.size();

            long[] prefix = new long[size];
            prefix[0] = indices.get(0);

            for (int i = 1; i < size; i++) {
                prefix[i] = prefix[i - 1] + indices.get(i);
            }

            for (int i = 0; i < size; i++) {
                int idx = indices.get(i);

                long left = (long) i * idx - (i > 0 ? prefix[i - 1] : 0);

                long right = (prefix[size - 1] - prefix[i]) - (long) (size - i - 1) * idx;

                result[idx] = left + right;
            }
        }

        return result;
    }
}