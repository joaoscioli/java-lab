package java_ebook_200_exercices;

public class FindDiscount {
    public static double findDiscount(double originalPrice, int discountPercentage) {

        double discount = originalPrice * (discountPercentage / 100.0);

        return originalPrice - discount;

    }

    public static void main(String[] args) {

// Example usage

        System.out.printf("%.2f%n", findDiscount(1500.0, 50)); // Output: 750.00

        System.out.printf("%.2f%n", findDiscount(89.0, 20));   // Output: 71.20

        System.out.printf("%.2f%n", findDiscount(100.0, 75));  // Output: 25.00

    }

}
