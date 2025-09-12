package java_ebook_200_exercices;

///
/// # NumberedAlphabet
///
/// This class provides functionality to convert letters of a string into their
/// corresponding **numeric positions** in the English alphabet (zero-based).
///
/// ## Details
/// - Characters are first converted to uppercase.
/// - `'A'` corresponds to `0`, `'B'` to `1`, and so on until `'Z'` which corresponds to `25`.
/// - Each character in the input string is mapped and separated by spaces.
///
/// ## Example
/// ```java
/// NumberedAlphabet.alphNum("XYZ");     // returns "23 24 25"
/// NumberedAlphabet.alphNum("ABCDEF");  // returns "0 1 2 3 4 5"
/// NumberedAlphabet.alphNum("JAVASCRIPT"); // returns "9 0 21 0 18 2 17 8 15 19"
/// ```
///
public class NumberedAlphabet {

    ///
    /// Converts a given string into a sequence of numbers representing
    /// the zero-based positions of its characters in the English alphabet.
    ///
    /// ## Parameters
    /// - `s`: The input string containing alphabetic characters.
    ///
    /// ## Returns
    /// A space-separated string of numbers, each representing the
    /// corresponding letter’s position in the alphabet.
    ///
    /// ## Throws
    /// - None explicitly, but non-alphabetic characters will produce
    ///   unexpected results due to the subtraction operation (`c - 'A'`).
    ///
    public static String alphNum(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toUpperCase().toCharArray()) {
            // Calculate the position in the alphabet
            int index = c - 'A';
            result.append(index).append(" ");
        }
        // Remove the trailing space
        return result.toString().trim();
    }

    ///
    /// Demonstrates the use of `alphNum` by converting
    /// predefined examples and printing their numeric representation.
    ///
    /// ## Examples
    /// Input: `"XYZ"` → Output: `"23 24 25"`
    /// Input: `"ABCDEF"` → Output: `"0 1 2 3 4 5"`
    /// Input: `"JAVASCRIPT"` → Output: `"9 0 21 0 18 2 17 8 15 19"`
    ///
    public static void main(String[] args) {
        String[] examples = {"XYZ", "ABCDEF", "JAVASCRIPT"};
        for (String example : examples) {
            String result = alphNum(example);
            System.out.println(example + " -> " + result);
        }
    }
}
