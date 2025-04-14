package java_ebook_200_exercices;

import java.util.Scanner;

public class PrintFibonacciSequence {

    /// # PrintFibonacciSequence
    ///
    /// This program prints the **Fibonacci sequence** up to a number of terms specified by the user.
    ///
    /// ## How the program works:
    /// - Prompts the user to enter the number of terms.
    /// - Validates that the input is a **positive integer**.
    /// - Uses an array to store and compute the Fibonacci numbers:
    ///   - First term is 0.
    ///   - Second term is 1.
    ///   - Remaining terms are computed using the formula:
    ///     ```
    ///     fib[i] = fib[i - 1] + fib[i - 2]
    ///     ```
    /// - Prints the sequence separated by commas.
    ///
    /// ## Example
    /// ```
    /// Enter the number of terms in the Fibonacci sequence: 5
    /// Fibonacci Sequence: 0, 1, 1, 2, 3
    /// ```
    ///
    /// ## Input Validation
    /// If the user enters a non-integer or a non-positive number, the program will prompt again
    /// or display a validation message.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms in the Fibonacci sequence: ");

        // Validate input
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid positive integer.");
            scanner.next(); // Clear invalid input
            System.out.print("Enter the number of terms in the Fibonacci sequence: ");
        }

        int numTerms = scanner.nextInt();
        if (numTerms <= 0) {
            System.out.println("Please enter a positive integer.");
            scanner.close();
            return;
        }

        // Generate Fibonacci sequence
        long[] fib = new long[numTerms];
        if (numTerms > 0) fib[0] = 0;   // First term
        if (numTerms > 1) fib[1] = 1;   // Second term
        for (int i = 2; i < numTerms; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];   // Fibonacci formula
        }

        // Print the Fibonacci sequence
        System.out.print("Fibonacci Sequence: ");
        for (int i = 0; i < numTerms; i++) {
            System.out.print(fib[i]);
            if (i < numTerms - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        scanner.close();
    }
}