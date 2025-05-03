package java_ebook_200_exercices;

import java.util.Scanner;

public class FindSumNaturalNumbersUsingRecursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = readPositiveNumber(scanner, "Enter a positive integer: ");
        // Display the sum using recursion
        System.out.printf("The sum of natural numbers up to %d is: %d%n", number, sumNaturalNumbers(number));
        scanner.close();
    }

    // Recursive function to calculate the sum of natural numbers
    private static long sumNaturalNumbers(long n) {
        if (n == 0) {
            return 0;
        } else {
            return n + sumNaturalNumbers(n - 1); // Recursive call to calculate the sum of natural numbers up to n - 1
        }
    }

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

// Enter a positive integer: 33
// The sum of natural numbers up to 33 is: 561