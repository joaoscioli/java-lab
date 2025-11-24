package java_ebook_200_exercices;

public class FindAreaTrapezoid {

    /// # trapezoidArea
    ///
    /// Calculates the area of a trapezoid using the formula:
    ///
    /// ```
    /// Area = 0.5 × height × (base1 + base2)
    /// ```
    ///
    /// ## Parameters
    /// - **base1**: The length of the first base. Must be a positive number.
    /// - **base2**: The length of the second base. Must be a positive number.
    /// - **height**: The height of the trapezoid. Must be a positive number.
    ///
    /// ## Returns
    /// - The computed area of the trapezoid as a `double`.
    ///
    /// ## Throws
    /// - `IllegalArgumentException`
    ///   Thrown if any input value is zero or negative.
    ///
    /// ## Example
    /// ```java
    /// double area = FindAreaTrapezoid.trapezoidArea(5.0, 9.0, 4.0);
    /// // area = 28.0
    /// ```
    public static double trapezoidArea(double base1, double base2, double height) throws IllegalArgumentException {

        // Check if the inputs are valid numbers
        if (base1 <= 0 || base2 <= 0 || height <= 0) {
            throw new IllegalArgumentException("Invalid input. Please provide valid positive numbers.");
        }

        // Calculate the area of the trapezoid
        return 0.5 * height * (base1 + base2);
    }

    /// # main
    ///
    /// Demonstrates how to calculate the area of a trapezoid using `trapezoidArea`.
    ///
    /// ## Example Output
    /// ```
    /// The area of the trapezoid is: 28.00
    /// ```
    public static void main(String[] args) {
        double base1Length = 5.0;
        double base2Length = 9.0;
        double trapezoidHeight = 4.0;

        try {
            double area = trapezoidArea(base1Length, base2Length, trapezoidHeight);
            System.out.printf("The area of the trapezoid is: %.2f%n", area);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
