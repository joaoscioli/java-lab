
package java_ebook_200_exercices;

import java.security.SecureRandom;

public class GenerateRandomString {
    private static final String ALPHANUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int RANDOM_STRING_LENGTH = 8;
    private static final SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        // Generate a random string of length 8
        String randomString = generateRandomString(RANDOM_STRING_LENGTH);

        // Display the random string
        System.out.println("Random String: " + randomString);
    }

    // Function to generate a random string of a given length
    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(ALPHANUMERIC.length());
            sb.append(ALPHANUMERIC.charAt(index));
        }
        return sb.toString();
    }
}

/*
Random String: jQmNYWWC
*/