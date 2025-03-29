package java_ebook_200_exercices;

import java.util.Random;
import java.util.Scanner;

/// # GenerateRandomNumber
///
/// This program generates a random number within a user-specified range.
/// It prompts the user for a minimum and maximum value and ensures that the input is valid.
/// If valid, it generates a random number within the given range and displays it.
///
/// ## Example Usage
/// ```
/// Enter the minimum value of the range: 3
/// Enter the maximum value of the range: 4
/// A random number between 3.0 and 4.0 is: 3.990459557841887
/// ```
///

public class GenerateRandomNumber {
    /// Main method that executes the program.
    ///
    /// - Prompts the user for a minimum and maximum value.
    /// - Validates that the minimum is less than the maximum.
    /// - Generates and displays a random number within the specified range.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Prompt user for the range
        System.out.print("Enter the minimum value of the range: ");
        double minRange = scan.nextDouble();
        System.out.print("Enter the maximum value of the range: ");
        double maxRange = scan.nextDouble();
        // Check if input is valid
        if (minRange < maxRange) {
            // Generate a random number within the specified range
            Random random = new Random();
            double randomNumber = minRange + (maxRange - minRange) * random.nextDouble();
            System.out.println("A random number between " + minRange + " and " + maxRange + " is: " + randomNumber);
        } else {
            System.out.println("Please enter valid numbers, ensuring that the minimum value is less than the maximum value.");
        }
    }
}
