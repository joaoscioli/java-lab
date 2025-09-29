package java_ebook_200_exercices;

/// # SumOfDigits
///
/// This class provides a utility method to calculate the **sum of digits**
/// of a given integer number.
///
/// ## Example
/// ```java
/// int inputNumber = 12345;
/// int result = SumOfDigits.sumOfDigits(inputNumber);
/// System.out.println(result); // 15
/// ```
///
/// The program will output:
/// ```
/// The sum of digits in 12345 is: 15
/// ```
public class SumOfDigits {

    /// Calculates the sum of digits in the given integer.
    ///
    /// ## Parameters
    /// - `number`: the integer whose digits will be summed.
    ///
    /// ## Returns
    /// - the sum of all digits in the given number.
    ///
    /// ## Example
    /// ```java
    /// int result = SumOfDigits.sumOfDigits(9876);
    /// System.out.println(result); // 30
    /// ```
    public static int sumOfDigits(int number) {
        int sum = 0;

        // Convert number to string and iterate over each character
        for (char digit : String.valueOf(number).toCharArray()) {

            // Convert character to digit and add to sum
            sum += Character.getNumericValue(digit);
        }
        return sum;
    }

    /// Main method to demonstrate the usage of `sumOfDigits`.
    ///
    /// Runs an example calculation and prints the result to the console.
    public static void main(String[] args) {
        int inputNumber = 12345;
        int result = sumOfDigits(inputNumber);
        System.out.println("The sum of digits in " + inputNumber + " is: " + result);
    }
}
