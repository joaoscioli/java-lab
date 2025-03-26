package java_ebook_200_exercices;

import java.util.Scanner;

public class ConvertCelsiusToFahrenheit {
    // Function to read user input and parse it to double
    public static double readNumber(String prompt) {
        Scanner scanner = new Scanner(prompt);
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public static void main(String[] args) {
        // Read temperature in Celsius from user
        double celsius = readNumber("Enter the temperature in Celsius: ");
        // Convert Celsius to Fahrenheit
        double fahrenheit = ((celsius * 9.0) / 5.0 + 32.0);
        System.out.println(celsius + " degrees Celsius is equal to " + fahrenheit + " degrees Fahrenheit.");
    }
}

// Enter the temperature in Celsius: 33
// 33.0 degrees Celsius is equal to 91.4 degrees Fahrenheit.
