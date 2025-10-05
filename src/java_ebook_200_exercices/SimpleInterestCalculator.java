package java_ebook_200_exercices;

public class SimpleInterestCalculator {
    // Method to calculate simple interest
    public static double calculateSimpleInterest(double principal, double rate, double time) throws IllegalArgumentException {

        // Check if the inputs are valid positive numbers
        if (principal <= 0.0 || rate <= 0.0 || time <= 0.0) {
            throw new IllegalArgumentException("Invalid inputs. Please provide valid positive numbers.");
        }

        // Calculate simple interest
        return (principal * rate * time) / 100.0;
    }

    public static void main(String[] args) {
        double principalAmount = 1000.0;
        double interestRate = 5.0;  // 5%
        double investmentTime = 2.0; // 2 years

        try {
            double interestAmount = calculateSimpleInterest(principalAmount, interestRate, investmentTime);
            System.out.printf("Principal Amount: $%.2f%n", principalAmount);
            System.out.printf("Interest Rate: %.2f%%%n", interestRate);
            System.out.printf("Investment Time: %.2f years%n", investmentTime);
            System.out.printf("Simple Interest: $%.2f%n", interestAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

// Output:
// Principal Amount: $1000.00
// Interest Rate: 5.00%
// Investment Time: 2.00 years
// Simple Interest: $100.00