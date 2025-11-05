package daily_question.maximumDifferenceBetweenEvenOddFrequencyI;

import java.util.HashMap;
import java.util.Map;

public class Solution {
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
}
