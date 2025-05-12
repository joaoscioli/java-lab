package java_ebook_200_exercices;

import java.math.BigInteger;
import java.util.Scanner;

public class FindFactorialNumberUsingRecursion {

    /// # FindFactorialNumberUsingRecursion
    ///
    /// This program calculates the **factorial** of a non-negative integer using **recursion**.
    ///
    /// ## Overview
    /// - Prompts the user to input a non-negative integer.
    /// - Computes the factorial using a recursive method.
    /// - Uses `BigInteger` to handle large results that exceed the range of primitive integer types.
    ///
    /// ## What is a factorial?
    /// The **factorial** of a non-negative integer `n` (denoted as `n!`) is the product of all positive integers less than or equal to `n`.
    ///
    /// ```
    /// n! = n × (n - 1) × (n - 2) × ... × 1
    /// 0! = 1
    /// ```
    ///
    /// ## Example Usage
    /// ```
    /// Enter non-negative integer: 22
    /// The factorial of 22 is: 1124000727777607680000
    /// ```
    ///
    /// ## Note
    /// This implementation uses **recursion**, which is elegant but not suitable for very large values of `n` due to stack limitations.
    /// For extremely large values, consider using an **iterative approach** to avoid `StackOverflowError`.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter non-negative integer: ");
        int number = scanner.nextInt();

        if (number < 0) {
            System.out.println("Please enter a valid non-negative integer.");
            return;
        }

        BigInteger result = factorial(number);
        System.out.println("The factorial of " + number + " is: " + result);
    }

    /// Recursively calculates the factorial of a given non-negative integer using `BigInteger`.
    ///
    /// @param n the non-negative integer whose factorial is to be computed
    /// @return the factorial of `n` as a `BigInteger`
    private static BigInteger factorial(int n) {
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        } else {
            return BigInteger.valueOf(n).multiply(factorial(n - 1));
        }
    }
}
