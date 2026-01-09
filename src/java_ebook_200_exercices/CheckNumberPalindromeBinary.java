package java_ebook_200_exercices;

public class CheckNumberPalindromeBinary {
    // Method to check if a number is a palindrome in binary
    public static boolean isBinaryPalindrome(int number) {
        String binaryRepresentatio = Integer.toBinaryString(number); //Convert to binary representation
        String reservedBinary = new StringBuilder(binaryRepresentatio).reverse().toString(); //Reverse the binary representation

        return binaryRepresentatio.equals(reservedBinary); //Check if it is a palindrome
    }

    void main() {
        int numberToCheck = 9; //Replace with the number you want to check

        if(isBinaryPalindrome(numberToCheck)) {
            System.out.printf("%d is a binary palindrome! \uD83C\uDF89%n", numberToCheck);
        } else {
            System.out.printf("%d is not a palindrome. \uD83D\uDE22%n", numberToCheck);
        }
    }
}

// 9 is a binary palindrome! 🎉