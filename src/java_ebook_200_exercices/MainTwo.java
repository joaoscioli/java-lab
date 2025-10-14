package java_ebook_200_exercices;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MainTwo {
    public static List<Integer> findIntersection(int[] arr1, int[] arr2) {

        // Convert the first array into a HashSet for efficient membership testing
        HashSet<Integer> set1 = new HashSet<>();
        for (int num : arr1) {
            set1.add(num);
        }

        // Use a List to collect the intersection
        List<Integer> intersection = new ArrayList<>();

        for (int num : arr2) {
            if (set1.contains(num)) {
                intersection.add(num);
            }
        }
        return intersection;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 6, 7};

        List<Integer> intersection = findIntersection(arr1, arr2);
        System.out.println("Intersection of Arrays: " + intersection);
    }
}

// Output: Intersection of Arrays: [3, 4, 5]