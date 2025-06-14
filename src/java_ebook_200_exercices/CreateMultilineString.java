package java_ebook_200_exercices;

/// # CreateMultilineString
/// Demonstrates how to declare and use a multiline string in Java using **text blocks**, introduced in Java 13.
///
/// ## Description
/// This example uses triple quotes (`"""`) to define a string that spans multiple lines.
/// Text blocks make it easier to write and read strings that contain line breaks, indentation, or formatted content.
///
/// ## Output
/// ```text
/// This is a multiline string.
/// It spans multiple lines.
/// You can include line breaks and indentation easily.
/// ```
public class CreateMultilineString {

    /// Program entry point.
    ///
    /// Defines a multiline string using a text block and prints it to the console.
    /// This syntax is available in Java 13 and later.
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
