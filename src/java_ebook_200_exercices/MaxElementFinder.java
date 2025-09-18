package java_ebook_200_exercices;

import java.util.Arrays;

/// # MaxElementFinder
///
/// Utility class that provides a method to find the maximum element in an integer array.
///
/// ## Features
/// - Returns the maximum element in a given integer array.
/// - Handles empty arrays by returning `null`.
///
/// ## Example
/// ```java
/// int[] numbers = {5, 2, 9, 1, 7};
/// Integer maxNumber = MaxElementFinder.findMaxElement(numbers);
///
/// if (maxNumber != null) {
///     System.out.println("Maximum Element: " + maxNumber);
/// } else {
///     System.out.println("Empty array");
/// }
/// ```
///
/// ### Output
/// ```text
/// Maximum Element: 9
/// ```
public class MaxElementFinder {

    /// Finds the maximum element in the given integer array.
    ///
    /// ## Parameters
    /// - `arr`: the array of integers to search.
    ///
    /// ## Returns
    /// - The maximum element in the array, or `null` if the array is empty.
    ///
    /// ## Throws
    /// - Does not throw exceptions explicitly, but calling with `null` will result
    ///   in a `NullPointerException`.
    public static Integer findMaxElement(int[] arr) {
        // Check if the array is not empty
        if (arr.length == 0) {
            return null;  // Return null if the array is empty
        }
        int max = arr[0];   // Initialize max with the first element
        for (int num : arr) {
            if (num > max) {
                max = num;  // Update max if a larger number is found
            }
        }
        return max;  // Return the maximum element found
    }

    /// Demonstrates the usage of `findMaxElement` with a sample array.
    ///
    /// ## Example
    /// ```java
    /// int[] numbers = {5, 2, 9, 1, 7};
    /// Integer maxNumber = MaxElementFinder.findMaxElement(numbers);
    /// System.out.println("Maximum Element: " + maxNumber);
    /// ```
    ///
    /// ### Output
    /// ```text
    /// Array: [5, 2, 9, 1, 7]
    /// Maximum Element: 9
    /// ```
    public static void main(String[] args) {
        int[] numbers = {5, 2, 9, 1, 7};
        Integer maxNumber = findMaxElement(numbers);

        if (maxNumber != null) {
            System.out.println("Array: " + Arrays.toString(numbers));
            System.out.println("Maximum Element: " + maxNumber);
        } else {
            System.out.println("Empty array");
        }
    }
}
