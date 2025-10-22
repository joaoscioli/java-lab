package java_ebook_200_exercices;

import java.util.Arrays;

/// # FindMedianArray
///
/// This class provides a utility method to calculate the **median** value of an integer array.
/// The median represents the middle value in a sorted list of numbers —
/// or the average of the two middle numbers when the list has an even length.
///
/// ## Example
/// ```java
/// int[] numbers = {5, 2, 8, 1, 7, 3};
/// double median = FindMedianArray.findMedian(numbers);
/// System.out.printf("Median: %.1f%n", median);
/// ```
/// **Output:**
/// ```text
/// Median: 4.0
/// ```
///
/// ## Author
/// Great Designer Software
public class FindMedianArray {

    /// ## findMedian
    ///
    /// Calculates the median value from the given integer array.
    ///
    /// The method performs the following steps:
    /// 1. Validates that the array is not empty.
    /// 2. Sorts the array in ascending order.
    /// 3. Determines the middle index.
    /// 4. Returns the middle value if the length is odd, or the average of the two middle values if even.
    ///
    /// ### Parameters
    /// - `arr` — an integer array containing the elements to analyze.
    ///
    /// ### Returns
    /// - A `double` representing the **median** of the array.
    ///
    /// ### Throws
    /// - `IllegalArgumentException` if the array is empty.
    ///
    /// ### Example
    /// ```java
    /// int[] arr = {1, 3, 2};
    /// double median = FindMedianArray.findMedian(arr);
    /// System.out.println(median); // 2.0
    /// ```
    public static double findMedian(int[] arr) {

        // Check if the list is valid
        if (arr.length == 0) {
            throw new IllegalArgumentException("Invalid input. Please provide a non-empty list.");
        }

        // Sort the array
        Arrays.sort(arr);
        int len = arr.length;
        int middleIndex = len / 2;

        // Calculate the median
        if (len % 2 == 0) {
            // If the list has an even number of elements, return the average of the two middle elements
            return (arr[middleIndex - 1] + arr[middleIndex]) / 2.0;
        } else {
            // If the list has an odd number of elements, return the middle element
            return arr[middleIndex];
        }
    }

    /// ## main
    ///
    /// Demonstrates the usage of the `findMedian` method by calculating
    /// and printing the median of a predefined integer array.
    ///
    /// ### Example
    /// ```java
    /// // Output:
    /// // Median: 4.0
    /// ```
    public static void main(String[] args) {
        int[] numbers = {5, 2, 8, 1, 7, 3};
        double median = findMedian(numbers);
        System.out.printf("Median: %.1f%n", median);
    }
}
