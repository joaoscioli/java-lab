package java_ebook_200_exercices;

import java.io.File;

/**
 /// # FileExtension
 ///
 /// Utility class for extracting the extension from a file name.
 ///
 /// ## Overview
 /// This class provides a static method to retrieve the extension of a file
 /// by analyzing the file name string. If the file does not contain a valid
 /// extension (no period or ends with a period), the method returns `null`.
 ///
 /// ## Example
 /// ```java
 /// String extension = FileExtension.getFileExtension("example.txt");
 /// System.out.println(extension); // Output: txt
 /// ```
 ///
 */
public class FileExtension {

    /**
     /// ## getFileExtension
     ///
     /// Extracts the extension from the provided file name.
     ///
     /// ### Parameters
     /// - `fileName`: The name of the file from which to extract the extension.
     ///
     /// ### Returns
     /// - The file extension as a `String`, or `null` if no extension is found.
     ///
     /// ### Notes
     /// - The extension is defined as the substring after the last `.` character.
     /// - Hidden files or files with no extension will return `null`.
     ///
     /// ### Example
     /// ```java
     /// String ext = FileExtension.getFileExtension("document.pdf"); // returns "pdf"
     /// ```
     */
    public static String getFileExtension(String fileName) {
        File file = new File(fileName);
        String extension = "";

        if (file.getName().contains(".")) {
            extension = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        }

        return extension.isEmpty() ? null : extension;
    }

    /**
     /// ## main
     ///
     /// Demonstrates the usage of the `getFileExtension` method.
     ///
     /// ### Example
     /// ```java
     /// FileExtension.main(); // prints "File extension: txt"
     /// ```
     */
    void main() {
        String fileName = "example.txt";
        String extension = getFileExtension(fileName);

        if (extension != null) {
            System.out.println("File extension: " + extension);
        } else {
            System.out.println("No file extension found");
        }
    }
}
