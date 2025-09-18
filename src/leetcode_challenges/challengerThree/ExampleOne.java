package leetcode_challenges.challengerThree;

import java.util.HashSet;

/// # ExampleOne
///
/// Utility class that provides a method to count the number of unique characters in a string.
///
/// ## Features
/// - Uses a `HashSet` to ensure uniqueness of characters.
/// - Returns the count of distinct characters found in the string.
///
/// ## Example
/// ```java
/// int result = ExampleOne.contarUnicos("hello");
/// System.out.println(result); // 4
/// ```
public class ExampleOne {

    /// Counts the number of unique characters in the given string.
    ///
    /// ## Parameters
    /// - `s`: the input string to analyze.
    ///
    /// ## Returns
    /// - The number of distinct characters in the string.
    ///
    /// ## Example
    /// ```java
    /// ExampleOne.contarUnicos("abc");      // returns 3
    /// ExampleOne.contarUnicos("aabbcc");   // returns 3
    /// ExampleOne.contarUnicos("hello");    // returns 4
    /// ```
    public static int contarUnicos(String s) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        return set.size();
    }

    /// Demonstrates the usage of `contarUnicos` with sample strings.
    ///
    /// ## Example
    /// ```java
    /// ExampleOne.main();
    /// ```
    ///
    /// ### Output
    /// ```text
    /// 3
    /// 3
    /// 4
    /// ```
    static void main() {
        System.out.println(contarUnicos("abc"));      // Deve imprimir 3
        System.out.println(contarUnicos("aabbcc"));   // Deve imprimir 3
        System.out.println(contarUnicos("hello"));    // Deve imprimir 4 (h, e, l, o)
    }
}
