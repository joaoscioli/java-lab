package java_ebook_200_exercices;

import java.util.Arrays;

/// # MinElementFinder
///
/// Utility class that provides functionality to find the minimum element in an integer array.
public class MinElementFinder {

    /// Finds the minimum element in the given integer array.
    ///
    /// ## Parameters
    /// - `arr`: the input integer array
    ///
    /// ## Returns
    /// - The minimum element in the array, or `null` if the array is empty.
    ///
    /// ## Notes
    /// - If the array contains only one element, that element will be returned.
    /// - If the array is empty, `null` is returned to indicate no minimum value.
    ///
    /// ## Example
    /// ```java
    /// int[] numbers = {5, 2, 9, 1, 7};
    /// Integer minNumber = MinElementFinder.findMinElement(numbers);
    /// System.out.println(minNumber); // Output: 1
    /// ```
    public static Integer findMinElement(int[] arr) {
        // Check if the array is not empty
        if (arr.length == 0) {
            return null; // Return null for empty array
        }

        // Initialize min with the first element
        int min = arr[0];

        // Loop through the array to find the minimum element
        for (int num : arr) {
            if (num < min) {
                min = num; // Update min if current number is smaller
            }
        }
        return min;
    }

    /// Demonstrates the usage of the `findMinElement` method.
    ///
    /// Prints the list of numbers and its minimum element.
    ///
    /// ## Example Output
    /// ```
    /// List: [5, 2, 9, 1, 7]
    /// Minimum Element: 1
    /// ```
    public static void main(String[] args) {
        int[] numbers = {5, 2, 9, 1, 7};
        Integer minNumber = findMinElement(numbers);

        if (minNumber != null) {
            System.out.println("List: " + Arrays.toString(numbers));
            System.out.println("Minimum Element: " + minNumber);
        } else {
            System.out.println("Empty list");
        }
    }
}
