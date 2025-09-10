package java_ebook_200_exercices;

public class CircleArea {

    /// # CircleArea
    ///
    /// Utility class for calculating the area of a circle.
    ///
    /// ## Usage
    /// Call the `calculateCircleArea(double radius)` method with a positive radius value.
    /// If the radius is not valid (zero or negative), an `IllegalArgumentException` will be thrown.
    ///
    /// ### Example
    /// ```java
    /// double area = CircleArea.calculateCircleArea(5.0);
    /// System.out.println(area); // 78.53981633974483
    /// ```
    ///
    /// ## Methods
    /// - `calculateCircleArea(double radius)`: Calculates the area of a circle based on the given radius.
    /// - `main()`: Demonstrates usage with a sample radius.
    public static double calculateCircleArea(double radius) throws IllegalArgumentException {
        // Check if radius is a valid number
        if (radius <= 0) {
            throw new IllegalArgumentException("Invalid radius. Please provide a positive number.");
        }
        // Calculate the area
        return Math.PI * Math.pow(radius, 2);
    }

    /// ### main
    ///
    /// Demonstrates how to use the `calculateCircleArea` method.
    /// Prints the calculated area of a circle with a predefined radius.
    ///
    /// #### Output
    /// ```
    /// The area of a circle with radius 5.0 is: 78.53981633974483
    /// ```
    static void main() {
        double radius = 5.0;
        try {
            double area = calculateCircleArea(radius);
            System.out.println("The area of a circle with radius " + radius + " is: " + area);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
