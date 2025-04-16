package java_ebook_200_exercices;

import java.util.Scanner;

public class CheckArmstrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");

        // Validate input
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid positive integer.");
            scanner.next(); // Clear invalid input
            System.out.print("Enter a number: ");
        }

        int number = scanner.nextInt();
        if (number < 0) {
            System.out.println("Please enter a valid positive integer.");
            scanner.close();
            return;
        }

        int digits = Integer.toString(number).length(); // Number of digits
        int sum = 0;
        int temp = number;

        // Calculate the sum of the powers of its digits
        while (temp > 0) {
            int digit = temp % 10; // Get last digit
            sum += Math.pow(digit, digits); // Add digit raised to the power of digits
            temp /= 10; // Remove last digit
        }

        // Check if the sum is equal to the original number
        if (sum == number) {System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }
        scanner.close();
    }
}
// Enter a number: 153
// 153 is an Armstrong number.