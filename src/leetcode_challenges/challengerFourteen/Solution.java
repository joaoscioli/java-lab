package leetcode_challenges.challengerFourteen;

import java.io.IO;

public class Solution {

    /// ## longestCommomPrefix
    ///
    /// Determines the **longest common prefix** among all strings in the input array `strs`.
    ///
    /// The algorithm starts by assuming the first string as the prefix and then
    /// iteratively shortens this prefix until all other strings start with it.
    ///
    /// ### Parameters
    /// - `strs`: An array of strings for which the longest common prefix is to be found.
    ///
    /// ### Returns
    /// - The longest common prefix shared among all strings in the array.
    /// - Returns an empty string if:
    ///   - the array is `null` or empty, or
    ///   - no common prefix exists.
    ///
    /// ### Example
    /// ```java
    /// String[] strs = {"flower", "flow", "flight"};
    /// Solution sol = new Solution();
    /// String result = sol.longestCommomPrefix(strs);
    /// // result = "fl"
    /// ```
    ///
    /// ### Notes
    /// - Prefix comparison is performed using `String.startsWith(prefix)`.
    /// - The prefix is reduced progressively using `substring`, ensuring an O(N · M) worst-case runtime,
    ///   where `N` is the number of strings and `M` is the length of the shortest string.
    ///
    /// ### Complexity
    /// - **Time Complexity:** O(N · M)
    /// - **Space Complexity:** O(1)
    public String longestCommomPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    /// ## main
    ///
    /// Demonstrates the usage of `longestCommomPrefix` by printing the result
    /// of an example input array.
    ///
    /// ### Example Output
    /// ```
    /// fl
    /// ```
    void main() {
        String[] strs = {"flower", "flow", "flight"};
        IO.println(longestCommomPrefix(strs));
    }
}
