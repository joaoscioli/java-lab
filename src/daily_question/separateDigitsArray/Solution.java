package daily_question.separateDigitsArray;

import java.util.ArrayList;
import java.util.List;

class Solution {
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