package java_ebook_200_exercices;

import java.util.Scanner;

public class PrintFibonacciSequence {
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
        for (int i = 2; i <= numTerms; i++) {
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

// Enter the number of terms in the Fibonacci sequence: 5
// Fibonacci Sequence: 0, 1, 1, 2, 3