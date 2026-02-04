package daily_question.divideArrayIntoSubarraysWithMinimumCostII;

import java.util.TreeMap;

/// ## Solution
///
/// This class provides an efficient solution for the problem
/// **Divide Array Into Subarrays With Minimum Cost II**.
///
/// The goal is to compute the minimum possible cost of selecting
/// `k` elements under a distance constraint, where:
///
/// - The first element is always `nums[0]`
/// - The second element is `nums[i]`
/// - The remaining `k - 2` elements are chosen from a sliding window
///   of size `dist`
///
/// The algorithm uses a **sliding window + two balanced multisets**
/// to maintain the smallest possible sum of the required elements.
///
/// ### Key Idea
///
/// Maintain:
/// - A multiset `small` containing the smallest `k - 2` elements
/// - A multiset `large` containing the remaining elements in the window
///
/// The sum of elements in `small` is tracked incrementally to allow
/// constant-time cost calculation.
///
/// ### Data Structures
///
/// - `TreeMap<Integer, Integer>` is used to simulate a multiset
/// - Counts handle duplicate values
///
/// ### Time Complexity
///
/// - Each insertion/removal costs `O(log n)`
/// - Sliding window runs in `O(n)`
///
/// **Overall complexity:** `O(n log n)`
///
/// ### Space Complexity
///
/// - `O(n)` for maintaining window elements
class Solution {

    /// Multiset containing the smallest `k - 2` elements.
    TreeMap<Integer, Integer> small = new TreeMap<>();

    /// Multiset containing the remaining elements.
    TreeMap<Integer, Integer> large = new TreeMap<>();

    /// Sum of all elements currently stored in `small`.
    long sumSmall = 0;

    /// Number of elements currently stored in `small`.
    int sizeSmall = 0;

    /// ## minimumCost
    ///
    /// Computes the minimum cost to divide the array under the given constraints.
    ///
    /// ### Parameters
    /// - `nums`: Input array of integers
    /// - `k`: Total number of elements to select
    /// - `dist`: Maximum allowed distance for selecting elements
    ///
    /// ### Returns
    /// - The minimum possible cost as a `long`
    ///
    /// ### Algorithm
    ///
    /// 1. Fix `nums[0]` as the first element
    /// 2. Iterate over possible second elements `nums[i]`
    /// 3. Maintain a sliding window of candidates for the remaining `k - 2` elements
    /// 4. Always keep the smallest `k - 2` values in `small`
    /// 5. Update the answer using the current sum
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        long ans = Long.MAX_VALUE;

        int left = 2;
        int right = Math.min(n - 1, 1 + dist);

        /// Initialize the sliding window
        for (int i = left; i <= right; i++) {
            add(nums[i], k - 2);
        }

        /// Iterate over the second element
        for (int i1 = 1; i1 < n; i1++) {

            /// If we have exactly `k - 2` elements,
            /// compute the current cost
            if (sizeSmall == k - 2) {
                ans = Math.min(ans, nums[0] + nums[i1] + sumSmall);
            }

            /// Expand the window to the right
            if (right + 1 < n) {
                right++;
                add(nums[right], k - 2);
            }

            /// Shrink the window from the left
            if (left < n) {
                remove(nums[left], k - 2);
                left++;
            }
        }

        return ans;
    }

    /// ## add
    ///
    /// Inserts an element into either `small` or `large`,
    /// preserving the invariant that `small` contains
    /// the smallest `need` elements.
    private void add(int x, int need) {
        if (sizeSmall < need) {
            addSmall(x);
        } else if (!small.isEmpty() && x < small.lastKey()) {
            addSmall(x);
            moveSmallToLarge();
        } else {
            addLarge(x);
        }
    }

    /// ## remove
    ///
    /// Removes an element from the appropriate multiset
    /// and rebalances if necessary.
    private void remove(int x, int need) {
        if (small.containsKey(x)) {
            removeSmall(x);
        } else {
            removeLarge(x);
        }

        /// Restore invariant if `small` has fewer than `need` elements
        if (sizeSmall < need && !large.isEmpty()) {
            moveLargeToSmall();
        }
    }

    /// Adds an element to `small` and updates metadata.
    private void addSmall(int x) {
        small.put(x, small.getOrDefault(x, 0) + 1);
        sumSmall += x;
        sizeSmall++;
    }

    /// Removes an element from `small` and updates metadata.
    private void removeSmall(int x) {
        decrement(small, x);
        sumSmall -= x;
        sizeSmall--;
    }

    /// Adds an element to `large`.
    private void addLarge(int x) {
        large.put(x, large.getOrDefault(x, 0) + 1);
    }

    /// Removes an element from `large`.
    private void removeLarge(int x) {
        decrement(large, x);
    }

    /// Moves the largest element from `small` to `large`.
    private void moveSmallToLarge() {
        int x = small.lastKey();
        removeSmall(x);
        addLarge(x);
    }

    /// Moves the smallest element from `large` to `small`.
    private void moveLargeToSmall() {
        int x = large.firstKey();
        removeLarge(x);
        addSmall(x);
    }

    /// Decrements the count of an element in a multiset,
    /// removing it if the count reaches zero.
    private void decrement(TreeMap<Integer, Integer> map, int x) {
        map.put(x, map.get(x) - 1);
        if (map.get(x) == 0) {
            map.remove(x);
        }
    }
}
