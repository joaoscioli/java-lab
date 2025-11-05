package java_ebook_200_exercices;

import java.util.HashMap;

public class ScoringSystem {

    /// # `calculateScores`
    ///
    /// Calculates the number of occurrences for each player's identifier in a given score string.
    /// The players are represented by the characters:
    /// - **A** → Andy
    /// - **B** → Ben
    /// - **C** → Charlotte
    ///
    /// ## Parameters
    /// - `scoreString` — A string containing uppercase letters representing players’ scores.
    ///
    /// ## Returns
    /// An integer array containing the scores in the following order:
    /// ```
    /// [Andy (A), Ben (B), Charlotte (C)]
    /// ```
    ///
    /// ## Example
    /// ```java
    /// calculateScores("ABCBACC");
    /// // Returns: [2, 2, 3]
    /// ```
    ///
    /// ## Implementation Details
    /// - Initializes a `HashMap` to store scores for each player.
    /// - Iterates through each character in the input string.
    /// - Updates the count of each player.
    /// - Returns the results in a fixed order `[A, B, C]`.
    ///
    public static int[] calculateScores(String scoreString) {
        // Initialize the scores for Andy (A), Ben (B), and Charlotte (C)
        HashMap<Character, Integer> scores = new HashMap<>();
        scores.put('A', 0);
        scores.put('B', 0);
        scores.put('C', 0);

        // Count occurrences of each letter in the string
        for (char ch : scoreString.toCharArray()) {
            scores.put(ch, scores.getOrDefault(ch, 0) + 1);
        }

        // Return the scores in the order: Andy (A), Ben (B), Charlotte (C)
        return new int[] {
                scores.getOrDefault('A', 0),
                scores.getOrDefault('B', 0),
                scores.getOrDefault('C', 0)
        };
    }

    /// # `main`
    ///
    /// Demonstrates the use of the `calculateScores` method by printing the results
    /// for several example inputs.
    ///
    /// ## Example
    /// ```java
    /// Input:  "A"
    /// Output: [1, 0, 0]
    ///
    /// Input:  "ABC"
    /// Output: [1, 1, 1]
    ///
    /// Input:  "ABCBACC"
    /// Output: [2, 2, 3]
    /// ```
    ///
    public static void main(String[] args) {
        // Example usage
        System.out.println(java.util.Arrays.toString(calculateScores("A")));
        System.out.println(java.util.Arrays.toString(calculateScores("ABC")));
        System.out.println(java.util.Arrays.toString(calculateScores("ABCBACC")));
    }
}
