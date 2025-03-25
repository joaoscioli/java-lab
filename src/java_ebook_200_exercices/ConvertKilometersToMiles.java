package java_ebook_200_exercices;

import java.util.Scanner;

/// # ConvertKilometersToMiles
///
/// This program converts a distance from kilometers to miles.
/// It reads the distance from the user, applies the conversion formula,
/// and displays the result.
///
/// ## Example Usage
/// ```
/// Enter the distance in kilometers: 2
/// 2.0 kilometers is approximately 1.2426742 miles.
/// ```
///

public class ConvertKilometersToMiles {
    /// Reads a numeric value from user input.
    ///
    /// This method continuously prompts the user until a valid numeric input is provided.
    ///
    /// @param prompt The message displayed to the user before input.
    /// @return A valid double number entered by the user.
    public static double readNumber(String prompt) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
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
    /// - Reads a distance in kilometers from user input.
    /// - Converts the distance using the conversion factor (`1 km ≈ 0.621371 miles`).
    /// - Displays the result.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        // Read distance in kilometers from user
        double kilometers = readNumber("Enter the distance in Kilometers: ");
        // Conversion factor
        double kilometersToMilesConversionFactor = 0.621371;
        // Convert kilometers to miles
        double miles = kilometers * kilometersToMilesConversionFactor;
        System.out.println(kilometers + " kilometers is approximately " + miles + " miles.");
    }
}