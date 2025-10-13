package java_ebook_200_exercices;

import java.util.ArrayList;
import java.util.List;

/// # Main
///
/// This class demonstrates how to extract and display the highest grades (top notes)
/// from a list of `Student` objects.
///
/// ## Description
/// The program defines a method `getStudentTopNotes()` that iterates over a list of
/// students and collects their highest grades into a new list.
/// The `main()` method initializes sample students with their grades, retrieves their
/// top grades, and prints them to the console.
///
/// ## Example
/// ```java
/// List<Student> students = new ArrayList<>();
/// students.add(new Student(1, "Jacek", List.of(5, 3, 4, 2, 5, 5)));
/// students.add(new Student(2, "Ewa", List.of(2, 3, 3, 3, 2, 5)));
/// students.add(new Student(3, "Zygmunt", List.of(2, 2, 4, 4, 3, 3)));
///
/// List<Integer> topNotes = Main.getStudentTopNotes(students);
/// System.out.println("Top notes: " + topNotes);
/// // Output: Top notes: [5, 5, 4]
/// ```
///
/// ## See Also
/// - [`Student`](#)
/// - [`List`](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/util/List.html)
///
public class Main {

    /// ## Method: getStudentTopNotes
    ///
    /// Returns a list of the highest grades (top notes) from a list of students.
    ///
    /// ### Parameters
    /// - `students`: A list of `Student` objects.
    ///
    /// ### Returns
    /// A list of integers, where each integer represents the top grade of a student.
    ///
    /// ### Example
    /// ```java
    /// List<Integer> topNotes = Main.getStudentTopNotes(students);
    /// ```
    ///
    /// ### Throws
    /// This method does not throw any checked exceptions.
    public static List<Integer> getStudentTopNotes(List<Student> students) {
        List<Integer> topNotes = new ArrayList<>();

        for (Student student : students) {
            topNotes.add(student.getTopNote());
        }
        return topNotes;
    }

    /// ## Method: main
    ///
    /// Demonstrates how to use the `getStudentTopNotes()` method by creating a list of
    /// students and printing their top grades.
    ///
    /// ### Example
    /// ```java
    /// public static void main(String[] args) {
    ///     List<Student> students = new ArrayList<>();
    ///     students.add(new Student(1, "Jacek", List.of(5, 3, 4, 2, 5, 5)));
    ///     students.add(new Student(2, "Ewa", List.of(2, 3, 3, 3, 2, 5)));
    ///     students.add(new Student(3, "Zygmunt", List.of(2, 2, 4, 4, 3, 3)));
    ///
    ///     List<Integer> topNotes = getStudentTopNotes(students);
    ///     System.out.println("Top notes: " + topNotes);
    ///     // Output: Top notes: [5, 5, 4]
    /// }
    /// ```
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "Jacek", List.of(5, 3, 4, 2, 5, 5)));
        students.add(new Student(2, "Ewa", List.of(2, 3, 3, 3, 2, 5)));
        students.add(new Student(3, "Zygmunt", List.of(2, 2, 4, 4, 3, 3)));
        List<Integer> topNotes = getStudentTopNotes(students);
        System.out.println("Top notes: " + topNotes);
    }
}

// Output: Top notes: [5, 5, 4]
