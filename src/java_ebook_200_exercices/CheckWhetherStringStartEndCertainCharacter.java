package java_ebook_200_exercices;

import java.util.Scanner;

/// # CheckWhetherStringStartEndCertainCharacter
/// This program reads a string from the user and checks whether it starts and ends with specific characters.
///
/// ## Usage
/// The program prompts the user to:
/// 1. Enter a string.
/// 2. Enter the starting characters to check.
/// 3. Enter the ending characters to check.
///
/// It then verifies if the string starts with the given prefix and ends with the given suffix, displaying the result accordingly.
public class CheckWhetherStringStartEndCertainCharacter {

    /// The program entry point.
    ///
    /// Prompts the user to input a string, a starting substring, and an ending substring. Then,
    /// checks if the input string starts and ends with the given values, printing the result.
    ///
    /// Example:
    /// ```
    /// Enter a string: hello
    /// Enter the starting characters: he
    /// Enter the ending characters: lo
    /// The string 'hello' starts with 'he' and ends with 'lo'.
    /// ```
    ///
    /// If the input string is empty, a warning message is printed and the program exits early.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine().trim();

        if (inputString.isEmpty()) {
            System.out.println("Please enter a valid string.");
            return;
        }

        String startChar = promptUser("Enter the starting characters: ");
        String endChar = promptUser("Enter the ending characters: ");

        if (inputString.startsWith(startChar) && inputString.endsWith(endChar)) {
            System.out.printf("The string '%s' starts with '%s' and ends with '%s'.%n", inputString, startChar, endChar);
        } else {
            System.out.printf("The string '%s' does not start with '%s' or end with '%s'.%n", inputString, startChar, endChar);
        }

        scanner.close();
    }

    /// Prompts the user with a custom message and returns the trimmed input string.
    ///
    /// @param message the prompt message to display
    /// @return the trimmed user input
    private static String promptUser(String message) {
        System.out.print(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }
}
