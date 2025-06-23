package java_ebook_200_exercices;

/// # CheckWhetherStringContainsSubstring
/// Demonstrates how to check whether a string contains a specific substring using the `contains()` method.
///
/// ## Overview
/// This example uses the `String.contains(CharSequence)` method in Java to determine whether a given
/// substring is present within a larger string. This operation is commonly used in input validation,
/// search functionality, and text processing.
///
/// ## Example
/// The main string is:
/// `"Hello, World!"`
/// The substring to check is:
/// `"World"`
///
/// The result will be:
/// ```text
/// Does the string contain 'World'? true
/// ```
///
/// ## See Also
/// - [`String.contains(CharSequence)`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html#contains(java.lang.CharSequence))
/// - [`String.indexOf(String)`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html#indexOf(java.lang.String))
public class CheckWhetherStringContainsSubstring {
    public static void main(String[] args) {

        // Example string
        String mainString = "Hello, World!";
        String substringToCheck = "World";

        // Check if mainString contains substringToCheck
        boolean containsSubstring = mainString.contains(substringToCheck);

        // Display the result
        System.out.println("Does the string contain '" + substringToCheck + "'? " + containsSubstring);
    }
}
