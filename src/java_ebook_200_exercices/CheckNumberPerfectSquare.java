package java_ebook_200_exercices;

public class CheckNumberPerfectSquare {
    public static boolean isPerfectSquare(double number) {

        // Check if the number is a non-negative value
        if (number < 0) {
            return false;
        }

        // Calculate the square root of the number
        double squareRoot = Math.sqrt(number);

        // Check if the square of the integer part of the square root is equal to the original number
        return squareRoot == Math.floor(squareRoot);
    }

    public static void main(String[] args) {
        double testNumber = 25.0;
        boolean result = isPerfectSquare(testNumber);

        System.out.printf("Is %.1f a perfect square? %b%n", testNumber, result);
    }
}

// Output: Is 25.0 a perfect square? true
