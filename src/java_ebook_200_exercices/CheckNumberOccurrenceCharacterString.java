package java_ebook_200_exercices;

import java.util.Scanner;

public class CheckNumberOccurrenceCharacterString {

    /// # CheckNumberOccurrenceCharacterString
    ///
    /// This program counts how many times a **specific character** appears in a given string.
    ///
    /// ## Features
    /// - Prompts the user to enter a string.
    /// - Prompts the user to enter a **single character** to count.
    /// - Validates input for correctness.
    /// - Uses the Java Stream API to efficiently count character occurrences.
    ///
    /// ## Example
    /// ```
    /// Enter a string: Hello, World!
    /// Enter the character to count: o
    /// Number of occurrences of 'o' in 'Hello, World!': 2
    /// ```
    ///
    /// ## How It Works
    /// 1. Receives a non-empty string from the user.
    /// 2. Receives a second input and validates it as a single character.
    /// 3. Uses `String.chars()` to convert the string into an `IntStream`.
    /// 4. Filters the stream to count how many times the target character appears.
    /// 5. Outputs the result using formatted printing.
    ///
    /// ## Notes
    /// - The input character must be a single character string (e.g., "a", not "abc").
    /// - The program is **case-sensitive**, meaning 'A' and 'a' are treated differently.
    /// - Whitespace, punctuation, and symbols are counted as valid characters.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for a string
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine().trim(); // Remove trailing newline

        // Prompt user for a character to count
        System.out.print("Enter the character to count: ");
        String targetChar = scanner.nextLine().trim(); // Remove trailing newline

        // Check if inputs are valid
        if (!inputString.isEmpty() && targetChar.length() == 1) {
            // Count occurrences of the target character
            long count = inputString.chars()
                    .filter(c -> c == targetChar.charAt(0))
                    .count();

            // Display the result
            System.out.printf("Number of occurrences of '%s' in '%s': %d%n", targetChar, inputString, count);
        } else {
            System.out.println("Please enter a valid string and a single character.");
        }
        scanner.close();
    }
}
