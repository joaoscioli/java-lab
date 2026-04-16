package daily_question.closestEqualElementQueries;

import java.util.*;

class Solution {

    /// # solveQueries
    ///
    /// Computes the minimum circular distance from each queried index
    /// to the nearest index that contains the same value.
    ///
    /// ## Problem Summary
    /// Given a circular array `nums`, for each index in `queries`,
    /// this method finds the shortest distance to another index `j`
    /// such that:
    ///
    /// - `nums[j] == nums[queries[i]]`
    /// - Distance is measured circularly
    ///
    /// If no such index exists, `-1` is returned for that query.
    ///
    /// ## Approach
    /// - Build a mapping from value → sorted list of indices.
    /// - For each query:
    ///   - Retrieve the list of indices for the value.
    ///   - If only one occurrence exists → return `-1`.
    ///   - Use binary search to locate the current index.
    ///   - Compare distances to:
    ///     - Previous index in the list
    ///     - Next index in the list
    ///   - Compute circular distance using:
    ///     `min(|a - b|, n - |a - b|)`
    ///
    /// ## Parameters
    /// - `nums`: The input circular array of integers.
    /// - `queries`: Array of indices to evaluate.
    ///
    /// ## Returns
    /// A list of integers where each element represents the minimum
    /// circular distance for the corresponding query.
    ///
    /// ## Complexity
    /// - Time:
    ///   - Preprocessing: `O(n)`
    ///   - Each query: `O(log k)` (binary search)
    ///   - Total: `O(n + q log n)`
    /// - Space: `O(n)`
    ///
    /// ## Example
    /// ```
    /// Input:
    /// nums = [1,3,1,4,1,3,2]
    /// queries = [0,3,5]
    ///
    /// Output:
    /// [2, -1, 3]
    /// ```
    ///
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> result = new ArrayList<>();

        for (int idx : queries) {
            int val = nums[idx];
            List<Integer> list = map.get(val);

            if (list.size() == 1) {
                result.add(-1);
                continue;
            }

            int pos = Collections.binarySearch(list, idx);

            int prev = list.get((pos - 1 + list.size()) % list.size());
            int next = list.get((pos + 1) % list.size());

            int dist1 = Math.min(Math.abs(idx - prev), n - Math.abs(idx - prev));
            int dist2 = Math.min(Math.abs(idx - next), n - Math.abs(idx - next));

            result.add(Math.min(dist1, dist2));
        }

        return result;
    }
}