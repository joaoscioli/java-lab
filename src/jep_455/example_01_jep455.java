package jep_455;
/// # example_01_jep455 Class
///
/// The `example_01_jep455` class provides a method to check the status of a system operation.
/// It uses the new `switch` feature from JEP 455 to handle primitive types directly.
/// This makes the code cleaner by allowing the `switch` statement to match primitive values without conversions.
///
/// ## Example Usage
/// ```java
/// Status status1 = new Status(0);
/// Status status2 = new Status(3); // Any other value besides 0, 1, 2
/// System.out.println(checkStatus(status1));   // Output: okay
/// System.out.println(checkStatus(status2));   // Output: unknown status: 3
/// ```
/// ## See Also
/// - [JEP 455: Primitive Types in Patterns, instanceof, and switch](https://openjdk.org/jeps/455)
/// - [JEP 467: Markdown Documentation Comments](https://openjdk.org/jeps/467)
/// - [Article: Thallyta Castro "Novidades do java 23: JEP 455 - Tipos Primitivos em Padrões, instanceof e switch"](https://www.linkedin.com/pulse/novidades-do-java-23-jep-455-tipos-primitivos-em-padr%C3%B5es-castro-bduye/)
public class example_01_jep455 {
    /// ## checkStatus Method
    /// This method checks the status of the system using a `switch` statement.
    /// It uses **JEP 455** to allow primitive types in patterns. For known status values (`0`, `1`, `2`),
    /// the method returns predefined response. For unknown status values, it uses a pattern
    /// to catch any `int` and returns the value.
    /// ### Parameters
    /// A `String` describing the status:
    /// - "okay" if the status is `0`
    /// - "warning" if the status is `1`
    /// - "error" if the status is `2`
    /// - "unknown status: i" for any other status value `i`
    /// ### Example
    /// ```java
    /// Status status = new Status(1);
    /// System.of.println(example_01_jep455.checkStatus(status));    // Output: warning
    /// ```
    ///
    /// @param x the status object containing the system status as an `int`
    /// @return a description of the status
    public static String checkStatus(Status x) {
        return switch (x.getStatus()) {
            case 1 -> "okay";
            case 2 -> "warning";
            case 3 -> "error";
            case int i -> "unknown status: " + i;
        };
    }
}

