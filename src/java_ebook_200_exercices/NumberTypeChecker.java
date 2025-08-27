package java_ebook_200_exercices;

/// # NumberTypeChecker
///
/// The `NumberTypeChecker` class provides functionality to check
/// whether a given input is an **integer**, a **float**, or an invalid number.
///
/// It accepts different types of inputs, such as:
/// - `Integer`
/// - `Double`
/// - `String` (attempts parsing as integer, then as float)
///
/// If the input does not represent a valid number,
/// it prints an appropriate message.
///
/// ## Example Usage
/// ```java
/// NumberTypeChecker.checkNumberType(5);       // Output: 5 is an integer.
/// NumberTypeChecker.checkNumberType(3.14);    // Output: 3.14 is a float.
/// NumberTypeChecker.checkNumberType("abc");   // Output: abc is not a valid number.
/// ```
public class NumberTypeChecker {


        /// ## checkNumberType
        ///
        /// Checks whether the provided object is an **integer**, **float**,
        /// or **invalid number**, printing the result to the console.
        ///
        /// ### Parameters
        /// - `number`: The input object to be analyzed.
        ///   It can be an `Integer`, `Double`, or `String`.
        ///
        /// ### Behavior
        /// - If the input is an instance of `Integer`, prints:
        ///   `<number> is an integer.`
        /// - If the input is an instance of `Double`, prints:
        ///   `<number> is a float.`
        /// - If the input is a `String`, tries parsing:
        ///   - First as integer.
        ///   - If fails, then as double.
        ///   - If both fail, prints:
        ///     `<input> is not a valid number.`
        /// - For other object types, also prints:
        ///   `<input> is not a valid number.`
        public static void checkNumberType(Object number) {
            if (number instanceof Integer) {
                System.out.println(number + " is an integer.");
            } else if (number instanceof Double) {
                System.out.println(number + " is a float.");
            } else if (number instanceof String) {
                try {
                    // Try parsing the string as an integer first
                    Integer.parseInt((String) number);
                    System.out.println(number + " is an integer.");
                } catch (NumberFormatException e1) {
                    try {
                        // Try parsing the string as a double
                        Double.parseDouble((String) number);
                        System.out.println(number + " is a float.");
                    } catch (NumberFormatException e2) {
                        System.out.println(number + " is not a valid number.");
                    }
                }
            } else {
                System.out.println(number + " is not a valid number.");
            }
        }

        /// ## main
        ///
        /// Demonstrates the usage of the `checkNumberType` method
        /// with different types of inputs.
        ///
        /// ### Example
        /// ```java
        /// checkNumberType(5);       // Outputs: 5 is an integer.
        /// checkNumberType(3.14);    // Outputs: 3.14 is a float.
        /// checkNumberType(7.0);     // Outputs: 7.0 is a float.
        /// checkNumberType(-2.5);    // Outputs: -2.5 is a float.
        /// checkNumberType("abc");   // Outputs: abc is not a valid number.
        /// ```
        public static void main(String[] args) {
            checkNumberType(5);         // Outputs: 5 is an integer.
            checkNumberType(3.14);      // Outputs: 3.14 is a float.
            checkNumberType(7.0);       // Outputs: 7.0 is a float.
            checkNumberType(-2.5);      // Outputs: -2.5 is a float.
            checkNumberType("abc");     // Outputs: abc is not a valid number.
        }
}
