package java_ebook_200_exercices;

import java.io.File;
import java.util.Scanner;

public class FileExtension {
    public static String getFileExtension(String fileName) {
        // Create a File object from the file name
        File file = new File(fileName);

        // Get the file extension
        String extension = "";

        // Check if the file has a name
        if (file.getName().contains(".")) {
            // Extract the extension from the file name
            extension = file.getName().substring(file.getName().lastIndexOf(".")+1);
        }
        return extension.isEmpty() ? null : extension;  // Return null if no extension is found
    }

    void main() {
        // Example file name
        String fileName = "example.txt";

        // Get the file extension
        String extension = getFileExtension(fileName);

        if (extension != null) {
            System.out.println("File extension: " + extension);
        } else {
            System.out.println("No file extension found");
        }
    }
}

/*
* File Extension: txt
* */