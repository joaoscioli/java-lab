package java_ebook_200_exercices;

import java.util.Scanner;

public class CheckWhetherStringPalindrome {
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

    // Function to clean the string by removing non-alphanumeric characters and converting to lowercase
    private static String cleanString(String str) {
        StringBuilder cleaned = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }
        return cleaned.toString();
    }

    // Function to check if a string is a palindrome
    private static boolean isPalindrome(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        return s.equals(reversed);
    }
}
// Enter a string: A man, a plan, a canal, Panama!
// "A man, a plan, a canal, Panama!"
