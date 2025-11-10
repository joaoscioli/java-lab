package java_ebook_200_exercices;

/// # CheckNumberNarcissisticNumber
///
/// This class provides functionality to determine whether a given integer
/// is a **Narcissistic Number** (also known as an **Armstrong Number**).
///
/// A **Narcissistic Number** is a number that is equal to the sum of its own
/// digits each raised to the power of the number of digits.
/// For example:
/// - 153 → 1³ + 5³ + 3³ = 153
/// - 1634 → 1⁴ + 6⁴ + 3⁴ + 4⁴ = 1634
///
/// ## Example
/// ```java
/// int testNumber = 1634;
/// boolean result = CheckNumberNarcissisticNumber.isNarcissisticNumber(testNumber);
/// System.out.println(testNumber + " is a Narcissistic Number: " + result);
/// ```
///
/// **Output:**
/// ```
/// 1634 is a Narcissistic Number: true
/// ```
public class CheckNumberNarcissisticNumber {

    /// ## isNarcissisticNumber
    ///
    /// Determines whether a given integer is a **Narcissistic Number**.
    ///
    /// ### Parameters
    /// - `num` — the integer value to be checked.
    ///
    /// ### Returns
    /// - `true` if the number is narcissistic.
    /// - `false` otherwise.
    ///
    /// ### Algorithm
    /// 1. Converts the integer to a string to determine its digits.
    /// 2. Computes the number of digits.
    /// 3. Sums each digit raised to the power of the number of digits.
    /// 4. Compares the sum to the original number.
    ///
    /// ### Example
    /// ```java
    /// CheckNumberNarcissisticNumber.isNarcissisticNumber(9474); // returns true
    /// CheckNumberNarcissisticNumber.isNarcissisticNumber(123);  // returns false
    /// ```
    public static boolean isNarcissisticNumber(int num) {
        String numStr = Integer.toString(num);
        int numDigits = numStr.length();

        int total = 0;
        for (char digitChar : numStr.toCharArray()) {
            int digit = Character.getNumericValue(digitChar);
            total += Math.pow(digit, numDigits);
        }

        return total == num;
    }

    /// ## main
    ///
    /// Demonstrates the use of the `isNarcissisticNumber` method.
    ///
    /// ### Example
    /// ```java
    /// int testNumber = 1634;
    /// boolean result = isNarcissisticNumber(testNumber);
    /// System.out.println(testNumber + " is a Narcissistic Number: " + result);
    /// ```
    public static void main(String[] args) {
        int testNumber = 1634;
        boolean result = isNarcissisticNumber(testNumber);
        System.out.println(testNumber + " is a Narcissistic Number: " + result);
    }
}
