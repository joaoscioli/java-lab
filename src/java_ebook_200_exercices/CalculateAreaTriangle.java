package java_ebook_200_exercices;

import java.util.Scanner;

/// # CalculateAreaTriangle
///
/// This program calculates the area of a triangle given its base and height.
/// It ensures valid input handling by only accepting positive numerical values.
///
/// ## Example Usage
/// ```
/// Enter the base of the triangle: 3
/// Enter the height of the triangle: 4
/// The area of the triangle with base 3.0 and height 4.0 is: 6.0
/// ```
///

public class CalculateAreaTriangle {

    /// Reads a positive number from user input.
    ///
    /// This method continuously prompts the user until a valid positive number is entered.
    ///
    /// @param prompt The message displayed to the user before input.
    /// @return A valid positive double number entered by the user.
    public static double readPositiveNumber(String prompt) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                // Attempt to parse the input to double
                double number = Double.parseDouble(input);
                if (number > 0) {
                    return number;
                } else {
                    System.out.println("Please enter a valid positive number");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
    }

    /// Main method that executes the program.
    ///
    /// - Reads the base and height of a triangle from the user.
    /// - Calculates the area using the formula `0.5 * base * height`.
    /// - Displays the result.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        // Read base and height from user
        double base = readPositiveNumber("Enter the base of the triangle: ");
        double height = readPositiveNumber("Enter the height of the triangle: ");
        // Calculate the area of the triangle
        double area = 0.5 * base * height;

        System.out.println("The area of the triangle with base " + base + " and height " + height + " is " + area);
    }
}
