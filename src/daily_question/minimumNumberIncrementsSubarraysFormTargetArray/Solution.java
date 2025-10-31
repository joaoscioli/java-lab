package daily_question.minimumNumberIncrementsSubarraysFormTargetArray;


public class Solution {
    public int minNumberOperations(int[] target) {
        int operations = target[0]; // Base case: need target[0] increments for the first element

        // For each subsequent element, count only the positive differences
        for (int i = 1; i < target.length; i++) {
            if (target[i] > target[i - 1]) {
                operations += target[i] - target[i - 1];
            }
        }

        return operations;
    }
}
