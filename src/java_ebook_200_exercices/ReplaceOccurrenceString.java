package java_ebook_200_exercices;

/// # ReplaceOccurrenceString
/// This class demonstrates how to replace all occurrences of a specific substring within a given string.
///
/// ## Description
/// The program defines:
/// - An original string containing repeated words.
/// - A target substring to be replaced.
/// - A replacement string.
///
/// It uses `String.replace()` to replace all occurrences of the target substring and prints both the original and the modified strings.
///
/// ## Example
/// ```
/// Original String: Hello world, world!
/// Modified String: Hello universe, universe!
/// ```
public class ReplaceOccurrenceString {

    /// The entry point of the program.
    ///
    /// This method:
    /// 1. Defines a sample string with multiple occurrences of the word "world".
    /// 2. Replaces each "world" with the word "universe".
    /// 3. Prints the original and modified strings.
    public static void main(String[] args) {
        // Example string
        String originalString = "Hello world, world!";

        // String to replace
        String searchString = "world";

        // Replacement string
        String replacementString = "universe";

        // Replace all occurrences of searchString with replacementString
        String modifiedString = originalString.replace(searchString, replacementString);

        // Display the result
        System.out.println("Original String: " + originalString);
        System.out.println("Modified String: " + modifiedString);
    }
}
