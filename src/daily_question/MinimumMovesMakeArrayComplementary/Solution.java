package daily_question.MinimumMovesMakeArrayComplementary;

class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] diff = new int[2 * limit + 2];

        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];

            int min = Math.min(a, b);
            int max = Math.max(a, b);
            int sum = a + b;

            diff[2] += 2;
            diff[2 * limit + 1] -= 2;

            diff[min + 1] -= 1;
            diff[max + limit + 1] += 1;

            diff[sum] -= 1;
            diff[sum + 1] += 1;
        }

        int answer = Integer.MAX_VALUE;
        int moves = 0;

        for (int target = 2; target <= 2 * limit; target++) {
            moves += diff[target];
            answer = Math.min(answer, moves);
        }

        return answer;
    }
}