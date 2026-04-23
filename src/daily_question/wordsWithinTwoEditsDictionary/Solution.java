package daily_question.wordsWithinTwoEditsDictionary;

import java.util.ArrayList;
import java.util.List;

/// ## Solution
///
/// Provides a method to find all words from the `queries` array that can match
/// at least one word in the `dictionary` array with **at most two character edits**.
///
/// An edit is defined as changing a single character in the string.
/// All words are assumed to have the same length.
class Solution {

    /// ### twoEditWords
    ///
    /// Iterates through each query word and checks if it can be transformed
    /// into any word in the dictionary with **at most two edits**.
    ///
    /// If such a match is found, the query word is added to the result list.
    ///
    /// ---
    /// **Parameters:**
    /// - `queries`: Array of query strings to evaluate.
    /// - `dictionary`: Array of valid dictionary words.
    ///
    /// **Returns:**
    /// - A list of query words that match at least one dictionary word
    ///   within two edits.
    ///
    /// ---
    /// **Time Complexity:**
    /// - `O(q * d * n)`
    ///   - `q` = number of queries
    ///   - `d` = number of dictionary words
    ///   - `n` = length of each word
    ///
    /// **Space Complexity:**
    /// - `O(q)` for storing the result.
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();

        for (String query : queries) {
            for (String word : dictionary) {
                if (isWithinTwoEdits(query, word)) {
                    result.add(query);
                    break;
                }
            }
        }

        return result;
    }

    /// ### isWithinTwoEdits
    ///
    /// Compares two strings character by character and counts the number
    /// of positions where they differ.
    ///
    /// Returns `true` if the number of differing characters is **at most 2**.
    ///
    /// ---
    /// **Parameters:**
    /// - `a`: First string.
    /// - `b`: Second string.
    ///
    /// **Returns:**
    /// - `true` if the strings differ by at most 2 characters.
    /// - `false` otherwise.
    ///
    /// ---
    /// **Assumptions:**
    /// - Both strings have the same length.
    ///
    /// ---
    /// **Time Complexity:**
    /// - `O(n)` where `n` is the length of the strings.
    private boolean isWithinTwoEdits(String a, String b) {
        int diff = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff > 2) return false;
            }
        }

        return true;
    }
}