package java_ebook_200_exercices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Superheroes {
    public static List<String> superheroes(String[] names) {
        List<String> filtered = new ArrayList<>();

        // Filter names ending with "man"
        for (String name : names) {
            if (name.toLowerCase().endsWith("man")) {
                filtered.add(name);
            }
        }

        // Sort the filtered list
        Collections.sort(filtered);
        return filtered;
    }

    public static void main(String[] args) {
        String[] heroes1 = {"Batman", "Superman", "Spider-man", "Hulk", "Wolverine", "Wonder-Woman"};
        List<String> result1 = superheroes(heroes1);

        System.out.println(result1); // Output: [Batman, Spider-man, Superman]
        String[] heroes2 = {"Catwoman", "Deadpool", "Dr.Strange", "Captain-America", "Aquaman", "Hawkeye"};

        List<String> result2 = superheroes(heroes2);
        System.out.println(result2); // Output: [Aquaman]

        String[] heroes3 = {"Wonder-Woman", "Catwoman", "Invisible-Woman"};
        List<String> result3 = superheroes(heroes3);

        System.out.println(result3); // Output: []
    }
}

// Expected Output:
// [Batman, Spider-man, Superman]
// [Aquaman]
// []