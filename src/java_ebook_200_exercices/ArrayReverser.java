package java_ebook_200_exercices;

import java.util.Arrays;

/// # ArrayReverser
///
/// A utility class that provides functionality to reverse arrays of integers.
///
/// ## Overview
/// The `ArrayReverser` class contains a static method `reverseArray(int[])`
/// that reverses the order of elements in an integer array in-place.
/// It also includes a demonstration method `main()` to show its usage.
///
/// ## Example
/// ```java
/// int[] arr = {1, 2, 3, 4, 5};
/// ArrayReverser.reverseArray(arr);
/// System.out.println(Arrays.toString(arr)); // Output: [5, 4, 3, 2, 1]
/// ```
public class ArrayReverser {

    /// Reverses the given integer array in-place.
    ///
    /// ## Parameters
    /// - `arr`: The integer array to be reversed.
    ///
    /// ## Behavior
    /// The method uses two pointers (`left` and `right`) that move towards
    /// each other, swapping elements until the array is fully reversed.
    ///
    /// ## Example
    /// ```java
    /// int[] data = {10, 20, 30};
    /// ArrayReverser.reverseArray(data);
    /// System.out.println(Arrays.toString(data)); // [30, 20, 10]
    /// ```
    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        // Swap elements until the pointers meet
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    /// Demonstrates the usage of the `reverseArray` method.
    ///
    /// ## Output
    /// ```
    /// Original Array: [1, 2, 3, 4, 5]
    /// Reversed Array: [5, 4, 3, 2, 1]
    /// ```
    static void main() {
        int[] originalArray = {1, 2, 3, 4, 5};
        int[] reversedArray = originalArray.clone(); // Clone the original array
        reverseArray(reversedArray);    // Reverse the cloned array
        System.out.println("Original Array: " + Arrays.toString(originalArray));
        System.out.println("Reversed Array: " + Arrays.toString(reversedArray));
    }
}
