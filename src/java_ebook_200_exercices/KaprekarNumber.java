package java_ebook_200_exercices;

public class KaprekarNumber {
    // Method to check if a number is a Kaprekar number
    public static boolean isKaprekar(long n) {
        if (n == 0 || n == 1) {
            return true; // 0 and 1 are Kaprekar numbers
        }

        // Calculate the square of n
        long square = n * n;
        String squareStr = Long.toString(square);
        int len = squareStr.length();

        // Split the squared number into left and right parts
        String leftStr, rightStr;

        if (len == 1) {
            leftStr = ""; // Only right part
            rightStr = squareStr;
        } else {
            int splitIndex = len / 2;
            leftStr = squareStr.substring(0, len - splitIndex);
            rightStr = squareStr.substring(len - splitIndex);
        }

        // Convert left and right parts to numbers
        long left = leftStr.isEmpty() ? 0 : Long.parseLong(leftStr);
        long right = rightStr.isEmpty() ? 0 : Long.parseLong(rightStr);

        // Check if the sum of left and right equals n
        return left + right == n;
    }

    public static void main(String[] args) {
        // Test cases
        // Output: false
        System.out.println("isKaprekar(3) ➞ " + isKaprekar(3));

        // Output: false
        System.out.println("isKaprekar(5) ➞ " + isKaprekar(5));

        // Output: true
        System.out.println("isKaprekar(297) ➞ " + isKaprekar(297));
    }
}
