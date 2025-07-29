package java_ebook_200_exercices;

public class VariableCheck {
    void main() {
        // Example variables
        Integer undefineVariable = null; // Using Integer wrapper to allow null
        String nullVariable = null;
        String valueVariable = "Hello, World!";

        // Check the variables
        checkVariable(undefineVariable);    // Variable is null
        checkVariable(nullVariable);    // Variable is null
        checkVariable(valueVariable);   // Variable has a value
    }

    private static void checkVariable(Object variable) {
        // Check if the variable is null
        if (variable == null) {
            System.out.println("Variable is null.");
        } else {
            System.out.println("Variable has a value: " + variable);
        }
    }
}

// Variable is null
// Variable is null
// Variable has a value: Hello, World!