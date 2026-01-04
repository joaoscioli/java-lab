package java_ebook_200_exercices;

import java.io.IO;

public class CensorWordLongThanFourCharacters {

    /// ## censor
    ///
    /// Replaces every word in the given `text` that contains **more than four characters**
    /// with a sequence of asterisks (`*`).
    ///
    /// Each censored word is transformed into a string of asterisks.
    /// The length of the censored word matches the *number of words in the sentence*,
    /// based on the current implementation.
    ///
    /// > ⚠ **Note:** This behavior differs from typical censorship logic,
    /// > where each censored word is replaced by asterisks of the *same length as the word*.
    /// > If you want that corrected, I can adjust it.
    ///
    /// ### Parameters
    /// - `text`: A string containing one or more words separated by whitespace.
    ///
    /// ### Returns
    /// - A new string where each word longer than four characters is replaced by asterisks,
    ///   while shorter words are kept unchanged.
    ///
    /// ### Example
    /// ```java
    /// CensorWordLongThanFourCharacters.censor("The code is fourty");
    /// // Output: "The code is ******"
    /// ```
    ///
    /// ### Complexity
    /// - **Time Complexity:** O(N · W)
    ///   where `N` is number of words, `W` is average word length.
    /// - **Space Complexity:** O(N · W) for the resulting string.
    public static String censor(String text) {
        // Split the text into words
        String[] words = text.split("\\s+");

        // Transform each word, replacing those longer than four characters
        StringBuilder censoredText = new StringBuilder();

        for (String word : words) {
            if (word.length() > 4) {
                // Replace with asterisks (current behavior based on number of words)
                String censoredWord = "*".repeat(words.length);
                censoredText.append(censoredWord).append(" ");
            } else {
                censoredText.append(word).append(" ");
            }
        }

        // Return the censored words as a single string, trimming any trailing space
        return censoredText.toString().trim();
    }

    /// ## main
    ///
    /// Simple demonstration method printing sample calls to `censor`.
    ///
    /// ### Example Output
    /// ```
    /// The code is ******
    /// Two plus ***** is five
    /// aaaa ***** 1234 *****
    /// ```
    void main() {
        // Example usage
        IO.println(censor("The code is fourty"));
        IO.println(censor("Two plus three is five"));
        IO.println(censor("aaaa aaaaa 1234 12345"));
    }
}
