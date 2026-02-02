package daily_question.minimumPairRemovalToSortArrayI;

import java.util.ArrayList;
import java.util.List;

/// ## Solution
///
/// Solves the **Minimum Pair Removal to Sort Array I** problem.
///
/// The operation consists of:
/// - selecting two **adjacent elements**
/// - removing them
/// - inserting their **sum** back into the same position
///
/// The process is repeated until the array becomes **non-decreasing**.
///
/// This implementation uses a **brute-force greedy approach**
/// and is intended for smaller inputs.
class Solution {

    /// ### minimumPairRemoval
    ///
    /// Computes the minimum number of operations required to make
    /// the array non-decreasing.
    ///
    /// #### Algorithm
    /// 1. Convert the input array into a dynamic list.
    /// 2. While the list is not non-decreasing:
    ///    - Find the adjacent pair with the **minimum sum**.
    ///    - Replace the pair with their sum.
    ///    - Increment the operation counter.
    ///
    /// #### Characteristics
    /// - Simple and intuitive implementation.
    /// - Recomputes the minimum pair at each iteration.
    /// - Suitable for educational purposes and small constraints.
    ///
    /// #### Complexity
    /// - **Time Complexity:** `O(n³)` in the worst case
    /// - **Space Complexity:** `O(n)`
    ///
    /// @param nums the input array of integers
    /// @return the minimum number of operations required
    public int minimumPairRemoval(int[] nums) {

        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            list.add(n);
        }

        int operations = 0;

        // Repeat until the array becomes non-decreasing
        while (!isNonDecreasing(list)) {

            int minSum = Integer.MAX_VALUE;
            int index = 0;

            // Find the adjacent pair with the smallest sum
            for (int i = 0; i < list.size() - 1; i++) {
                int sum = list.get(i) + list.get(i + 1);
                if (sum < minSum) {
                    minSum = sum;
                    index = i;
                }
            }

            // Replace the pair with their sum
            list.set(index, minSum);
            list.remove(index + 1);

            operations++;
        }

        return operations;
    }

    /// ### isNonDecreasing
    ///
    /// Checks whether the list is in non-decreasing order.
    ///
    /// #### Definition
    /// A list is non-decreasing if:
    /// `list[i] >= list[i - 1]` for all valid indices.
    ///
    /// @param list the list of integers to check
    /// @return `true` if the list is non-decreasing, otherwise `false`
    private boolean isNonDecreasing(List<Integer> list) {

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }

        return true;
    }
}
