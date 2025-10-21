package java_ebook_200_exercices;

import java.util.Arrays;

public class FindMedianArray {
    public static double findMedian(int[] arr) {

        // Check if the list is valid
        if (arr.length == 0) {
            throw new IllegalArgumentException("Invalid input. Please provide a non-empty list.");
        }

        // Sort the array
        Arrays.sort(arr);
        int len = arr.length;
        int middleIndex = len / 2;

        // Calculate the median
        if (len % 2 == 0) {
            // If the list has an even number of elements, return the average of the two middle elements
            return (arr[middleIndex - 1] + arr[middleIndex]) / 2.0;
        } else {
            // If the list has an odd number of elements, return the middle element
            return arr[middleIndex];
        }
    }

    public static void main(String[] args) {
        int[] numbers = {5, 2, 8, 1, 7, 3};
        double median = findMedian(numbers);
        System.out.printf("Median: %.1f%n", median);
    }
}

// Output: Median: 4.0
