package java_ebook_200_exercices;

import java.util.Scanner;

public class FindLargestAmongThreeNumbers {
    /// # Find the Largest Among Three Numbers
    ///
    /// This program reads three numbers from the user and determines the largest among them.
    /// It utilizes the `Math.max` function to find the maximum value efficiently.
    ///
    /// ## Example Usage
    /// ```
    /// Enter the first number: 3
    /// Enter the second number: 4
    /// Enter the third number: 3
    /// The largest number among 3.00, 4.00, and 3.00 is: 4.00
    /// ```
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /// Reads three numbers from the user.
        double num1 = readNumber(scanner, "Enter the first number:");
        double num2 = readNumber(scanner, "Enter the second number:");
        double num3 = readNumber(scanner, "Enter the third number:");

        /// Finds the largest number among the three inputs.
        double largestNumber = Math.max(num1, Math.max(num2, num3));

        System.out.printf("The largest number among %.2f, %.2f, and %.2f is: %.2f%n", num1, num2, num3, largestNumber);
        scanner.close();
    }

    /// Reads a valid number from user input.
    ///
    /// - `scanner`: The Scanner object to read input.
    /// - `prompt`: The message displayed to the user.
    /// - Returns: A valid double value entered by the user.
    private static double readNumber(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Please enter a valid number.");
            scanner.next(); // Clear invalid input
            System.out.print(prompt);
        }
        return scanner.nextDouble();
    }
}
