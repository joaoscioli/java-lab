package java_ebook_200_exercices;

import java.util.Scanner;

public class PrintAllPrimeNumbersInterval {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read starting number of the interval
        System.out.print("Enter the ending number of the interval: ");
        int start = readInput(scanner);
        // Read ending number of the interval
        System.out.print("Enter the ending number of the interval: ");
        int end = readInput(scanner);
        if (start > 1 && start < end) {
            System.out.printf("Prime numbers in the interval [%d -  %d]:%n", start, end);
            for (int n = start; n <= end; n++) {
                if(isPrime(n)){
                    System.out.println(n);
                }
            }
        } else  {
            System.out.println("Please enter valid integers, ensuring that the starting number is less than the ending number and greater than 1.");
        }
    scanner.close();
    }

    // Function ro read input and parse it as integer
    public static int readInput(Scanner scanner) {
        while (!scanner.hasNext()) {
            System.out.println("Please enter a valid integer.");
            scanner.next(); // Clear invalid input
        }
        return scanner.nextInt();
    }

    // Function to check if a number is prime
    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;   // Found a divisor, not prime
            }
        }
        return true;    // No divisors found, is prime
    }
}

// Enter the starting number of the interval: 33
// Enter the ending number of the interval: 44
// Prime numbers in the interval [33 - 44]:
// 37
// 41
// 43