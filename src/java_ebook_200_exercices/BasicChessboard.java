package java_ebook_200_exercices;

public class BasicChessboard {
    public static String generateChessboard() {
        int size = 8; // Size of the chessboard (8x8)
        StringBuilder chessboard = new StringBuilder();

        for (int row = 0; row < size; row++) {
            StringBuilder currentRow = new StringBuilder();

            for (int col = 0; col < size; col++) {

                // Use 'X' for black squares and ' ' for white squares
                char square = (row + col) % 2 == 1 ? 'X' : ' ';
                currentRow.append(square).append(' '); // Adding a space between squares
            }

            // Add the current row to the chessboard and add a newline
            chessboard.append(currentRow.toString().trim()).append('\n'); // Trim trailing space
        }
        return chessboard.toString();
    }

    public static void main(String[] args) {
        String chessboard = generateChessboard();
        System.out.print(chessboard);
    }
}

// Output:
//   X   X   X   X
// X   X   X   X
//   X   X   X   X
// X   X   X   X
//   X   X   X   X
// X   X   X   X
//   X   X   X   X
// X   X   X   X
