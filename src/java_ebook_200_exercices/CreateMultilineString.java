package java_ebook_200_exercices;

public class CreateMultilineString {
    public static void main(String[] args) {
        // Multiline string using triple quotes (Java 13 and later)
        String multilineString = """
            This is a multiline string.
            It spans multiple lines.
            You can include line breaks and indentation easily.
            """;
        System.out.println(multilineString);
    }
}

/*
This is a multiline string.
It spans multiple lines.
You can include line breaks and indentation easily.
*/