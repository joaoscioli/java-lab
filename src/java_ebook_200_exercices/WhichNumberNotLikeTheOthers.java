package java_ebook_200_exercices;

import java.util.HashMap;
import java.util.Map;

public class WhichNumberNotLikeTheOthers {
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

        // If no unique number is found, returning 0 (as a fallback)
        return 0; // You may want to handle this case differently
    }

    static void main() {
        int[] numbers1 = {3, 3, 3, 7, 3, 3};
        int[] numbers2 = {0, 0, 77, 0, 0};
        int[] numbers3 = {0, 1, 1, 1, 1, 1, 1, 1};

        System.out.println("Unique number in array 1: " + unique(numbers1)); // Output: 7
        System.out.println("Unique number in array 2: " + unique(numbers2)); // Output: 77
        System.out.println("Unique number in array 3: " + unique(numbers3)); // Output: 0
    }
}
