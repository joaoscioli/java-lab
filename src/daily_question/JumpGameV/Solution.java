package daily_question.JumpGameV;

class Solution {
    private int[] arr;
    private int d;
    private int[] memo;

    public int maxJumps(int[] arr, int d) {
        this.arr = arr;
        this.d = d;
        this.memo = new int[arr.length];

        int answer = 1;

        for (int i = 0; i < arr.length; i++) {
            answer = Math.max(answer, dfs(i));
        }

        return answer;
    }

    private int dfs(int index) {
        if (memo[index] != 0) {
            return memo[index];
        }

        int best = 1;

        // Jump to the right
        for (int next = index + 1; next <= Math.min(index + d, arr.length - 1); next++) {
            if (arr[next] >= arr[index]) {
                break;
            }

            best = Math.max(best, 1 + dfs(next));
        }

        // Jump to the left
        for (int next = index - 1; next >= Math.max(index - d, 0); next--) {
            if (arr[next] >= arr[index]) {
                break;
            }

            best = Math.max(best, 1 + dfs(next));
        }

        memo[index] = best;
        return best;
    }

}
