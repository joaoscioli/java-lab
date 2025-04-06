package java_ebook_200_exercices;

import java.util.Scanner;

public class CheckPrimeNumber {

    /// # CheckPrimeNumber
    ///
    /// This program checks whether a given integer is a **prime number**.
    ///
    /// A *prime number* is a number greater than 1 that has no divisors other than 1 and itself.
    ///
    /// ## How it works:
    /// - Prompts the user to enter an integer.
    /// - Verifies the input is a valid integer greater than 1.
    /// - Determines if the number is prime using the `isPrime(int)` method.
    /// - Outputs the result to the console.
    ///
    /// ## Example
    /// ```
    /// Enter a number: 33
    /// 33 is not a prime number.
    /// ```
    ///
    /// ## See Also
    /// - [Prime number - Wikipedia](https://en.wikipedia.org/wiki/Prime_number)
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

    /// ### isPrime
    ///
    /// Checks whether a given integer is a **prime number**.
    ///
    /// A number is considered prime if it has no divisors other than 1 and itself.
    ///
    /// @param number the number to check for primality
    /// @return `true` if the number is prime; `false` otherwise
    private static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false; // Found a divisor, not prime
            }
        }
        return true; // No divisors found, is prime
    }
}
