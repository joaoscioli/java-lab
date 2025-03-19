package java_ebook_200_exercices;

import java.util.Scanner;

public class CalculateAreaTriangle {

    // Function to read user input and parse it to double
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

    public static void main(String[] args) {
        // Read base and height from user
        double base = readPositiveNumber("Enter the base of the triangle: ");
        double height = readPositiveNumber("Enter the height of the triangle: ");
        // Calculate the area of the triangle
        double area = 0.5 * base * height;

        System.out.println("The area of the triangle with base " + base + " and height " + height + " is " + area);
    }
}

// Enter base of the triangle: 3
// Enter the height of triangle: 4
// The area of the triangle with base 3.0 and height 4.0 is: 6.0
