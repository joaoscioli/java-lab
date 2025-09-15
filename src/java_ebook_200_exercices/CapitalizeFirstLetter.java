package java_ebook_200_exercices;

public class CapitalizeFirstLetter {
    public static String capitalizeFirstLetter(String string) {
        if (string.isEmpty()) {
            return "Empty String";
        }
        char firstChar = Character.toUpperCase(string.charAt(0));
        String rest = string.substring(1);
        return firstChar + rest;
    }

    static void main() {
        String originalString = "hello, world!";
        String capitalizedString = capitalizeFirstLetter(originalString);
        System.out.println("Original String: " + originalString);
        System.out.println("Capitalized String: " + capitalizedString);
    }
}

// Output:
// Original String: hello, world!
// Capitalized String: Hello, world!