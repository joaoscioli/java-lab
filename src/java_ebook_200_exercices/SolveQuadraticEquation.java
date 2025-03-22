package java_ebook_200_exercices;

import java.util.Scanner;

public class SolveQuadraticEquation {
    // Function to read user input and parse it to double
    public static double readNumber(String prompt) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return  Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public static void main(String[] args) {
        double a = readNumber("Enter the coefficient a: ");
        double b = readNumber("Enter the coefficient b: ");
        double c = readNumber("Enter the coefficient c: ");

        // Calculate the discriminant
        double dicriminant = Math.pow(b, 2) - 4 * a * c;
        if (a == 0) {
            System.out.printf("Coeficient 'a' cannot be zero.");
            return;
        }

        // Check the discriminant and compute the roots
        if (dicriminant > 0 ) {
            double sqrt_d = Math.sqrt(dicriminant);
            double root1 = (-b + sqrt_d) / (2 * a);
            double root2 = (-b - sqrt_d) / (2 * a);
            System.out.println("The roots are: " + root1 + " and " + root2);
        } else if (dicriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("The roots is: " + root);
        } else {
            System.out.println("The equation has complex roots.");
        }
    }
}

// Enter the coefficient a: 1
// Enter the coefficient b: -3
// Enter the coefficient c: 2
// The roots are: 2.0 and 1.0
