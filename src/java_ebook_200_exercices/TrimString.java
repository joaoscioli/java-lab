package java_ebook_200_exercices;

/// # TrimString
/// Demonstrates how to remove leading and trailing whitespace from a string using the `trim()` method.
///
/// ## Overview
/// This example shows the use of the `String.trim()` method in Java, which returns a copy of the string,
/// with leading and trailing whitespace removed. This is a common task when processing user input or
/// cleaning text data.
///
/// ## Output
/// ```
/// Original String: '   Hello, World! '
/// Trimmed String: 'Hello, World!'
/// ```
public class TrimString {
    public static void main(String[] args) {
        // Example string with leading and trailing whitespaces
        String stringWithSpaces = "   Hello, World! ";

        // Trim the string
        String trimmedString = stringWithSpaces.trim();

        // Display the result
        System.out.println("Original String: '" + stringWithSpaces + "'");
        System.out.println("Trimmed String: '" + trimmedString + "'");
    }
}
