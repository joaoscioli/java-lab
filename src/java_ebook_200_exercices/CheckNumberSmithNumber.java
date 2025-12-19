package java_ebook_200_exercices;

import java.util.ArrayList;
import java.util.List;

public class CheckNumberSmithNumber {
    public static boolean isPrime(long num) {
        if (num < 2) return false;

        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static long sumOfDigits(long num) {
        long sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static List<Long> primeFactors(long num) {
        List<Long> factors = new ArrayList<>();

        for (long i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                factors.add(i);
                num /= i;
            }
        }

        if (num > 1) {
            factors.add(num);
        }
        return factors;
    }

    public static boolean isSmithNumber(long num) {
        long originalSum = sumOfDigits(num);
        long primeFactorSum = primeFactors(num).stream().mapToLong(CheckNumberSmithNumber::sumOfDigits).sum();
        return originalSum != primeFactorSum && !isPrime(num);
    }

    static void main() {
        long number = 728;
        System.out.println("Is " + number + " a Smith number? " + isSmithNumber(number));
    }
}

// Output: Is 728 a Smith number? false
