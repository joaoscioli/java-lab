package java_ebook_200_exercices;

public class CircleArea {

    public static double calculateCircleArea(double radius) throws IllegalArgumentException {
        // Check if radius is a valid number
        if (radius <= 0) {
            throw new IllegalArgumentException("Invalid radius. Please provide a positive number.");
        }
        // Calculate the area
        return Math.PI * Math.pow(radius, 2);
    }

    static void main() {
        double radius = 5.0;
        try {
            double area = calculateCircleArea(radius);
            System.out.println("The area of a circle with radius " + radius + " is: " + area);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

// Output:
// The area of a circle with radius 5.0 is: 78.53981633974483