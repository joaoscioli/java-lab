package java_ebook_200_exercices;


import java.util.ArrayList;
import java.util.Arrays;

/// # Remove a Specific Item from an ArrayList
///
/// This example demonstrates how to remove a specific item from an `ArrayList` in Java.
/// It creates a list of integers, attempts to remove a specific element, and prints the updated list or a message if the item is not found.
///
/// ## Example
/// ```java
/// Original List: [1, 2, 3, 4, 5]
/// Item to remove: 3
/// Output:
/// Original List: [1, 2, 4, 5]
/// ```
///

public class RemoveSpecifcItemFromArray {

    /// Removes a specific item from an `ArrayList` of integers and prints the result.
    ///
    /// This method demonstrates:
    /// - How to remove an element by value using `remove(Object o)`
    /// - How to handle the case when the item is not found in the list
    ///
    /// ### Output
    /// If the item exists in the list:
    /// ```
    /// Original List: [1, 2, 4, 5]
    /// ```
    ///
    /// If the item does not exist:
    /// ```
    /// Item not found in the list.
    /// ```
    static void main() {
        // Example list
        ArrayList<Integer> originalList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int itemToRemove = 3;

        // Find the position of the item to remove
        if (originalList.remove(Integer.valueOf(itemToRemove))) {
            System.out.println("Original List: " + originalList);
        } else {
            System.out.println("Item not found in the list.");
        }
    }
}
