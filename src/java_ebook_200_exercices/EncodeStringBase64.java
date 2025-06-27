package java_ebook_200_exercices;

import java.util.Base64;

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

/*
Original String: Hello, 你好!
Base64 Encoded String: SGVsbG8sIOS9oOWlvSE=
*/
