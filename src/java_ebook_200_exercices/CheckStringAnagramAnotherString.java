package java_ebook_200_exercices;

import java.util.HashMap;

public class CheckStringAnagramAnotherString {

    /// ### cleanAndCount
    /// Cleans the input string and counts the frequency of each alphabetic character.
    ///
    /// This helper method:
    /// - Ignores any non-alphabetic characters.
    /// - Converts all characters to lowercase before counting.
    /// - Returns a map where each key is a character and each value is its frequency.
    ///
    /// #### Parameters
    /// - `s`: The input string to be processed.
    ///
    /// #### Returns
    /// A `HashMap<Character, Integer>` representing the frequency of each letter.
    ///
    /// #### Examples
    /// ```java
    /// cleanAndCount("Hello!");
    /// // {h=1, e=1, l=2, o=1}
    /// ```
    private static HashMap<Character, Integer> cleanAndCount(String s) {
        HashMap<Character, Integer> count = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                char lowerChar = Character.toLowerCase(c);
                count.put(lowerChar, count.getOrDefault(lowerChar, 0) + 1);
            }
        }

        return count;
    }

    /// ### areAnagrams
    /// Checks whether two strings are anagrams of each other.
    ///
    /// Two strings are considered *anagrams* when:
    /// - They contain the same alphabetic letters,
    /// - With the same frequency,
    /// - Ignoring case and non-alphabetic characters.
    ///
    /// This method uses `cleanAndCount` to normalize the input and compare
    /// the resulting character frequency maps.
    ///
    /// #### Parameters
    /// - `str1`: The first string.
    /// - `str2`: The second string.
    ///
    /// #### Returns
    /// `true` if the strings are anagrams, otherwise `false`.
    ///
    /// #### Examples
    /// ```java
    /// areAnagrams("Listen", "Silent"); // true
    /// areAnagrams("Hello", "World");   // false
    /// ```
    public static boolean areAnagrams(String str1, String str2) {
        HashMap<Character, Integer> count1 = cleanAndCount(str1);
        HashMap<Character, Integer> count2 = cleanAndCount(str2);

        return count1.equals(count2);
    }

    /// ### main
    /// Demonstrates the usage of the `areAnagrams` method by comparing two example strings.
    ///
    /// Prints the result to the console in a human-readable format.
    static void main() {
        String string1 = "listen";
        String string2 = "silent";

        boolean result = areAnagrams(string1, string2);
        System.out.println(string1 + " and " + string2 + " are anagrams: " + result);
    }
}
