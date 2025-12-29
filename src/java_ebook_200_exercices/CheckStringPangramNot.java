package java_ebook_200_exercices;

/// ## CheckStringPangramNot
///
/// Utility class responsible for verifying whether a given string
/// is a **pangram**, meaning it contains **all letters of the English alphabet**
/// at least once.
///
/// A pangram check is case-insensitive and ignores characters
/// that are not part of the alphabet (`a`–`z`).
///
/// ### Example of a pangram:
/// - `"The quick brown fox jumps over the lazy dog"`
public class CheckStringPangramNot {

    /// ### isPangram
    ///
    /// Checks whether the provided string is a pangram.
    ///
    /// The method converts the input string to lowercase and verifies
    /// if each character from `'a'` to `'z'` exists at least once.
    ///
    /// ### Algorithm
    /// 1. Convert the input string to lowercase.
    /// 2. Iterate through all letters of the English alphabet.
    /// 3. Check if each letter exists in the input string.
    /// 4. If any letter is missing, return `false`.
    /// 5. If all letters are found, return `true`.
    ///
    /// ### Time Complexity
    /// - **O(26 × n)** → effectively **O(n)**, where *n* is the length of the string.
    ///
    /// ### Space Complexity
    /// - **O(1)** (constant extra space).
    ///
    /// @param inputStr the string to be analyzed
    /// @return `true` if the string is a pangram; `false` otherwise
    public static boolean isPangram(String inputStr) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String lowercasedStr = inputStr.toLowerCase();

        for (char ch : alphabet.toCharArray()) {
            if (lowercasedStr.indexOf(ch) == -1) {
                return false;
            }
        }
        return true;
    }

    /// ### main
    ///
    /// Demonstrates the usage of the `isPangram` method
    /// using a classic pangram example.
    ///
    /// The output indicates whether the given string
    /// satisfies the pangram condition.
    static void main() {
        String inputString = "The quick brown fox jumps over the lazy dog";

        if (isPangram(inputString)) {
            System.out.println("The given string is a pangram! 🎉");
        } else {
            System.out.println("The given string is not a pangram. 😢");
        }
    }
}
