package daily_question.ConcatenationConsecutiveBinaryNumbers;

class Solution {
    public int concatenatedBinary(int n) {
        long res = 0;
        int mod = 1_000_000_007;
        int bits = 0;

        for (int i = 1; i <= n; i++) {

            // Se for potência de 2, aumenta quantidade de bits
            if ((i & (i - 1)) == 0) {
                bits++;
            }

            // Desloca e adiciona i
            res = ((res << bits) | i) % mod;
        }

        return (int) res;
    }
}
