package java_ebook_200_exercices;

import java.util.Scanner;

public class DisplayMultiplicationTable {

    /// # DisplayMultiplicationTable
    ///
    /// This program displays the **multiplication table** for a number entered by the user.
    ///
    /// ## How the program works:
    /// - Prompts the user to enter a number.
    /// - Validates the input to ensure it's an integer.
    /// - Prints the multiplication table for the given number, from 1 to 10.
    ///
    /// ## Example
    /// ```
    /// Enter a number for the multiplication table: 2
    /// Multiplication table for 2 (up to 10):
    /// 2 * 1 = 2
    /// 2 * 2 = 4
    /// 2 * 3 = 6
    /// ...
    /// 2 * 10 = 20
    /// ```
    ///
    /// ## Input Validation
    /// If the user enters a non-integer value, the program will prompt again until a valid integer is entered.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number for the multiplication table: ");

        // Check if the input is a valid integer
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid integer.");
            scanner.next(); // Clear invalid input
            System.out.print("Enter a number for the multiplication table: ");
        }

        int number = scanner.nextInt();
        int rangeVal = 10;

        System.out.printf("Multiplication table for %d (up to %d):%n", number, rangeVal);

        // Display the multiplication table
        for (int i = 1; i <= rangeVal; i++) {
            int result = number * i;
            System.out.printf("%d * %d = %d%n", number, i, result);
        }

        scanner.close();
    }
}
