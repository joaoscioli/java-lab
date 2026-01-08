package java_ebook_200_exercices;

/// # FindAreaEllipse
///
/// Utility class responsible for calculating the area of an ellipse
/// using the mathematical formula:
///
/// ```text
/// Area = π × a × b
/// ```
///
/// Where:
/// - `a` is the semi-major axis length.
/// - `b` is the semi-minor axis length.
/// - `π` is the mathematical constant Pi.
///
/// ## Use Cases
/// - Geometry calculations.
/// - Educational and scientific applications.
/// - Engineering and physics problems.
///
/// ## Example Output
/// ```text
/// The area of the ellipse is: 47.12
/// ```
///
/// ## Notes
/// - This class is stateless and thread-safe.
/// - Uses `Math.PI` for high precision.
///
/// @author
/// Great Designer Software
public class FindAreaEllipse {

    /// ## calculateEllipseArea
    ///
    /// Calculates the area of an ellipse based on its semi-major
    /// and semi-minor axis lengths.
    ///
    /// ### Formula
    /// ```text
    /// Area = π × semiMajorAxis × semiMinorAxis
    /// ```
    ///
    /// ### Parameters
    /// - `semiMajorAxis` — Length of the semi-major axis (`a`).
    /// - `semiMinorAxis` — Length of the semi-minor axis (`b`).
    ///
    /// Both parameters must be positive real numbers.
    ///
    /// ### Returns
    /// - The computed area of the ellipse as a `double`.
    ///
    /// ### Throws
    /// - `IllegalArgumentException` — If any parameter is negative or zero
    ///   (recommended validation if added).
    ///
    /// ### Example
    /// ```java
    /// double area = FindAreaEllipse.calculateEllipseArea(5.0, 3.0);
    /// // area == 47.12388980384689
    /// ```
    ///
    /// ### Complexity
    /// - **Time:** O(1)
    /// - **Space:** O(1)
    public static double calculateEllipseArea(double semiMajorAxis, double semiMinorAxis) {
        return Math.PI * semiMajorAxis * semiMinorAxis;
    }

    /// ## main
    ///
    /// Demonstrates the usage of the `calculateEllipseArea` method
    /// with sample values.
    ///
    /// ### Execution Flow
    /// 1. Defines the semi-major axis length.
    /// 2. Defines the semi-minor axis length.
    /// 3. Calculates the ellipse area.
    /// 4. Prints the formatted result to standard output.
    ///
    /// ### Example Output
    /// ```text
    /// The area of the ellipse is: 47.12
    /// ```
    public static void main(String[] args) {
        double semiMajorAxis = 5.0; // Replace with the semi-major axis length
        double semiMinorAxis = 3.0; // Replace with the semi-minor axis length
        double ellipseArea = calculateEllipseArea(semiMajorAxis, semiMinorAxis);

        System.out.printf("The area of the ellipse is: %.2f%n", ellipseArea);
    }
}
