package java_ebook_200_exercices;

/// # ConsoleOutput
///
/// This class demonstrates how to write output to the console in Java.
///
/// It covers:
/// - Printing simple text
/// - Printing variables and expressions
/// - Concatenating and printing multiple values
///
/// ## Example
/// ```java
/// ConsoleOutput.main(new String[]{});
/// ```
///
/// ### Output
/// ```text
/// Hello, world!
/// The answer is: 42
/// Full Name: John Doe
/// ```
public class ConsoleOutput {

    /// The entry point of the program.
    ///
    /// Demonstrates different ways of using `System.out.println`:
    /// - Writing a fixed message
    /// - Printing the value of a variable
    /// - Concatenating and printing multiple values
    ///
    /// @param args Command-line arguments (not used in this example).
    public static void main(String[] args) {
        // Write a message to the console
        System.out.println("Hello, world!");

        // You can also print variables or expressions
        int number = 42;
        System.out.println("The answer is: " + number);

        // Multiple values can be printed in a single statement
        String firstName = "John";
        String lastName = "Doe";
        System.out.println("Full Name: " + firstName + " " + lastName);
    }
}
