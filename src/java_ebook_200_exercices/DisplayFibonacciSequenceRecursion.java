package java_ebook_200_exercices;

import java.util.Scanner;

public class DisplayFibonacciSequenceRecursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms in the Fibonacci sequence: ");
        int numTerms = scanner.nextInt();
        if (numTerms < 0) {
            System.out.println("Please enter a valid non-negative integer.");
            return;
        }

        System.out.println("Fibonacci sequence of: " + numTerms + " terms: ");
        for (int i = 0; i < numTerms; i++) {
            System.out.println(fibonacci(i) );
        }
    }

    private static int fibonacci(int n) {
        if(n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}

//Enter the number of terms in the Fibonacci sequence: 5
//Fibonacci sequence of: 5 terms:
//0
//1
//1
//2
//3
