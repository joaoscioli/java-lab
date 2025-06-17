package java_ebook_200_exercices;

public class CheckStringStartsAnotherString {
    public static void main(String[] args) {
        // Example strings
        String mainString = "Hello, World!";
        String searchString = "Hello";

        // Check if mainString starts with searchString
        boolean startsWith = mainString.startsWith(searchString);

        // Display the result
        System.out.println("Does the string start with '" + searchString + "'? " + startsWith);
    }
}

/*
Does the string start with 'Hello'? true
*/
