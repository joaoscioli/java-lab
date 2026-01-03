package daily_question.nrepeatedElementSize2NArray;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /// ## repeatedNTimes
    ///
    /// Given an integer array `nums` of size **2N**, where **exactly one element**
    /// is repeated **N** times and all other elements appear **once**, this method
    /// returns the element that is repeated.
    ///
    /// The algorithm uses a `HashSet` to track previously seen numbers.
    /// As soon as a number appears twice, it is immediately returned.
    ///
    /// ### Parameters
    /// - `nums`: An integer array of length `2N`, containing exactly one value that appears `N` times.
    ///
    /// ### Returns
    /// - The integer value that appears repeatedly `N` times.
    /// - Returns `-1` only if no repeated value is found, but due to the problem
    ///   constraints, this scenario should never occur.
    ///
    /// ### Example
    /// ```java
    /// int[] nums = {1, 2, 3, 3};
    /// Solution sol = new Solution();
    /// int result = sol.repeatedNTimes(nums); // result = 3
    /// ```
    public int repeatedNTimes(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return num; // repeated element found
            }
            seen.add(num);
        }

        return -1; // theoretically unreachable due to problem guarantees
    }
}
/// ### Complexity
/// - **Time Complexity:** O(N), where N is the size of the array.
/// - **Space Complexity:** O(N), due to the HashSet used to track visited elements.
