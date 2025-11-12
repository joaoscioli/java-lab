package java_ebook_200_exercices;

/// # CountNumberConsonantsString
///
/// This class provides a utility method to **count the number of consonants**
/// in a given string. It processes the input by converting it to lowercase and
/// iterating over each character to verify if it belongs to the consonant set.
///
/// ## Example
/// ```java
/// String testString = "Hello World";
/// int result = CountNumberConsonantsString.countConsonants(testString);
/// System.out.println("The number of consonants in '" + testString + "' is: " + result);
/// ```
///
/// **Output:**
/// ```text
/// The number of consonants in 'Hello World' is: 7
/// ```
public class CountNumberConsonantsString {

    /// ## countConsonants
    ///
    /// Counts the total number of consonant letters in a given string.
    ///
    /// ### Parameters
    /// - `inputStr`: The input string in which consonants will be counted.
    ///
    /// ### Returns
    /// - The total number of consonants found in the string.
    ///
    /// ### Details
    /// - The method converts the input string to lowercase to ensure consistent comparison.
    /// - Only English consonant characters (`bcdfghjklmnpqrstvwxyz`) are considered.
    ///
    /// ### Example
    /// ```java
    /// int count = CountNumberConsonantsString.countConsonants("Programming");
    /// System.out.println(count); // Output: 8
    /// ```
    public static int countConsonants(String inputStr) {

        // Define a string of consonant characters
        String consonants = "bcdfghjklmnpqrstvwxyz";
        int count = 0;

        // Convert the input string to lowercase and iterate through each character
        for (char c : inputStr.toLowerCase().toCharArray()) {

            // Check if the character is a consonant
            if (consonants.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    /// ## main
    ///
    /// Demonstrates the use of the `countConsonants` method by counting
    /// consonants in a sample string and printing the result.
    public static void main(String[] args) {
        String testString = "Hello World";
        int result = countConsonants(testString);
        System.out.println("The number of consonants in '" + testString + "' is: " + result);
    }
}
