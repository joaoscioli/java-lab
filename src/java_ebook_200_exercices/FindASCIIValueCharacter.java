package java_ebook_200_exercices;

import java.util.Scanner;

public class FindASCIIValueCharacter {
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

// Enter a character: a
// The ASCII value of 'a' is: 97