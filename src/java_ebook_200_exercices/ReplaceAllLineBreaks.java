package java_ebook_200_exercices;

public class ReplaceAllLineBreaks {
    public static void main(String[] args) {
        // Example string with line breaks
        String stringWithLineBreaks = "Hello,\nWorld!\nThis is a new line.";

        // Replacement string
        String replacementString = "-";

        // Replace all line breaks with the replacement string
        String stringWithoutLineBreaks = stringWithLineBreaks.replace("\n", replacementString);

        // Display the result
        System.out.println("Original String:");
        System.out.println(stringWithLineBreaks);
        System.out.println("\nString without Line Breaks:");
        System.out.println(stringWithoutLineBreaks);
    }
}

/*
Original String:
Hello,
World!
This is a new line.
String without Line Breaks:
Hello,-World!-This is a new line.
*/