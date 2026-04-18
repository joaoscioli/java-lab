package daily_question.mirrorDistanceOfAnInteger;

class Solution {
    public int mirrorDistance(int n) {
        int reversed = reverse(n);
        return Math.abs(n - reversed);
    }
    private int reverse(int x) {
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + (x % 10);
            x /= 10;
        }
        return rev;
    }
}
