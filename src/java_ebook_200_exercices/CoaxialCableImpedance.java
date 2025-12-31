package java_ebook_200_exercices;

public class CoaxialCableImpedance {
    public static double impedanceCalculator(double dD, double dC, double eR) {

        // Calculate the impedance using the formula
        double logTerm = Math.log10(dD / dC);
        double impedance = 60.0 / Math.sqrt(eR) * logTerm;
        return impedance;
    }

    public static void main(String[] args) {
        // Example usage
        System.out.printf("%.1f%n", impedanceCalculator(20.7, 2.0, 4.0));
        System.out.printf("%.1f%n", impedanceCalculator(5.3, 1.2, 2.2));
        System.out.printf("%.1f%n", impedanceCalculator(4.48, 1.33, 2.2));
    }
}

// 30.4
// 26.1
// 21.3
