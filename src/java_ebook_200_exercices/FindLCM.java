package java_ebook_200_exercices;

import java.util.Scanner;

public class FindLCM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long num1 = readPositiveNumber(scanner, "Enter the first positive integer: ");
        long num2 = readPositiveNumber(scanner, "Enter the second positive integer: ");
        long lcm = (num1 * num2) / gcd(num1, num2);

        System.out.printf("The LCM of %d and %d is: %d%n", num1, num2, lcm);
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

    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

// Enter the first positive integer: 22
// Enter the second positive integer: 22
// The LCM of 22 and 22 is: 22

