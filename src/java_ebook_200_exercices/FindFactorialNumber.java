package java_ebook_200_exercices;

import java.util.Scanner;

public class FindFactorialNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");

        if (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            System.out.println(number < 0 ? "Please enter a non-negative integer." : "The factorial of " +
                    number + " is: " + calculateFactorial(number));
        } else {
            System.out.println("Please enter a valid non-negative integer.");
        }
        scanner.close();
    }
    public static long calculateFactorial(long n) {
        long result = 1;
        for (long i = 2; i <= n; i++) result *= i;
        return result;
    }
}

// Enter non-negative integer: 11
// The factorial of 11 is: 39916800
