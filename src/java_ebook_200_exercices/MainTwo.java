package java_ebook_200_exercices;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MainTwo {

    /// ### findIntersection
    ///
    /// Finds the intersection between two integer arrays.
    ///
    /// This method converts the first array into a `HashSet` for efficient
    /// membership testing, then iterates through the second array to collect
    /// all numbers that also exist in the first one.
    ///
    /// #### Parameters
    /// - `arr1` — the first array of integers.
    /// - `arr2` — the second array of integers.
    ///
    /// #### Returns
    /// A `List<Integer>` containing the common elements (intersection)
    /// between the two arrays.
    ///
    /// #### Example
    /// ```java
    /// int[] arr1 = {1, 2, 3, 4, 5};
    /// int[] arr2 = {3, 4, 5, 6, 7};
    /// List<Integer> intersection = findIntersection(arr1, arr2);
    /// // Output: [3, 4, 5]
    /// ```
    ///
    /// #### Complexity
    /// - **Time Complexity:** O(n + m), where *n* is the size of `arr1` and *m* is the size of `arr2`.
    /// - **Space Complexity:** O(n), due to the HashSet storage.
    public static List<Integer> findIntersection(int[] arr1, int[] arr2) {

        // Convert the first array into a HashSet for efficient membership testing
        HashSet<Integer> set1 = new HashSet<>();
        for (int num : arr1) {
            set1.add(num);
        }

        // Use a List to collect the intersection
        List<Integer> intersection = new ArrayList<>();

        for (int num : arr2) {
            if (set1.contains(num)) {
                intersection.add(num);
            }
        }
        return intersection;
    }

    /// ### main
    ///
    /// Demonstrates the use of the `findIntersection` method.
    ///
    /// Creates two integer arrays, computes their intersection,
    /// and prints the result to the console.
    ///
    /// #### Output
    /// ```
    /// Intersection of Arrays: [3, 4, 5]
    /// ```
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 6, 7};

        List<Integer> intersection = findIntersection(arr1, arr2);
        System.out.println("Intersection of Arrays: " + intersection);
    }
}
