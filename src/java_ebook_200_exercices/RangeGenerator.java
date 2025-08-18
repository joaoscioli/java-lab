package java_ebook_200_exercices;

import java.util.ArrayList;
import java.util.List;

/// # RangeGenerator
///
/// A utility class for generating ranges of numbers and characters.
///
/// ## Features
/// - Generate a list of integers between a start and end value (inclusive).
/// - Generate a list of characters between a start and end character (inclusive).
///
/// ## Example
/// ```java
/// List<Integer> numbers = RangeGenerator.generateNumberRange(1, 5);
/// // Output: [1, 2, 3, 4, 5]
///
/// List<Character> chars = RangeGenerator.generateCharRange('a', 'e');
/// // Output: [a, b, c, d, e]
/// ```
public class RangeGenerator {

    /// Generates a list of integers from `start` to `end` (inclusive).
    ///
    /// ## Parameters
    /// - `start`: The starting integer.
    /// - `end`: The ending integer.
    ///
    /// ## Returns
    /// A `List<Integer>` containing all integers in the specified range.
    ///
    /// ## Example
    /// ```java
    /// List<Integer> numbers = RangeGenerator.generateNumberRange(1, 5);
    /// // [1, 2, 3, 4, 5]
    /// ```
    public static List<Integer> generateNumberRange(int start, int end) {
        List<Integer> numberRange = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            numberRange.add(i);
        }
        return numberRange;
    }

    /// Generates a list of characters from `start` to `end` (inclusive).
    ///
    /// ## Parameters
    /// - `start`: The starting character.
    /// - `end`: The ending character.
    ///
    /// ## Returns
    /// A `List<Character>` containing all characters in the specified range.
    ///
    /// ## Example
    /// ```java
    /// List<Character> chars = RangeGenerator.generateCharRange('a', 'e');
    /// // [a, b, c, d, e]
    /// ```
    public static List<Character> generateCharRange(char start, char end) {
        List<Character> charRange = new ArrayList<>();
        for (char c = start; c <= end; c++) {
            charRange.add(c);
        }
        return charRange;
    }

    /// Demonstrates the usage of the `generateNumberRange` and `generateCharRange` methods.
    ///
    /// ## Example
    /// ```java
    /// Number Range: [1, 2, 3, 4, 5]
    /// Character Range: [a, b, c, d, e]
    /// ```
    public static void main(String[] args) {

        // Generate numbers from 1 to 5
        List<Integer> numberRange = generateNumberRange(1, 5);
        System.out.println("Number Range: " + numberRange);

        // Generate characters from 'a' to 'e'
        List<Character> charRange = generateCharRange('a', 'e');
        System.out.println("Character Range: " + charRange);
    }
}
