package java_ebook_200_exercices;

import java.util.Scanner;

public class ReplaceCharactersString {

    /// # ReplaceCharactersString
    ///
    /// This program allows the user to **replace all occurrences** of a character in a string with another character.
    ///
    /// ## Features
    /// - Prompts the user to enter a string.
    /// - Asks for a **target character** to be replaced.
    /// - Asks for a **replacement character**.
    /// - Replaces all occurrences of the target character with the replacement character.
    /// - Validates input to ensure both characters are single characters.
    ///
    /// ## Example
    /// ```
    /// Enter a string: Hello World!
    /// Enter the target character: o
    /// Enter the replacement character: a
    /// Modified String: Hella Warld!
    /// ```
    ///
    /// ## How it works
    /// 1. Captures the original string from user input.
    /// 2. Prompts for a target and replacement character.
    /// 3. Uses `String.replace()` to perform the replacement.
    /// 4. Outputs the modified string.
    ///
    /// ## Notes
    /// - The program uses `String.replace(String target, String replacement)`, which replaces **all** matches.
    /// - Only single-character inputs are accepted for target and replacement; otherwise, the operation is aborted.
    /// - Input validation ensures the string is not empty.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for a string
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine().trim();

        if (inputString.isEmpty()) {
            System.out.println("Please enter a valid string.");
            return;
        }

        // Get target and replacement characters
        String targetChar = promptUser(scanner, "Enter the target character: ");
        String replacementChar = promptUser(scanner, "Enter the replacement character: ");

        if (targetChar.length() == 1 && replacementChar.length() == 1) {
            // Replace occurrences of targetChar with replacementChar in inputString
            String modifiedString = inputString.replace(targetChar, replacementChar);
            System.out.println("Modified String: " + modifiedString);
        } else {
            System.out.println("Please enter valid single characters for target and replacement.");
        }
        scanner.close();
    }

    /// Prompts the user with a custom message and returns the trimmed response.
    ///
    /// @param scanner the `Scanner` object used for input
    /// @param message the message to display to the user
    /// @return the trimmed user input as a `String`
    private static String promptUser(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }
}
