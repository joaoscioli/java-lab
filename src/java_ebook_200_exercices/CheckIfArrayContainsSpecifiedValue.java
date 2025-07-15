package java_ebook_200_exercices;

public class CheckIfArrayContainsSpecifiedValue {
    public static void main(String[] args) {

        // Example array
        int[] myList = {1, 2, 3, 4, 5};
        int valueToCheck = 3;

        // Check if the array contains the specified value
        boolean containsValue = contains(myList, valueToCheck);

        // Display the result
        System.out.println("Does the list include " + valueToCheck + "? " + containsValue);
    }

    // Method to check if the array contains the specified value
    public static boolean contains(int[] array, int value) {
        for (int num : array) {
            if (num == value) {
                return true; // Value found
            }
        }
        return false; // Value not found
    }
}

/*
Does the list include 3? true
*/
