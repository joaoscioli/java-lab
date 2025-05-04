package java_ebook_200_exercices;

import java.util.Scanner;

public class FindSumNaturalNumbersUsingRecursion {

    /// # FindSumNaturalNumbersUsingRecursion
    ///
    /// This program calculates the **sum of the first _n_ natural numbers** using a recursive method.
    ///
    /// ## Program Flow:
    /// 1. Prompts the user to enter a **positive integer**.
    /// 2. Validates the input.
    /// 3. Calls a **recursive function** to compute the sum of natural numbers up to the entered number.
    /// 4. Prints the result to the console.
    ///
    /// ## Recursive Formula:
    /// ```
    /// sum(n) = n + sum(n - 1)
    /// sum(0) = 0
    /// ```
    ///
    /// ## Example:
    /// ```
    /// Enter a positive integer: 33
    /// The sum of natural numbers up to 33 is: 561
    /// ```
    ///
    /// ## Notes:
    /// - Natural numbers are defined as the sequence: 1, 2, 3, ...
    /// - Recursion is used to illustrate the breakdown of a problem into smaller subproblems.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = readPositiveNumber(scanner, "Enter a positive integer: ");
        // Display the sum using recursion
        System.out.printf("The sum of natural numbers up to %d is: %d%n", number, sumNaturalNumbers(number));
        scanner.close();
    }

    /// Calculates the sum of the first `n` natural numbers using recursion.
    ///
    /// @param n A positive integer.
    /// @return The sum from 1 to `n`.
    private static long sumNaturalNumbers(long n) {
        if (n == 0) {
            return 0;
        } else {
            return n + sumNaturalNumbers(n - 1); // Recursive call to calculate sum up to n - 1
        }
    }

    /// Prompts the user for a valid positive integer and validates input.
    ///
    /// @param scanner The `Scanner` object used for input.
    /// @param prompt The text prompt shown to the user.
    /// @return A positive long value entered by the user.
    private static long readPositiveNumber(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (true) {
            if (scanner.hasNextLong()) {
                long number = scanner.nextLong();
                if (number > 0) {
                    return number;
                } else {
                    System.out.println("Please enter a positive integer.");
                }
            } else {
                System.out.println("Please enter a positive integer.");
                scanner.next(); // Clear invalid input
            }
            System.out.print(prompt);   // Prompt again
        }
    }
}
