package java_ebook_200_exercices;

import java.util.ArrayList;
import java.util.List;

/// # ApplyingDiscounts
///
/// Utility class responsible for applying a percentage-based discount
/// to a collection of product prices.
///
/// This example demonstrates:
/// - Parsing percentage values from strings
/// - Applying mathematical transformations to arrays
/// - Returning immutable results using a `List<Double>`
///
/// The implementation follows a functional-style approach, where
/// input data is not modified directly.
public class ApplyingDiscounts {

    /// Applies a percentage discount to each price in the given array.
    ///
    /// The discount must be provided as a string containing a numeric
    /// value followed by the `%` symbol (e.g. `"50%"`).
    ///
    /// ## Algorithm
    /// 1. Remove the `%` symbol from the discount string.
    /// 2. Convert the remaining value into a `double`.
    /// 3. Calculate the discount factor.
    /// 4. Apply the discount to each price.
    ///
    /// ## Example
    /// ```java
    /// double[] prices = { 10.0, 20.0 };
    /// List<Double> result = ApplyingDiscounts.getDiscounts(prices, "50%");
    /// // result -> [5.0, 10.0]
    /// ```
    ///
    /// @param prices
    ///     an array of original prices
    /// @param discount
    ///     the discount percentage formatted as a string (e.g. `"25%"`)
    /// @return
    ///     a list containing the discounted prices
    /// @throws NumberFormatException
    ///     if the discount string cannot be parsed into a valid number
    public static List<Double> getDiscounts(double[] prices, String discount) {

        // Extract the discount percentage as a double
        double discountPercentage =
                Double.parseDouble(discount.replace("%", "").trim());

        double discountFactor = discountPercentage / 100.0;

        // Calculate discounted prices
        List<Double> discountedPrices = new ArrayList<>();
        for (double price : prices) {
            discountedPrices.add(price * (1.0 - discountFactor));
        }

        return discountedPrices;
    }

    /// Demonstrates example usages of the `getDiscounts` method.
    ///
    /// This method applies different discounts to multiple price arrays
    /// and prints the results to standard output.
    ///
    /// ## Expected Output
    /// ```text
    /// [1.0, 2.0, 3.0, 5.5]
    /// [7.5, 15.0, 30.0, 60.0]
    /// [55.0]
    /// ```
    static void main() {

        // Example usage
        double[] prices1 = {2.0, 4.0, 6.0, 11.0};
        String discount1 = "50%";
        List<Double> discountedPrices1 = getDiscounts(prices1, discount1);
        System.out.println(discountedPrices1);

        double[] prices2 = {10.0, 20.0, 40.0, 80.0};
        String discount2 = "75%";
        List<Double> discountedPrices2 = getDiscounts(prices2, discount2);
        System.out.println(discountedPrices2);

        double[] prices3 = {100.0};
        String discount3 = "45%";
        List<Double> discountedPrices3 = getDiscounts(prices3, discount3);
        System.out.println(discountedPrices3);
    }
}
