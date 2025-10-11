package java_ebook_200_exercices;

/// # CylinderVolumeCalculator
///
/// A utility class that provides a method to calculate the volume of a cylinder.
///
/// The formula used for volume calculation is:
/// \[ V = \pi \times r^2 \times h \]
///
/// Where:
/// - *r* is the radius of the cylinder’s base  
/// - *h* is the height of the cylinder  
///
/// This class also includes a simple demonstration in the `main` method.
///
/// ---

public class CylinderVolumeCalculator {

    /// ## calculateCylinderVolume
    ///
    /// Calculates the volume of a cylinder based on its radius and height.
    ///
    /// ### Parameters
    /// - `radius` — The radius of the cylinder’s base. Must be a positive number.  
    /// - `height` — The height of the cylinder. Must be a positive number.
    ///
    /// ### Returns
    /// - The calculated volume of the cylinder as a `double`.
    ///
    /// ### Throws
    /// - `IllegalArgumentException` — If either the radius or height is not a positive number.
    ///
    /// ### Example
    /// ```java
    /// double volume = CylinderVolumeCalculator.calculateCylinderVolume(5.0, 10.0);
    /// System.out.printf("Cylinder Volume: %.2f cubic units%n", volume);
    /// ```
    ///
    /// **Output:**
    /// ```
    /// Cylinder Volume: 785.40 cubic units
    /// ```
    ///
    public static double calculateCylinderVolume(double radius, double height) throws IllegalArgumentException {
        // Check if the inputs are valid positive numbers
        if (radius <= 0 || height <= 0) {
            throw new IllegalArgumentException("Invalid inputs. Please provide valid positive numbers.");
        }

        // Calculate the volume of the cylinder
        double volume = Math.PI * Math.pow(radius, 2) * height;
        return volume;
    }

    /// ## main
    ///
    /// Demonstrates how to use the `calculateCylinderVolume` method by calculating
    /// the volume of a cylinder with a radius of 5.0 and a height of 10.0.
    ///
    /// ### Example
    /// ```java
    /// CylinderVolumeCalculator.main(new String[]{});
    /// ```
    ///
    /// **Expected Output:**
    /// ```
    /// Cylinder Volume: 785.40 cubic units
    /// ```
    ///
    public static void main(String[] args) {
        double cylinderRadius = 5.0;
        double cylinderHeight = 10.0;

        try {
            double volume = calculateCylinderVolume(cylinderRadius, cylinderHeight);
            System.out.printf("Cylinder Volume: %.2f cubic units%n", volume);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}