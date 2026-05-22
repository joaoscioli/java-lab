package daily_question.findLengthLongestCommonPrefix;

import java.util.HashSet;
import java.util.Set;

/// Provides a solution for finding the length of the longest common numeric prefix
/// between two integer arrays.
///
/// A **numeric prefix** is formed by repeatedly removing the last digit of a number.
/// For example, the prefixes of `12345` are:
///
/// - `12345`
/// - `1234`
/// - `123`
/// - `12`
/// - `1`
///
/// The algorithm stores every numeric prefix from the first array in a set, then
/// checks each prefix of every number in the second array to find the longest match.
class Solution {

    /// Returns the length of the longest common numeric prefix shared by any number
    /// in `arr1` and any number in `arr2`.
    ///
    /// The method works in two phases:
    ///
    /// 1. Generate and store all numeric prefixes from `arr1`.
    /// 2. Generate prefixes from `arr2` and check whether each prefix exists in
    ///    the stored prefix set.
    ///
    /// Once a matching prefix is found for a number in `arr2`, the method stops
    /// checking shorter prefixes for that number because prefixes are checked from
    /// longest to shortest.
    ///
    /// Example:
    ///
    /// ```java
    /// int[] arr1 = {12345, 67};
    /// int[] arr2 = {123, 678};
    ///
    /// int result = new Solution().longestCommonPrefix(arr1, arr2);
    /// // result == 3, because "123" is the longest common prefix.
    /// ```
    ///
    /// @param arr1 the first array of positive integers used to build the prefix set
    /// @param arr2 the second array of positive integers checked against the prefix set
    /// @return the number of digits in the longest common numeric prefix, or `0`
    ///         when no common prefix exists
    ///
    /// @implNote This implementation assumes the input numbers are positive.
    /// Numbers less than or equal to zero do not contribute any prefixes because
    /// the prefix-building loops only run while the number is greater than zero.
    ///
    /// @implSpec The time complexity is `O(d * (n + m))`, where `n` is the length
    /// of `arr1`, `m` is the length of `arr2`, and `d` is the maximum number of
    /// digits in any input number. The space complexity is `O(n * d)` in the worst
    /// case, because every prefix from `arr1` may be stored.
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> prefixes = new HashSet<>();

        for (int number : arr1) {
            while (number > 0) {
                prefixes.add(number);
                number /= 10;
            }
        }

        int longest = 0;

        for (int number : arr2) {
            while (number > 0) {
                if (prefixes.contains(number)) {
                    longest = Math.max(longest, countDigits(number));
                    break;
                }

                number /= 10;
            }
        }

        return longest;
    }

    /// Counts the number of decimal digits in a positive integer.
    ///
    /// The method repeatedly removes the last digit of the number by dividing it
    /// by `10`, incrementing the digit counter at each step.
    ///
    /// Example:
    ///
    /// ```java
    /// countDigits(12345); // returns 5
    /// ```
    ///
    /// @param number the positive integer whose digits should be counted
    /// @return the number of decimal digits in `number`, or `0` when `number`
    ///         is less than or equal to zero
    private int countDigits(int number) {
        int digits = 0;

        while (number > 0) {
            digits++;
            number /= 10;
        }

        return digits;
    }
}