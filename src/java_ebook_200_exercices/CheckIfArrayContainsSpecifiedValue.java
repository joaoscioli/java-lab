package java_ebook_200_exercices;

/// # CheckIfArrayContainsSpecifiedValue
///
/// This class demonstrates how to check if an integer array contains a specified value.
/// It includes a `main` method to run the example and a helper method `contains` to perform the check.
public class CheckIfArrayContainsSpecifiedValue {

    /// ## main(String[] args)
    ///
    /// Entry point of the application. Creates an example integer array, specifies a value to search for,
    /// calls the `contains` method, and prints the result to standard output.
    ///
    /// ```
    /// int[] myList = {1, 2, 3, 4, 5};
    /// int valueToCheck = 3;
    /// boolean containsValue = contains(myList, valueToCheck);
    /// System.out.println("Does the list include " + valueToCheck + "? " + containsValue);
    /// ```
    public static void main(String[] args) {

        // Example array
        int[] myList = {1, 2, 3, 4, 5};
        int valueToCheck = 3;

        // Check if the array contains the specified value
        boolean containsValue = contains(myList, valueToCheck);

        // Display the result
        System.out.println("Does the list include " + valueToCheck + "? " + containsValue);
    }

    /// ## contains(int[] array, int value)
    ///
    /// Checks whether the provided integer array contains the specified value.
    ///
    /// **Parameters**
    /// - `array` : the integer array to search through.
    /// - `value` : the integer value to look for in the array.
    ///
    /// **Returns**
    /// - `true` if the array contains the specified value;
    /// - `false` otherwise.
    ///
    /// ```
    /// for (int num : array) {
    ///     if (num == value) {
    ///         return true;
    ///     }
    /// }
    /// return false;
    /// ```
    public static boolean contains(int[] array, int value) {
        for (int num : array) {
            if (num == value) {
                return true; // Value found
            }
        }
        return false; // Value not found
    }
}
