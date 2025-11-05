package java_ebook_200_exercices;

import java.util.HashMap;

public class ScoringSystem {
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

    public static void main(String[] args) {
        // Example usage
        System.out.println(java.util.Arrays.toString(calculateScores("A")));
        System.out.println(java.util.Arrays.toString(calculateScores("ABC")));
        System.out.println(java.util.Arrays.toString(calculateScores("ABCBACC")));
    }
}

/*
Output:
[1, 0, 0]
[1, 1, 1]
[2, 2, 3]
*/
