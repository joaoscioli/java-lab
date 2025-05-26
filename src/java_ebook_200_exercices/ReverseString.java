package java_ebook_200_exercices;

import java.util.Scanner;

class ReverseString {

    /// # ReverseString
    ///
    /// This program reads a string from the user and displays its **reversed** form.
    ///
    /// ## Features
    /// - Prompts the user to enter a string.
    /// - Reverses the string using `StringBuilder.reverse()`.
    /// - Validates the input to ensure it is not empty.
    ///
    /// ## Example
    /// ```
    /// Enter a string: Hello, World!
    /// Reversed String: !dlroW ,olleH
    /// ```
    ///
    /// ## How It Works
    /// 1. The user inputs a string.
    /// 2. The program checks that the string is not empty.
    /// 3. It uses `StringBuilder` to reverse the string efficiently.
    /// 4. The reversed string is printed to the console.
    ///
    /// ## Notes
    /// - Input is trimmed using `String.trim()` to remove leading/trailing whitespace.
    /// - If the input is empty, the user is notified and the operation is aborted.
    /// - The reversal is **character-based**, preserving punctuation, spacing, and letter casing.
    static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine().trim(); // Remove trailing newline

        if (!inputString.isEmpty()) {
            String reversedString = new StringBuilder(inputString).reverse().toString();
            System.out.println("Reversed String: " + reversedString);
        } else {
            System.out.println("Please enter a valid string.");
        }

        scanner.close();
    }
}
