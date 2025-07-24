package java_ebook_200_exercices;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/// # ArrayIntersection
///
/// This class demonstrates how to compute the **intersection** between two `ArrayList<Integer>`
/// using `HashSet` in Java.
///
/// The method:
/// - Populates two lists with integer elements.
/// - Converts both lists into sets to remove duplicates and allow efficient set operations.
/// - Applies the `retainAll` method to find the common elements between both sets.
/// - Prints the result to the console.
///
/// ## Output Example
/// ```text
/// Intersection: [3, 4, 5]
/// ```
public class ArrayIntersectionsProject {

    /// ## main
    ///
    /// Runs the intersection logic between two lists and prints the result.
    ///
    /// ### Steps:
    /// 1. Creates two sample lists: `list1` and `list2`.
    /// 2. Fills each list with integers.
    /// 3. Converts the lists to `HashSet` to prepare for set operations.
    /// 4. Uses `retainAll` to keep only elements that are present in both sets.
    /// 5. Prints the intersection result to standard output.
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
