
package java_ebook_200_exercices;

import java.util.Scanner;

/// # SolveQuadraticEquation
///
/// This program solves a quadratic equation of the form `ax² + bx + c = 0`.
/// It reads the coefficients `a`, `b`, and `c` from the user, calculates the discriminant,
/// and determines the real or complex roots accordingly.
///
/// ## Example Usage
/// ```
/// Enter the coefficient a: 1
/// Enter the coefficient b: -3
/// Enter the coefficient c: 2
/// The roots are: 2.0 and 1.0
/// ```
///

public class SolveQuadraticEquation {
    /// Reads a numeric value from user input.
    ///
    /// This method continuously prompts the user until a valid numeric input is provided.
    ///
    /// @param prompt The message displayed to the user before input.
    /// @return A valid double number entered by the user.
    public static double readNumber(String prompt) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    /// Main method that executes the program.
    ///
    /// - Reads coefficients `a`, `b`, and `c` from user input.
    /// - Calculates the discriminant (`b² - 4ac`).
    /// - Determines the nature of the roots:
    ///   - If `discriminant > 0`, two real roots are displayed.
    ///   - If `discriminant == 0`, one real root is displayed.
    ///   - If `discriminant < 0`, the equation has complex roots.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        double a = readNumber("Enter the coefficient a: ");
        double b = readNumber("Enter the coefficient b: ");
        double c = readNumber("Enter the coefficient c: ");

        // Calculate the discriminant
        double discriminant = Math.pow(b, 2) - 4 * a * c;
        if (a == 0) {
            System.out.printf("Coefficient 'a' cannot be zero.");
            return;
        }

        // Check the discriminant and compute the roots
        if (discriminant > 0 ) {
            double sqrt_d = Math.sqrt(discriminant);
            double root1 = (-b + sqrt_d) / (2 * a);
            double root2 = (-b - sqrt_d) / (2 * a);
            System.out.println("The roots are: " + root1 + " and " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("The root is: " + root);
        } else {
            System.out.println("The equation has complex roots.");
        }
    }
}
