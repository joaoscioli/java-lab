package daily_question.trionicArrayII;

public class Solution {

    /// ## Maximum Trionic Sum
    ///
    /// Computes the maximum possible sum of a **trionic subarray**.
    ///
    /// A trionic subarray is defined as a contiguous sequence that follows
    /// three consecutive phases:
    ///
    /// 1. **Strictly increasing** segment
    /// 2. **Strictly decreasing** segment
    /// 3. **Strictly increasing** segment
    ///
    /// Each segment must contain at least one element, and the transitions
    /// between segments must preserve strict monotonicity.
    ///
    /// This implementation scans the array to identify valid decreasing
    /// "valleys" and then expands outward to compute the best possible
    /// increasing sums on both sides.
    ///
    /// ---
    ///
    /// ### Algorithm Overview
    ///
    /// - Iterate through the array treating each index as a potential center
    ///   of the decreasing segment.
    /// - Extend to the right while values are strictly decreasing, accumulating
    ///   the total sum of the valley.
    /// - Extend to the left while values are strictly increasing, tracking the
    ///   maximum prefix sum.
    /// - Extend further to the right while values are strictly increasing,
    ///   tracking the maximum suffix sum.
    /// - Combine the best left increase, the full decreasing segment,
    ///   and the best right increase to form a trionic sum candidate.
    /// - Keep track of the global maximum.
    ///
    /// The loop index is advanced to skip already processed segments,
    /// ensuring linear traversal behavior.
    ///
    /// ---
    ///
    /// ### Example
    ///
    /// ```text
    /// Input:  nums = [1, 3, 5, 4, 2, 6, 8]
    /// Output: maximum trionic sum = 28
    /// ```
    ///
    /// ---
    ///
    /// ### Time Complexity
    ///
    /// - **O(n)** — each index is visited a constant number of times due to
    ///   controlled pointer movement.
    ///
    /// ### Space Complexity
    ///
    /// - **O(1)** — only constant extra space is used.
    ///
    /// ---
    ///
    /// ### Notes
    ///
    /// - Uses `long` to prevent overflow when summing large values.
    /// - Early `continue` statements ensure that only valid trionic
    ///   configurations are considered.
    ///
    /// @param nums the input integer array
    /// @return the maximum sum of any valid trionic subarray
    public long maximumTrionicSum(int[] nums) {
        int n = nums.length;
        long res = -1 * (long) 1e16;

        for (int i = 1; i < n - 2; i++) {

            int a = i;
            int b = i;

            long net = nums[a];

            // Identify the strictly decreasing segment
            while (b + 1 < n && nums[b + 1] < nums[b]) {
                net += (long) nums[b + 1];
                b++;
            }

            if (b == a) continue;

            int c = b;

            long left = 0;
            long right = 0;

            long lx = Integer.MIN_VALUE;
            long rx = Integer.MIN_VALUE;

            // Expand left for the strictly increasing segment
            while (a - 1 >= 0 && nums[a - 1] < nums[a]) {
                left += (long) nums[a - 1];
                lx = Math.max(lx, left);
                a--;
            }

            if (a == i) continue;

            // Expand right for the strictly increasing segment
            while (b + 1 < n && nums[b + 1] > nums[b]) {
                right += (long) nums[b + 1];
                rx = Math.max(rx, right);
                b++;
            }

            if (b == c) continue;

            // Skip processed range
            i = b - 1;

            res = Math.max(res, lx + rx + net);
        }

        return res;
    }
}
