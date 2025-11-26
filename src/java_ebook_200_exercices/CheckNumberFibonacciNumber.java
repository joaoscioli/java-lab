package java_ebook_200_exercices;

public class CheckNumberFibonacciNumber {
    // Helper function to check if a number is a perfect square
    private static boolean isPerfectSquare(long n) {
        long sqrt = (long) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    public static boolean isFibonacciNumber(long num) {
        // A number is a Fibonacci number if and only if one of (5 * num^2 + 4) or (5 * num^2 - 4) is a perfect square
        long numSquared = num * num;
        return isPerfectSquare(5 * numSquared + 4) || isPerfectSquare(5 * numSquared - 4);
    }

    static void main() {
        long testNumber = 8;
        boolean result = isFibonacciNumber(testNumber);
        System.out.println(testNumber + " is a Fibonacci number: " + result);
    }
}
// Output:
// 8 is a Fibonacci number: true
