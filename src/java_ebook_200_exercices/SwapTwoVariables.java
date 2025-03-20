package java_ebook_200_exercices;

import java.util.Scanner;

public class SwapTwoVariables {
    // Function to read user input
    public static String readInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        // Read variables from user
        String variable1 = readInput("Enter the first variable: ");
        String variable2 = readInput("Enter the second variable: ");

        System.out.println("Before swapping: Variable1 = " + variable1 + " Variable2 = " + variable2);
        // Swapping the variable
        String temp = variable1;
        variable1 = variable2;
        variable2 = temp;
        System.out.println("After swapping: Variable1 = " + variable1 + " Variable2 = " + variable2);
    }
}

// Enter the first variable: a
// Enter the second variable: b
// Before swapping: Variable1 = a, Variable2=b
// After swapping: Variable1 = b, Variable2 = a