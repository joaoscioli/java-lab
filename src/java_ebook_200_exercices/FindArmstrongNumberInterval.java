package java_ebook_200_exercices;

import java.util.Scanner;


///
/// A program to find Armstrong numbers within a specified interval.
///
/// An Armstrong number is a number that equals the sum of its digits raised to the power
/// of the total number of digits. For example:
/// - 153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
///
/// @version 1.0
///
public class FindArmstrongNumberInterval {
    ///
    /// Main method that handles user input and finds Armstrong numbers in the given interval.
    ///
    /// Prompts the user for start and end numbers, validates the input, and displays
    /// all Armstrong numbers found within the specified interval.
    ///
    /// @param args command line arguments (not used)
    ///
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read interval
        System.out.print("Enter the starting number: ");
        int start = getValidInteger(scanner);

        System.out.print("Enter the ending number: ");
        int end = getValidInteger(scanner);

        if (start > 0 && start < end) {
            System.out.println("Armstrong numbers in the interval [" + start + " - " + end + "]:");
            boolean found = false;

            for (int i = start; i <= end; i++) {
                if (isArmstrong(i)) {
                    System.out.println(i);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No Armstrong numbers found in the interval.");
            }
        } else {
            System.out.println("Please enter valid positive integer with the starting number less than the ending number.");
        }
        scanner.close();
    }

    // Function to validate input and return an integer

     ///
     /// Validates and retrieves an integer input from the user.
     ///
     /// Continuously prompts the user until a valid integer is entered.
     ///
     /// @param scanner the Scanner object used for input
     /// @return the valid integer entered by the user
     ///
    private static int getValidInteger(Scanner scanner) {
        while (!scanner.hasNext()) {
            System.out.println("Please enter a valid positive integer.");
            scanner.next(); // Clear invalid input
        }
        return scanner.nextInt();
    }

    // Function to check if a number is an Armstrong number

     ///
     /// Checks if a number is an Armstrong number.
     ///
     /// An Armstrong number equals the sum of its digits each raised to the power
     /// of the total number of digits.
     ///
     /// @param num the number to check
     /// @return true if the number is an Armstrong number, false otherwise
     ///
    private static boolean isArmstrong(int num) {
        int originalNum = num;
        int sum = 0;
        int digits = Integer.toString(num).length();

        // Calculate the sum of the digits raised to the power of the number of digits
        while (num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, digits);
            num /= 10;
        }
        return sum == originalNum;
    }
}

// Enter the starting number: 10
// Enter the ending number: 100
// Armstrong numbers in the interval [10 - 100]:
// 10
// 11
// 12
// ...