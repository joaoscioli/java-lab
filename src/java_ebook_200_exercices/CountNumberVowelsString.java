package java_ebook_200_exercices;

import java.util.Scanner;

public class CountNumberVowelsString {

    /// # CountNumberVowelsString
    ///
    /// This program counts the number of **vowels** in a given input string.
    ///
    /// ## Features
    /// - Prompts the user to input a string.
    /// - Counts all vowel characters: `a`, `e`, `i`, `o`, `u` (both lowercase and uppercase).
    /// - Displays the total number of vowels found in the input.
    /// - Validates the input to ensure it is not empty.
    ///
    /// ## Example
    /// ```
    /// Enter a string: asd
    /// Number of vowels in 'asd': 1
    /// ```
    ///
    /// ## How It Works
    /// 1. The user is prompted to enter a string.
    /// 2. The `countVowels` method:
    ///     - Converts the string to a character stream.
    ///     - Filters characters that match any vowel (`a`, `e`, `i`, `o`, `u`, and their uppercase versions).
    ///     - Counts the filtered characters and returns the total.
    /// 3. The result is printed.
    ///
    /// ## Notes
    /// - The program uses `String.chars()` and a lambda with `filter()` to count vowels efficiently.
    /// - Input is trimmed to remove leading/trailing whitespace.
    /// - If an empty string is entered, the program displays a validation message.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for a string
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine().trim(); // Remove trailing newline

        // Check if input is a valid string
        if (!inputString.isEmpty()) {
            // Call the function and display the result
            int numberOfVowels = countVowels(inputString);
            System.out.println("Number of vowels in '" + inputString + "': " + numberOfVowels);
        } else {
            System.out.println("Please enter a valid string.");
        }
        scanner.close();
    }

    /// ## How It Works
    /// 1. The user is prompted to enter a string.
    /// 2. The `countVowels` method:
    ///     - Converts the string to a character stream.
    ///     - Filters characters that match any vowel (`a`, `e`, `i`, `o`, `u`, and their uppercase versions).
    ///     - Counts the filtered characters and returns the total.
    /// 3. The result is printed.
    ///
    /// ## Notes
    /// - The program uses `String.chars()` and a lambda with `filter()` to count vowels efficiently.
    /// - Input is trimmed to remove leading/trailing whitespace.
    /// - If an empty string is entered, the program displays a validation message.

    /// Counts the number of vowels in a string (both uppercase and lowercase).
    ///
    /// @param s the input string to analyze
    /// @return the number of vowel characters in the string
    private static int countVowels(String s) {
        String vowels = "aeiouAEIOU";
        return (int) s.chars()
                .filter(c -> vowels.indexOf(c) != -1) // Check if the character is a vowel
                .count();
    }
}
