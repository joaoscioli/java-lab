package java_ebook_200_exercices;

public class ClubEntry {
    public static Integer clubEntry(String word) {
        // Find the doubled letter
        Character doubledLetter = null;

        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) == word.charAt(i + 1)) {
                doubledLetter = word.charAt(i);
                break;
            }
        }

        // Ensure that a doubled letter was found
        if (doubledLetter == null) {
            return null; // No doubled letter found
        }

        // Calculate the position of the letter in the alphabet
        int position = doubledLetter - 'a' + 1;

        // Multiply the position by 4
        int result = position * 4;
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"hill", "apple", "bee"};
        for (String word : words) {
            Integer number = clubEntry(word);
            if (number != null) {
                System.out.println("clubEntry(\"" + word + "\") ➞ " + number);
            } else {
                System.out.println("clubEntry(\"" + word + "\") ➞ No doubled letter found");
            }
        }
    }
}

// Output:
// clubEntry("hill") ➞ 32
// clubEntry("apple") ➞ No doubled letter found
// clubEntry("bee") ➞ 8

