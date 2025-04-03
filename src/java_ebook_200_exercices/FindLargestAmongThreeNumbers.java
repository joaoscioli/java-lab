package java_ebook_200_exercices;

import java.util.Scanner;

public class FindLargestAmongThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read three numbers from the user
        double num1 = readNumber(scanner, "Enter the first number:");
        double num2 = readNumber(scanner, "Enter the second number:");
        double num3 = readNumber(scanner, "Enter the third number:");
        // Find the largest number
        double largestNumber = Math.max(num1, Math.max(num2,num3));
        System.out.printf("The largest number among %.2f, %.2f, and %.2f is: $.2f%n", num1, num2, num3, largestNumber);
        scanner.close();
    }

    // Function to read a number from user input
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

// Enter the first number: 3
// Enter the second number: 4
// Enter the third number: 3
