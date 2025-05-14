package java_ebook_200_exercices;

import java.util.Scanner;

class DecimalToBinaryConverter  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a decimal number: ");
        int decimalNumber = scanner.nextInt();
        if (decimalNumber < 0) {
            System.out.println("Please enter a valid non-negative integer.");
            return;
        }

        String binaryEquivalent = decimalToBinary(decimalNumber);
        System.out.println("The binary equivalent of " + decimalNumber + " is: " + binaryEquivalent);
    }

    private static String decimalToBinary(int num) {
        if (num == 0) {
            return "0";
        }

        StringBuilder binary = new StringBuilder();
        int n = num;

        while (n > 0) {
            binary.insert(0, n % 2);
            n /= 2;
        }
        return binary.toString();
    }
}

// Enter a decimal number: 10
// The binary equivalent of 10 is: 1010
