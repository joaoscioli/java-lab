package java_ebook_200_exercices;

import java.util.Arrays;
import java.util.Scanner;

public class SortWordsAlphabeticalOrder {

    /// # SortWordsAlphabeticalOrder
    ///
    /// This program reads a sentence or a list of words from user input and sorts them in **alphabetical order**.
    ///
    /// ## Features
    /// - Accepts a full sentence or a space-separated list of words.
    /// - Splits the input string into individual words.
    /// - Sorts the words in ascending alphabetical order.
    /// - Displays the sorted list, separated by commas.
    ///
    /// ## Example
    /// ```
    /// Enter a sentence or a list of words: ad d dwqdwq qw qwd sadasd wqdwq
    /// Sorted Words:
    /// ad, d, dwqdwq, qw, qwd, sadasd, wqdwq
    /// ```
    ///
    /// ## How it works
    /// 1. Uses `Scanner` to capture input from the user.
    /// 2. Splits the string by whitespace using the regular expression `\\s+`.
    /// 3. Uses `Arrays.sort()` to perform the alphabetical sorting.
    /// 4. Prints the result using `String.join()`.
    ///
    /// ## Notes
    /// - Sorting is case-sensitive by default. Capital letters come before lowercase.
    /// - You may want to normalize case for case-insensitive sorting.
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
