package java_ebook_200_exercices;

/// # CapitalizeFirstLetter
///
/// Utility class that provides a method to capitalize the first letter of a string.
public class CapitalizeFirstLetter {

    /// ## capitalizeFirstLetter
    ///
    /// Capitalizes the first letter of the given string.
    ///
    /// - If the input string is empty, the method returns `"Empty String"`.
    /// - Otherwise, it converts the first character to uppercase and keeps the rest unchanged.
    ///
    /// ### Parameters
    /// - `string`: The input string to be processed.
    ///
    /// ### Returns
    /// - A string with the first character capitalized.
    /// - `"Empty String"` if the input string is empty.
    ///
    /// ### Examples
    /// ```java
    /// String text = "hello, world!";
    /// String result = CapitalizeFirstLetter.capitalizeFirstLetter(text);
    /// // result -> "Hello, world!"
    /// ```
    public static String capitalizeFirstLetter(String string) {
        if (string.isEmpty()) {
            return "Empty String";
        }
        char firstChar = Character.toUpperCase(string.charAt(0));
        String rest = string.substring(1);
        return firstChar + rest;
    }

    /// ## main
    ///
    /// Demonstrates the usage of the `capitalizeFirstLetter` method.
    ///
    /// Prints both the original and capitalized strings to the console.
    ///
    /// ### Output
    /// ```
    /// Original String: hello, world!
    /// Capitalized String: Hello, world!
    /// ```
    static void main() {
        String originalString = "hello, world!";
        String capitalizedString = capitalizeFirstLetter(originalString);
        System.out.println("Original String: " + originalString);
        System.out.println("Capitalized String: " + capitalizedString);
    }
}
