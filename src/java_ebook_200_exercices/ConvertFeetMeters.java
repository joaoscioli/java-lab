package java_ebook_200_exercices;
/// ## ConvertFeetMeters
///
/// Utility class that provides a method to convert a measurement from **feet** to **meters**.
///
/// This class demonstrates a simple unit conversion often used in engineering,
/// physics, and software systems that require international measurement support.
///
/// ### Example
/// ```java
    /// double feetValue = 10.0;
    /// double metersValue = ConvertFeetMeters.feetToMeters(feetValue);
    /// System.out.printf("%.2f feet is equal to %.2f meters%n", feetValue, metersValue);
    /// // Output: 10.00 feet is equal to 3.05 meters
    /// ```

public class ConvertFeetMeters {

    /// ### feetToMeters
    ///
    /// Converts a given distance from **feet** to **meters**.
    ///
    /// The conversion is based on the standard factor:
    /// \[
    /// 1 \text{ foot} = 0.3048 \text{ meters}
    /// \]
    ///
    /// ### Parameters
    /// - `feet` — The value in feet to be converted.
    ///
    /// ### Returns
    /// - The equivalent distance in meters.
    ///
    /// ### Example
    /// ```java
    /// double meters = ConvertFeetMeters.feetToMeters(10);
    /// // meters = 3.048
    /// ```
    public static double feetToMeters(double feet) {
        return feet * 0.3048;
    }

    /// ### main
    ///
    /// Demonstrates the usage of the `feetToMeters` method by converting
    /// a sample value and printing the result to the console.
    ///
    /// ### Example Output
    /// ```
    /// 10.00 feet is equal to 3.05 meters
    /// ```
    public static void main(String[] args) {
        double feetValue = 10.0;
        double metersValue = feetToMeters(feetValue);
        System.out.printf("%.2f feet is equal to %.2f meters%n", feetValue, metersValue);
    }
}
