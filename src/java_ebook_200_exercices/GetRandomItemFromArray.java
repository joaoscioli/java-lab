package java_ebook_200_exercices;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

/*
* Random Item: 4
* */