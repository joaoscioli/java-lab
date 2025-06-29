package java_ebook_200_exercices;

public class ReplaceInstanceCharacterString {
    public static void main(String[] args) {
        // Example string
        String originalString = "Hello, World!";

        // Character to replace
        char charToReplace = 'l';

        // Replacement character
        char replacementChar = 'x';

        // Replace all instances of charToReplace with replacementChar
        String modifiedString = originalString.replace(charToReplace, replacementChar);

        // Display the result
        System.out.println("Original String: " + originalString);
        System.out.println("Modified String: " + modifiedString);
    }
}

/*
Original String: Hello, World!
Modified String: Hexxo, Worxd!
*/
