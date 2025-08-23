package java_ebook_200_exercices;

import java.util.Arrays;

/// # ImageReverser
///
/// Utility class for working with binary images represented as 2D arrays of integers.
/// A binary image is composed of pixels with values `0` (white) or `1` (black).
///
/// This class provides methods to reverse the pixel values of a binary image:
/// - `1` becomes `0`
/// - `0` becomes `1`
public class ImageReverser {

    /// ## reverseImage
    ///
    /// Reverses the pixel values of a binary image represented as a 2D array.
    /// Each pixel is inverted: `1 -> 0` and `0 -> 1`.
    ///
    /// ### Parameters
    /// - `image` : A two-dimensional array of integers representing the binary image.
    ///
    /// ### Returns
    /// - A new two-dimensional array of integers with inverted pixel values.
    ///
    /// ### Example
    /// ```java
    /// int[][] image = {
    ///     {1, 0, 0},
    ///     {0, 1, 0},
    ///     {0, 0, 1}
    /// };
    ///
    /// int[][] reversed = ImageReverser.reverseImage(image);
    /// // reversed ➞ [[0, 1, 1], [1, 0, 1], [1, 1, 0]]
    /// ```
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

    /// ## main
    ///
    /// Demonstrates the usage of the `reverseImage` method with multiple examples.
    ///
    /// ### Examples
    /// ```java
    /// // Example 1
    /// int[][] image1 = {
    ///     {1, 0, 0},
    ///     {0, 1, 0},
    ///     {0, 0, 1}
    /// };
    /// int[][] reversed1 = reverseImage(image1);
    /// System.out.println(Arrays.deepToString(reversed1));
    /// // Output: [[0, 1, 1], [1, 0, 1], [1, 1, 0]]
    ///
    /// // Example 2
    /// int[][] image2 = {
    ///     {1, 1, 1},
    ///     {0, 0, 0}
    /// };
    /// int[][] reversed2 = reverseImage(image2);
    /// System.out.println(Arrays.deepToString(reversed2));
    /// // Output: [[0, 0, 0], [1, 1, 1]]
    ///
    /// // Example 3
    /// int[][] image3 = {
    ///     {1, 0, 0},
    ///     {1, 0, 0}
    /// };
    /// int[][] reversed3 = reverseImage(image3);
    /// System.out.println(Arrays.deepToString(reversed3));
    /// // Output: [[0, 1, 1], [0, 1, 1]]
    /// ```
    public static void main(String[] args) {
        int[][] image1 = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };

        int[][] reversed1 = reverseImage(image1);
        System.out.println(Arrays.deepToString(reversed1));

        int[][] image2 = {
                {1, 1, 1},
                {0, 0, 0}
        };

        int[][] reversed2 = reverseImage(image2);
        System.out.println(Arrays.deepToString(reversed2));

        int[][] image3 = {
                {1, 0, 0},
                {1, 0, 0}
        };

        int[][] reversed3 = reverseImage(image3);
        System.out.println(Arrays.deepToString(reversed3));
    }
}
