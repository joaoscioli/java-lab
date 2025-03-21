package java_ebook_200_exercices;

import java.util.Scanner;

/// # SwapTwoVariables
///
/// This program swaps the values of two variables entered by the user.
/// It reads input values, performs the swap using a temporary variable,
/// and displays the values before and after swapping.
///
/// ## Example Usage
/// ```
/// Enter the first variable: a
/// Enter the second variable: b
/// Before swapping: Variable1 = a, Variable2 = b
/// After swapping: Variable1 = b, Variable2 = a
/// ```
///

public class SwapTwoVariables {
    /// Reads a string input from the user.
    ///
    /// @param prompt The message displayed to the user before input.
    /// @return The string value entered by the user.
    public static String readInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }

    /// Main method that executes the program.
    ///
    /// - Reads two variables from user input.
    /// - Swaps their values using a temporary variable.
    /// - Displays the values before and after swapping.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        // Read variables from user
        String variable1 = readInput("Enter the first variable: ");
        String variable2 = readInput("Enter the second variable: ");

        System.out.println("Before swapping: Variable1 = " + variable1 + " Variable2 = " + variable2);

        // Swapping the variables
        String temp = variable1;
        variable1 = variable2;
        variable2 = temp;

        System.out.println("After swapping: Variable1 = " + variable1 + " Variable2 = " + variable2);
    }
}
