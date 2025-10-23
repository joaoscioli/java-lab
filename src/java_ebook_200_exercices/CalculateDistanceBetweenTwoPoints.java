package java_ebook_200_exercices;

public class CalculateDistanceBetweenTwoPoints {
    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        // Calculate the distance using the distance formula
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static void main(String[] args) {
        double x1 = 1.0;
        double y1 = 2.0;
        double x2 = 4.0;
        double y2 = 6.0;
        double result = calculateDistance(x1, y1, x2, y2);

        System.out.printf("The distance between (%.1f, %.1f) and (%.1f, %.1f) is %.2f%n", x1, y1, x2, y2, result);
    }
}

// Output: The distance between (1.0, 2.0) and (4.0, 6.0) is 5.00