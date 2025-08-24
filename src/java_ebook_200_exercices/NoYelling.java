package java_ebook_200_exercices;

/// # NoYelling
///
/// Utility class that provides functionality to normalize sentences by
/// reducing multiple trailing exclamation (`!`) or question (`?`) marks
/// into a single one, avoiding "yelling" in text.
public class NoYelling {

    /// Removes extra exclamation or question marks at the end of a sentence.
    /// If the sentence ends with multiple `!` or `?`, they are reduced to a single instance.
    /// If it ends with other characters, the sentence remains unchanged.
    ///
    /// ## Parameters
    /// - `sentence`: the input string that may contain multiple trailing exclamation
    ///   or question marks.
    ///
    /// ## Returns
    /// A normalized sentence with at most one trailing `!` or `?`.
    ///
    /// ## Examples
    /// ```java
    /// NoYelling.noYelling("What went wrong?????????");
    /// // ➞ "What went wrong?"
    ///
    /// NoYelling.noYelling("Oh my goodness!!!");
    /// // ➞ "Oh my goodness!"
    ///
    /// NoYelling.noYelling("I just cannot believe it.");
    /// // ➞ "I just cannot believe it."
    /// ```
    public static String noYelling(String sentence) {
            String trimmed = sentence.replaceAll("[!?]+$", "");
            char lastChar = sentence.charAt(sentence.length() - 1);

            if (lastChar == '!') {
                return trimmed + "!";
            } else if (lastChar == '?') {
                return trimmed + "?";
            } else {
                return sentence;
            }
        }

        /// Entry point of the program.
        /// Demonstrates the behavior of the `noYelling` method with various examples.
    public static void main(String[] args) {
            System.out.println(noYelling("What went wrong?????????"));
            System.out.println(noYelling("Oh my goodness!!!"));
            System.out.println(noYelling("I just!!! can!!! not!!! believe!!! it!!!"));
            System.out.println(noYelling("Oh my goodness!"));
            System.out.println(noYelling("I just cannot believe it."));
        }

}
