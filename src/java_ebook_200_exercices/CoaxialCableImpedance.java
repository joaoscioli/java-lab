package java_ebook_200_exercices;

/// # CoaxialCableImpedance
///
/// Utility class for calculating the **characteristic impedance** of a coaxial cable.
/// The impedance is computed using the standard logarithmic formula based on:
/// - Outer diameter (`dD`)
/// - Inner conductor diameter (`dC`)
/// - Relative permittivity (`eR`)
///
/// The formula used is:
///
/// ```math
/// Z₀ = 60 / √εᵣ · log₁₀(d_D / d_C)
/// ```
///
/// This class contains:
/// - `impedanceCalculator(...)`: performs the impedance calculation
/// - `main(...)`: demonstrates example usage
public class CoaxialCableImpedance {

    /// ## impedanceCalculator
    ///
    /// Calculates the **characteristic impedance** of a coaxial cable using the formula:
    ///
    /// ```math
    /// Z₀ = 60 / √εᵣ · log₁₀(d_D / d_C)
    /// ```
    ///
    /// ### Parameters
    /// - `dD` — Outer diameter of the coaxial cable
    /// - `dC` — Diameter of the inner conductor
    /// - `eR` — Relative permittivity of the insulating material
    ///
    /// ### Returns
    /// The calculated impedance as a `double`.
    ///
    /// ### Example
    /// ```java
    /// double z = impedanceCalculator(20.7, 2.0, 4.0);
    /// ```
    public static double impedanceCalculator(double dD, double dC, double eR) {

        // Calculate the impedance using the formula
        double logTerm = Math.log10(dD / dC);
        double impedance = 60.0 / Math.sqrt(eR) * logTerm;
        return impedance;
    }

    /// ## main
    ///
    /// Demonstrates example calls to the impedance calculator.
    /// Outputs the resulting impedance values formatted with one decimal place.
    public static void main(String[] args) {
        // Example usage
        System.out.printf("%.1f%n", impedanceCalculator(20.7, 2.0, 4.0));
        System.out.printf("%.1f%n", impedanceCalculator(5.3, 1.2, 2.2));
        System.out.printf("%.1f%n", impedanceCalculator(4.48, 1.33, 2.2));
    }
}

// Expected output:
// 30.4
// 26.1
// 21.3
