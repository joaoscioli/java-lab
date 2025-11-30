package java_ebook_200_exercices;

public class FindPerimeterRectangle {

    /// ## rectanglePerimeter
    ///
    /// Computes the perimeter of a rectangle given its length and width.
    ///
    /// The formula used is:
    ///
    /// ```
    /// perimeter = 2 * (length + width)
    /// ```
    ///
    /// ### Parameters
    /// - `length` — The length of the rectangle. Must be a positive number.
    /// - `width` — The width of the rectangle. Must be a positive number.
    ///
    /// ### Returns
    /// The computed perimeter of the rectangle.
    ///
    /// ### Throws
    /// - `IllegalArgumentException` — If either `length` or `width` is less than or equal to zero.
    ///
    /// ### Examples
    /// ```java
    /// double p = FindPerimeterRectangle.rectanglePerimeter(5.0, 8.0);
    /// // p == 26.0
    /// ```
    public static double rectanglePerimeter(double length, double width) throws IllegalArgumentException {

        // Check if the inputs are valid numbers
        if (length <= 0.0 || width <= 0.0) {
            throw new IllegalArgumentException("Invalid input. Please provide valid positive numbers.");
        }

        // Calculate the perimeter of the rectangle
        return 2.0 * (length + width);
    }

    /// ## main
    ///
    /// Demonstrates the usage of the `rectanglePerimeter` method by calculating
    /// the perimeter of a rectangle with predefined values.
    ///
    /// ### Output
    /// ```
    /// The perimeter of the rectangle is: 26.0
    /// ```
    public static void main(String[] args) {
        double length = 5.0;
        double width = 8.0;

        try {
            double perimeter = rectanglePerimeter(length, width);
            System.out.println("The perimeter of the rectangle is: " + perimeter);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
