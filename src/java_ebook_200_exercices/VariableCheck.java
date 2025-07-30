package java_ebook_200_exercices;

/**
 /// # VariableCheck
 ///
 /// Demonstrates how to check if variables are null in Java.
 ///
 /// ## Overview
 /// This class includes a method to check whether a variable is null or has a value,
 /// and prints the result to the console. It uses `Object` as the parameter type
 /// to support checking different data types.
 ///
 /// ## Example Output
 /// ```text
 /// Variable is null.
 /// Variable is null.
 /// Variable has a value: Hello, World!
 /// ```
 ///
 */
public class VariableCheck {

    /**
     /// ## main
     ///
     /// Entry point that demonstrates null checking on different variable types.
     ///
     /// ### Description
     /// Creates three variables:
     /// - An `Integer` explicitly set to `null`.
     /// - A `String` set to `null`.
     /// - A `String` with a value `"Hello, World!"`.
     ///
     /// Each variable is passed to the `checkVariable` method.
     ///
     /// ### Example
     /// ```java
     /// new VariableCheck().main();
     /// ```
     */
    void main() {
        Integer undefineVariable = null; // Using Integer wrapper to allow null
        String nullVariable = null;
        String valueVariable = "Hello, World!";

        checkVariable(undefineVariable);
        checkVariable(nullVariable);
        checkVariable(valueVariable);
    }

    /**
     /// ## checkVariable
     ///
     /// Checks whether the provided variable is `null` or has a value.
     ///
     /// ### Parameters
     /// - `variable`: An `Object` representing the variable to be checked.
     ///
     /// ### Behavior
     /// - Prints `"Variable is null."` if the object is `null`.
     /// - Otherwise, prints `"Variable has a value: <value>"`.
     ///
     /// ### Example
     /// ```java
     /// checkVariable("Test");        // Output: Variable has a value: Test
     /// checkVariable(null);          // Output: Variable is null.
     /// ```
     */
    private static void checkVariable(Object variable) {
        if (variable == null) {
            System.out.println("Variable is null.");
        } else {
            System.out.println("Variable has a value: " + variable);
        }
    }
}
