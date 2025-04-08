package java_ebook_200_exercices;

import java.util.Scanner;

public class PrintAllPrimeNumbersInterval {

    /// # PrintAllPrimeNumbersInterval
    ///
    /// This program prints all **prime numbers** within a given interval defined by the user.
    ///
    /// ## How it works:
    /// - Prompts the user to enter the **starting** and **ending** numbers of the interval.
    /// - Validates that the start is greater than 1 and less than the end.
    /// - Iterates through the interval and checks if each number is **prime**.
    /// - Prints all prime numbers found in the interval.
    ///
    /// ## Example
    /// ```
    /// Enter the starting number of the interval: 33
    /// Enter the ending number of the interval: 44
    /// Prime numbers in the interval [33 - 44]:
    /// 37
    /// 41
    /// 43
    /// ```
    ///
    /// ## See Also
    /// - [`isPrime(int)`](#isprime)
    /// - [Prime number - Wikipedia](https://en.wikipedia.org/wiki/Prime_number)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read starting number of the interval
        System.out.print("Enter the starting number of the interval: ");
        int start = readInput(scanner);

        // Read ending number of the interval
        System.out.print("Enter the ending number of the interval: ");
        int end = readInput(scanner);

        if (start > 1 && start < end) {
            System.out.printf("Prime numbers in the interval [%d - %d]:%n", start, end);
            for (int n = start; n <= end; n++) {
                if (isPrime(n)) {
                    System.out.println(n);
                }
            }
        } else {
            System.out.println("Please enter valid integers, ensuring that the starting number is less than the ending number and greater than 1.");
        }

        scanner.close();
    }

    /// ### readInput
    ///
    /// Reads a valid integer from user input.
    ///
    /// Continues prompting until a valid integer is entered.
    ///
    /// @param scanner a `Scanner` instance for reading input
    /// @return the parsed integer value from user input
    public static int readInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid integer.");
            scanner.next(); // Clear invalid input
        }
        return scanner.nextInt();
    }

    /// ### isPrime
    ///
    /// Determines whether a number is **prime**.
    ///
    /// A number is considered prime if it's greater than 1 and has no divisors other than 1 and itself.
    ///
    /// @param n the number to check
    /// @return `true` if `n` is a prime number, otherwise `false`
    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false; // Found a divisor, not prime
            }
        }
        return true; // No divisors found, is prime
    }
}
