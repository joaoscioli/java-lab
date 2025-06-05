package java_ebook_200_exercices;

import java.util.Scanner;

public class CountNumberVowelsString {
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

    // Function to count vowels in a string
    private static int countVowels(String s) {
        String vowels = "aeiouAEIOU";
        return (int) s.chars()
                .filter(c -> vowels.indexOf(c) != -1) // Check if the character is a vowel
                .count();
    }
}
// Enter a string: asd
// Number of vowels in 'asd': 1

