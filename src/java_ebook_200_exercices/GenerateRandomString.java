package java_ebook_200_exercices;

import java.security.SecureRandom;

/// # GenerateRandomString
///
/// This class provides functionality to generate a random alphanumeric string.
/// It uses a secure random number generator to ensure high-quality randomness.
///
/// ## Example usage:
/// ```java
/// String randomStr = GenerateRandomString.generateRandomString(8);
/// System.out.println("Random String: " + randomStr);
/// ```
///
/// ## Output example:
/// ```text
/// Random String: jQmNYWWC
/// ```
public class GenerateRandomString {

    /// The set of characters used to generate the random string.
    private static final String ALPHANUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    /// The default length for generated random strings.
    private static final int RANDOM_STRING_LENGTH = 8;

    /// A secure random number generator for producing cryptographically strong random values.
    private static final SecureRandom random = new SecureRandom();

    /// The main method to demonstrate the random string generation.
    ///
    /// It generates a random string of length `RANDOM_STRING_LENGTH`
    /// and prints it to the console.
    public static void main(String[] args) {
        String randomString = generateRandomString(RANDOM_STRING_LENGTH);
        System.out.println("Random String: " + randomString);
    }

    /// Generates a random alphanumeric string of the specified length.
    ///
    /// @param length the desired length of the random string
    /// @return a randomly generated string containing letters and digits
    ///
    /// ## Example:
    /// ```java
    /// String str = GenerateRandomString.generateRandomString(10);
    /// ```
    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(ALPHANUMERIC.length());
            sb.append(ALPHANUMERIC.charAt(index));
        }

        return sb.toString();
    }
}
