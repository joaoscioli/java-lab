package java_ebook_200_exercices;

import java.util.Scanner;

public class FindFactorialNumber {

    /// # FindFactorialNumber
    ///
    /// This program calculates the **factorial** of a non-negative integer entered by the user.
    ///
    /// ## What is a factorial?
    /// The factorial of a non-negative integer `n` is the product of all positive integers less than or equal to `n`.
    /// It is denoted as `n!`.
    ///
    /// For example:
    /// ```
    /// 5! = 5 × 4 × 3 × 2 × 1 = 120
    /// ```
    ///
    /// ## How the program works:
    /// - Prompts the user to enter a non-negative integer.
    /// - Validates that the input is a non-negative number.
    /// - Calls the [`calculateFactorial(long)`](#calculatefactorial) method to compute the result.
    /// - Prints the result or an error message if the input is invalid.
    ///
    /// ## Example
    /// ```
    /// Enter a non-negative integer: 11
    /// The factorial of 11 is: 39916800
    /// ```
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");

        if (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            System.out.println(number < 0
                    ? "Please enter a non-negative integer."
                    : "The factorial of " + number + " is: " + calculateFactorial(number));
        } else {
            System.out.println("Please enter a valid non-negative integer.");
        }

        scanner.close();
    }

    /// ### calculateFactorial
    ///
    /// Calculates the **factorial** of the given non-negative integer using an iterative approach.
    ///
    /// @param n a non-negative long integer
    /// @return the factorial of `n` as a `long`
    ///
    /// ## Note
    /// This method does **not** handle values of `n` greater than 20 properly due to `long` overflow.
    /// For larger values, consider using `BigInteger`.
    public static long calculateFactorial(long n) {
        long result = 1;
        for (long i = 2; i <= n; i++) result *= i;
        return result;
    }
}
