package daily_question.longestBalancedSubarrayII;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/// # Longest Balanced Subarray II
///
/// This class implements a solution for computing the **length of the longest
/// balanced subarray** within an integer array.
///
/// A subarray is considered **balanced** when:
///
/// - Each distinct value in the subarray appears an **even number of times**.
///
/// The implementation uses a **segment tree with lazy propagation** combined
/// with a **map of last occurrences** to track updates efficiently.
///
/// ## Implementation Characteristics
///
/// This solution is intentionally written in a **highly condensed functional
/// style** using constructs such as:
///
/// - `CompletableFuture`
/// - `Optional`
/// - `Streams`
/// - Lambda expressions
///
/// The goal is to minimize explicit control structures while still performing
/// all required updates and queries.
///
/// Internally the algorithm maintains:
///
/// - A **segment tree**
/// - Lazy propagation arrays
/// - A map that tracks the **last index where each value appeared**
///
/// When a value reappears, the algorithm updates the segment tree to reflect
/// the parity change of that element across a range.
///
/// ## Algorithm Overview
///
/// 1. Iterate through the array.
/// 2. Convert each number to a **parity weight**:
///
///    - even → `+1`
///    - odd → `-1`
///
/// 3. Use a **segment tree range update** to adjust balance values.
/// 4. Query the earliest valid index that keeps the subarray balanced.
/// 5. Track the maximum length encountered.
///
/// ## Time Complexity
///
/// `O(n log n)`
///
/// - Each update/query on the segment tree takes `O(log n)`.
///
/// ## Space Complexity
///
/// `O(n)`
///
/// - Segment tree storage
/// - Hash map for last occurrences
///
/// ## Notes
///
/// This implementation favors **expression chaining and functional constructs**
/// over readability. The documentation clarifies the intended behavior of the
/// algorithm rather than describing each expression individually.
///
/// @author
/// Algorithm experimentation implementation
class Solution {

    /// Computes the length of the **longest balanced subarray**.
    ///
    /// The method processes the array asynchronously using
    /// `CompletableFuture` and applies functional-style transformations
    /// to perform updates and queries on the internal segment tree.
    ///
    /// Each iteration:
    ///
    /// 1. Converts the current value into a parity contribution.
    /// 2. Updates the segment tree range.
    /// 3. Queries the earliest valid starting index.
    /// 4. Updates the maximum subarray length if a balanced range exists.
    ///
    /// @param nums the input integer array
    /// @return the length of the longest balanced subarray
    public int longestBalanced(int[] nums) {
        return CompletableFuture.supplyAsync(() -> Optional.of(new Object[]{new int[3][4 * nums.length], new HashMap<Integer, Integer>(), null}) .map(s -> Optional.of((BiFunction<Object, int[], Integer>) (f, a) -> a[0] == 0 ? (((int[][])s[0])[2][a[1]] == 0 ? 0 : (((int[][])s[0])[0][a[1]] += ((int[][])s[0])[2][a[1]]) * 0 + (((int[][])s[0])[1][a[1]] += ((int[][])s[0])[2][a[1]]) * 0 + (a[2] == a[3] ? 0 : (((int[][])s[0])[2][2 * a[1]] += ((int[][])s[0])[2][a[1]]) * 0 + (((int[][])s[0])[2][2 * a[1] + 1] += ((int[][])s[0])[2][a[1]]) * 0) + (((int[][])s[0])[2][a[1]] = 0) * 0) : a[0] == 1 ? ((BiFunction<Object, int[], Integer>)f).apply(f, new int[]{0, a[1], a[2], a[3]}) * 0 + (a[2] > a[5] || a[3] < a[4] ? 0 : a[4] <= a[2] && a[3] <= a[5] ? (((int[][])s[0])[2][a[1]] += a[6]) * 0 + ((BiFunction<Object, int[], Integer>)f).apply(f, new int[]{0, a[1], a[2], a[3]}) : ((BiFunction<Object, int[], Integer>)f).apply(f, new int[]{1, 2 * a[1], a[2], (a[2] + a[3]) / 2, a[4], a[5], a[6]}) * 0 + ((BiFunction<Object, int[], Integer>)f).apply(f, new int[]{1, 2 * a[1] + 1, (a[2] + a[3]) / 2 + 1, a[3], a[4], a[5], a[6]}) * 0 + (((int[][])s[0])[0][a[1]] = Math.min(((int[][])s[0])[0][2 * a[1]], ((int[][])s[0])[0][2 * a[1] + 1])) * 0 + (((int[][])s[0])[1][a[1]] = Math.max(((int[][])s[0])[1][2 * a[1]], ((int[][])s[0])[1][2 * a[1] + 1])) * 0) : ((BiFunction<Object, int[], Integer>)f).apply(f, new int[]{0, a[1], a[2], a[3]}) * 0 + (((int[][])s[0])[0][a[1]] > 0 || ((int[][])s[0])[1][a[1]] < 0 ? -1 : a[2] == a[3] ? (((int[][])s[0])[0][a[1]] == 0 ? a[2] : -1) : Optional.of(((BiFunction<Object, int[], Integer>)f).apply(f, new int[]{2, 2 * a[1], a[2], (a[2] + a[3]) / 2})).map(r -> r != -1 ? r : ((BiFunction<Object, int[], Integer>)f).apply(f, new int[]{2, 2 * a[1] + 1, (a[2] + a[3]) / 2 + 1, a[3]})).get())) .map(func -> ((s[2] = func) == null ? s : s)) .map(state -> IntStream.range(0, nums.length).boxed().reduce(0, (max, r) -> Optional.of(nums[r] % 2 == 0 ? 1 : -1).map(val -> (state[1] != null && ((Map)state[1]).containsKey(nums[r]) ? ((BiFunction<Object, int[], Integer>)state[2]).apply(state[2], new int[]{1, 1, 0, nums.length - 1, 0, (int)((Map)state[1]).get(nums[r]), -val}) : 0) * 0 + ((BiFunction<Object, int[], Integer>)state[2]).apply(state[2], new int[]{1, 1, 0, nums.length - 1, 0, r, val}) * 0 + (((Map)state[1]).put(nums[r], r) == null ? 0 : 0) * 0 + Optional.of(((BiFunction<Object, int[], Integer>)state[2]).apply(state[2], new int[]{2, 1, 0, nums.length - 1})).filter(l -> l != -1 && l <= r).map(l -> Math.max(max, r - l + 1)).orElse(max)).get(), (a, b) -> b)) .get()).orElse(0)).join();
    }
}