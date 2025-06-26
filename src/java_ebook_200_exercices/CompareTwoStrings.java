package java_ebook_200_exercices;

/// # CompareTwoStrings
///
/// This program demonstrates how to compare two strings in Java using both
/// case-sensitive and case-insensitive methods.
///
/// ## Overview
/// The program defines two string variables: `string1` and `string2`, with
/// slightly different casing ("Hello" vs "hello").
/// It then compares them using:
/// - `String.equals(String other)`: which is case-sensitive.
/// - `String.equalsIgnoreCase(String other)`: which ignores case differences.
///
/// ## Output
/// The output shows the result of both comparisons:
///
/// ```
/// Case-sensitive comparison: false
/// Case-insensitive comparison: true
/// ```
///
/// ## See Also
/// - [`String.equals(String)`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html#equals(java.lang.Object))
/// - [`String.equalsIgnoreCase(String)`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html#equalsIgnoreCase(java.lang.String))
///
public class CompareTwoStrings {
    public static void main(String[] args) {
        // Example strings
        String string1 = "Hello";
        String string2 = "hello";

        // Case-sensitive comparison
        boolean caseSensitiveComparison = string1.equals(string2);

        // Case-insensitive comparison
        boolean caseInsensitiveComparison = string1.equalsIgnoreCase(string2);

        // Display the results
        System.out.println("Case-sensitive comparison: " + caseSensitiveComparison);
        System.out.println("Case-insensitive comparison: " + caseInsensitiveComparison);
    }
}
