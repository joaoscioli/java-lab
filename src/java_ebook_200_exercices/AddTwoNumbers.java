package java_ebook_200_exercices;

import java.util.Scanner;

public class AddTwoNumbers {
    public static void main(String[] args) {
        // Created a scanner object for user input
        Scanner scanner = new Scanner(System.in);
        // Read numbers from user
        double num1 = readNumber(scanner, "Enter the first number: ");
        double num2 = readNumber(scanner, "Enter the second number: ");
        // Perform the addition
        double sumResult = num1 + num2;
        System.out.printf("The sum of %.2f and %.2f is: %.2f%n",  num1, num2, sumResult);
        scanner.close();
    }

    private static double readNumber(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                // Try to parse the input to a double
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
    }
}
