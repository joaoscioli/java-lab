package java_ebook_200_exercices;

public class ConvertFeetMeters {
    public static double feetToMeters(double feet) {
        // Converts feet to meters
        return feet * 0.3048;
    }

    public static void main(String[] args) {
        double feetValue = 10.0;
        double metersValue = feetToMeters(feetValue);
        System.out.printf("%.2f feet is equal to %.2f meters%n", feetValue, metersValue);
    }
}

// Output: 10.00 feet is equal to 3.05 meters
