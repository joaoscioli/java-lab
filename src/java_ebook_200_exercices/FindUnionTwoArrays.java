package java_ebook_200_exercices;

import java.util.Arrays;
import java.util.HashSet;

public class FindUnionTwoArrays {
    public static <T> HashSet<T> findUnion(T[] arr1, T[] arr2) {

        // Create a HashSet to store the union of both arrays
        HashSet<T> unionSet = new HashSet<>();

        // Insert elements of both arrays into the HashSet
        unionSet.addAll(Arrays.asList(arr1));
        unionSet.addAll(Arrays.asList(arr2));
        return unionSet;
    }

    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 3, 4, 5};
        Integer[] array2 = {3, 4, 5, 6, 7};

        // Get the union of both arrays
        HashSet<Integer> unionResult = findUnion(array1, array2);

        // Display the result
        System.out.println("Union of Arrays: " + unionResult);
    }
}

// Output: Union of Arrays: [1, 2, 3, 4, 5, 6, 7]

