package daily_question.findLengthLongestCommonPrefix;

import java.util.HashSet;
import java.util.Set;

class Solution {
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


    private int countDigits(int number) {
        int digits = 0;

        while (number > 0) {
            digits++;
            number /= 10;
        }

        return digits;
    }
}
