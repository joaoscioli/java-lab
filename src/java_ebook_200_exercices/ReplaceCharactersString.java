package java_ebook_200_exercices;

import java.util.Scanner;

public class ReplaceCharactersString {
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

    private static String promptUser(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }
}

/*
      Enter a string: Hello World!
      Enter the target character: o
      Enter the replacement character: a
      Modified String: Hella Warld!
*/
