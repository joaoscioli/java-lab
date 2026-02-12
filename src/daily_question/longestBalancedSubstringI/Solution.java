package daily_question.longestBalancedSubstringI;

class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;

        for (int start = 0; start < n; start++) {
            int[] freq = new int[26]; // frequency of each lowercase letter

            for (int end = start; end < n; end++) {
                char c = s.charAt(end);
                freq[c - 'a']++;

                if (isBalanced(freq)) {
                    maxLen = Math.max(maxLen, end - start + 1);
                }
            }
        }

        return maxLen;
    }

    private boolean isBalanced(int[] freq) {
        int target = 0;
        for (int f : freq) {
            if (f != 0) {
                target = f;
                break;
            }
        }

        for (int f : freq) {
            if (f != 0 && f != target) {
                return false;
            }
        }
        return target != 0;
    }
}
