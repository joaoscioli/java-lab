package java_ebook_200_exercices;

import java.util.Arrays;
import java.util.HashSet;

public class FindUnionTwoArrays {

    /// ## `findUnion(T[] arr1, T[] arr2)`
    ///
    /// Returns the **union** of two arrays as a `HashSet`.
    ///
    /// The method uses Java generics to work with any reference type.
    /// It combines the elements from both arrays and eliminates duplicates
    /// by leveraging the properties of the `HashSet` collection.
    ///
    /// ### Parameters
    /// - `arr1`: The first array of type `T`.
    /// - `arr2`: The second array of type `T`.
    ///
    /// ### Returns
    /// - A `HashSet<T>` containing all unique elements from both arrays.
    ///
    /// ### Example
    /// ```java
    /// Integer[] array1 = {1, 2, 3, 4, 5};
    /// Integer[] array2 = {3, 4, 5, 6, 7};
    ///
    /// HashSet<Integer> unionResult = FindUnionTwoArrays.findUnion(array1, array2);
    /// System.out.println("Union of Arrays: " + unionResult);
    /// // Output: Union of Arrays: [1, 2, 3, 4, 5, 6, 7]
    /// ```
    public static <T> HashSet<T> findUnion(T[] arr1, T[] arr2) {

        // Create a HashSet to store the union of both arrays
        HashSet<T> unionSet = new HashSet<>();

        // Insert elements of both arrays into the HashSet
        unionSet.addAll(Arrays.asList(arr1));
        unionSet.addAll(Arrays.asList(arr2));
        return unionSet;
    }

    /// ## `main(String[] args)`
    ///
    /// Demonstrates the use of the `findUnion` method with two `Integer` arrays.
    /// Prints the union result to the console.
    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 3, 4, 5};
        Integer[] array2 = {3, 4, 5, 6, 7};

        // Get the union of both arrays
        HashSet<Integer> unionResult = findUnion(array1, array2);

        // Display the result
        System.out.println("Union of Arrays: " + unionResult);
    }
}
