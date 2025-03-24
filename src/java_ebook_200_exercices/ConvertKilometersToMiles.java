package java_ebook_200_exercices;

import java.util.Scanner;

public class ConvertKilometersToMiles {
    // Function to read user input and parse it to double
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

// Enter the distance in kilometers: 2
// 2.0 kilometers is approximately 1.2426742