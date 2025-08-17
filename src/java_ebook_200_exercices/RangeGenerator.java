package java_ebook_200_exercices;

import java.util.ArrayList;
import java.util.List;

public class RangeGenerator {
    // Method to generate a range of numbers from start to end
    public static List<Integer> generateNumberRange(int start, int end) {
        List<Integer> numberRange = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            numberRange.add(i);
        }
        return numberRange;
    }

    // Method to generate a range of characters from start to end
    public static List<Character> generateCharRange(char start, char end) {
        List<Character> charRange = new ArrayList<>();
        for (char c = start; c <= end; c++) {
            charRange.add(c);
        }
        return charRange;
    }

    public static void main(String[] args) {

        // Generate numbers from 1 to 5
        List<Integer> numberRange = generateNumberRange(1, 5);
        System.out.println("Number Range: " + numberRange);

        // Generate characters from 'a' to 'e'
        List<Character> charRange = generateCharRange('a', 'e');
        System.out.println("Character Range: " + charRange);
    }
}
