package daily_question.makeArrayElementsEqualZero;

import java.util.*;

/// # Solution — Make Array Elements Equal to Zero
///
/// This class provides a solution to the **"Make Array Elements Equal to Zero"** problem,
/// where the objective is to determine how many valid starting positions and movement
/// directions can reduce all array elements to zero following a specific set of rules.
///
/// ## Problem Description
/// You are given an integer array `nums`.
///
/// You must start from a position `curr` where `nums[curr] == 0`, and choose a movement
/// direction — either **left (-1)** or **right (+1)**. Then, repeatedly perform the following process:
///
/// 1. If `curr` is **out of bounds**, the process ends.
/// 2. If `nums[curr] == 0`, move in the current direction (increment or decrement `curr`).
/// 3. Otherwise:
///    - Decrease `nums[curr]` by 1.
///    - Reverse the direction (multiply by `-1`).
///    - Move one step in the new direction.
///
/// After this process, the goal is to verify whether **all elements in the array become zero**.
/// The method returns how many valid starting positions (and directions) can achieve that.
///
/// ## Example
/// ```java
/// int[] nums = {1, 0, 2, 0, 3};
/// int result = Solution.countValidSelections(nums);
/// System.out.println(result); // 2
/// ```
///
/// **Output:**
/// ```text
/// Output: 2
/// ```
///
/// ## Algorithm Overview
/// 1. Iterate over all indices where `nums[i] == 0`.
/// 2. For each zero index, simulate the process twice:
///    - Once moving **right** (`+1`).
///    - Once moving **left** (`-1`).
/// 3. After each simulation, check whether all elements were reduced to zero.
/// 4. Count the number of valid simulations.
///
/// ## Time Complexity
/// - **O(n²)** — due to repeated simulations per zero element.
/// - **O(n)** extra space — for array copies during simulation.
///
/// @since 1.0
public class Solution {

    /// Counts how many valid starting positions and directions can make all array elements equal to zero.
    ///
    /// ## Parameters
    /// - `nums`: The input integer array representing the state of the elements.
    ///
    /// ## Returns
    /// - The number of valid selections (starting positions and directions)
    ///   that can transform all elements into zero.
    ///
    /// ## Example
    /// ```java
    /// int[] nums = {1, 0, 2, 0, 3};
    /// int result = Solution.countValidSelections(nums);
    /// System.out.println(result); // 2
    /// ```
    public static int countValidSelections(int[] nums) {
        int n = nums.length;
        int validCount = 0;

        // Traverse all indices that contain zero
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                // Test moving to the right (+1)
                if (simulate(Arrays.copyOf(nums, n), i, 1)) {
                    validCount++;
                }
                // Test moving to the left (-1)
                if (simulate(Arrays.copyOf(nums, n), i, -1)) {
                    validCount++;
                }
            }
        }

        return validCount;
    }

    /// Simulates the process of moving through the array and decrementing elements according to the rules.
    ///
    /// ## Parameters
    /// - `arr`: The current state of the array to simulate on.
    /// - `start`: The starting index where the process begins.
    /// - `direction`: The initial movement direction (`+1` for right, `-1` for left).
    ///
    /// ## Returns
    /// - `true` if all elements become zero after the simulation.
    /// - `false` otherwise.
    ///
    /// ## Example
    /// ```java
    /// int[] arr = {1, 0, 2, 0, 3};
    /// boolean result = simulate(arr, 1, 1);
    /// System.out.println(result); // true or false depending on simulation outcome
    /// ```
    private static boolean simulate(int[] arr, int start, int direction) {
        int n = arr.length;
        int curr = start;

        while (curr >= 0 && curr < n) {
            if (arr[curr] == 0) {
                curr += direction;
            } else {
                arr[curr]--;
                direction = -direction;
                curr += direction;
            }
        }

        // Verify if all elements are zero
        for (int num : arr) {
            if (num != 0) return false;
        }

        return true;
    }

    /// Demonstrates the usage of the `countValidSelections` method.
    ///
    /// This method runs two sample test cases and prints the total number of valid selections.
    ///
    /// **Example Output:**
    /// ```text
    /// Output: 2
    /// Output: 0
    /// ```
    public static void main(String[] args) {
        int[] nums1 = {1, 0, 2, 0, 3};
        System.out.println("Output: " + countValidSelections(nums1)); // Output: 2

        int[] nums2 = {2, 3, 4, 0, 4, 1, 0};
        System.out.println("Output: " + countValidSelections(nums2)); // Output: 0
    }
}
