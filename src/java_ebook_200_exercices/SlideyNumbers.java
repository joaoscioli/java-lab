package java_ebook_200_exercices;

import java.util.ArrayList;
import java.util.List;

public class SlideyNumbers {

    // Method to check if a number is slidey
    public static boolean isSlidey(int n) {

        // Convert the number to a string and extract digits
        List<Integer> digits = new ArrayList<>();
        for (char c : Integer.toString(n).toCharArray()) {
            digits.add(Character.getNumericValue(c));
        }

        // All single-digit numbers are considered slidey
        if (digits.size() <= 1) {
            return true;
        }

        // Check the absolute difference between consecutive digits
        for (int i = 0; i < digits.size() - 1; i++) {
            if (Math.abs(digits.get(i) - digits.get(i + 1)) != 1) {
                return false; // Not slidey if the difference is not 1
            }
        }
        return true; // If all checks pass, it's slidey
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isSlidey(123454321)); // Outputs: true
        System.out.println(isSlidey(54345));     // Outputs: true
        System.out.println(isSlidey(987654321)); // Outputs: true
        System.out.println(isSlidey(1123));      // Outputs: false
        System.out.println(isSlidey(1357));      // Outputs: false
    }
}
