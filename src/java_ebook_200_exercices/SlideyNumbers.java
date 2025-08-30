package java_ebook_200_exercices;

import java.util.ArrayList;
import java.util.List;

/// # SlideyNumbers
///
/// This class provides a method to determine whether a number is **slidey**.
/// A number is considered *slidey* if the absolute difference between each pair
/// of consecutive digits is exactly 1.
///
/// ## Definition
/// - All single-digit numbers are **slidey** by default.
/// - Multi-digit numbers must satisfy the rule:
///   - `|digit[i] - digit[i+1]| == 1` for all consecutive digits.
///
/// ## Examples
/// - `123454321` → **true** (digits go up and down consecutively).
/// - `54345` → **true**.
/// - `987654321` → **true**.
/// - `1123` → **false** (because `1` and `1` differ by 0).
/// - `1357` → **false** (because consecutive differences are greater than 1).
public class SlideyNumbers {

    /// Checks if a given integer is a **slidey number**.
    ///
    /// ## Parameters
    /// - `n`: the number to be checked.
    ///
    /// ## Returns
    /// - `true` if the number is slidey.
    /// - `false` otherwise.
    ///
    /// ## Notes
    /// - Internally, the method converts the number into a list of digits.
    /// - A loop checks the absolute difference between each consecutive pair of digits.
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

    /// Main entry point for testing the `isSlidey` method.
    ///
    /// ## Behavior
    /// Prints the evaluation of several numbers to check whether they are slidey.
    ///
    /// ## Example Output
    /// ```
    /// true
    /// true
    /// true
    /// false
    /// false
    /// ```
    public static void main(String[] args) {
        // Test cases
        System.out.println(isSlidey(123454321)); // Outputs: true
        System.out.println(isSlidey(54345));     // Outputs: true
        System.out.println(isSlidey(987654321)); // Outputs: true
        System.out.println(isSlidey(1123));      // Outputs: false
        System.out.println(isSlidey(1357));      // Outputs: false
    }
}
