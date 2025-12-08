package java_ebook_200_exercices;

import java.util.HashMap;

public class CheckStringAnagramAnotherString {

    // Helper function to clean the string and count letters
    private static HashMap<Character, Integer> cleanAndCount(String s) {
        HashMap<Character, Integer> count = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                char lowerChar = Character.toLowerCase(c);
                count.put(lowerChar, count.getOrDefault(lowerChar, 0) + 1);
            }
        }

        return count;
    }

    public static boolean areAnagrams(String str1, String str2) {
        // Get character counts for both strings
        HashMap<Character, Integer> count1 = cleanAndCount(str1);
        HashMap<Character, Integer> count2 = cleanAndCount(str2);

        // Compare the two frequency counts
        return count1.equals(count2);
    }

    public static void main(String[] args) {
        String string1 = "listen";
        String string2 = "silent";

        boolean result = areAnagrams(string1, string2);
        System.out.println(string1 + " and " + string2 + " are anagrams: " + result);
    }
}
