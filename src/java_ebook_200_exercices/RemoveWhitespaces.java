package java_ebook_200_exercices;

public class RemoveWhitespaces {
    public static void main(String[] args) {
        String textWithWhitespaces = "This is a text with spaces";
        String textWithoutWhitespaces = removeWhitespaces(textWithWhitespaces);
        System.out.println("Original Text: " + textWithWhitespaces);
        System.out.println("Text without Whitespaces: " + textWithoutWhitespaces);
    }

    public static String removeWhitespaces(String inputText) {
        // Replace all whitespace characters with an empty string
        return inputText.replaceAll("\\s", "");
    }
}

// Output:
// Original Text: This is a text with spaces
// Text without Whitespaces: Thisisatextwithspaces
