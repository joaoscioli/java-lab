package java_ebook_200_exercices;

import java.util.function.BiFunction;

public class FunctionParameterExample {
    // Method that takes two integers and a BiFunction as a parameter
    public static int operateOnNumbers(int a, int b, BiFunction<Integer, Integer, Integer> operation) {
        return operation.apply(a, b); // Call the passed function with the provided arguments
    }

    public static void main(String[] args) {
        // Example usage with addition
        int result1 = operateOnNumbers(3, 5, (x, y) -> x + y);
        System.out.println("Result of addition: " + result1);  // Outputs: 8

        // Example usage with multiplication
        int result2 = operateOnNumbers(3, 5, (x, y) -> x * y);
        System.out.println("Result of multiplication: " + result2);  // Outputs: 15
    }
}

