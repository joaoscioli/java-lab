package java_ebook_200_exercices;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveSpecifcItemFromArray {
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

/*
* Original List: [1,2,4,5]
* */