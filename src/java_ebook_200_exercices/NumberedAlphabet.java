package java_ebook_200_exercices;

public class NumberedAlphabet {
    public static String alphNum(String s) {
        StringBuilder result = new StringBuilder();
        for(char c : s.toUpperCase().toCharArray()) {
            // Calculate the position in the alphabet
            int index = c - 'A';
            result.append(index).append(" ");
        }
        // Remove the trailing space
        return result.toString().trim();
    }

    public static void main(String[] args) {
        String[] examples = {"XYZ", "ABCDEF", "JAVASCRIPT"};
        for(String example : examples) {
            String result = alphNum(example);
            System.out.println(example + " -> " + result);
        }
    }
}

// Output:
// XYZ -> 23 24 25
// ABCDEF -> 0 1 2 3 4 5
// JAVASCRIPT -> 9 0 21 0 18 2 17 8 15 19