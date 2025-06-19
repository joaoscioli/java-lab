package java_ebook_200_exercices;

/// A concise example that shows how to test whether one string starts with another
/// using {@link java.lang.String#startsWith(String)}.
///
/// The program prints the result to standard output:
/// ```text
/// Does the string start with 'Hello'? true
/// ```
///
/// ### Example
/// ```java
/// String mainString = "Hello, World!";
/// String searchString = "Hello";
/// boolean startsWith = mainString.startsWith(searchString); // true
/// ```
///
/// *This class is intended for educational purposes within the*
/// *java_ebook_200_exercices* *package.*
public class CheckStringStartsAnotherString {

    /// Entry point that sets up the example strings, performs the check,
    /// and displays the outcome.
    ///
    /// ### Parameters
    /// * `args` — command‑line arguments (not used)
    public static void main(String[] args) {
        // Example strings
        String mainString = "Hello, World!";
        String searchString = "Hello";

        // Check if mainString starts with searchString
        boolean startsWith = mainString.startsWith(searchString);

        // Display the result
        System.out.println("Does the string start with '" + searchString + "'? " + startsWith);
    }
}
