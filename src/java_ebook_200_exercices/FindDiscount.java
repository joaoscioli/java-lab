package java_ebook_200_exercices;

/// # FindDiscount
///
/// Utility class that calculates the final price of a product
/// after applying a percentage-based discount.
///
/// ## Purpose
/// This class demonstrates a simple financial calculation
/// using basic arithmetic operations in Java.
///
/// ## Formula
/// ```text
/// discount = originalPrice × (discountPercentage / 100)
/// finalPrice = originalPrice − discount
/// ```
///
/// ## Example
/// - Original price: `1500.00`
/// - Discount: `50%`
/// - Final price: `750.00`
public class FindDiscount {

    /// ## findDiscount
    ///
    /// Calculates the discounted price based on the original price
    /// and the discount percentage.
    ///
    /// ### Implementation Details
    /// - Uses floating-point arithmetic to avoid integer division
    /// - The percentage value is converted to a decimal factor
    ///
    /// ### Time Complexity
    /// - **O(1)** — constant time calculation
    ///
    /// ### Space Complexity
    /// - **O(1)** — no additional memory allocation
    ///
    /// @param originalPrice the initial price before discount
    /// @param discountPercentage the discount percentage to be applied
    /// @return the final price after applying the discount
    public static double findDiscount(double originalPrice, int discountPercentage) {
        double discount = originalPrice * (discountPercentage / 100.0);
        return originalPrice - discount;
    }

    /// ## main
    ///
    /// Demonstrates the usage of the `findDiscount` method
    /// with different input values.
    ///
    /// ### Example Output
    /// ```text
    /// 750.00
    /// 71.20
    /// 25.00
    /// ```
    ///
    /// @param args command-line arguments (not used)
    public static void main(String[] args) {
        // Example usage
        System.out.printf("%.2f%n", findDiscount(1500.0, 50)); // Output: 750.00
        System.out.printf("%.2f%n", findDiscount(89.0, 20));   // Output: 71.20
        System.out.printf("%.2f%n", findDiscount(100.0, 75));  // Output: 25.00
    }
}
