package daily_question.fancySequence;

import java.util.ArrayList;
import java.util.List;

class Fancy {
    private static final long MOD = 1_000_000_007;

    private List<Long> values;
    private long mul;
    private long add;

    public Fancy() {
        values = new ArrayList<>();
        mul = 1;
        add = 0;
    }

    public void append(int val) {
        long invMul = modInverse(mul);
        long normalized = ((val - add) % MOD + MOD) % MOD;
        normalized = (normalized * invMul) % MOD;
        values.add(normalized);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= values.size()) return -1;

        long val = values.get(idx);
        long result = (val * mul + add) % MOD;
        return (int) result;
    }

    private long modInverse(long x) {
        return modPow(x, MOD - 2);
    }

    private long modPow(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }

        return result;
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */
/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */
