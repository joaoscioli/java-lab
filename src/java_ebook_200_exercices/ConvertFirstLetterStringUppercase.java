package java_ebook_200_exercices;

import java.util.Scanner;

public class ConvertFirstLetterStringUppercase {

    /// # ConvertFirstLetterStringUppercase
    ///
    /// This program capitalizes the **first letter** of a given string.
    ///
    /// ## Features
    /// - Prompts the user to enter a string.
    /// - Converts only the **first character** of the string to uppercase.
    /// - Leaves the rest of the string unchanged.
    /// - Validates input to ensure the string is not empty.
    ///
    /// ## Example
    /// ```
    /// Enter a string: hello world
    /// Original String: hello world
    /// String with First Letter Uppercase: Hello world
    /// ```
    ///
    /// ## How It Works
    /// 1. Reads the input string and trims whitespace.
    /// 2. Verifies the input is not empty.
    /// 3. Calls `capitalizeFirstLetter()` to:
    ///     - Take the first character and convert it to uppercase.
    ///     - Append the rest of the original string unchanged.
    /// 4. Prints both the original and modified strings.
    ///
    /// ## Notes
    /// - The program does **not** alter casing of any characters beyond the first.
    /// - If the string starts with a non-letter character, it remains unchanged.
    /// - Empty strings are rejected with a validation message.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for a string
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine().trim(); // Remove trailing newline

        // Check if input is a valid string
        if (!inputString.isEmpty()) {

            // Capitalize the first letter
            String resultString = capitalizeFirstLetter(inputString);

            // Display the result
            System.out.println("Original String: " + inputString);
            System.out.println("String with First Letter Uppercase: " + resultString);
        } else {
            System.out.println("Please enter a valid string.");
        }
        scanner.close();
    }

    /// Capitalizes the first letter of a string, leaving the rest unchanged.
    ///
    /// @param s the input string
    /// @return a string with the first character in uppercase (if present)
    private static String capitalizeFirstLetter(String s) {
        if (s.isEmpty()) {
            return s; // Return the original string if it's empty
        }

        // Capitalize the first character and append the rest of the string
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}
