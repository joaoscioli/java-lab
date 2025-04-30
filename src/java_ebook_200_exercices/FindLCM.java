package java_ebook_200_exercices;

import java.util.Scanner;

public class FindLCM {

    /// # FindLCM
    ///
    /// This program calculates the **Least Common Multiple (LCM)** of two positive integers.
    ///
    /// ## Program Steps:
    /// 1. Prompt the user for two positive integers.
    /// 2. Validate the input to ensure the values are positive.
    /// 3. Calculate the **LCM** using the formula:
    ///    `LCM(a, b) = (a * b) / GCD(a, b)`
    /// 4. Display the result to the user.
    ///
    /// ## Example:
    /// ```
    /// Enter the first positive integer: 22
    /// Enter the second positive integer: 22
    /// The LCM of 22 and 22 is: 22
    /// ```
    ///
    /// ## Notes:
    /// - The program ensures that only valid, positive integers are accepted.
    /// - The `gcd` method uses the **Euclidean algorithm** for computing the greatest common divisor.
    /// - The result is computed using integer arithmetic to avoid precision loss.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long num1 = readPositiveNumber(scanner, "Enter the first positive integer: ");
        long num2 = readPositiveNumber(scanner, "Enter the second positive integer: ");
        long lcm = (num1 * num2) / gcd(num1, num2);

        System.out.printf("The LCM of %d and %d is: %d%n", num1, num2, lcm);
        scanner.close();
    }

    /// Prompts the user to enter a positive integer, and validates the input.
    ///
    /// @param scanner The `Scanner` object used for user input.
    /// @param prompt The prompt message shown to the user.
    /// @return A valid positive integer entered by the user.
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

    /// Computes the Greatest Common Divisor (GCD) of two positive integers using the Euclidean algorithm.
    ///
    /// @param a The first positive integer.
    /// @param b The second positive integer.
    /// @return The GCD of `a` and `b`.
    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
