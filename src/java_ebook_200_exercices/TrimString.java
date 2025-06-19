package java_ebook_200_exercices;

public class TrimString {
    public static void main(String[] args) {
        // Example string with leading and trailing whitespaces
        String stringWithSpaces = "   Hello, World! ";

        // Trim the string
        String trimmedString = stringWithSpaces.trim();

        // Display the result
        System.out.println("Original String: '" + stringWithSpaces + "'");
        System.out.println("Trimmed String: '" + trimmedString + "'");
    }
}

/*
Original String: '   Hello, World! '
Trimmed String: 'Hello, World!'
*/