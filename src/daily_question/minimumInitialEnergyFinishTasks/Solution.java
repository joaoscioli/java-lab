package daily_question.minimumInitialEnergyFinishTasks;

import java.util.Arrays;

/// Provides a solution for calculating the minimum initial energy required to
/// finish all given tasks.
///
/// Each task is represented by an integer array with two values:
///
/// - `task[0]`: the actual energy consumed to complete the task.
/// - `task[1]`: the minimum energy required before starting the task.
///
/// The algorithm sorts the tasks in descending order by the difference
/// `minimum - actual`. This greedy ordering prioritizes tasks that require a
/// larger energy buffer, which helps minimize the total initial energy needed.
class Solution {

    /// Returns the minimum initial energy required to complete all tasks.
    ///
    /// The method assumes each task is represented as an array of two integers:
    ///
    /// - `tasks[i][0]` is the actual energy cost of completing the task.
    /// - `tasks[i][1]` is the minimum energy required before the task can start.
    ///
    /// The tasks are first sorted by the difference between their minimum
    /// required energy and their actual energy cost, in descending order.
    /// After sorting, the method simulates completing each task while increasing
    /// the initial energy only when the current available energy is below the
    /// task's minimum requirement.
    ///
    /// @param tasks a two-dimensional array where each task contains the actual
    ///              energy cost and the minimum required energy
    /// @return the minimum initial energy required to complete all tasks
    ///
    /// @implSpec
    /// This implementation modifies the input array by sorting it in place.
    ///
    /// @apiNote
    /// The greedy strategy works because tasks with a larger difference between
    /// minimum required energy and actual energy cost should be performed earlier
    /// to reduce the amount of extra initial energy needed later.
    ///
    /// @implNote
    /// The time complexity is `O(n log n)` due to sorting, where `n` is the
    /// number of tasks. The additional space complexity is `O(1)`, excluding the
    /// space used internally by the sorting implementation.
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