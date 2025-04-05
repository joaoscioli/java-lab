package java_ebook_200_exercices;

import java.util.Scanner;

public class CheckPrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Prompt the user to enter a number
        System.out.print("Enter a number: ");
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            if (number > 1 && isPrime(number)) {
                System.out.printf("%d is a prime number.%n", number);
            } else {
                System.out.printf("%d is not a prime number.%n", number);
            }
        } else {
            System.out.println("Please enter a valid integer greater than 1.");
        }
        scanner.close();
    }

    // Function to check if a number is prime
    private static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false; // Found a divisor, not prime
            }
        }
        return true; // No divisors found, is prime
    }
}
