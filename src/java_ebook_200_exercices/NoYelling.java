package java_ebook_200_exercices;

public class NoYelling {
    // Method to remove extra exclamation or question marks from the end of a sentence
    public static String noYelling(String sentence) {

    // Remove trailing '!' or '?' from the sentence
        String trimmed = sentence.replaceAll("[!?]+$", "");
        char lastChar = sentence.charAt(sentence.length() - 1);

        // Check if the last character was '!' or '?'
        if (lastChar == '!') {
            return trimmed + "!";
        } else if (lastChar == '?') {
            return trimmed + "?";
        } else {
            return sentence;
        }
    }

    public static void main(String[] args) {
        System.out.println(noYelling("What went wrong?????????"));  // ➞ "What went wrong?"
        System.out.println(noYelling("Oh my goodness!!!"));         // ➞ "Oh my goodness!"
        System.out.println(noYelling("I just!!! can!!! not!!! believe!!! it!!!")); // ➞ "I just!!! can!!! not!!! believe!!! it!"
        System.out.println(noYelling("Oh my goodness!"));           // ➞ "Oh my goodness!"
        System.out.println(noYelling("I just cannot believe it.")); // ➞ "I just cannot believe it."
    }
}
