package daily_question.minimumNumberSecondsMakeMountainHeightZero;

/// # Minimum Number of Seconds to Make Mountain Height Zero
///
/// This solution computes the **minimum number of seconds required** for a group
/// of workers to reduce a mountain's height to zero.
///
/// Each worker reduces the mountain in **increasing time intervals**:
///
/// ```text
/// w + 2w + 3w + ... + xw
/// ```
///
/// Where:
/// - `w` is the worker's base time (`workerTimes[i]`)
/// - `x` is the number of height units reduced by that worker
///
/// This sequence forms an **arithmetic progression**:
///
/// ```math
/// time = w * (1 + 2 + ... + x)
/// ```
///
/// Using the sum formula:
///
/// ```math
/// 1 + 2 + ... + x = x(x + 1) / 2
/// ```
///
/// Therefore:
///
/// ```math
/// time = w * x(x + 1) / 2
/// ```
///
/// The algorithm uses **Binary Search on the answer (time)** to determine
/// the smallest time where the total height reduction from all workers
/// is at least `mountainHeight`.
///
/// ## Strategy
///
/// 1. Perform a binary search on the possible time range.
/// 2. For a candidate time `T`, compute how many height units each worker
///    can reduce within that time.
/// 3. Sum the contributions of all workers.
/// 4. If the total reduction is at least the mountain height,
///    the time is feasible.
///
/// ## Time Complexity
///
/// ```text
/// O(n log T)
/// ```
///
/// - `n` = number of workers
/// - `T` = upper bound of time (`1e18`)
///
/// ## Space Complexity
///
/// ```text
/// O(1)
/// ```
///
/// Only constant extra space is used.
class Solution {

    /// ## minNumberOfSeconds
    ///
    /// Computes the minimum time required for workers to completely
    /// reduce the mountain height.
    ///
    /// ### Parameters
    ///
    /// - `mountainHeight` : the total height of the mountain to remove
    /// - `workerTimes` : array where each element represents the base time
    ///   required for a worker to remove the first unit of height
    ///
    /// ### Returns
    ///
    /// - The **minimum number of seconds** needed to reduce the mountain to zero.
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 0;
        long right = (long) 1e18;
        long ans = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (can(mid, mountainHeight, workerTimes)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    /// ## can
    ///
    /// Determines whether the workers can reduce the mountain height
    /// to zero within a given time.
    ///
    /// For each worker, we compute the maximum number of height units `x`
    /// that can be reduced within the given time using the derived formula:
    ///
    /// ```math
    /// x = floor((sqrt(1 + 8T / w) - 1) / 2)
    /// ```
    ///
    /// Where:
    ///
    /// - `T` is the available time
    /// - `w` is the worker's base time
    ///
    /// ### Parameters
    ///
    /// - `time` : candidate time to test
    /// - `mountainHeight` : required total reduction
    /// - `workerTimes` : worker base times
    ///
    /// ### Returns
    ///
    /// - `true` if workers can reduce at least `mountainHeight`
    /// - `false` otherwise
    private boolean can(long time, int mountainHeight, int[] workerTimes) {
        long total = 0;

        for (int w : workerTimes) {

            long val = (long)(Math.sqrt(1 + (8.0 * time) / w) - 1) / 2;

            total += val;

            if (total >= mountainHeight) return true;
        }

        return total >= mountainHeight;
    }
}