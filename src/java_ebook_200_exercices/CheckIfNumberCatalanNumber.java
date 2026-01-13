package java_ebook_200_exercices;

/// # CheckIfNumberCatalanNumber
///
/// Provides utility methods to:
/// - Compute **binomial coefficients**
/// - Determine whether a given number is a **Catalan number**
///
/// ## Catalan Numbers
/// Catalan numbers form a sequence of natural numbers that appear in various
/// combinatorial problems, such as:
/// - Counting valid parenthesis expressions
/// - Number of unique Binary Search Trees (BSTs)
/// - Number of full binary trees
///
/// The *n-th Catalan number* is defined as:
///
/// ```text
/// Cₙ = (1 / (n + 1)) * binomial(2n, n)
/// ```
///
/// ## Notes
/// - This implementation computes Catalan numbers **iteratively**
/// - The algorithm stops as soon as the computed value exceeds the target
/// - Suitable for **small to medium-sized numbers** due to `long` limitations
///
public class CheckIfNumberCatalanNumber {

    /// ## binomialCoefficient
    ///
    /// Computes the binomial coefficient **C(n, k)** using an optimized
    /// multiplicative approach.
    ///
    /// ### Mathematical Definition
    /// ```text
    /// C(n, k) = n! / (k! * (n - k)!)
    /// ```
    ///
    /// ### Optimization
    /// - Uses the symmetry property: `C(n, k) = C(n, n - k)`
    /// - Avoids computing large factorials directly
    ///
    /// ### Parameters
    /// - `n` — the total number of elements
    /// - `k` — the number of selected elements
    ///
    /// ### Returns
    /// - The binomial coefficient `C(n, k)`
    ///
    /// ### Time Complexity
    /// - **O(k)**
    ///
    /// ### Space Complexity
    /// - **O(1)**
    ///
    public static long binomialCoefficient(long n, long k) {
        long result = 1;

        if (k > n - k) {
            k = n - k; // Take advantage of symmetry
        }

        for (long i = 0; i < k; i++) {
            result *= n;
            result /= (i + 1);
            n--;
        }
        return result;
    }

    /// ## isCatalanNumber
    ///
    /// Determines whether a given number belongs to the **Catalan number sequence**.
    ///
    /// ### Algorithm
    /// - Iteratively compute Catalan numbers using the closed-form formula
    /// - Compare each value with the input number
    /// - Stop when:
    ///   - A match is found, or
    ///   - The computed Catalan number exceeds the input
    ///
    /// ### Formula Used
    /// ```text
    /// Cₙ = binomial(2n, n) / (n + 1)
    /// ```
    ///
    /// ### Parameters
    /// - `num` — the number to be checked
    ///
    /// ### Returns
    /// - `true` if the number is a Catalan number
    /// - `false` otherwise
    ///
    /// ### Time Complexity
    /// - **O(n²)** in practice due to repeated binomial computations
    ///
    /// ### Space Complexity
    /// - **O(1)**
    ///
    public static boolean isCatalanNumber(long num) {
        long i = 0;

        while (true) {
            long catalan = binomialCoefficient(2 * i, i) / (i + 1);

            if (catalan == num) {
                return true; // Found a match
            } else if (catalan > num) {
                return false; // Exceeded the number
            }
            i++;
        }
    }

    /// ## main
    ///
    /// Demonstrates how to use the `isCatalanNumber` method
    /// to verify whether a given number belongs to the Catalan sequence.
    ///
    /// ### Example
    /// ```text
    /// Input:  42
    /// Output: 42 is a Catalan number! 🎉
    /// ```
    ///
    void main() {
        long numberToCheck = 42; // Replace with the number you want to check

        if (isCatalanNumber(numberToCheck)) {
            System.out.printf("%d is a Catalan number! 🎉%n", numberToCheck);
        } else {
            System.out.printf("%d is not a Catalan number. 😢%n", numberToCheck);
        }
    }
}
