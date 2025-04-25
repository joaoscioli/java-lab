package java_ebook_200_exercices;

import java.util.Scanner;

public class CheckIfNumbersHaveSameLastDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num1 = readNumber(scanner, "Enter the first number: ");
        long num2 = readNumber(scanner, "Enter the second number: ");

        if (Math.abs(num1 % 10) == Math.abs(num2 % 10)) {
            System.out.printf("The last digit of %d is the same as last digit of %d%n", num1, num2);
        } else {
            System.out.printf("The last digit of %d is different from the last digit of %d%n", num1, num2);
        }
        scanner.close();
    }

    private static long readNumber(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextLong()) {
            System.out.println("Please enter a valid integer.");
            scanner.next(); // Clear invalid input
            System.out.print(prompt);
        }
        return scanner.nextLong();
    }
}

// Enter the first number: 2
// Enter the second number: 3
// The last digit of 2 is different from the last digit of 3.
