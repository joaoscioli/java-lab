package java_ebook_200_exercices;

import java.util.Scanner;

public class CheckIfNumberOddEven {
    public static void main(String[] args) {
        // Prompt user for a number
        System.out.print("Enter a number: ");
        Scanner scan = new Scanner(System.in);
        // Try to read the input as an integer
        if (scan.hasNextInt()) {
            int number = scan.nextInt();
            // Check if the number is odd or even
            if (number % 2 == 0) {
                System.out.println(number + " is an even number");
            } else {
                System.out.println(number + " is an odd number");
            }
        } else {
            System.out.println("Please enter a valid number");
        }
        scan.close();
    }
}

// Enter a number: 3
// 3 is an odd number