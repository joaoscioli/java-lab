package daily_question.robotCollisions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {

    /// ### survivedRobotsHealths
    ///
    /// Simulates collisions between robots moving along a 1D line and returns
    /// the health values of the surviving robots in their original input order.
    ///
    /// ---
    ///
    /// ### 🧠 Problem Overview
    ///
    /// Each robot has:
    /// - A unique position on a line
    /// - An initial health value
    /// - A movement direction:
    ///   - `'R'` → moving right
    ///   - `'L'` → moving left
    ///
    /// All robots move simultaneously at the same speed.
    ///
    /// ---
    ///
    /// ### 💥 Collision Rules
    ///
    /// When two robots collide:
    ///
    /// - The robot with **lower health is removed**
    /// - The surviving robot's health is **decreased by 1**
    /// - If both have the **same health**, both are removed
    ///
    /// The surviving robot continues moving in the same direction.
    ///
    /// ---
    ///
    /// ### ⚙️ Approach
    ///
    /// 1. **Sort robots by position** using an index array
    ///    - This ensures collisions are processed in spatial order
    ///
    /// 2. **Use a stack to track right-moving robots (`R`)**
    ///
    /// 3. **Process robots in sorted order**
    ///    - If the robot is moving right → push onto the stack
    ///    - If moving left → resolve collisions with stack robots
    ///
    /// 4. **Handle collisions iteratively**
    ///    - Continue while:
    ///      - There are right-moving robots in the stack
    ///      - The current robot is still alive
    ///
    /// 5. **Collect survivors**
    ///    - Only robots with health > 0 are included
    ///    - Returned in original input order
    ///
    /// ---
    ///
    /// ### ⏱️ Time Complexity
    ///
    /// - Sorting: `O(n log n)`
    /// - Collision processing: `O(n)`
    /// - Overall: `O(n log n)`
    ///
    /// ---
    ///
    /// ### 📦 Space Complexity
    ///
    /// - `O(n)` for indices array and stack
    ///
    /// ---
    ///
    /// ### 📥 Parameters
    ///
    /// - `positions` → array of unique robot positions
    /// - `healths` → array of robot health values
    /// - `directions` → string representing movement directions
    ///
    /// ---
    ///
    /// ### 📤 Returns
    ///
    /// - A list of integers representing the healths of surviving robots
    /// - Preserves the original input order
    ///
    /// ---
    ///
    /// ### ⚠️ Notes
    ///
    /// - The `healths` array is modified in-place during simulation
    /// - Only robots moving in opposite directions (`R` vs `L`) can collide
    /// - Multiple sequential collisions (chain reactions) are handled via loop
    ///
    public List<Integer> survivedRobotsHealths(
            int[] positions,
            int[] healths,
            String directions
    ) {
        int n = positions.length;
        Integer[] indices = new Integer[n];
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        /// Initialize indices array to preserve original ordering
        for (int index = 0; index < n; ++index) {
            indices[index] = index;
        }

        /// Sort indices based on robot positions
        Arrays.sort(
                indices,
                (lhs, rhs) -> Integer.compare(positions[lhs], positions[rhs])
        );

        /// Process robots in order of increasing position
        for (int currentIndex : indices) {

            /// If moving right, store for future collisions
            if (directions.charAt(currentIndex) == 'R') {
                stack.push(currentIndex);

            } else {
                /// If moving left, resolve collisions with right-moving robots
                while (!stack.isEmpty() && healths[currentIndex] > 0) {
                    int topIndex = stack.pop();

                    /// Case 1: Right robot is stronger
                    if (healths[topIndex] > healths[currentIndex]) {
                        healths[topIndex] -= 1;
                        healths[currentIndex] = 0;
                        stack.push(topIndex);

                        /// Case 2: Left robot is stronger
                    } else if (healths[topIndex] < healths[currentIndex]) {
                        healths[currentIndex] -= 1;
                        healths[topIndex] = 0;

                        /// Case 3: Equal health → both destroyed
                    } else {
                        healths[currentIndex] = 0;
                        healths[topIndex] = 0;
                    }
                }
            }
        }

        /// Collect surviving robots (health > 0) in original order
        for (int index = 0; index < n; ++index) {
            if (healths[index] > 0) {
                result.add(healths[index]);
            }
        }

        return result;
    }
}