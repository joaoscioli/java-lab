package daily_question.MinimumAbsoluteDistanceBetweenMirrorPairs;

import java.util.HashMap;
import java.util.Map;

/// # Solution
///
/// Provides a method to compute the **minimum absolute distance between mirror pairs**
/// in an integer array.
///
/// A *mirror pair* is defined as two indices `(i, j)` such that:
/// - `i < j`
/// - `nums[i]` is equal to the reverse of `nums[j]`
///
/// ## Approach
///
/// - Iterate through the array once.
/// - Maintain a map (`expected`) that stores:
///   - Key: reversed number
///   - Value: index where this reversed number is expected
/// - For each number:
///   - Check if it already exists in the map:
///     - If yes, compute the distance and update the minimum.
///   - Store the reverse of the current number in the map.
///
/// ## Complexity
///
/// - **Time Complexity:** O(n * d)
///   - `n` = number of elements
///   - `d` = number of digits (for reversing numbers)
/// - **Space Complexity:** O(n)
class Solution {

    /// ## minMirrorPairDistance
    ///
    /// Finds the minimum distance between mirror pairs in the array.
    ///
    /// ### Parameters
    /// - `nums`: an array of integers
    ///
    /// ### Returns
    /// - The minimum distance between indices of a mirror pair
    /// - `-1` if no such pair exists
    ///
    /// ### Example
    /// ```java
    /// nums = [120, 21]
    /// // reverse(120) = 21 → mirror pair found
    /// // distance = 1
    /// ```
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> expected = new HashMap<>();
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            // If current number matches a previously expected reversed value
            if (expected.containsKey(num)) {
                minDist = Math.min(minDist, i - expected.get(num));
            }

            // Store the reversed number as a future expectation
            int rev = reverse(num);
            expected.put(rev, i);
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }

    /// ## reverse
    ///
    /// Reverses the digits of a positive integer.
    ///
    /// ### Parameters
    /// - `x`: a non-negative integer
    ///
    /// ### Returns
    /// - The integer obtained by reversing the digits of `x`
    ///
    /// ### Example
    /// ```java
    /// reverse(120) → 21
    /// reverse(123) → 321
    /// ```
    private int reverse(int x) {
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + (x % 10);
            x /= 10;
        }
        return rev;
    }
}