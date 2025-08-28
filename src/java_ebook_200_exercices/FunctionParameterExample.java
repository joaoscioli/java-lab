import java.util.function.BiFunction;

/// # FunctionParameterExample
///
/// This class demonstrates how to use higher-order functions in Java by passing
/// a `BiFunction` as a parameter to perform operations on two integers.
///
/// ## Example
/// ```java
/// int sum = FunctionParameterExample.operateOnNumbers(3, 5, (x, y) -> x + y);
/// System.out.println(sum); // 8
///
/// int product = FunctionParameterExample.operateOnNumbers(3, 5, (x, y) -> x * y);
/// System.out.println(product); // 15
/// ```
public class FunctionParameterExample {

    /// ## operateOnNumbers
    ///
    /// Executes the given operation on two integers.
    ///
    /// ### Parameters
    /// - `a` — The first integer.
    /// - `b` — The second integer.
    /// - `operation` — A `BiFunction` defining the operation to perform on `a` and `b`.
    ///
    /// ### Returns
    /// The result of applying the provided operation on the two integers.
    ///
    /// ### Example
    /// ```java
    /// int result = FunctionParameterExample.operateOnNumbers(4, 6, (x, y) -> x - y);
    /// System.out.println(result); // -2
    /// ```
    public static int operateOnNumbers(int a, int b, BiFunction<Integer, Integer, Integer> operation) {
        return operation.apply(a, b); // Call the passed function with the provided arguments
    }

    /// ## main
    ///
    /// Demonstrates how to use `operateOnNumbers` with different operations
    /// such as addition and multiplication.
    ///
    /// ### Example Output
    /// ```
    /// Result of addition: 8
    /// Result of multiplication: 15
    /// ```
    public static void main(String[] args) {
        // Example usage with addition
        int result1 = operateOnNumbers(3, 5, (x, y) -> x + y);
        System.out.println("Result of addition: " + result1);  // Outputs: 8

        // Example usage with multiplication
        int result2 = operateOnNumbers(3, 5, (x, y) -> x * y);
        System.out.println("Result of multiplication: " + result2);  // Outputs: 15
    }
}
