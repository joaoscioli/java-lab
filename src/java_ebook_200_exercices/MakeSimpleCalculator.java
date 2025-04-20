package java_ebook_200_exercices;

import java.util.Scanner;

public class MakeSimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num1 = readNumber(scanner, "Enter the first number: ");
        double num2 = readNumber(scanner, "Enter the second number: ");

        String operation = readOperation(scanner);
        double result = performCalculation(num1, num2, operation);
    }

    // Function to read a number from user input
    private static double readNumber(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid number. Please try again.");
            scanner.next();     // Clear invalid input
            System.out.print(prompt);
        }
        return scanner.nextDouble();
    }

    // Function to read an operation from user input
    private static String readOperation(Scanner scanner) {
        System.out.print("Enter an operation (+, -, *, /): ");
        return scanner.next().trim();
    }

    // Function to perform the calculation based on the operation
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