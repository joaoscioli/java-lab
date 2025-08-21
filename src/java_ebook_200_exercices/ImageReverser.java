package java_ebook_200_exercices;

import java.util.Arrays;

public class ImageReverser {
    // Method to reverse a binary image
    public static int[][] reverseImage(int[][] image) {
        int[][] reversedImage = new int[image.length][];

        for (int i = 0; i < image.length; i++) {
            reversedImage[i] = new int[image[i].length];
            for (int j = 0; j < image[i].length; j++) {
                // Reverse pixel (1 -> 0, 0 -> 1)
                reversedImage[i][j] = 1 - image[i][j];
            }
        }
        return reversedImage;
    }

    public static void main(String[] args) {

        // Example 1
        int[][] image1 = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };

        int[][] reversed1 = reverseImage(image1);
        System.out.println(Arrays.deepToString(reversed1));

        // ➞ [[0, 1, 1], [1, 0, 1], [1, 1, 0]]
        // Example 2
        int[][] image2 = {
                {1, 1, 1},
                {0, 0, 0}
        };

        int[][] reversed2 = reverseImage(image2);
        System.out.println(Arrays.deepToString(reversed2));

        // ➞ [[0, 0, 0], [1, 1, 1]]
        // Example 3
        int[][] image3 = {
                {1, 0, 0},
                {1, 0, 0}
        };

        int[][] reversed3 = reverseImage(image3);
        System.out.println(Arrays.deepToString(reversed3));
        // ➞ [[0, 1, 1], [0, 1, 1]]
    }
}