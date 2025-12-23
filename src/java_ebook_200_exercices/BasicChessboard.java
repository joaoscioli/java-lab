package java_ebook_200_exercices;

/// # BasicChessboard
///
/// Generates a textual representation of a standard **8×8 chessboard**
/// using characters.
///
/// Black squares are represented by the character `'X'`,
/// while white squares are represented by spaces.
///
/// ## Output Format
/// - Each row contains 8 squares
/// - Squares are separated by a single space
/// - Rows are separated by a newline character (`\n`)
///
/// ## Pattern Rule
/// The color of each square is determined by the parity of
/// `(row + column)`:
///
/// - `(row + col) % 2 == 1` → black square (`X`)
/// - `(row + col) % 2 == 0` → white square (` `)
///
/// ## Example
/// ```text
///   X   X   X   X
/// X   X   X   X
///   X   X   X   X
/// X   X   X   X
///   X   X   X   X
/// X   X   X   X
///   X   X   X   X
/// X   X   X   X
/// ```
public class BasicChessboard {

    /// ## generateChessboard
    ///
    /// Builds and returns a string containing a visual representation
    /// of a chessboard using ASCII characters.
    ///
    /// ### Implementation Details
    /// - Uses a nested loop to iterate over rows and columns
    /// - Applies modulo arithmetic to alternate square colors
    /// - Uses `StringBuilder` for efficient string concatenation
    ///
    /// ### Time Complexity
    /// - **O(n²)**, where `n` is the board size (fixed at 8)
    ///
    /// ### Space Complexity
    /// - **O(n²)** for the generated string
    ///
    /// @return a string representing the chessboard layout
    public static String generateChessboard() {
        int size = 8; // Size of the chessboard (8x8)
        StringBuilder chessboard = new StringBuilder();

        for (int row = 0; row < size; row++) {
            StringBuilder currentRow = new StringBuilder();

            for (int col = 0; col < size; col++) {

                // Use 'X' for black squares and ' ' for white squares
                char square = (row + col) % 2 == 1 ? 'X' : ' ';
                currentRow.append(square).append(' ');
            }

            // Add the current row to the chessboard and add a newline
            chessboard.append(currentRow.toString().trim()).append('\n');
        }
        return chessboard.toString();
    }

    /// ## main
    ///
    /// Entry point of the program.
    ///
    /// Generates the chessboard and prints it to the standard output.
    ///
    /// This method serves as a simple demonstration of the
    /// `generateChessboard()` functionality.
    ///
    /// @param args command-line arguments (not used)
    public static void main(String[] args) {
        String chessboard = generateChessboard();
        System.out.print(chessboard);
    }
}
