package daily_question.findPrefixCommonArrayTwoArrays;

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] result = new int[n];
        int[] frequency = new int[n + 1];

        int common = 0;

        for (int i = 0; i < n; i++) {
            frequency[A[i]]++;

            if (frequency[A[i]] == 2) {
                common++;
            }

            frequency[B[i]]++;

            if (frequency[B[i]] == 2) {
                common++;
            }

            result[i] = common;
        }

        return result;
    }
}
