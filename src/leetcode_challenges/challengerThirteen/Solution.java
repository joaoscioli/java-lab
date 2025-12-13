package leetcode_challenges.challengerThirteen;


import java.util.Map;

public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> values = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int current = values.get(s.charAt(i));
            if (i + 1 < s.length() && current < values.get(s.charAt(i + 1))) {
                result -= current;
            } else {
                result += current;
            }
        }

        return result;
    }
}
