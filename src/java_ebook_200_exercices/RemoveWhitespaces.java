package java_ebook_200_exercices;

/// # RemoveWhitespaces
///
/// This class provides a utility method to remove all whitespace characters
/// from a given string.
///
/// ## Example
/// ```java
/// String textWithWhitespaces = "This is a text with spaces";
/// String textWithoutWhitespaces = RemoveWhitespaces.removeWhitespaces(textWithWhitespaces);
/// System.out.println("Original Text: " + textWithWhitespaces);
/// System.out.println("Text without Whitespaces: " + textWithoutWhitespaces);
/// ```
///
/// ### Output:
/// ```text
/// Original Text: This is a text with spaces
/// Text without Whitespaces: Thisisatextwithspaces
/// ```
public class RemoveWhitespaces {

    /// Entry point of the program.
    ///
    /// Demonstrates how to use the `removeWhitespaces` method by removing
    /// all spaces from a sample string and printing the results.
    ///
    /// @param args command-line arguments (not used in this program)
    public static void main(String[] args) {
        String textWithWhitespaces = "This is a text with spaces";
        String textWithoutWhitespaces = removeWhitespaces(textWithWhitespaces);
        System.out.println("Original Text: " + textWithWhitespaces);
        System.out.println("Text without Whitespaces: " + textWithoutWhitespaces);
    }

    /// Removes all whitespace characters from the provided string.
    ///
    /// This method replaces every whitespace character (spaces, tabs, newlines, etc.)
    /// with an empty string.
    ///
    /// @param inputText the original string that may contain whitespace characters
    /// @return a new string without any whitespace characters
    public static String removeWhitespaces(String inputText) {
        // Replace all whitespace characters with an empty string
        return inputText.replaceAll("\\s", "");
    }
}
