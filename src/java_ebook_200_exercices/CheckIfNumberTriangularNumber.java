package java_ebook_200_exercices;

public class CheckIfNumberTriangularNumber {
    // Method to check if a number is a triangular number
    public static boolean isTriangularNumber(int num) {
        // Check if the input is a non-negative integer
        if (num <= 0) {
            return false; // Zero and negative numbers are not considered triangular numbers
        }
        int total = 0;
        int n = 1;
        // Iterate through natural numbers until the sum exceeds or equals the input number
        while (total < num) {
            total += n;
            n++;
        }
        // Check if input number is equal to a triangular number
        return total == num;
    }

    static void main() {
        int testNumber = 10;
        boolean result = isTriangularNumber(testNumber);
        System.out.println(testNumber + " is a triangular number: " + result);
    }
}

/**
 * Output:
 * 10 is a triangular number: true
 */
