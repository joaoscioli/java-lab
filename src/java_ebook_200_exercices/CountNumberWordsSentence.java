package java_ebook_200_exercices;

public class CountNumberWordsSentence {
    public static int countWords(String sentence) throws IllegalArgumentException{
        // Check if the input is a valid non-empty string
        if (sentence == null || sentence.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid input. Please provide a valid sentence.");
        }

        // Count the words in the sentence
        String[] words = sentence.trim().split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        String sentence = "This is a sample sentence.";
        try {
            int wordCount = countWords(sentence);
            System.out.printf("The sentence \"%s\" has %d words.%n", sentence, wordCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

// Output: The sentence "This is a sample sentence." has 5 words.
