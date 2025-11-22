package java_ebook_200_exercices;

public class CheckIfNumberTriangularNumber {

    /// ## isTriangularNumber
    ///
    /// Determines whether a given integer is a **triangular number**.
    ///
    /// A triangular number represents a number that can be arranged
    /// in the shape of an equilateral triangle.
    /// They follow the pattern:
    ///
    /// \[
    /// T_n = \frac{n(n + 1)}{2}
    /// \]
    ///
    /// This method checks triangularity by iteratively summing natural numbers
    /// until the cumulative value is greater than or equal to the input.
    ///
    /// ### Parameters
    /// - `num` — The number to evaluate.
    ///
    /// ### Returns
    /// - `true` if the number is triangular.
    /// - `false` otherwise (including negative numbers or zero).
    ///
    /// ### Examples
    /// ```java
    /// CheckIfNumberTriangularNumber.isTriangularNumber(6);   // true
    /// CheckIfNumberTriangularNumber.isTriangularNumber(10);  // true
    /// CheckIfNumberTriangularNumber.isTriangularNumber(11);  // false
    /// ```
    public static boolean isTriangularNumber(int num) {
        if (num <= 0) {
            return false;
        }

        int total = 0;
        int n = 1;

        while (total < num) {
            total += n;
            n++;
        }

        return total == num;
    }

    /// ## main
    ///
    /// Demonstrates the usage of the `isTriangularNumber` method
    /// by checking whether a sample integer is a triangular number
    /// and printing the result to standard output.
    ///
    /// ### Example Output
    /// ```
    /// 10 is a triangular number: true
    /// ```
    static void main() {
        int testNumber = 10;
        boolean result = isTriangularNumber(testNumber);
        System.out.println(testNumber + " is a triangular number: " + result);
    }
}
