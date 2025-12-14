package java_ebook_200_exercices;

/// ## FindAreaParallelogram
///
/// Utility class responsible for calculating the area of a parallelogram
/// based on its base and height.
///
/// <p>The area of a parallelogram is computed using the mathematical formula:</p>
///
/// <pre>
/// area = base × height
/// </pre>
///
/// <p>This class also demonstrates basic exception handling by validating
/// input values before performing the calculation.</p>
public class FindAreaParallelogram {

    /// ### Calculates the area of a parallelogram
    ///
    /// Computes the area using the formula {@code base * height}.
    /// Both parameters must be positive numbers.
    ///
    /// @param base   the length of the base of the parallelogram
    /// @param height the height corresponding to the base
    /// @return the calculated area of the parallelogram
    ///
    /// @throws IllegalArgumentException if {@code base <= 0.0} or {@code height <= 0.0}
    ///
    /// @implNote This method performs a simple validation to ensure
    ///           that both dimensions are strictly positive before
    ///           calculating the area.
    public static double parallelogramArea(double base, double height)
            throws IllegalArgumentException {

        if (base > 0.0 && height > 0.0) {
            return base * height;
        } else {
            throw new IllegalArgumentException(
                    "Invalid input. Please provide valid positive number."
            );
        }
    }

    /// ### Application entry point (example usage)
    ///
    /// Demonstrates how to use {@link #parallelogramArea(double, double)}
    /// and how to handle invalid input using a {@code try-catch} block.
    ///
    /// <p>For the given values:</p>
    /// <ul>
    ///   <li>Base: {@code 6.0}</li>
    ///   <li>Height: {@code 8.0}</li>
    /// </ul>
    ///
    /// <p>The expected output is:</p>
    /// <pre>
    /// The area of the parallelogram is: 48.0
    /// </pre>
    void main() {
        double base = 6.0;
        double height = 8.0;

        try {
            double area = parallelogramArea(base, height);
            System.out.println("The area of the parallelogram is: " + area);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

/// Output:
/// The area of the parallelogram is: 48.0
