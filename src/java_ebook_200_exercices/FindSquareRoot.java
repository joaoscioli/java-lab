package java_ebook_200_exercices;

import java.util.Scanner;

/// # FindSquareRoot
///
/// This program prompts the user to enter a non-negative number, calculates its square root,
/// and displays the result. It ensures valid input handling to avoid errors.
///
/// ## Example Usage
/// ```
/// Enter a non-negative number: 3
/// The square root of 3.0 is: 1.7320508075688772
/// ```
///

public class FindSquareRoot {
    /// Reads a non-negative number from the user input.
    ///
    /// This method continuously prompts the user until a valid non-negative number is entered.
    ///
    /// @param prompt The message displayed to the user before input.
    /// @return A valid non-negative double number entered by the user.
    public static double readNumber(String prompt) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                // Attempt to parse the input to double
                double number = Double.parseDouble(input);
                if (number >= 0) {
                    return number;
                } else {
                    System.out.println("Please enter a non-negative number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    /// Main method that executes the program.
    ///
    /// - Reads a non-negative number from the user.
    /// - Calculates the square root of the number.
    /// - Displays the result.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        // Read a number from the user
        double inputNumber = readNumber("Enter a non-negative number: ");
        // Calculate the square root
        double squareRoot = Math.sqrt(inputNumber);
        System.out.println("The square root of " + inputNumber + " is: " + squareRoot);
    }
}
