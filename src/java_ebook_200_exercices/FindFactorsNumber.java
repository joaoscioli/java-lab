package java_ebook_200_exercices;

import java.util.Scanner;

public class FindFactorsNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = readPositiveNumber(scanner, "Enter a positive integer: ");
        System.out.printf("Factors of %d:%n: ", number);
        findFactors(number);
        scanner.close();
    }

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

    private static void findFactors(long number) {
        for (long i = 1; i <= number; i++) {
            if (number % i == 0) {
                System.out.println(i);
            }
        }
    }
}

// Enter a positive integer: 44
// Factors of 44:
// 1
// 2
// 4
// 11
// 22
// 44
