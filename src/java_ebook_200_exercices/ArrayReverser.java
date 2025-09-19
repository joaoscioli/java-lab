package java_ebook_200_exercices;

import java.util.Arrays;

public class ArrayReverser {

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

    static void main() {
        int[] originalArray = {1, 2, 3, 4, 5};
        int[] reversedArray = originalArray.clone(); // Clone the original array
        reverseArray(reversedArray);    // Reverse the cloned array
        System.out.println("Original Array: " + Arrays.toString(originalArray));
        System.out.println("Reversed Array: " + Arrays.toString(reversedArray));
    }
}

// Output:
// Original Array: [1, 2, 3, 4, 5]
// Reversed Array: [5, 4, 3, 2, 1]
