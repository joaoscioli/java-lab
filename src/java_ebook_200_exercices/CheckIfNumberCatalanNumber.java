package java_ebook_200_exercices;

public class CheckIfNumberCatalanNumber {
    // Method to calculate the binomial coefficient C(n,k)
    public static long binomialCoefficient(long n, long k) {
        long result = 1;
        if(k > n-k) {
            k = n-k;    //Take advantage of symmetry
        }

        for (long i=0; i<k; i++) {
            result *= n;
            result /= (i+1);
            n--;
        }
        return result;
    }

    //Method to check if a number is a Catalan number
     public static boolean isCatalanNumber(long num) {
        long i=0;
        while (true) {
            long catalan = binomialCoefficient(2*i,i)/(i+1);
            if (catalan == num) {
                return true;    //Found a match
            } else if (catalan > num) {
                return false;   //Exceeded the number
            }
            i++;
        }
     }
     void main() {
        long numberToCheck = 42;    //Replace with the number you want to check
         if (isCatalanNumber(numberToCheck)) {
             System.out.printf("%d is a Catalan number! \uD83C\uDF89%n", numberToCheck);
         } else {
             System.out.printf("%d is not a Catalan number. \uD83D\uDE22%n", numberToCheck);
         }
     }
}

// 42 is a Catalan number! 🎉
