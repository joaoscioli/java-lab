package daily_question.minimumInitialEnergyFinishTasks;

import java.util.Arrays;

class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> {
            int diffA = a[1] - a[0];
            int diffB = b[1] - b[0];
            return diffB - diffA;
        });

        int initialEnergy = 0;
        int currentEnergy = 0;

        for (int[] task : tasks) {
            int actual = task[0];
            int minimum = task[1];

            if (currentEnergy < minimum) {
                int needed = minimum - currentEnergy;
                initialEnergy += needed;
                currentEnergy += needed;
            }

            currentEnergy -= actual;
        }

        return initialEnergy;
    }
}