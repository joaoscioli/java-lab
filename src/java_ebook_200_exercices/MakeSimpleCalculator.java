package java_ebook_200_exercices;

import java.util.Scanner;

/// Simple calculator application that performs basic arithmetic operations.
/// This class provides functionality for:
/// - Reading numeric input from users
/// - Performing basic calculations (+, -, *, /)
/// - Handling invalid inputs and division by zero
public class MakeSimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num1 = readNumber(scanner, "Enter the first number: ");
        double num2 = readNumber(scanner, "Enter the second number: ");

        String operation = readOperation(scanner);
        double result = performCalculation(num1, num2, operation);

        if (!Double.isNaN(result)) {
            System.out.printf("Result: %.2f %s %.2f = %.2f%n", num1, operation, num2, result);
        }
        scanner.close();
    }

    /// Reads a numeric value from user input with error handling
    ///
    /// @param scanner The Scanner object used for input
    /// @param prompt  The message to display to the user
    /// @return The valid double number entered by the user
    private static double readNumber(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid number. Please try again.");
            scanner.next();     // Clear invalid input
            System.out.print(prompt);
        }
        return scanner.nextDouble();
    }

    /// Reads an arithmetic operation symbol from user input
    ///
    /// @param scanner The Scanner object used for input
    /// @return The operation symbol entered by the user (+, -, *, /)
    private static String readOperation(Scanner scanner) {
        System.out.print("Enter an operation (+, -, *, /): ");
        return scanner.next().trim();
    }

    /// Performs the arithmetic calculation based on the given operation
    ///
    /// @param num1      The first number in the calculation
    /// @param num2      The second number in the calculation
    /// @param operation The arithmetic operation to perform (+, -, *, /)
    /// @return The result of the calculation, or Double.NaN if the operation is invalid or division by zero
    private static double performCalculation(double num1, double num2, String operation) {
        switch (operation) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    System.out.println("Cannot divide by zero.");
                    return Double.NaN; // Return NaN to indicate error
                }
                return num1 / num2;
            default:
                System.out.println("Invalid operation.");
                return Double.NaN; // Return NaN to indicate error
        }
    }
}

// Enter the first number: 10
// Enter the second number: 5
// Enter an operation (+, -, *, /): /
// Cannot divide by zero.
// Result: 10.00 / 5.00 = 2.00