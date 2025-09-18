package leetcode_challenges.challengerThree;

import java.util.HashSet;

/// # ExampleTwo
///
/// Utility class that provides a method to compute the length of the longest prefix
/// without repeating characters in a string.
///
/// ## Features
/// - Iterates over the input string and checks for repeated characters.
/// - Returns the size of the unique prefix before the first repetition.
/// - If no repetition is found, returns the length of the entire string.
///
/// ## Example
/// ```java
/// int result = ExampleTwo.maiorPrefixoSemRepeticao("abcabcbb");
/// System.out.println(result); // 3
/// ```
public class ExampleTwo {

    /// Finds the length of the longest prefix of the given string
    /// without repeating characters.
    ///
    /// ## Parameters
    /// - `s`: the input string to analyze.
    ///
    /// ## Returns
    /// - The length of the longest prefix with unique characters.
    ///
    /// ## Example
    /// ```java
    /// ExampleTwo.maiorPrefixoSemRepeticao("abcd");     // returns 4
    /// ExampleTwo.maiorPrefixoSemRepeticao("aabbcc");   // returns 1
    /// ExampleTwo.maiorPrefixoSemRepeticao("abcabcbb"); // returns 3
    /// ```
    public static int maiorPrefixoSemRepeticao(String s) {
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                return set.size();
            }
            set.add(c);
        }
        // if no repetition is found, the prefix is the whole string
        return set.size();
    }

    /// Demonstrates the usage of `maiorPrefixoSemRepeticao` with sample strings.
    ///
    /// ## Example
    /// ```java
    /// ExampleTwo ex = new ExampleTwo();
    /// ex.main();
    /// ```
    ///
    /// ### Output
    /// ```text
    /// 3
    /// 4
    /// 1
    /// ```
    public void main() {
        System.out.println(maiorPrefixoSemRepeticao("abcabcbb")); // Deve imprimir 3
        System.out.println(maiorPrefixoSemRepeticao("abcd"));     // Deve imprimir 4
        System.out.println(maiorPrefixoSemRepeticao("aabbcc"));   // Deve imprimir 1
    }
}
