package daily_question.primeNumberSetBitsBinaryRepresentation;

import java.util.Set;

class Solution {
    public int countPrimeSetBits(int left, int right) {
        Set<Integer> primes = Set.of(
                2, 3, 5, 7, 11, 13, 17, 19
        );

        int count = 0;

        for (int num = left; num <= right; num++) {
            int setBits = Integer.bitCount(num);
            if (primes.contains(setBits)) {
                count++;
            }
        }

        return count;
    }
}
