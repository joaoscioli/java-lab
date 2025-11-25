package java_ebook_200_exercices;

import java.util.HashMap;
import java.util.List;

public class AbbreviationsUnique {

    /// # uniqueAbbrev
    ///
    /// Verifies whether each abbreviation in the given list uniquely identifies
    /// exactly one word from the provided list of words.
    ///
    /// ## How it works
    /// - The method creates a mapping between each abbreviation and the list of
    ///   words that start with that abbreviation.
    /// - An abbreviation is considered **unique** if it corresponds to *exactly one*
    ///   word in the mapping.
    /// - If *any* abbreviation maps to zero or multiple words, the method returns `false`.
    ///
    /// ## Parameters
    /// - `abbreviations`: An array of abbreviations to validate.
    /// - `words`: An array of words used to build the abbreviation-to-word mapping.
    ///
    /// ## Returns
    /// - `true` if **all** abbreviations uniquely map to exactly one word.
    /// - `false` otherwise.
    ///
    /// ## Example
    /// ```java
    /// uniqueAbbrev(new String[]{"ho", "h", "ha"}, new String[]{"house", "hope", "happy"});
    /// // ➞ true
    /// ```
    ///
    /// ## Notes
    /// - Only the **first character** of each word is considered as its abbreviation
    ///   when constructing the mapping.
    ///
    public static boolean uniqueAbbrev(String[] abbreviations, String[] words) {

        // Create a map where each abbreviation maps to the words it can represent
        HashMap<String, List<String>> abbrevMap = new HashMap<>();

        for (String word : words) {
            String abbrev = word.substring(0, 1); // Use the first character as abbreviation
            abbrevMap.computeIfAbsent(abbrev, _ -> new java.util.ArrayList<>()).add(word);
        }

        // Check that each abbreviation is unique
        for (String abbrev : abbreviations) {
            List<String> correspondingWords = abbrevMap.get(abbrev);
            if (correspondingWords == null || correspondingWords.size() != 1) {
                return false; // Abbreviation is not unique
            }
        }
        return true; // All abbreviations are unique
    }

    /// # main
    ///
    /// Demonstrates usage of the `uniqueAbbrev` method with various examples.
    ///
    /// Prints the results to the console.
    ///
    static void main() {
        // Example usage
        String[] abbreviations1 = {"ho", "h", "ha"};
        String[] words1 = {"house", "hope", "happy"};
        System.out.println("uniqueAbbrev([\"ho\", \"h\", \"ha\"], [\"house\", \"hope\", \"happy\"]) ➞ " + uniqueAbbrev(abbreviations1, words1));

        String[] abbreviations2 = {"s", "t", "v"};
        String[] words2 = {"stamina", "television", "vindaloo"};
        System.out.println("uniqueAbbrev([\"s\", \"t\", \"v\"], [\"stamina\", \"television\", \"vindaloo\"]) ➞ " + uniqueAbbrev(abbreviations2, words2));

        String[] abbreviations3 = {"bi", "ba", "bat"};
        String[] words3 = {"big", "bard", "battery"};
        System.out.println("uniqueAbbrev([\"bi\", \"ba\", \"bat\"], [\"big\", \"bard\", \"battery\"]) ➞ " + uniqueAbbrev(abbreviations3, words3));

        String[] abbreviations4 = {"mo", "ma", "me"};
        String[] words4 = {"moment", "many", "mean"};
        System.out.println("uniqueAbbrev([\"mo\", \"ma\", \"me\"], [\"moment\", \"many\", \"mean\"]) ➞ " + uniqueAbbrev(abbreviations4, words4));
    }
}
