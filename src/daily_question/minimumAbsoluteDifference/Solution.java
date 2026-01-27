package daily_question.minimumAbsoluteDifference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/// ## Minimum Absolute Difference
///
/// This solution finds all pairs of integers in an array whose absolute
/// difference is the minimum among all possible pairs.
///
/// ### Key Observation
/// After sorting the array, the minimum absolute difference can only occur
/// between two adjacent elements. This allows the problem to be solved
/// efficiently without checking all possible pairs.
///
/// ### Approach
/// 1. Sort the input array.
/// 2. Scan adjacent elements to determine the minimum difference.
/// 3. Scan again to collect all pairs that match this minimum difference.
///
/// ### Complexity
/// - Time: `O(n log n)` due to sorting
/// - Space: `O(1)` auxiliary space (excluding the output list)
class Solution {

    /// ## minimumAbsDifference
    ///
    /// Returns all pairs `[a, b]` such that:
    /// - `a` and `b` come from the input array
    /// - `a < b`
    /// - `b - a` is the minimum absolute difference among all pairs
    ///
    /// The returned list is ordered in ascending order with respect to pairs.
    ///
    /// ### Example
    /// Input: `[4, 2, 1, 3]`
    /// Output: `[[1, 2], [2, 3], [3, 4]]`
    ///
    /// @param arr an array of distinct integers
    /// @return a list of pairs with the minimum absolute difference
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        /// Sort the array to bring closest values together
        Arrays.sort(arr);

        /// Find the minimum difference between adjacent elements
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
        }

        /// Collect all pairs that have the minimum difference
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == minDiff) {
                result.add(List.of(arr[i - 1], arr[i]));
            }
        }

        return result;
    }
}
