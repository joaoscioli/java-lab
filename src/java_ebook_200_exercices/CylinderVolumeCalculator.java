package java_ebook_200_exercices;

public class CylinderVolumeCalculator {
    public static double calculateCylinderVolume(double radius, double height) throws IllegalArgumentException {
        // Check if the inputs are valid positive numbers
        if (radius <= 0 || height <= 0) {
            throw new IllegalArgumentException("Invalid inputs. Please provide valid positive numbers.");
        }

        // Calculate the volume of the cylinder
        double volume = Math.PI * Math.pow(radius, 2) * height;
        return volume;
    }

    public static void main(String[] args) {
        double cylinderRadius = 5.0;
        double cylinderHeight = 10.0;

        try {
            double volume = calculateCylinderVolume(cylinderRadius, cylinderHeight);
            System.out.printf("Cylinder Volume: %.2f cubic units%n", volume);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

/*
Output:
Cylinder Volume: 785.40 cubic units
*/