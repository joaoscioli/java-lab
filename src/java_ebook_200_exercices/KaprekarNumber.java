package java_ebook_200_exercices;

/**
 /// # KaprekarNumber
 ///
 /// Utility class to check whether a number is a **Kaprekar number**.
 ///
 /// ## Overview
 /// A Kaprekar number is a non-negative integer `n` such that the square of `n`
 /// can be split into two parts that sum to `n`.
 ///
 /// - Example:
 ///   `297² = 88209` → Split into `88` and `209` → `88 + 209 = 297` → **Kaprekar number**.
 ///
 /// Special case: `0` and `1` are considered Kaprekar numbers by definition.
 ///
 /// ## Example Output
 /// ```text
 /// isKaprekar(3) ➞ false
 /// isKaprekar(5) ➞ false
 /// isKaprekar(297) ➞ true
 /// ```
 ///
 */
public class KaprekarNumber {

    /**
     /// ## isKaprekar
     ///
     /// Checks if the given number is a Kaprekar number.
     ///
     /// ### Parameters
     /// - `n`: The number to check (`long`).
     ///
     /// ### Returns
     /// - `true` if the number is a Kaprekar number.
     /// - `false` otherwise.
     ///
     /// ### Algorithm
     /// 1. Handle special cases for `0` and `1` (both are Kaprekar numbers).
     /// 2. Compute the square of `n` and convert it to a string.
     /// 3. Split the squared number into left and right parts:
     ///    - **Right part**: last `len/2` digits.
     ///    - **Left part**: remaining digits.
     /// 4. Convert both parts to integers (`0` if empty).
     /// 5. Check if their sum equals `n`.
     ///
     /// ### Example
     /// ```java
     /// boolean result = KaprekarNumber.isKaprekar(297); // true
     /// ```
     */
    public static boolean isKaprekar(long n) {
        if (n == 0 || n == 1) {
            return true; // 0 and 1 are Kaprekar numbers
        }

        long square = n * n;
        String squareStr = Long.toString(square);
        int len = squareStr.length();

        String leftStr, rightStr;
        if (len == 1) {
            leftStr = "";
            rightStr = squareStr;
        } else {
            int splitIndex = len / 2;
            leftStr = squareStr.substring(0, len - splitIndex);
            rightStr = squareStr.substring(len - splitIndex);
        }

        long left = leftStr.isEmpty() ? 0 : Long.parseLong(leftStr);
        long right = rightStr.isEmpty() ? 0 : Long.parseLong(rightStr);

        return left + right == n;
    }

    /**
     /// ## main
     ///
     /// Demonstrates the usage of `isKaprekar` with sample test cases.
     ///
     /// ### Example
     /// ```java
     /// KaprekarNumber.main(new String[]{});
     /// // Output:
     /// // isKaprekar(3) ➞ false
     /// // isKaprekar(5) ➞ false
     /// // isKaprekar(297) ➞ true
     /// ```
     */
    public static void main(String[] args) {
        System.out.println("isKaprekar(3) ➞ " + isKaprekar(3));
        System.out.println("isKaprekar(5) ➞ " + isKaprekar(5));
        System.out.println("isKaprekar(297) ➞ " + isKaprekar(297));
    }
}
