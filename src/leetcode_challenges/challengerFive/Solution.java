package leetcode_challenges.challengerFive;

public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);       // Palíndromo de comprimento ímpar
            int len2 = expandAroundCenter(s, i, i + 1);   // Palíndromo de comprimento par
            int len = Math.max(len1, len2);

            if (len > end - start) {
                // Atualiza os limites da substring mais longa
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // comprimento do palíndromo
    }
}
