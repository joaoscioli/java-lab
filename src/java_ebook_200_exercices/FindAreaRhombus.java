package java_ebook_200_exercices;

public class FindAreaRhombus {
    // Method to calculate the area of a rhombus given its diagonals
    public static double calculateRhombusArea(double diagonal1, double diagonal2) {
        return (diagonal1 * diagonal2) / 2.0; // Area formula for rhombus
    }

    public static void main(String[] args) {
        double diagonal1Length = 8.0; // Length of the first diagonal
        double diagonal2Length = 6.0; // Length of the second diagonal
        double rhombusArea = calculateRhombusArea(diagonal1Length, diagonal2Length);


        System.out.printf("The area of the rhombus is: %.2f%n", rhombusArea);
    }
}

// The area of the rhombus is: 24.00
