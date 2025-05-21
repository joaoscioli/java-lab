package java_ebook_200_exercices;

import java.util.Arrays;
import java.util.Scanner;

public class SortWordsAlphabeticalOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for a sentence or a list of words
        System.out.print("Enter a sentence or a list of words: ");
        String input = scanner.nextLine().trim();

        // Split the input into an array of words
        String[] wordsList = input.split("\\s+");

        // Sort the array of words in alphabetical order
        Arrays.sort(wordsList);

        // Display the sorted words
        System.out.println("Sorted Words:");
        System.out.println(String.join(", ", wordsList));
        scanner.close();
    }
}

// Enter a sentence or a list of words: ad d dwqdwq qw qwd sadasd wqdwq
// Sorted Words:
// ad, d, dwqdwq, qw, qwd, sadasd, wqdwq
