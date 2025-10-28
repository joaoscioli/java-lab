package java_ebook_200_exercices;

/// # FindAreaOfRectangle
///
/// This class provides a method to **calculate the area of a rectangle**
/// given its length and width.
///
/// The area of a rectangle is computed using the formula:
///
///  Area = length \times width
///
/// ## Example
/// ```java
/// double length = 5.0;
/// double width = 8.0;
/// double area = FindAreaOfRectangle.calculateRectangleArea(length, width);
/// System.out.printf("The area of the rectangle is %.2f%n", area);
/// ```
///
/// **Output:**
/// ```text
/// The area of the rectangle is 40.00
/// ```
///
/// @since 1.0
public class FindAreaOfRectangle {

    /// Calculates the area of a rectangle based on its length and width.
    ///
    /// This method first validates that both parameters are **positive values**.
    /// If either is zero or negative, an error message is displayed and the method returns `0.0`.
    ///
    /// ## Parameters
    /// - `length`: The length of the rectangle.
    /// - `width`: The width of the rectangle.
    ///
    /// ## Returns
    /// - The computed area of the rectangle if inputs are valid.
    /// - `0.0` if any of the inputs are invalid.
    ///
    /// ## Example
    /// ```java
    /// double result = FindAreaOfRectangle.calculateRectangleArea(5.0, 8.0);
    /// System.out.println(result); // 40.0
    /// ```
    public static double calculateRectangleArea(double length, double width) {
        // Check if the inputs are valid positive numbers
        if (length <= 0.0 || width <= 0.0) {
            System.out.println("Invalid inputs. Please provide valid positive numbers for length and width.");
            return 0.0;
        }
        // Calculate the area of the rectangle
        return length * width;
    }

    /// Demonstrates how to use the `calculateRectangleArea` method.
    ///
    /// This example calculates the area of a rectangle with a length of `5.0`
    /// and a width of `8.0`, then prints the result to the console.
    ///
    /// **Output:**
    /// ```text
    /// The area of the rectangle with length 5.0 and width 8.0 is 40.00
    /// ```
    static void main() {
        double rectangleLength = 5.0;
        double rectangleWidth = 8.0;
        double result = calculateRectangleArea(rectangleLength, rectangleWidth);

        System.out.printf(
                "The area of the rectangle with length %.1f and width %.1f is %.2f%n",
                rectangleLength, rectangleWidth, result
        );
    }
}
