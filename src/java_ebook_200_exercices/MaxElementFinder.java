package java_ebook_200_exercices;

import java.util.Arrays;

public class MaxElementFinder {
    public static Integer findMaxElement(int[] arr) {
        // Check if the array is not empty
        if (arr.length == 0) {
            return null;  // Return null if the array is empty
        }
        int max = arr[0];   // Initialize max with the first element
        for (int num : arr) {
            if (num > max) {
                max = num;  // Update max if a larger number is found
            }
        }
        return max;  // Return the maximum element found
    }

    public static void main(String[] args) {
        int[] numbers = {5, 2, 9, 1, 7};
        Integer maxNumber = findMaxElement(numbers);

        if (maxNumber != null) {
            System.out.println("Array: " + Arrays.toString(numbers));
            System.out.println("Maximum Element: " + maxNumber);
        } else {
            System.out.println("Empty array");
        }
    }
}

// Output:
// Array: [5, 2, 9, 1, 7]
// Maximum Element: 9
