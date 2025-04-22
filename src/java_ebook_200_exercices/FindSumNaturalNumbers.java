package java_ebook_200_exercices;

import java.util.Scanner;

public class FindSumNaturalNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for a positive integer
        System.out.print("Enter a positive integer: ");

        while (!scanner.hasNextLong()) {
            System.out.println("Please enter a valid positive integer.");
            scanner.next(); // Clear invalid input
            System.out.print("Enter a positive integer: ");
        }

        long n = scanner.nextLong();
        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            // Calculate the sum of natural numbers
            long sumOfNaturalNumbers = (n * (n + 1)) / 2;
            System.out.printf("The sum of natural numbers from 1 to %d is: %d%n", n, sumOfNaturalNumbers);
        }
        scanner.close();
    }
}

// Enter a positive integer: 12
// The sum of natural numbers from 1 to 12 is: 78
