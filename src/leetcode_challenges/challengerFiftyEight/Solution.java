package leetcode_challenges.challengerFiftyEight;

public class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int length = 0;

        // 1️⃣ Ignora espaços no final
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // 2️⃣ Conta a última palavra
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}
