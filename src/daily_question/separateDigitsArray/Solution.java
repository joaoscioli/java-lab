package daily_question.separateDigitsArray;

import java.util.ArrayList;
import java.util.List;

/// Provides a solution for separating the digits of each integer in an array.
///
/// The `separateDigits` method takes an array of integers and returns a new
/// array containing each digit from the input numbers, preserving their original
/// order.
///
/// For example:
///
/// ```java
/// int[] nums = {13, 25, 83, 77};
/// int[] result = new Solution().separateDigits(nums);
/// // result: [1, 3, 2, 5, 8, 3, 7, 7]
/// ```
class Solution {

    /// Separates the digits of each integer in the given array.
    ///
    /// Each number in `nums` is converted to a string so its digits can be
    /// processed from left to right. The resulting digits are stored in a list
    /// and then copied into an integer array.
    ///
    /// ## Example
    ///
    /// ```java
    /// int[] nums = {7, 12, 305};
    /// int[] result = separateDigits(nums);
    /// // result: [7, 1, 2, 3, 0, 5]
    /// ```
    ///
    /// @param nums the input array of integers whose digits should be separated
    /// @return an array containing all digits from `nums` in the same order
    public int[] separateDigits(int[] nums) {
        List<Integer> digits = new ArrayList<>();

        for (int num : nums) {
            String s = String.valueOf(num);

            for (char c : s.toCharArray()) {
                digits.add(c - '0');
            }
        }

        int[] answer = new int[digits.size()];

        for (int i = 0; i < digits.size(); i++) {
            answer[i] = digits.get(i);
        }

        return answer;
    }
}