package java_ebook_200_exercices;

import java.util.Scanner;
/// # AddTwoNumbers
///
/// This program prompts the user to enter two numbers, performs an addition,
/// and displays the result. It uses a `Scanner` object to read user input and
/// includes error handling to ensure valid numerical input.
///
/// ## Example Usage
/// ```
/// Enter the first number: 5.5
/// Enter the second number: 4.5
/// The sum of 5.50 and 4.50 is: 10.00
/// ```
///
public class AddTwoNumbers {
    /// Main method that executes the program.
    ///
    /// - Reads two numbers from the user.
    /// - Performs an addition operation.
    /// - Displays the result.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        // Created a scanner object for user input
        Scanner scanner = new Scanner(System.in);
        // Read numbers from user
        double num1 = readNumber(scanner, "Enter the first number: ");
        double num2 = readNumber(scanner, "Enter the second number: ");
        // Perform the addition
        double sumResult = num1 + num2;
        System.out.printf("The sum of %.2f and %.2f is: %.2f%n",  num1, num2, sumResult);
        scanner.close();
    }

    /// Reads a valid double number from user input.
    ///
    /// This method continuously prompts the user until a valid number is entered.
    ///
    /// @param scanner The `Scanner` object for reading input.
    /// @param prompt The message displayed to the user before input.
    /// @return A valid double number entered by the user.
    private static double readNumber(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                // Try to parse the input to a double
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
    }
}
