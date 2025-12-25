package java_ebook_200_exercices;

import java.util.HashMap;
import java.util.Map;

/// ## WhichNumberNotLikeTheOthers
///
/// Utility class that provides a method to find the **unique number**
/// in an integer array where all other numbers are expected to repeat.
///
/// The algorithm counts the occurrences of each number and returns
/// the one that appears exactly once.
///
/// ### Characteristics
/// - Uses a `HashMap` to count occurrences
/// - Runs in **O(n)** time complexity
/// - Uses **O(n)** extra space
///
/// ### Notes
/// - If no unique number is found, the method returns `0` as a fallback.
/// - This behavior can be adapted depending on business rules.
public class WhichNumberNotLikeTheOthers {

    /// ### unique
    ///
    /// Finds and returns the number that appears **only once**
    /// in the given array of integers.
    ///
    /// #### Algorithm
    /// 1. Iterate over the array and count occurrences using a `Map`
    /// 2. Iterate over the map entries
    /// 3. Return the key whose value (count) is equal to `1`
    ///
    /// #### Parameters
    /// - `numbers` : an array of integers where exactly one number
    ///   is expected to be unique
    ///
    /// #### Returns
    /// - The integer that appears only once
    /// - Returns `0` if no unique number is found
    ///
    /// #### Complexity
    /// - **Time Complexity:** O(n)
    /// - **Space Complexity:** O(n)
    ///
    /// #### Example
    /// ```java
    /// int[] values = {3, 3, 3, 7, 3};
    /// int result = unique(values); // returns 7
    /// ```
    public static int unique(int[] numbers) {
        Map<Integer, Integer> counts = new HashMap<>();

        // Count occurrences of each number
        for (int num : numbers) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        // Find the unique number
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        // If no unique number is found, returning 0 (fallback behavior)
        return 0;
    }

    /// ### main
    ///
    /// Demonstrates the usage of the `unique` method
    /// with different input arrays.
    ///
    /// #### Examples
    /// - `{3, 3, 3, 7, 3, 3}` → `7`
    /// - `{0, 0, 77, 0, 0}` → `77`
    /// - `{0, 1, 1, 1, 1}` → `0`
    static void main() {
        int[] numbers1 = {3, 3, 3, 7, 3, 3};
        int[] numbers2 = {0, 0, 77, 0, 0};
        int[] numbers3 = {0, 1, 1, 1, 1, 1, 1, 1};

        System.out.println("Unique number in array 1: " + unique(numbers1));
        System.out.println("Unique number in array 2: " + unique(numbers2));
        System.out.println("Unique number in array 3: " + unique(numbers3));
    }
}
