package java_ebook_200_exercices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Superheroes {

    /// ## superheroes
    ///
    /// Filters and returns superhero names that end with the suffix **"man"**.
    ///
    /// The comparison is **case-insensitive**, and the resulting list is
    /// returned in **alphabetical order**.
    ///
    /// ### Parameters
    /// - `names` — An array of superhero names to be filtered.
    ///
    /// ### Returns
    /// A `List<String>` containing only the names that end with `"man"`,
    /// sorted in ascending lexicographical order.
    ///
    /// ### Behavior
    /// - Names such as `"Batman"`, `"Superman"`, and `"Aquaman"` are included.
    /// - Names like `"Wonder-Woman"` or `"Spider-woman"` are excluded because
    ///   they do not strictly end with `"man"`.
    ///
    /// ### Example
    /// ```java
    /// String[] heroes = {"Batman", "Superman", "Hulk", "Aquaman"};
    /// superheroes(heroes);
    /// ```
    ///
    /// Output:
    /// ```
    /// [Aquaman, Batman, Superman]
    /// ```
    public static List<String> superheroes(String[] names) {
        List<String> filtered = new ArrayList<>();

        // Filter names ending with "man"
        for (String name : names) {
            if (name.toLowerCase().endsWith("man")) {
                filtered.add(name);
            }
        }

        // Sort the filtered list alphabetically
        Collections.sort(filtered);
        return filtered;
    }

    /// ## main
    ///
    /// Demonstrates the usage of the `superheroes` method with multiple
    /// input scenarios, printing the filtered and sorted results.
    ///
    /// ### Demonstrated Cases
    /// - A list containing multiple superheroes ending with `"man"`.
    /// - A list containing a single valid superhero.
    /// - A list with no matching superheroes.
    public static void main(String[] args) {
        String[] heroes1 = {"Batman", "Superman", "Spider-man", "Hulk", "Wolverine", "Wonder-Woman"};
        List<String> result1 = superheroes(heroes1);
        System.out.println(result1); // [Batman, Spider-man, Superman]

        String[] heroes2 = {"Catwoman", "Deadpool", "Dr.Strange", "Captain-America", "Aquaman", "Hawkeye"};
        List<String> result2 = superheroes(heroes2);
        System.out.println(result2); // [Aquaman]

        String[] heroes3 = {"Wonder-Woman", "Catwoman", "Invisible-Woman"};
        List<String> result3 = superheroes(heroes3);
        System.out.println(result3); // []
    }
}
