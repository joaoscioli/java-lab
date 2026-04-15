package daily_question.shortestDistanceTargetStringCircularArray;

class Solution {

    /// ### Closest Target in a Circular Array
    ///
    /// Computes the shortest distance from a given `startIndex` to any occurrence
    /// of the `target` string within a circular array.
    ///
    /// A circular array means:
    /// - Moving forward from the last index wraps to the first index.
    /// - Moving backward from the first index wraps to the last index.
    ///
    /// ---
    ///
    /// ### Approach
    ///
    /// - Iterate through the array to find all occurrences of `target`.
    /// - For each occurrence at index `i`, calculate:
    ///   - **Forward distance** (clockwise movement)
    ///   - **Backward distance** (counterclockwise movement)
    /// - Use modulo arithmetic to handle circular wrapping.
    /// - Track the minimum distance among all valid occurrences.
    ///
    /// ---
    ///
    /// ### Distance Formulas
    ///
    /// ```text
    /// forward  = (i - startIndex + n) % n
    /// backward = (startIndex - i + n) % n
    /// ```
    ///
    /// ---
    ///
    /// ### Parameters
    ///
    /// - `words` (String[]): The circular array of words.
    /// - `target` (String): The word to search for.
    /// - `startIndex` (int): The starting position in the array.
    ///
    /// ---
    ///
    /// ### Returns
    ///
    /// - `int`: The minimum number of steps required to reach the target.
    /// - Returns `-1` if the target does not exist in the array.
    ///
    /// ---
    ///
    /// ### Complexity
    ///
    /// - **Time Complexity:** O(n)
    /// - **Space Complexity:** O(1)
    ///
    /// ---
    ///
    /// ### Example
    ///
    /// ```java
    /// String[] words = {"hello","i","am","leetcode","hello"};
    /// String target = "hello";
    /// int startIndex = 1;
    ///
    /// int result = new Solution().closestTarget(words, target, startIndex);
    /// // result = 1
    /// ```
    ///
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int forward = (i - startIndex + n) % n;
                int backward = (startIndex - i + n) % n;

                int distance = Math.min(forward, backward);
                minDistance = Math.min(minDistance, distance);
            }
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}