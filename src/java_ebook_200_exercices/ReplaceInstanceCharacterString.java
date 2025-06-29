package java_ebook_200_exercices;

/// # ReplaceInstanceCharacterString
///
/// This program demonstrates how to replace all instances of a specific character
/// in a string using the `String.replace(char oldChar, char newChar)` method.
///
/// ## Overview
/// The program defines an original string and uses the `replace()` method
/// to substitute every occurrence of a given character with another.
///
/// - **Original String:** `"Hello, World!"`
/// - **Character to replace:** `'l'`
/// - **Replacement character:** `'x'`
///
/// ## Output
/// ```text
/// Original String: Hello, World!
/// Modified String: Hexxo, Worxd!
/// ```
///
/// ## Use Cases
/// - Sanitizing or formatting text.
/// - Replacing characters in user input or file content.
/// - Performing lightweight transformations before processing.
///
/// ## See Also
/// - [`String.replace(char oldChar, char newChar)`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html#replace(char,char))
///
public class ReplaceInstanceCharacterString {
    public static void main(String[] args) {
        // Example string
        String originalString = "Hello, World!";

        // Character to replace
        char charToReplace = 'l';

        // Replacement character
        char replacementChar = 'x';

        // Replace all instances of charToReplace with replacementChar
        String modifiedString = originalString.replace(charToReplace, replacementChar);

        // Display the result
        System.out.println("Original String: " + originalString);
        System.out.println("Modified String: " + modifiedString);
    }
}
