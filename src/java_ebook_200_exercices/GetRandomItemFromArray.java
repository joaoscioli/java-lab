package java_ebook_200_exercices;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/// # GetRandomItemFromArray
///
/// This class demonstrates how to retrieve a random item from an `ArrayList` of integers.
///
/// ## Description
/// - Initializes a list with integers from 1 to 10.
/// - Uses `java.util.Random` to generate a random index.
/// - Fetches and prints the item at the generated index.
/// - Handles the case when the list is empty.
///
/// ## Example Output
/// ```
/// Random Item: 4
/// ```
///
/// ## See Also
/// - [Random (Java SE API)](https://docs.oracle.com/javase/8/docs/api/java/util/Random.html)
/// - [ArrayList (Java SE API)](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)
public class GetRandomItemFromArray {
    static void main() {
        // Example ArrayList
        List<Integer> myList = new ArrayList<Integer>();
        for (int i = 1; i <= 10; i++) {
            myList.add(i);
        }

        // Create a random number generator
        Random random = new Random();

        // Get a random item from the ArrayList
        if (!myList.isEmpty()) {
            int randomIndex = random.nextInt(myList.size());
            int randomItem = myList.get(randomIndex);

            // Display the result
            System.out.println("Random Item: " + randomItem);
        } else {
            System.out.println("The list is empty");
        }
    }
}
