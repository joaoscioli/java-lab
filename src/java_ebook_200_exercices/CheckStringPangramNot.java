package java_ebook_200_exercices;

public class CheckStringPangramNot {
    public static boolean isPangram(String inputStr) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String lowercasedStr = inputStr.toLowerCase();

        for (char ch : alphabet.toCharArray()) {
            if (lowercasedStr.indexOf(ch) == -1) {
                return false;
            }
        }
        return true;
    }

    static void main() {
        // Example usage
        String inputString = "The quick brown fox jumps over the lazy dog";
        if (isPangram(inputString)) {
            System.out.println("The given string is a pangram! 🎉");
        } else {
            System.out.println("The given string is not a pangram. 😢");
        }
    }
}
