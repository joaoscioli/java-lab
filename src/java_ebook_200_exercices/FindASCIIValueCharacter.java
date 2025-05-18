package java_ebook_200_exercices;

import java.util.Scanner;

public class FindASCIIValueCharacter {

    /// # FindASCIIValueCharacter
    ///
    /// This program reads a **single character** from the user and displays its **ASCII value**.
    ///
    /// ## Features
    /// - Prompts the user to enter a single character.
    /// - Converts the character to its corresponding ASCII (integer) value.
    /// - Validates the input to ensure only one character is provided.
    ///
    /// ## Example
    /// ```
    /// Enter a character: a
    /// The ASCII value of 'a' is: 97
    /// ```
    ///
    /// ## Notes
    /// - If the user enters more than one character or an empty string, a warning is displayed.
    /// - ASCII values are derived by casting the `char` to `int` in Java.
    ///
    /// ## How it works
    /// - Input is trimmed and validated to ensure it has length 1.
    /// - If valid, the character is converted to an integer using `(int) character`.
    /// - Otherwise, the program notifies the user that the input is invalid.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a character: ");
        String input = scanner.nextLine().trim();

        if (input.length() == 1) {
            char character = input.charAt(0);
            int asciiValue = (int) character; // Convert character to ASCII value
            System.out.println("The ASCII value of '" + character + "' is: " + asciiValue);
        } else {
            System.out.println("Please enter a valid single character.");
        }
        scanner.close();
    }
}
