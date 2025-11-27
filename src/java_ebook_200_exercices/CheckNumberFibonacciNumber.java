package java_ebook_200_exercices;

public class CheckNumberFibonacciNumber {

    /// ## Checks if a number is a perfect square
    ///
    /// This helper method determines whether the given number `n`
    /// is a perfect square by comparing the squared value of its
    /// integer square root to the original number.
    ///
    /// ### Parameters
    /// - `n` – the number to check
    ///
    /// ### Returns
    /// - `true` if `n` is a perfect square
    /// - `false` otherwise
    private static boolean isPerfectSquare(long n) {
        long sqrt = (long) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    /// ## Checks if a number belongs to the Fibonacci sequence
    ///
    /// Determines whether a number `num` is part of the Fibonacci sequence.
    /// A number is Fibonacci if and only if **one or both** of the following
    /// expressions result in a perfect square:
    ///
    /// - `5 * num² + 4`
    /// - `5 * num² - 4`
    ///
    /// This mathematical identity allows efficient checking without
    /// generating the Fibonacci sequence.
    ///
    /// ### Parameters
    /// - `num` – the number to verify
    ///
    /// ### Returns
    /// - `true` if `num` is a Fibonacci number.
    /// - `false` otherwise
    public static boolean isFibonacciNumber(long num) {
        long numSquared = num * num;
        return isPerfectSquare(5 * numSquared + 4) || isPerfectSquare(5 * numSquared - 4);
    }

    /// ## Demonstrates the Fibonacci check
    ///
    /// A simple test method that evaluates whether a predefined number
    /// (in this case, `8`) belongs to the Fibonacci sequence and prints
    /// the result to the console.
    static void main() {
        long testNumber = 8;
        boolean result = isFibonacciNumber(testNumber);
        System.out.println(testNumber + " is a Fibonacci number: " + result);
    }
}

// Output:
// 8 is a Fibonacci number: true
