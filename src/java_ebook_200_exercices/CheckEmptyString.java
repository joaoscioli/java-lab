package java_ebook_200_exercices;

/// # CheckEmptyString
///
/// This class provides a utility method to check if a given string is empty.
/// It also includes a demonstration in the `main` method.
///
/// ## Example
/// ```java
/// String emptyString = "";
/// String nonEmptyString = "Hello, world!";
///
/// System.out.println("Is emptyString empty? " + CheckEmptyString.isEmptyString(emptyString));
/// System.out.println("Is nonEmptyString empty? " + CheckEmptyString.isEmptyString(nonEmptyString));
/// ```
///
/// **Output:**
/// ```text
/// Is emptyString empty? true
/// Is nonEmptyString empty? false
/// ```
public class CheckEmptyString {

    /// Checks whether the given string is empty.
    ///
    /// @param string the string to be checked
    /// @return `true` if the string has no characters, otherwise `false`
    /// @throws NullPointerException if the input string is `null`
    public static boolean isEmptyString(String string) {
        return string.isEmpty();
    }

    /// Demonstrates the usage of the `isEmptyString` method with empty and non-empty strings.
    public static void main(String[] args) {
        String emptyString = "";
        String nonEmptyString = "Hello, world!";

        System.out.println("Is emptyString empty? " + isEmptyString(emptyString));
        System.out.println("Is nonEmptyString empty? " + isEmptyString(nonEmptyString));
    }
}
