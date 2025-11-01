package daily_question.TheTwoSneakyNumbersDigitville;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/// # The Two Sneaky Numbers of Digitville
///
/// In the town of Digitville, there was a list of numbers called `nums` containing integers from `0` to `n - 1`.
/// Each number was supposed to appear **exactly once** in the list. However, two mischievous numbers appeared **twice**.
///
/// The task is to find these two sneaky numbers and return them as an array.
///
/// ## Example
/// ```java
/// Input: nums = [0, 1, 2, 3, 2, 1]
/// Output: [1, 2]
/// ```
///
/// In this example, numbers `1` and `2` appear twice, so they are the sneaky numbers.
///
/// ## Approach
/// 1. Use a **HashMap** to count the frequency of each number.
/// 2. Iterate through the map to find numbers that appear more than once.
/// 3. Store these numbers in a list and return them as an array.
///
/// ## Complexity Analysis
/// - **Time Complexity:** O(n), where *n* is the length of the input array.
///   Each number is processed once to count frequencies and once to identify duplicates.
/// - **Space Complexity:** O(n), due to the use of a HashMap to store frequencies.
///
/// ## Returns
/// - An integer array containing the two numbers that appear more than once.
///
/// ## Notes
/// - The input always contains **exactly two duplicated numbers**.
/// - The order of the returned numbers corresponds to the order they are found.
///
/// ---
public class Solution {

    /// Finds the two sneaky (duplicate) numbers in the given array.
    ///
    /// @param nums the input array containing integers from `0` to `n - 1`,
    ///             where exactly two numbers appear twice
    /// @return an array of two integers that appear more than once in `nums`
    public int[] getSneakyNumbers(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();
        List<Integer> duplicates = new ArrayList<>();

        // Count the frequency of each number
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        // Collect numbers that appear more than once
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() > 1) duplicates.add(entry.getKey());
        }

        // Convert the list of duplicates to an array
        return new int[]{duplicates.get(0), duplicates.get(1)};
    }
}
