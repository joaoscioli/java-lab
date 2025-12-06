package java_ebook_200_exercices;

public class ClubEntry {

    /// # clubEntry
    ///
    /// Determines a numeric "entry value" based on the **first doubled letter**
    /// found inside a given lowercase word.
    ///
    /// A *doubled letter* is any character that appears twice consecutively,
    /// such as `"ll"` in `"hill"` or `"ee"` in `"bee"`.
    ///
    /// ## Logic
    /// 1. Scan the string from left to right searching for the
    ///    **first occurrence** of `word[i] == word[i + 1]`.
    /// 2. If no doubled letter is found, return `null`.
    /// 3. Once found:
    ///    - Compute the **alphabet position** of the repeated letter
    ///      (`a = 1`, `b = 2`, ..., `z = 26`).
    ///    - Multiply this position by **4**.
    ///
    /// ## Parameters
    /// - `word`
    ///   A non-empty string containing lowercase alphabetic characters.
    ///
    /// ## Returns
    /// - An `Integer` representing the doubled letter’s alphabet position
    ///   multiplied by 4.
    /// - `null` if the word contains **no doubled letters**.
    ///
    /// ## Example
    /// ```java
    /// clubEntry("hill"); // 'l' is doubled → position 12 → 12 * 4 = 48
    /// clubEntry("bee");  // 'e' is doubled → position 5  → 5  * 4 = 20
    /// clubEntry("apple"); // no doubled letter → null
    /// ```
    ///
    /// ## Notes
    /// - Only the **first** doubled letter is considered.
    /// - Behavior assumes lowercase ASCII letters ('a'–'z').
    ///
    public static Integer clubEntry(String word) {
        // Find the doubled letter
        Character doubledLetter = null;

        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) == word.charAt(i + 1)) {
                doubledLetter = word.charAt(i);
                break;
            }
        }

        // Ensure that a doubled letter was found
        if (doubledLetter == null) {
            return null; // No doubled letter found
        }

        // Calculate the position of the letter in the alphabet
        int position = doubledLetter - 'a' + 1;

        // Multiply the position by 4
        int result = position * 4;
        return result;
    }

    /// # main
    ///
    /// Demonstrates the usage of `clubEntry` with sample words.
    ///
    /// ## Output Example
    /// ```text
    /// clubEntry("hill") ➞ 32
    /// clubEntry("apple") ➞ No doubled letter found
    /// clubEntry("bee") ➞ 8
    /// ```
    ///
    public static void main(String[] args) {
        String[] words = {"hill", "apple", "bee"};
        for (String word : words) {
            Integer number = clubEntry(word);
            if (number != null) {
                System.out.println("clubEntry(\"" + word + "\") ➞ " + number);
            } else {
                System.out.println("clubEntry(\"" + word + "\") ➞ No doubled letter found");
            }
        }
    }
}
