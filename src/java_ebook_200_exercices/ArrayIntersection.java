package java_ebook_200_exercices;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayIntersection {
    void main() {
        // Example ArrayLists
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        // Fill the first list
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        // Fill the second list
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        list2.add(7);

        // Create HashSets from the lists
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);

        // Find the intersection of the two HashSets
        set1.retainAll(set2);

        // Display the result
        System.out.println("Intersection: " + set1);
    }
}

/*
* Intersection: [3, 4, 5]
*/