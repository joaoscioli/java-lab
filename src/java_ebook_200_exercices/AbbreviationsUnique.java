package java_ebook_200_exercices;

import java.util.HashMap;
import java.util.List;

public class AbbreviationsUnique {
    public static boolean uniqueAbbrev(String[] abbreviations, String[] words) {
        // Create a map where each abbreviation maps to the words it can represent
        HashMap<String, List<String>> abbrevMap = new HashMap<>();

        for (String word : words) {
            String abbrev = word.substring(0, 1); // Use the first character as abbreviation
            abbrevMap.computeIfAbsent(abbrev, k -> new java.util.ArrayList<>()).add(word);
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

    public static void main(String[] args) {
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

// Output:
// uniqueAbbrev(["ho", "h", "ha"], ["house", "hope", "happy"]) ➞ true
// uniqueAbbrev(["s", "t", "v"], ["stamina", "television", "vindaloo"]) ➞ false
// uniqueAbbrev(["bi", "ba", "bat"], ["big", "bard", "battery"]) ➞ false
// uniqueAbbrev(["mo", "ma", "me"], ["moment", "many", "mean"]) ➞ true