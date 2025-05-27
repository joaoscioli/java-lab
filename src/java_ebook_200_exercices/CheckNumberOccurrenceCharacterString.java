package java_ebook_200_exercices;

import java.util.Scanner;

public class CheckNumberOccurrenceCharacterString {
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
/*
    Enter a string: Hello, World!
    Enter the character to count: o
    Number of occurrences of 'o' in 'Hello, World!': 2
*/
