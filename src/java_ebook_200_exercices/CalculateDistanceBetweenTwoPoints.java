package java_ebook_200_exercices;

/// # CalculateDistanceBetweenTwoPoints
///
/// This class provides a utility method to calculate the Euclidean distance
/// between two points in a 2D Cartesian coordinate system.
///
/// ## Overview
/// The distance between two points `(x1, y1)` and `(x2, y2)` is computed
/// using the **distance formula** derived from the Pythagorean theorem:
///
/// \[
/// d = \sqrt{(x2 - x1)^2 + (y2 - y1)^2}
/// \]
///
/// ## Example
/// ```java
/// double distance = CalculateDistanceBetweenTwoPoints.calculateDistance(1.0, 2.0, 4.0, 6.0);
/// System.out.println(distance); // Output: 5.0
/// ```
///
/// This indicates that the distance between points (1.0, 2.0) and (4.0, 6.0) is 5 units.
///
/// ## See Also
/// - `Math.sqrt(double)`
/// - `Math.pow(double, double)`
///
/// ---
public class CalculateDistanceBetweenTwoPoints {

    /// ## calculateDistance
    ///
    /// Calculates the Euclidean distance between two points `(x1, y1)` and `(x2, y2)`.
    ///
    /// ### Parameters
    /// - `x1`: the x-coordinate of the first point
    /// - `y1`: the y-coordinate of the first point
    /// - `x2`: the x-coordinate of the second point
    /// - `y2`: the y-coordinate of the second point
    ///
    /// ### Returns
    /// - the distance between the two points as a `double`
    ///
    /// ### Formula
    /// \[
    /// distance = \sqrt{(x2 - x1)^2 + (y2 - y1)^2}
    /// \]
    ///
    /// ### Example
    /// ```java
    /// double result = CalculateDistanceBetweenTwoPoints.calculateDistance(1.0, 2.0, 4.0, 6.0);
    /// System.out.println(result); // Output: 5.0
    /// ```
    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        // Calculate the distance using the distance formula
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    /// ## main
    ///
    /// Demonstrates how to use the `calculateDistance` method by computing
    /// the distance between two points `(1.0, 2.0)` and `(4.0, 6.0)`.
    ///
    /// ### Output
    /// ```
    /// The distance between (1.0, 2.0) and (4.0, 6.0) is 5.00
    /// ```
    public static void main(String[] args) {
        double x1 = 1.0;
        double y1 = 2.0;
        double x2 = 4.0;
        double y2 = 6.0;
        double result = calculateDistance(x1, y1, x2, y2);

        System.out.printf("The distance between (%.1f, %.1f) and (%.1f, %.1f) is %.2f%n", x1, y1, x2, y2, result);
    }
}
