package daily_question.findAllPossibleStableBinaryArraysI;

class Solution {
    private static final int MOD = 1_000_000_007;
    private Integer[][][][] memo;

    public int numberOfStableArrays(int zero, int one, int limit) {
        memo = new Integer[zero + 1][one + 1][2][limit + 1];
        long res = 0;
        if (zero > 0)
            res += dfs(zero - 1, one, 0, 1, limit);

        if (one > 0)
            res += dfs(zero, one - 1, 1, 1, limit);

        return (int)(res % MOD);
    }

    private int dfs(int z, int o, int last, int streak, int limit) {
        if (z == 0 && o == 0)
            return 1;

        if (memo[z][o][last][streak] != null)
            return memo[z][o][last][streak];

        long ways = 0;

        if (last == 0) {
            if (z > 0 && streak < limit)
                ways += dfs(z - 1, o, 0, streak + 1, limit);
            if (o > 0)
                ways += dfs(z, o - 1, 1, 1, limit);

        } else {
            if (o > 0 && streak < limit)
                ways += dfs(z, o - 1, 1, streak + 1, limit);
            if (z > 0)
                ways += dfs(z - 1, o, 0, 1, limit);
        }

        ways %= MOD;
        return memo[z][o][last][streak] = (int) ways;
    }
}