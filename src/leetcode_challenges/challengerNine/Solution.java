package leetcode_challenges.challengerNine;

public class Solution {
    public boolean isPalindrome(int x) {
        // Números negativos ou terminando em 0 (mas não zero)
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;

        // Construímos só a metade do número
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // Se tiver número ímpar de dígitos, removemos o dígito central
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
