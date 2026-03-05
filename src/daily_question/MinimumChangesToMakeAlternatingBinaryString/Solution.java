package daily_question.MinimumChangesToMakeAlternatingBinaryString;

class Solution {
    public int minOperations(String s) {
        int mismatchStartWith0 = 0;
        int mismatchStartWith1 = 0;

        for (int i = 0; i < s.length(); i++) {
            char expectedFor0Pattern = (i % 2 == 0) ? '0' : '1';
            char expectedFor1Pattern = (i % 2 == 0) ? '1' : '0';

            if (s.charAt(i) != expectedFor0Pattern) {
                mismatchStartWith0++;
            }

            if (s.charAt(i) != expectedFor1Pattern) {
                mismatchStartWith1++;
            }
        }

        return Math.min(mismatchStartWith0, mismatchStartWith1);
    }
}