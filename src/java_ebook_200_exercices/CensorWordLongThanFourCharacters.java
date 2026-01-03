package java_ebook_200_exercices;

import java.io.IO;

public class CensorWordLongThanFourCharacters {
    public static String censor(String text) {
        // Split the text into words
        String[] words = text.split("\\s+");
        // Transform each words, replacing those longer than four characters
        StringBuilder censoredText = new StringBuilder();

        for (String word : words) {
            if (word.length() > 4) {
                // Replace with asterisks
                String censoredWord = "*".repeat(words.length);
                censoredText.append(censoredWord).append(" ");
            } else {
                censoredText.append(word).append(" ");
            }
        }
        // Return the censored words as a single string, trimming any trailing space
        return censoredText.toString().trim();
    }

    void main() {
        // Example usage
        IO.println(censor("The code is fourty"));
        IO.println(censor("Two plus three is five"));
        IO.println(censor("aaaa aaaaa 1234 12345"));
    }
}

// The code is ******
// Two plus ***** is five
// aaaa ***** 1234x *****