package java_ebook_200_exercices;

import java.util.Scanner;

/// # ConvertCelsiusToFahrenheit
///
/// This program converts a temperature from Celsius to Fahrenheit.
/// It reads the temperature from the user, applies the conversion formula,
/// and displays the result.
///
/// ## Example Usage
/// ```
/// Enter the temperature in Celsius: 33
/// 33.0 degrees Celsius is equal to 91.4 degrees Fahrenheit.
/// ```
///

public class ConvertCelsiusToFahrenheit {
    /// Reads a numeric value from user input.
    ///
    /// This method continuously prompts the user until a valid numeric input is provided.
    ///
    /// @param prompt The message displayed to the user before input.
    /// @return A valid double number entered by the user.
    public static double readNumber(String prompt) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
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
    /// - Reads a temperature in Celsius from user input.
    /// - Converts the temperature using the formula `F = (C × 9/5) + 32`.
    /// - Displays the result.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        // Read temperature in Celsius from user
        double celsius = readNumber("Enter the temperature in Celsius: ");
        // Convert Celsius to Fahrenheit
        double fahrenheit = ((celsius * 9.0) / 5.0 + 32.0);
        System.out.println(celsius + " degrees Celsius is equal to " + fahrenheit + " degrees Fahrenheit.");
    }
}
