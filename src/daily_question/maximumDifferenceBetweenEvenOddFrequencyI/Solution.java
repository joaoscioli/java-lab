package daily_question.maximumDifferenceBetweenEvenOddFrequencyI;

import java.util.HashMap;
import java.util.Map;

/**
 * # Maximum Difference Between Even and Odd Frequency I
 *
 * Given a lowercase English string `s`, this class provides a method to find
 * the **maximum difference** between the frequency of two characters `a₁` and `a₂`
 * such that:
 *
 * - `a₁` has an **odd** frequency in the string.
 * - `a₂` has an **even** frequency in the string.
 *
 * The goal is to return the largest possible value of:
 *
 * ```
 * diff = freq(a₁) - freq(a₂)
 * ```
 *
 * ## Example 1
 * ```java
 * Input: s = "aaaaabbc"
 * Output: 3
 * Explanation:
 * - 'a' occurs 5 times (odd), 'b' occurs 2 times (even)
 * - diff = 5 - 2 = 3
 * ```
 *
 * ## Example 2
 * ```java
 * Input: s = "abcabcab"
 * Output: 1
 * Explanation:
 * - 'a' occurs 3 times (odd), 'c' occurs 2 times (even)
 * - diff = 3 - 2 = 1
 * ```
 *
 * ## Constraints
 * - `3 <= s.length <= 100`
 * - `s` contains at least one character with an odd frequency
 *   and one with an even frequency.
 */
public class Solution {

    /// Calculates the maximum difference between odd and even character frequencies.
    ///
    /// This method:
    /// 1. Counts the frequency of each character in the input string.
    /// 2. Separates them into **odd** and **even** frequency groups.
    /// 3. Finds the largest odd frequency and the smallest even frequency.
    /// 4. Returns their difference.
    ///
    /// @param s the input string containing only lowercase English letters
    /// @return the maximum difference between an odd and an even frequency
    public int maxDifference(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        // Step 1: Count the frequency of each character
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;

        // Step 2: Identify odd and even frequencies
        for (int count : freq.values()) {
            if (count % 2 == 1) {
                maxOdd = Math.max(maxOdd, count);
            } else {
                minEven = Math.min(minEven, count);
            }
        }

        // Step 3: Compute the maximum difference
        return maxOdd - minEven;
    }

    /// Example usage and test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        String s1 = "aaaaabbc";
        String s2 = "abcabcab";

        System.out.println(sol.maxDifference(s1)); // Output: 3
        System.out.println(sol.maxDifference(s2)); // Output: 1
    }
}
