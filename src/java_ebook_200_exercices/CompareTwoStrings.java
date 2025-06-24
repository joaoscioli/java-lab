package java_ebook_200_exercices;

public class CompareTwoStrings {
    public static void main(String[] args) {
        // Example strings
        String string1 = "Hello";
        String string2 = "hello";

        // Case-sensitive comparison
        boolean caseSensitiveComparison = string1.equals(string2);

        // Case-insensitive comparison
        boolean caseInsensitiveComparison = string1.equalsIgnoreCase(string2);

        // Display the results
        System.out.println("Case-sensitive comparison: " + caseSensitiveComparison);
        System.out.println("Case-insensitive comparison: " + caseInsensitiveComparison);
    }
}

/*
Case-sensitive comparison: false
Case-insensitive comparison: true
*/
