package java_ebook_200_exercices;

/// # LikeDislike
///
/// Utility class that simulates the behavior of a Like/Dislike button system.
/// Each button press changes the current state (`Like`, `Dislike`, or `Nothing`)
/// according to simple toggle rules.
///
/// ## Rules
/// - If the state is **Nothing**:
///   - Pressing **Like** → becomes `Like`.
///   - Pressing **Dislike** → becomes `Dislike`.
/// - If the state is **Like**:
///   - Pressing **Like** → returns to `Nothing`.
///   - Pressing **Dislike** → becomes `Dislike`.
/// - If the state is **Dislike**:
///   - Pressing **Dislike** → returns to `Nothing`.
///   - Pressing **Like** → becomes `Like`.
///
/// ## Example
/// ```java
/// LikeDislike.likeOrDislike(new String[]{"Like", "Like"}); // returns "Nothing"
/// LikeDislike.likeOrDislike(new String[]{"Dislike", "Like"}); // returns "Like"
/// ```
public class LikeDislike {

    /// Determines the final state of the Like/Dislike system
    /// after a sequence of button presses.
    ///
    /// @param buttons an array of strings representing button presses (`"Like"` or `"Dislike"`)
    /// @return the final state: `"Like"`, `"Dislike"`, or `"Nothing"`
    ///
    /// ## Example
    /// ```java
    /// LikeDislike.likeOrDislike(new String[]{"Dislike"});
    /// // returns "Dislike"
    /// ```
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

    /// Demonstrates the usage of the `likeOrDislike` method with
    /// predefined test cases.
    ///
    /// ## Output
    /// ```
    /// Final state: Dislike
    /// Final state: Nothing
    /// Final state: Like
    /// Final state: Nothing
    /// ```
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
