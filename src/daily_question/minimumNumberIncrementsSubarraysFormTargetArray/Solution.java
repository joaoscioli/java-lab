package daily_question.minimumNumberIncrementsSubarraysFormTargetArray;

/// # Minimum Number of Increments on Subarrays to Form a Target Array
///
/// You are given an integer array `target`.
/// You start with an integer array `initial` of the same size, where all elements are initially **0**.
///
/// In one operation, you can choose any **contiguous subarray** from `initial` and increment each
/// element in that subarray by **1**.
///
/// The goal is to determine the **minimum number of operations** required to transform
/// `initial` into `target`.
///
/// ## 🧩 Key Insight
/// - Each time `target[i]` is **greater** than `target[i - 1]`, it means new increments must start
///   at index `i`.
/// - Therefore, only **positive increases** between consecutive elements matter.
///
/// The total operations can be computed as:
/// ```java
/// operations = target[0] + Σ(max(target[i] - target[i - 1], 0))
/// ```
///
/// ## 🕒 Time Complexity
/// - **O(n)** — single pass through the array.
///
/// ## 💾 Space Complexity
/// - **O(1)** — constant extra memory.
///
/// ## ✅ Example 1
/// ```java
/// Input:  target = [1, 2, 3, 2, 1]
/// Output: 3
/// Explanation:
/// [0,0,0,0,0] -> [1,1,1,1,1]
///              -> [1,2,2,2,1]
///              -> [1,2,3,2,1]
/// ```
///
/// ## ✅ Example 2
/// ```java
/// Input:  target = [3, 1, 1, 2]
/// Output: 4
/// Explanation:
/// [0,0,0,0] -> [1,1,1,1]
///             -> [1,1,1,2]
///             -> [2,1,1,2]
///             -> [3,1,1,2]
/// ```
///
/// ## ✅ Example 3
/// ```java
/// Input:  target = [3, 1, 5, 4, 2]
/// Output: 7
/// Explanation:
/// [0,0,0,0,0] -> [1,1,1,1,1]
///              -> [2,1,1,1,1]
///              -> [3,1,1,1,1]
///              -> [3,1,2,2,2]
///              -> [3,1,3,3,2]
///              -> [3,1,4,4,2]
///              -> [3,1,5,4,2]
/// ```
///
/// ## Constraints
/// - 1 <= target.length <= 100,000
/// - 1 <= target[i] <= 100,000
public class Solution {

    /// Calculates the minimum number of operations required to transform
    /// an initial zero array into the given `target` array.
    ///
    /// @param target The desired integer array.
    /// @return The minimum number of operations to reach the target.
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
