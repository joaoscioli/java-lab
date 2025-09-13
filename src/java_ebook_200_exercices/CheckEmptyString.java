package java_ebook_200_exercices;

public class CheckEmptyString {
    public static boolean isEmptyString(String string) {
        return string.isEmpty();
    }

    public static void main(String[] args) {
        String emptyString = "";
        String nonEmptyString = "Hello, world!";

        System.out.println("Is emptyString empty? " + isEmptyString(emptyString));
        System.out.println("Is nonEmptyString empty? " + isEmptyString(nonEmptyString));
    }
}

// Output:
// Is emptyString empty? true
// Is nonEmptyString empty? false