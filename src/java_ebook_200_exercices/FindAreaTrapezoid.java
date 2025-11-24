package java_ebook_200_exercices;

public class FindAreaTrapezoid {
    // Method to calculate the area of a trapezoid
    public static double trapezoidArea(double base1, double base2, double height) throws IllegalArgumentException {

        // Check if the inputs are valid numbers
        if (base1 <= 0 || base2 <= 0 || height <= 0) {
            throw new IllegalArgumentException("Invalid input. Please provide valid positive numbers.");
        }

    // Calculate the area of the trapezoid
        return 0.5 * height * (base1 + base2);
    }

    public static void main(String[] args) {
        double base1Length = 5.0;
        double base2Length = 9.0;
        double trapezoidHeight = 4.0;

        try {
            double area = trapezoidArea(base1Length, base2Length, trapezoidHeight);
            System.out.printf("The area of the trapezoid is: %.2f%n", area);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

/*
Output:
The area of the trapezoid is: 28.00
*/
