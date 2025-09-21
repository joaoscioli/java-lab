package java_ebook_200_exercices;

public class PowerCalculator {
    // Method to calculate power using double values
    public static double calculatePowerWithPow(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    // Method to calculate power using integer base and exponent
    public static int calculatePowerWithIntegerExponent(int base, int exponent) {
        int result = 1;

        for (int i = 0; i < exponent; i++) {
            result *= base; // Multiply base exponent times
        }
        return result;
    }

    public static void main(String[] args) {
        double baseNumberDouble = 2.0;
        double exponentNumberDouble = 3.0;
        double resultWithPow = calculatePowerWithPow(baseNumberDouble, exponentNumberDouble);

        System.out.printf("%.1f to the power of %.1f using Math.pow(): %.1f%n",
                baseNumberDouble, exponentNumberDouble, resultWithPow);

        int baseNumberInt = 2;
        int exponentNumberInt = 3;
        int resultWithIntegerPow = calculatePowerWithIntegerExponent(baseNumberInt, exponentNumberInt);

        System.out.printf("%d to the power of %d using the integer method: %d%n",
                baseNumberInt, exponentNumberInt, resultWithIntegerPow);
    }
}

// Output:
// 2.0 to the power of 3.0 using Math.pow(): 8.0
// 2 to the power of 3 using the integer method: 8

