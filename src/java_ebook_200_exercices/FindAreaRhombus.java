package java_ebook_200_exercices;

/// # FindAreaRhombus
///
/// This class provides a simple utility to calculate the **area of a rhombus**
/// using the lengths of its diagonals.
///
/// ## Mathematical Formula
/// The area of a rhombus is calculated using the formula:
///
/// ```text
/// Area = (d1 × d2) / 2
/// ```
///
/// Where:
/// - `d1` is the length of the first diagonal
/// - `d2` is the length of the second diagonal
///
/// ## Usage
/// This class contains a `main` method that demonstrates how to use
/// the area calculation method with sample values.
public class FindAreaRhombus {

    /// ## calculateRhombusArea
    ///
    /// Calculates the area of a rhombus given the lengths of its diagonals.
    ///
    /// ### Parameters
    /// - `diagonal1` — the length of the first diagonal
    /// - `diagonal2` — the length of the second diagonal
    ///
    /// ### Returns
    /// - The area of the rhombus as a `double`
    ///
    /// ### Example
    /// ```java
    /// double area = calculateRhombusArea(8.0, 6.0);
    /// ```
    ///
    /// This will return:
    /// ```text
    /// 24.0
    /// ```
    public static double calculateRhombusArea(double diagonal1, double diagonal2) {
        return (diagonal1 * diagonal2) / 2.0;
    }

    /// ## main
    ///
    /// Entry point of the program.
    ///
    /// This method demonstrates the calculation of a rhombus area
    /// using predefined diagonal lengths and prints the result
    /// formatted to two decimal places.
    ///
    /// ### Output
    /// ```text
    /// The area of the rhombus is: 24.00
    /// ```
    public static void main(String[] args) {
        double diagonal1Length = 8.0;
        double diagonal2Length = 6.0;

        double rhombusArea = calculateRhombusArea(diagonal1Length, diagonal2Length);

        System.out.printf("The area of the rhombus is: %.2f%n", rhombusArea);
    }
}
