package java_ebook_200_exercices;

import java.util.Scanner;

public class FindSquareRoot {
    // Function to read user input and parse it do double
    public static double readNumber(String prompt) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                // Attempt to parse the input to double
                double number = Double.parseDouble(input);
                if (number >= 0) {
                    return number;
                } else {
                    System.out.println("Please enter a non-negative number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public static void main(String[] args) {
        // Read a number from the user
        double inputNumber = readNumber("Enter a non-negative number: ");
        // Calculate the square root
        double squareRoot = Math.sqrt(inputNumber);
        System.out.println("The square root of " + squareRoot + " is: " + squareRoot);
    }

    // Output example:
    // Enter a non-negative number: 3
    // The square root of 3.0 is: 1.7320508075688772

}
