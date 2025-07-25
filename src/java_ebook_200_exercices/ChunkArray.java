package java_ebook_200_exercices;

import java.util.ArrayList;
import java.util.List;

public class ChunkArray {

    /// Splits a list into smaller sublists (chunks) of a specified maximum size.
    ///
    /// This method takes a list and divides it into consecutive sublists,
    /// each containing up to `chunkSize` elements. The final chunk may contain
    /// fewer elements if the total number of elements is not evenly divisible by `chunkSize`.
    ///
    /// ### Type Parameters
    /// - `T`: The type of elements in the input list.
    ///
    /// ### Parameters
    /// - `array`: The input list to be chunked.
    /// - `chunkSize`: The maximum number of elements per chunk.
    ///
    /// ### Returns
    /// A list of lists, where each inner list is a chunk of the original list.
    ///
    /// ### Example
    /// ```java
    /// List<Integer> myArray = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    /// List<List<Integer>> chunks = chunkArray(myArray, 3);
    /// System.out.println(chunks);
    /// // Output: [[1, 2, 3], [4, 5, 6], [7, 8, 9], [10]]
    /// ```
    public static <T> List<List<T>> chunkArray(List<T> array, int chunkSize) {
        List<List<T>> chunks = new ArrayList<>();
        for (int i = 0; i < array.size(); i += chunkSize) {
            int end = Math.min(i + chunkSize, array.size());
            chunks.add(new ArrayList<>(array.subList(i, end)));
        }
        return chunks;
    }

    /// Demonstrates how to use the `chunkArray` method with a sample list of integers.
    ///
    /// This method creates a list of integers from 1 to 10 and splits it into chunks
    /// of size 3. It then prints the original array and the resulting chunks.
    void main() {
        // Example array
        List<Integer> myArray = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Split the array into chunks of size 3
        List<List<Integer>> chunks = chunkArray(myArray, 3);

        // Display the result
        System.out.println("Original Array: " + myArray);
        System.out.println("Chunks: " + chunks);
    }
}
