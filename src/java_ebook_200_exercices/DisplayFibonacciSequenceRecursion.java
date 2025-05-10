package java_ebook_200_exercices;

import java.util.Scanner;

public class DisplayFibonacciSequenceRecursion {

    /// # DisplayFibonacciSequenceRecursion
    ///
    /// This program displays the **Fibonacci sequence** up to a specified number of terms using **recursion**.
    ///
    /// ## Overview
    /// - Prompts the user to enter a non-negative integer representing the number of Fibonacci terms to display.
    /// - Uses a recursive method to compute each Fibonacci number.
    /// - Outputs the Fibonacci sequence to the console.
    ///
    /// ## What is the Fibonacci sequence?
    /// The Fibonacci sequence is a series where each number is the sum of the two preceding ones:
    ///
    /// ```
    /// 0, 1, 1, 2, 3, 5, 8, ...
    /// ```
    ///
    /// ## Example Usage
    /// ```
    /// Enter the number of terms in the Fibonacci sequence: 5
    /// Fibonacci sequence of: 5 terms:
    /// 0
    /// 1
    /// 1
    /// 2
    /// 3
    /// ```
    ///
    /// ## Performance Note
    /// This implementation uses **naive recursion**, which is **inefficient for large values** due to repeated subproblem computation.
    /// For better performance, consider using **memoization** or an **iterative approach** for large inputs.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms in the Fibonacci sequence: ");
        int numTerms = scanner.nextInt();
        if (numTerms < 0) {
            System.out.println("Please enter a valid non-negative integer.");
            return;
        }

        System.out.println("Fibonacci sequence of: " + numTerms + " terms: ");
        for (int i = 0; i < numTerms; i++) {
            System.out.println(fibonacci(i));
        }
    }

    /// Recursively calculates the nth Fibonacci number.
    ///
    /// @param n The index (0-based) of the Fibonacci term to compute.
    /// @return The nth term in the Fibonacci sequence.
    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
