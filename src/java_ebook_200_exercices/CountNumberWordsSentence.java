package java_ebook_200_exercices;

/// # Count Number of Words in a Sentence
///
/// This class provides a utility method to count the number of words in a given sentence.
///
/// A **word** is defined as a sequence of non-whitespace characters separated by one or more spaces.
///
/// ## Example
/// ```java
/// Input: "This is a sample sentence."
/// Output: 5
/// ```
///
/// ## Approach
/// 1. Validate the input string to ensure it is not `null` or empty.
/// 2. Use `String.trim()` to remove leading and trailing whitespace.
/// 3. Split the sentence using the regular expression `\\s+` to handle multiple spaces between words.
/// 4. Return the length of the resulting array as the total word count.
///
/// ## Complexity Analysis
/// - **Time Complexity:** O(n), where *n* is the length of the input string (for the split operation).
/// - **Space Complexity:** O(n), as an array of words is created during splitting.
///
/// ## Throws
/// - `IllegalArgumentException` if the input string is `null` or empty.
///
/// ## Output Example
/// ```
/// The sentence "This is a sample sentence." has 5 words.
/// ```
///
/// ---
public class CountNumberWordsSentence {

    /// Counts the number of words in a given sentence.
    ///
    /// @param sentence the input string containing words separated by spaces
    /// @return the total number of words in the sentence
    /// @throws IllegalArgumentException if the input is null or empty
    public static int countWords(String sentence) throws IllegalArgumentException {
        // Check if the input is a valid non-empty string
        if (sentence == null || sentence.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid input. Please provide a valid sentence.");
        }

        // Count the words in the sentence
        String[] words = sentence.trim().split("\\s+");
        return words.length;
    }

    /// Demonstrates the usage of the `countWords` method.
    ///
    /// Example output:
    /// ```
    /// The sentence "This is a sample sentence." has 5 words.
    /// ```
    public static void main(String[] args) {
        String sentence = "This is a sample sentence.";
        try {
            int wordCount = countWords(sentence);
            System.out.printf("The sentence \"%s\" has %d words.%n", sentence, wordCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
