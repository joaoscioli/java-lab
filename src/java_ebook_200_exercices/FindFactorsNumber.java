package java_ebook_200_exercices;

import java.util.Scanner;

public class FindFactorsNumber {

    /// # FindFactorsNumber
    ///
    /// This program finds and displays all the **factors** of a given positive integer.
    ///
    /// ## Program Steps:
    /// 1. Prompt the user to enter a **positive integer**.
    /// 2. Validate the input to ensure it is a valid positive number.
    /// 3. Call the `findFactors` method to display all numbers that divide the input without remainder.
    ///
    /// ## Definition:
    /// A **factor** of a number is an integer that divides the number evenly (no remainder).
    ///
    /// ## Example:
    /// ```
    /// Enter a positive integer: 44
    /// Factors of 44:
    /// 1
    /// 2
    /// 4
    /// 11
    /// 22
    /// 44
    /// ```
    ///
    /// ## Notes:
    /// - The program uses a loop from 1 to the number to test for divisibility.
    /// - Input is strictly validated to prevent invalid or negative entries.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = readPositiveNumber(scanner, "Enter a positive integer: ");
        System.out.printf("Factors of %d:%n", number);
        findFactors(number);
        scanner.close();
    }

    /// Prompts the user for a positive integer and performs validation.
    ///
    /// @param scanner The `Scanner` object used to read input from the user.
    /// @param prompt The message shown to the user.
    /// @return A valid positive integer.
    private static long readPositiveNumber(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (true) {
            if (scanner.hasNextLong()) {
                long number = scanner.nextLong();
                if (number > 0) {
                    return number;
                } else {
                    System.out.println("Please enter a valid positive integer.");
                }
            } else {
                System.out.println("Please enter a valid positive integer.");
                scanner.next(); // Clear invalid input
            }
            System.out.print(prompt); // Prompt again
        }
    }

    /// Prints all factors of the given positive number.
    ///
    /// @param number The number whose factors will be printed.
    private static void findFactors(long number) {
        for (long i = 1; i <= number; i++) {
            if (number % i == 0) {
                System.out.println(i);
            }
        }
    }
}
