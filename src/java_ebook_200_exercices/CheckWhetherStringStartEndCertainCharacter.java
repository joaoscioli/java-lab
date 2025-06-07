package java_ebook_200_exercices;

import java.util.Scanner;

public class CheckWhetherStringStartEndCertainCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for a string
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine().trim(); // Remove trailing newline

        // Check if input is a valid string
        if (inputString.isEmpty()) {
            System.out.println("Please enter a valid string.");
            return;
        }

        String startChar = promptUser("Enter the starting characters: ");
        String endChar = promptUser("Enter the ending characters: ");

        // Check if the string starts and ends with the specified characters
        if (inputString.startsWith(startChar) && inputString.endsWith(endChar)) {
            System.out.printf("The string '%s' starts with '%s' and ends with '%s'.%n", inputString, startChar, endChar);
        } else {
            System.out.printf("The string '%s' does not start with '%s' or end with '%s'.%n", inputString, startChar, endChar);
        }
        scanner.close();
    }

    // Method to prompt user for input
    private static String promptUser(String message) {
        System.out.print(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }
}

// Enter a string: asd
// Enter the starting characters: a
// Enter the ending characters: d
// The string 'asd' starts with 'a' and ends with 'd'.