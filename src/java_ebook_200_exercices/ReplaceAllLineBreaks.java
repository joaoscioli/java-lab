package java_ebook_200_exercices;

/// # ReplaceAllLineBreaks
///
/// This program demonstrates how to replace all line break characters (`\n`)
/// in a string using the `String.replace()` method.
///
/// ## Overview
/// The program defines a string containing multiple line breaks (`\n`)
/// and replaces each line break with a custom replacement string (in this case, `"-"`).
///
/// This is useful when converting multi-line text into a single line,
/// especially for logging, compact display, or preprocessing.
///
/// ## Input
/// - **Original String:**
/// ```
/// Hello,
/// World!
/// This is a new line.
/// ```
/// - **Replacement String:** `"-"`
///
/// ## Output
/// ```text
/// Original String:
/// Hello,
/// World!
/// This is a new line.
///
/// String without Line Breaks:
/// Hello,-World!-This is a new line.
/// ```
///
/// ## Use Cases
/// - Cleaning up user input for logging or storage.
/// - Formatting text for single-line display.
/// - Preparing multi-line strings for CSV, JSON, or other flat formats.
///
/// ## See Also
/// - [`String.replace(CharSequence target, CharSequence replacement)`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html#replace(java.lang.CharSequence,java.lang.CharSequence))
///
public class ReplaceAllLineBreaks {
    public static void main(String[] args) {
        // Example string with line breaks
        String stringWithLineBreaks = "Hello,\nWorld!\nThis is a new line.";

        // Replacement string
        String replacementString = "-";

        // Replace all line breaks with the replacement string
        String stringWithoutLineBreaks = stringWithLineBreaks.replace("\n", replacementString);

        // Display the result
        System.out.println("Original String:");
        System.out.println(stringWithLineBreaks);
        System.out.println("\nString without Line Breaks:");
        System.out.println(stringWithoutLineBreaks);
    }
}
