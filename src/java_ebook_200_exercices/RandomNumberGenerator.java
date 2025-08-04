package java_ebook_200_exercices;

import java.util.Random;

/// # RandomNumberGenerator
///
/// This class provides functionality to generate a random integer
/// within a specified range using Java's `Random` class.
///
/// ## Example
/// ```java
/// int number = RandomNumberGenerator.getRandomNumber(1, 100);
/// System.out.println("Random Number: " + number);
/// ```
///
public class RandomNumberGenerator {

    /// The program entry point.
    ///
    /// Generates a random number between 1 and 100 and prints it to the console.
    ///
    /// @param args the command-line arguments (not used)
    public static void main(String[] args) {
        int minVal = 1;
        int maxVal = 100;
        int randomNum = getRandomNumber(minVal, maxVal); // Generate a random number between 1 and 100
        System.out.println("Random Number: " + randomNum);
    }

    /// Generates a random integer within the given range `[minVal, maxVal]` (inclusive).
    ///
    /// This method creates a new `Random` instance and uses `nextInt(bound)` to generate
    /// a number between the minimum and maximum values provided.
    ///
    /// @param minVal the minimum value of the range (inclusive)
    /// @param maxVal the maximum value of the range (inclusive)
    /// @return a random integer between `minVal` and `maxVal`
    ///
    /// ## Throws
    /// - `IllegalArgumentException` if `minVal > maxVal`
    ///
    /// ## Example
    /// ```java
    /// int num = RandomNumberGenerator.getRandomNumber(10, 50);
    /// ```
    public static int getRandomNumber(int minVal, int maxVal) {
        if (minVal > maxVal) {
            throw new IllegalArgumentException("minVal must be less than or equal to maxVal.");
        }
        Random rand = new Random(); // Create a Random object
        return rand.nextInt(maxVal - minVal + 1) + minVal; // Generate a random number in the range [minVal, maxVal]
    }
}
