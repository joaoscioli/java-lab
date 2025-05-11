package java_ebook_200_exercices;

import java.math.BigInteger;
import java.util.Scanner;

public class FindFactorialNumberUsingRecursion {
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

    private static BigInteger factorial(int n) {
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        } else {
            return BigInteger.valueOf(n).multiply(factorial(n - 1)); // n! = n * (n - 1) * (n - 2) * ... * 1
        }
    }
}

// Enter a non-negative integer: 22
// The factorial of 22 is: 1124000727777607680000
