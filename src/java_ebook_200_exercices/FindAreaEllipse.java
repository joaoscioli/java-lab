package java_ebook_200_exercices;

public class FindAreaEllipse {
    // Method to calculate the area of an ellipse
    public static double calculateEllipseArea(double semiMajorAxis, double semiMinorAxis) {
        return Math.PI * semiMajorAxis * semiMinorAxis;
    }

    public static void main(String[] args) {
        double semiMajorAxis = 5.0; // Replace with the semi-major axis length
        double semiMinorAxis = 3.0; // Replace with the semi-minor axis length
        double ellipseArea = calculateEllipseArea(semiMajorAxis, semiMinorAxis);

        System.out.printf("The area of the ellipse is: %.2f%n", ellipseArea);
    }
}
// The area of the ellipse is: 47.12

