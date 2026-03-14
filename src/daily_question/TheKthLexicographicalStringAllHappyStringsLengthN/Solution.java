package daily_question.TheKthLexicographicalStringAllHappyStringsLengthN;

class Solution {
    private int count = 0;
    private String result = "";

    public String getHappyString(int n, int k) {
        backtrack(new StringBuilder(), n, k);
        return result;
    }

    private void backtrack(StringBuilder current, int n, int k) {
        if (current.length() == n) {
            count++;
            if (count == k) {
                result = current.toString();
            }
            return;
        }

        for (char c : new char[]{'a', 'b', 'c'}) {

            if (current.length() > 0 &&
                    current.charAt(current.length() - 1) == c) {
                continue;
            }

            current.append(c);
            backtrack(current, n, k);

            if (!result.isEmpty()) return;

            current.deleteCharAt(current.length() - 1);
        }
    }
}