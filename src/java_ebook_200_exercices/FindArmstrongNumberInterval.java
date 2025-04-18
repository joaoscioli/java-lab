package java_ebook_200_exercices;

import java.util.Scanner;

public class FindArmstrongNumberInterval {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read interval
        System.out.print("Enter the starting number: ");
        int start = getValidInteger(scanner);

        System.out.print("Enter the ending number: ");
        int end = getValidInteger(scanner);

        if (start > 0 && start < end) {
            System.out.println("Armstrong numbers in the interval [" + start + " - " + end + "]:");
            boolean found = false;

            for (int i = start; i <= end; i++) {
                if (isArmstrong(i)) {
                    System.out.println(i);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No Armstrong numbers found in the interval.");
            }
        } else {
            System.out.println("Please enter valid positive integer with the starting number less than the ending number.");
        }
        scanner.close();
    }

    // Function to validate input and return an integer
    private static int getValidInteger(Scanner scanner) {
        while (!scanner.hasNext()) {
            System.out.println("Please enter a valid positive integer.");
            scanner.next(); // Clear invalid input
        }
        return scanner.nextInt();
    }

    // Function to check if a number is an Armstrong number
    private static boolean isArmstrong(int num) {
        int originalNum = num;
        int sum = 0;
        int digits = Integer.toString(num).length();

        // Calculate the sum of the digits raised to the power of the number of digits
        while (num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, digits);
            num /= 10;
        }
        return sum == originalNum;
    }
}

// Enter the starting number: 10
// Enter the ending number: 100
// Armstrong numbers in the interval [10 - 100]:
// 10
// 11
// 12
// ...