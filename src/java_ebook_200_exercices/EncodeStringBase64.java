package java_ebook_200_exercices;

import java.util.Base64;

/// # EncodeStringBase64
///
/// This program demonstrates how to encode a string into Base64 format using Java's
/// built-in `Base64` class from the `java.util` package.
///
/// ## Overview
/// The program defines a string containing both ASCII and non-ASCII characters
/// (e.g., English and Chinese). It then encodes this string into Base64 using:
///
/// ```java
/// Base64.getEncoder().encodeToString(originalString.getBytes());
/// ```
///
/// ## Input
/// - Original String: `"Hello, 你好!"`
///
/// ## Output
/// ```text
/// Original String: Hello, 你好!
/// Base64 Encoded String: SGVsbG8sIOS9oOWlvSE=
/// ```
///
/// ## Use Cases
/// Base64 encoding is commonly used to:
/// - Transmit binary data over text-based protocols (e.g., HTTP, JSON).
/// - Store data in encoded form for configuration or transfer.
/// - Encode credentials or tokens (e.g., Basic Auth).
///
/// ## See Also
/// - [`Base64` class documentation](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Base64.html)
///
public class EncodeStringBase64 {
    public static void main(String[] args) {

        // Original string
        String originalString = "Hello, 你好!";

        // Encode the string to Base64
        String base64EncodedString = Base64.getEncoder().encodeToString(originalString.getBytes());

        // Display the result
        System.out.println("Original String: " + originalString);
        System.out.println("Base64 Encoded String: " + base64EncodedString);
    }
}
