package java_ebook_200_exercices;

import java.util.ArrayList;
import java.util.List;

public class ApplyingDiscounts {
    public static List<Double> getDiscounts(double[] prices, String discount) {
        // Extract the discount percentage as a double
        double discountPercentage = Double.parseDouble(discount.replace("%", "").trim());
        double discountFactor = discountPercentage / 100.0;

        // Calculate discounted prices
        List<Double> discountedPrices = new ArrayList<>();
        for (double price : prices) {
            discountedPrices.add(price * (1.0 - discountFactor));
        }
        return discountedPrices;
    }

    static void main() {
    // Example usage
        double[] prices1 = {2.0, 4.0, 6.0, 11.0};
        String discount1 = "50%";
        List<Double> discountedPrices1 = getDiscounts(prices1, discount1);

        System.out.println(discountedPrices1); // Output: [1.0, 2.0, 3.0, 5.5]

        double[] prices2 = {10.0, 20.0, 40.0, 80.0};
        String discount2 = "75%";
        List<Double> discountedPrices2 = getDiscounts(prices2, discount2);

        System.out.println(discountedPrices2); // Output: [7.5, 15.0, 30.0, 60.0]

        double[] prices3 = {100.0};
        String discount3 = "45%";
        List<Double> discountedPrices3 = getDiscounts(prices3, discount3);

        System.out.println(discountedPrices3); // Output: [55.0]
    }
}

// Expected Output:
// [1.0, 2.0, 3.0, 5.5]
// [7.5, 15.0, 30.0, 60.0]
// [55.0]
