package daily_question.numberOfWaysToPainN3Grid;

public class Solution {
    public int numOfWays(int n) {
        long MOD = 1_000_000_007;

        long same = 6;
        long diff = 6;

        for (int i = 2; i <= n; i++) {
            long newSame = (3 * same + 2 * diff) % MOD;
            long newDiff = (2 * same + 2 * diff) % MOD;

            same = newSame;
            diff = newDiff;
        }
        return (int) ((same + diff) % MOD);
    }
}
