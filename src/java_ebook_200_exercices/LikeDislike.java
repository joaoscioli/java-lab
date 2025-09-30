package java_ebook_200_exercices;

public class LikeDislike {
    // Method to determine the final state based on button presses
    public static String likeOrDislike(String[] buttons) {
        String state = "Nothing";
        for (String button : buttons) {
            switch (state) {
                case "Nothing":
                    if (button.equals("Like")) {
                        state = "Like";
                    } else if (button.equals("Dislike")) {
                        state = "Dislike";
                    }
                    break;
                case "Like":
                    if (button.equals("Like")) {
                        state = "Nothing";
                    } else if (button.equals("Dislike")) {
                        state = "Dislike";
                    }
                    break;
                case "Dislike":
                    if (button.equals("Like")) {
                        state = "Like";
                    } else if (button.equals("Dislike")) {
                        state = "Nothing";
                    }
                    break;
            }
        }
        return state;
    }

    public static void main(String[] args) {
        String[][] testCases = {
                {"Dislike"},
                {"Like", "Like"},
                {"Dislike", "Like"},
                {"Like", "Dislike", "Dislike"},
        };

        for (String[] buttons : testCases) {
            System.out.println("Final state: " + likeOrDislike(buttons));
        }
    }
}

// Output:
// Final state: Dislike
// Final state: Nothing
// Final state: Like
// Final state: Nothing