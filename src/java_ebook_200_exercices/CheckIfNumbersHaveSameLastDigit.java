package java_ebook_200_exercices;

import java.util.Scanner;

public class CheckIfNumbersHaveSameLastDigit {

    /// # CheckIfNumbersHaveSameLastDigit
    ///
    /// This program checks whether two input numbers have the same last digit.
    ///
    /// ## Program Flow:
    /// 1. Prompts the user to enter two integers.
    /// 2. Validates that the inputs are valid integers.
    /// 3. Compares the last digits of the two numbers.
    /// 4. Displays whether the last digits are the same or different.
    ///
    /// ## How It Works:
    /// - The last digit is obtained by calculating `number % 10`.
    /// - The absolute value is used to handle potential negative numbers correctly.
    ///
    /// ## Input Example:
    /// ```
    /// Enter the first number: 2
    /// Enter the second number: 3
    /// ```
    ///
    /// ## Output Example:
    /// ```
    /// The last digit of 2 is different from the last digit of 3
    /// ```
    ///
    /// ## Notes:
    /// - Negative numbers are supported; their last digit is compared based on absolute value.
    /// - Input validation ensures only integers are accepted.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num1 = readNumber(scanner, "Enter the first number: ");
        long num2 = readNumber(scanner, "Enter the second number: ");

        if (Math.abs(num1 % 10) == Math.abs(num2 % 10)) {
            System.out.printf("The last digit of %d is the same as last digit of %d%n", num1, num2);
        } else {
            System.out.printf("The last digit of %d is different from the last digit of %d%n", num1, num2);
        }
        scanner.close();
    }

    /// Reads a valid integer input from the user.
    ///
    /// @param scanner The `Scanner` object used for reading input.
    /// @param prompt  A custom prompt message displayed to the user.
    /// @return The number entered by the user as a `long`.
    private static long readNumber(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextLong()) {
            System.out.println("Please enter a valid integer.");
            scanner.next(); // Clear invalid input
            System.out.print(prompt);
        }
        return scanner.nextLong();
    }
}
