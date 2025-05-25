package java_ebook_200_exercices;

import java.util.Scanner;

class ReverseString {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for a string
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine().trim(); // Remove trailing newline

        // Check if input is a valid string
        if (!inputString.isEmpty()) {
            // Reverse the string
            String reversedString = new StringBuilder(inputString).reverse().toString();

            // Display the reversed string
            System.out.println("Reversed String: " + reversedString);
        } else {
            System.out.println("Please enter a valid string.");
        }
        scanner.close();
    }
}
/*
    Enter a string: Hello, World!
    Reversed String: !dlroW ,olleH
*/
