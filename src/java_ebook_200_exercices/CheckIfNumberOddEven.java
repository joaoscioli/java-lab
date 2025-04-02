package java_ebook_200_exercices;

import java.util.Scanner;

/// # CheckIfNumberOddEven
///
/// This program checks whether a given integer is odd or even.
/// The user is prompted to enter a number, and the program evaluates its parity.
///
/// ## Example Usage
/// ```
/// Enter a number: 3
/// 3 is an odd number
/// ```
///

public class CheckIfNumberOddEven {
    /// Main method that executes the program.
    ///
    /// - Prompts the user to enter an integer.
    /// - Validates and reads the input as an integer.
    /// - Determines if the number is odd or even and prints the result.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        // Prompt user for a number
        System.out.print("Enter a number: ");
        Scanner scan = new Scanner(System.in);
        // Try to read the input as an integer
        if (scan.hasNextInt()) {
            int number = scan.nextInt();
            // Check if the number is odd or even
            if (number % 2 == 0) {
                System.out.println(number + " is an even number");
            } else {
                System.out.println(number + " is an odd number");
            }
        } else {
            System.out.println("Please enter a valid number");
        }
        scan.close();
    }
}
