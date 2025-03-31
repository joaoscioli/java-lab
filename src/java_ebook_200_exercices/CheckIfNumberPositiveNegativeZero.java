package java_ebook_200_exercices;

import java.util.Scanner;

/// # CheckIfNumberPositiveNegativeZero
///
/// This program checks whether a given number is positive, negative, or zero.
/// The user is prompted to enter a number, and the program evaluates its sign.
///
/// ## Example Usage
/// ```
/// Enter a number: 3
/// 3.0 is a positive number.
/// ```
///

public class CheckIfNumberPositiveNegativeZero {
    /// Main method that executes the program.
    ///
    /// - Prompts the user to enter a number.
    /// - Validates and reads the input as a floating-point number.
    /// - Determines if the number is positive, negative, or zero and prints the result.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        // Prompt user for a number
        System.out.print("Enter a number: ");
        Scanner scanner = new Scanner(System.in);
        // Try to read the input as a floating-point number
        if (scanner.hasNextDouble()) {
            double number = scanner.nextDouble();
            // Check if the number is positive, negative, or zero
            if (number > 0.0) {
                System.out.println(number + " is a positive number.");
            } else if (number < 0.0) {
                System.out.println(number + " is a negative number.");
            } else {
                System.out.println("The entered number is zero.");
            }
        } else {
            System.out.println("Please enter a valid number.");
        }
        scanner.close();
    }
}
