package leetcode_challenges.challengerTwentySeven;

/// # Find the Index of the First Occurrence in a String
///
/// Searches for the **first occurrence** of a substring (`needle`)
/// within another string (`haystack`).
///
/// If the substring exists, the method returns the **starting index**
/// of its first appearance. If the substring does not exist,
/// the method returns `-1`.
///
/// ## Algorithm
///
/// This implementation uses a **naive substring search approach**.
///
/// Steps:
///
/// 1. Determine the lengths of both strings:
///    - `n` for `haystack`
///    - `m` for `needle`
///
/// 2. If `needle` is longer than `haystack`,
///    it is impossible to find a match, so return `-1`.
///
/// 3. Iterate through each possible starting index in `haystack`
///    where `needle` could fit (`0` to `n - m`).
///
/// 4. For each position:
///    - Compare characters sequentially between
///      `haystack` and `needle`.
///    - Continue while the characters match.
///
/// 5. If all characters of `needle` match (`j == m`),
///    return the current starting index.
///
/// 6. If no match is found after checking all possible positions,
///    return `-1`.
///
/// ## Time Complexity
///
/// - **O(n × m)** in the worst case,
///   where `n` is the length of `haystack`
///   and `m` is the length of `needle`.
///
/// ## Space Complexity
///
/// - **O(1)** — The algorithm uses constant additional memory.
///
/// ## Example
///
/// ```java
/// String haystack = "sadbutsad";
/// String needle = "sad";
///
/// int result = new Solution().strStr(haystack, needle);
/// // result = 0
/// ```
///
/// ```java
/// String haystack = "leetcode";
/// String needle = "leeto";
///
/// int result = new Solution().strStr(haystack, needle);
/// // result = -1
/// ```
///
/// ## Parameters
///
/// - `haystack` — The string where the search will be performed.
/// - `needle` — The substring to locate.
///
/// ## Returns
///
/// Returns the **index of the first occurrence** of `needle` in `haystack`,
/// or **-1 if the substring is not present**.
class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if (m > n) return -1;

        for (int i = 0; i <= n - m; i++) {
            int j = 0;

            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == m) {
                return i;
            }
        }

        return -1;
    }
}