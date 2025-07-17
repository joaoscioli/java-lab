package java_ebook_200_exercices;

import java.util.ArrayList;

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

/*
List after inserting: [1, 2, 3, 4, 5, 6]
*/