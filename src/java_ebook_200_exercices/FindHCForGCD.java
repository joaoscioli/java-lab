package java_ebook_200_exercices;

import java.util.Scanner;

public class FindHCForGCD {

    /// # FindHCForGCD
    ///
    /// This program calculates the Highest Common Factor (HCF), also known as the Greatest Common Divisor (GCD), of two positive integers entered by the user.
    ///
    /// ## Program Flow:
    /// 1. Prompt the user to enter two positive integers.
    /// 2. Validate the inputs to ensure they are positive integers.
    /// 3. Compute the HCF (GCD) using the Euclidean algorithm.
    /// 4. Display the result.
    ///
    /// ## How It Works:
    /// - The user is repeatedly prompted until valid positive integers are entered.
    /// - The `gcd` method implements the **Euclidean algorithm**:
    ///   - Repeatedly replace `a` with `b`, and `b` with `a % b`, until `b` becomes 0.
    ///   - The final value of `a` is the GCD.
    ///
    /// ## Input Example:
    /// ```
    /// Enter the first positive integer: 22
    /// Enter the second positive integer: 33
    /// ```
    ///
    /// ## Output Example:
    /// ```
    /// The HCF (GCD) of 22 and 33 is: 11
    /// ```
    ///
    /// ## Notes:
    /// - Input validation ensures only positive integers are accepted.
    /// - The program handles invalid or negative inputs gracefully.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num1 = readPositiveNumber(scanner, "Enter the first positive integer: ");
        long num2 = readPositiveNumber(scanner, "Enter the second positive integer: ");
        System.out.printf("The HCF (GCD) of %d and %d is: %d%n", num1, num2, gcd(num1, num2));
        scanner.close();
    }

    /// Reads a positive integer from the user input.
    ///
    /// @param scanner The `Scanner` object used to read the input.
    /// @param prompt The message displayed to the user.
    /// @return The positive integer entered by the user.
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

    /// Calculates the Greatest Common Divisor (GCD) of two numbers using the Euclidean algorithm.
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
