package java_ebook_200_exercices;

import java.util.ArrayList;

/// # InsertItemArray
///
/// Demonstrates how to insert an item at the end of an `ArrayList`.
///
/// This example creates an `ArrayList` of integers, inserts a new item
/// at the end using the `add` method, and prints the updated list.
///
/// ## Example Output
/// ```text
/// List after inserting: [1, 2, 3, 4, 5, 6]
/// ```

public class InsertItemArray {
    public static void main(String[] args) {

        // Example ArrayList
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        int itemToInsert = 6;

        // Insert the item at the end of the ArrayList
        myList.add(itemToInsert);

        // Display the result
        System.out.println("List after inserting: " + myList);
    }
}
