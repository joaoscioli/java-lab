package java_ebook_200_exercices;

import java.util.Scanner;

public class CheckWhetherStringPalindrome {

    /// # CheckWhetherStringPalindrome
    ///
    /// This program checks whether a given string is a **palindrome**.
    ///
    /// ## Features
    /// - Accepts a string input from the user.
    /// - Cleans the input by removing non-alphanumeric characters and converting it to lowercase.
    /// - Checks if the cleaned string reads the same forwards and backwards.
    ///
    /// ## What is a Palindrome?
    /// A palindrome is a word, phrase, number, or other sequence of characters that reads the same backward as forward, **ignoring spaces, punctuation, and capitalization**.
    ///
    /// ## Example
    /// ```
    /// Enter a string: A man, a plan, a canal, Panama!
    /// "A man, a plan, a canal, Panama!" is a palindrome.
    /// ```
    ///
    /// ## How it works
    /// - `cleanString`: removes all non-alphanumeric characters and converts the string to lowercase.
    /// - `isPalindrome`: reverses the cleaned string and compares it with the original cleaned version.
    ///
    /// ## Notes
    /// - The comparison is case-insensitive and ignores punctuation or whitespace.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine().trim();
        String cleanedString = cleanString(input);

        if (isPalindrome(cleanedString)) {
            System.out.println("\"" + input + "\" is a palindrome.");
        } else {
            System.out.println("\"" + input + "\" is not a palindrome.");
        }
        scanner.close();
    }

    /// Cleans the string by removing non-alphanumeric characters and converting to lowercase.
    ///
    /// @param str the original input string
    /// @return a cleaned version of the string suitable for palindrome checking
    private static String cleanString(String str) {
        StringBuilder cleaned = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }
        return cleaned.toString();
    }

    /// Checks whether the given string is a palindrome.
    ///
    /// @param s the cleaned string to check
    /// @return true if the string is a palindrome, false otherwise
    private static boolean isPalindrome(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        return s.equals(reversed);
    }
}
