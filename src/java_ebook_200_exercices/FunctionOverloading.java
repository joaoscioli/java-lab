package java_ebook_200_exercices;

/// # FunctionOverloading
///
/// Demonstrates **method overloading** in Java by defining multiple methods
/// with the same name (`exampleFunction`) but different parameter lists.
/// This allows the same method name to be reused for different types or numbers
/// of arguments.
///
/// ## Usage
/// - Call `exampleFunction()` without arguments.
/// - Call `exampleFunction(int n)` with an integer.
/// - Call `exampleFunction(String s, int n)` with a string and an integer.
///
/// ## Example
/// ```java
/// FunctionOverloading.exampleFunction();              // No arguments
/// FunctionOverloading.exampleFunction(42);            // One number argument
/// FunctionOverloading.exampleFunction("Hello", 7);    // String and number
/// ```
public class FunctionOverloading {

    /// Prints a message indicating that no arguments were passed.
    public static void exampleFunction() {
        System.out.println("No arguments");
    }

    /// Prints a message with a single integer argument.
    ///
    /// @param n the integer value to be displayed
    public static void exampleFunction(int n) {
        System.out.println("One number argument: " + n);
    }

    /// Prints a message with a string and an integer argument.
    ///
    /// @param s the string value to be displayed
    /// @param n the integer value to be displayed
    public static void exampleFunction(String s, int n) {
        System.out.println("String and number arguments: " + s + ", " + n);
    }

    /// Entry point of the program.
    ///
    /// Demonstrates calling the overloaded `exampleFunction` methods
    /// with different parameter combinations.
    public static void main(String[] args) {
        exampleFunction();          // No arguments
        exampleFunction(42);        // One integer argument
        exampleFunction("Hello", 7); // String and integer arguments
    }
}
