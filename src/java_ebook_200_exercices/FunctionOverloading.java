package java_ebook_200_exercices;

public class FunctionOverloading {
    // Method with no arguments
    public static void exampleFunction() {
        System.out.println("No arguments");
    }

    // Method with one number argument
    public static void exampleFunction(int n) {
        System.out.println("One number argument: " + n);
    }

    // Method with string and number arguments
    public static void exampleFunction(String s, int n) {
        System.out.println("String and number arguments: " + s + ", " + n);
    }

    public static void main(String[] args) {
        // Calls the method with no arguments
        exampleFunction();

        // Calls the method with one integer argument
        exampleFunction(42);

        // Calls the method with a string and an integer argument
        exampleFunction("Hello", 7);

        // The following line will work correctly due to method overloading:
        // exampleFunction("world", 7);
    }
}