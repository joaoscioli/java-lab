package java_ebook_200_exercices;

public class ReplaceOccurrenceString {
    public static void main(String[] args) {
        // Example string
        String originalString = "Hello world, world!";

        // String to replace
        String searchString = "world";

        // Replacement string
        String replacementString = "universe";

        // Replace all occurrences of searchString with replacementString
        String modifiedString = originalString.replace(searchString, replacementString);

        // Display the result
        System.out.println("Original String: " + originalString);
        System.out.println("Modified String: " + modifiedString);
    }
}

// Original String: Hello world, world!
//Modified String: Hello universe, universe!