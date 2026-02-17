package leetcode_challenges.challengerTwentyTwo;


import java.util.ArrayList;
import java.util.List;

// Combinações
//
// ["((()))","(()())","(())()","()(())","()()()"]
//

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        backtrack(sb, 0, 0, n, result);

        return result;
    }

    public void backtrack(StringBuilder sb, int open, int close, int n, List<String> result) {
        if(open == n && close == n) {
            result.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append("(");
            backtrack(sb, open + 1, close, n, result);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(")");
            backtrack(sb, open, close + 1, n, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
