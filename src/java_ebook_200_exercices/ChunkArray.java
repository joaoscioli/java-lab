package java_ebook_200_exercices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChunkArray {

    public static <T> List<List<T>> chunkArray(List<T> array, int chunkSize) {
        List<List<T>> chunks = new ArrayList<>();
        for (int i = 0; i < array.size(); i+= chunkSize) {
            int end = Math.min(i + chunkSize, array.size());
            chunks.add(new ArrayList<>(array.subList(i, end)));
        }
        return chunks;
    }

    static void main() {
        // Example array
        List<Integer> myArray = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Split the array into chunks of size 3
        List<List<Integer>> chunks = chunkArray(myArray, 3);

        // Display the result
        System.out.println("Original array: " + myArray);
        System.out.println("Chunk: " + chunks);
    }
}

/*
* Original Array: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
* Chunks: [[1, 2, 3], [4, 5, 6], [7, 8, 9], [10]]
* */