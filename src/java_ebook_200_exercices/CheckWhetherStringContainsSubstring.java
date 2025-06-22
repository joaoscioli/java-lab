package java_ebook_200_exercices;

public class CheckWhetherStringContainsSubstring {
    public static void main(String[] args) {

        // Example string
        String mainString = "Hello, World!";
        String substringToCheck = "World";

        // Check if mainString contains substringToCheck
        boolean containsSubstring = mainString.contains(substringToCheck);

        // Display the result
        System.out.println("Does the string contain '" + substringToCheck + "'? " + containsSubstring);
    }
}

/*
Does the string contain 'World'? true
*/
