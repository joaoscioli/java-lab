package java_ebook_200_exercices;

import java.util.Scanner;

public class ConvertFirstLetterStringUppercase {
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

    // Function to capitalize the first letter of a string
    private static String capitalizeFirstLetter(String s) {
        if (s.isEmpty()) {
            return s; // Return the original string if it's empty
        }

        // Capitalize the first character and append the rest of the string
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}

/*
      Enter a string: hello world
      Original String: hello world
      String with First Letter Uppercase: Hello world
*/
