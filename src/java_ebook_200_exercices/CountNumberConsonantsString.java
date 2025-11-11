package java_ebook_200_exercices;

public class CountNumberConsonantsString {
    // Method to count the number of consonants in a string
    public static int countConsonants(String inputStr) {

        // Define a string of consonant characters
        String consonants = "bcdfghjklmnpqrstvwxyz";
        int count = 0;

        // Convert the input string to lowercase and iterate through each character
        for (char c : inputStr.toLowerCase().toCharArray()) {

            // Check if the character is a consonant
            if (consonants.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String testString = "Hello World";
        int result = countConsonants(testString);
        System.out.println("The number of consonants in '" + testString + "' is: " + result);
    }
}

/*
Output:
The number of consonants in 'Hello World' is: 7
*/
