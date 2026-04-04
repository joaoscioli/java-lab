package daily_question.decodeSlantedCiphertext;

class Solution {

    /// # Decode Slanted Ciphertext
    ///
    /// Decodes a string that was encoded using a **slanted transposition cipher**.
    ///
    /// ## Approach
    ///
    /// The encoding process works in two phases:
    ///
    /// 1. The original text is written into a matrix **diagonally (top-left → bottom-right)**.
    /// 2. The encoded string is then formed by reading the matrix **row by row**.
    ///
    /// To reverse this process:
    ///
    /// - Reconstruct the matrix by filling it **row-wise** from the encoded text.
    /// - Traverse the matrix diagonally (↘) starting from each column in the first row.
    /// - Collect characters to rebuild the original string.
    /// - Trim any trailing spaces.
    ///
    /// ## Algorithm Steps
    ///
    /// 1. Handle edge case where `rows == 1` (no transformation needed).
    /// 2. Compute number of columns:
    ///    ```
    ///    cols = encodedText.length() / rows
    ///    ```
    /// 3. Fill a `rows x cols` matrix row-wise.
    /// 4. Traverse diagonals starting from `(0, startCol)`:
    ///    ```
    ///    (i, j) → (i+1, j+1)
    ///    ```
    /// 5. Remove trailing spaces from the result.
    ///
    /// ## Complexity
    ///
    /// - Time Complexity: **O(n)**
    /// - Space Complexity: **O(n)** (due to matrix storage)
    ///
    /// ## Notes
    ///
    /// - The input is guaranteed to be a valid encoding.
    /// - The original text does **not** contain trailing spaces.
    ///
    /// ## Example
    ///
    /// ```text
    /// Input:
    /// encodedText = "ch   ie   pr", rows = 3
    ///
    /// Output:
    /// "cipher"
    /// ```
    ///
    /// @param encodedText the encoded string produced by row-wise traversal of a slanted matrix
    /// @param rows the number of rows used to build the matrix
    /// @return the decoded original string without trailing spaces
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1) return encodedText;

        int n = encodedText.length();
        int cols = n / rows;

        char[][] matrix = new char[rows][cols];

        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = encodedText.charAt(index++);
            }
        }

        StringBuilder result = new StringBuilder();

        for (int startCol = 0; startCol < cols; startCol++) {
            int i = 0, j = startCol;

            while (i < rows && j < cols) {
                result.append(matrix[i][j]);
                i++;
                j++;
            }
        }

        int end = result.length() - 1;
        while (end >= 0 && result.charAt(end) == ' ') {
            end--;
        }

        return result.substring(0, end + 1);
    }
}