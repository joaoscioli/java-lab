package java_ebook_200_exercices;

import java.util.Arrays;

public class MinElementFinder {
    // Method to find the minimum element in an array
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

// Output:
// List: [5, 2, 9, 1, 7]
// Minimum Element: 1
