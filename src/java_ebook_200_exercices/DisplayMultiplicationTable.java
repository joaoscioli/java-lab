package java_ebook_200_exercices;

import java.util.Scanner;

public class DisplayMultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number for the multiplication table: ");
        // Check if the input is a valid integer
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid integer.");
            scanner.next();
            System.out.print("Enter a number for the multiplication table: ");
        }
        int number = scanner.nextInt();
        int rangeVal = 10;
        System.out.printf("Multiplication table for %d (up to %d):%n", number, rangeVal);

        // Display the multiplication table
        for (int i = 1; i <= rangeVal; i++) {
            int result = number * i;
            System.out.printf("%d * %d = %d%n", number, i, result);
        }
        scanner.close();
    }
}

// Enter a number the multiplication table: 2
// Multiplication table for 2 (up to 10):
// 2 x 1 = 2
// 2 x 2 = 4
// 2 x 3 = 6
// 2 x 4 = 8
// 2 x 5 = 10
// 2 x 6 = 12
// 2 x 7 = 14
// 2 x 8 = 16
// 2 x 9 = 18
// 2 x 10 = 20