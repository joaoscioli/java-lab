package daily_question.FourDivisors;

public class Solution {
    public int sumFourDivisors(int[] nums) {
        int total = 0;

        for (int n : nums) {
            total += getFourDivisorsSum(n);
        }

        return total;
    }

    private int getFourDivisorsSum(int n) {
        int sum = 0;
        int count = 0;

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                int j = n / i;

                if (i == j) {
                    count++;
                    sum += i;
                } else {
                    count += 2;
                    sum += i + j;
                }
                if (count > 4) return 0;
            }
        }
        return count == 4 ? sum : 0;
    }
}
