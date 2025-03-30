package java_ebook_200_exercices;

import java.util.Scanner;

public class CheckIfNumberPositiveNegativeZero {
    public static void main(String[] args) {
        // Prompt user for a number
        System.out.print("Enter a number: ");
        Scanner scanner = new Scanner(System.in);
        // Try to read the input as a floating-point number
        if (scanner.hasNextDouble()) {
            double number = scanner.nextDouble();
            // Check if the number is positive, negative, or zero
            if (number > 0.0) {
                System.out.println(number + " is a positive number.");
            } else if (number < 0.0) {
                System.out.println(number + " is a negative number.");
            } else {
                System.out.println("The entered number is zero.");
            }
        } else {
            System.out.println("Please enter a valid number.");
        }
        scanner.close();
    }
}
// Enter a number: 3
// 3.0 is a positive number.
