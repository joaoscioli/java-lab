package java_ebook_200_exercices;

import java.util.Collections;
import java.util.List;

/// # Student
///
/// Represents a student with an identifier, name, and a list of grades (`notes`).
///
/// ## Description
/// The `Student` class models a student and provides a method to retrieve
/// the highest grade among their recorded grades.
/// If a student has no grades, the `getTopNote()` method safely returns `0`
/// as a default value.
///
/// ## Example
/// ```java
/// Student student = new Student(1, "Jacek", List.of(5, 3, 4, 2, 5, 5));
/// int topNote = student.getTopNote();
/// System.out.println(topNote); // Output: 5
/// ```
///
/// ## See Also
/// - [`Main`](#)
/// - [`List`](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/util/List.html)
///
public class Student {

    /// ## Field: id
    ///
    /// Unique identifier of the student.
    private int id;

    /// ## Field: name
    ///
    /// Name of the student.
    private String name;

    /// ## Field: notes
    ///
    /// List of integer grades representing the student's scores.
    private List<Integer> notes;

    /// ## Constructor: Student
    ///
    /// Initializes a new `Student` instance with an ID, name, and list of grades.
    ///
    /// ### Parameters
    /// - `id`: The unique identifier of the student.
    /// - `name`: The student's name.
    /// - `notes`: A list of integer grades.
    ///
    /// ### Example
    /// ```java
    /// Student student = new Student(1, "Ewa", List.of(2, 3, 3, 3, 2, 5));
    /// ```
    public Student(int id, String name, List<Integer> notes) {
        this.id = id;
        this.name = name;
        this.notes = notes;
    }

    /// ## Method: getTopNote
    ///
    /// Returns the highest grade (top note) from the student's list of grades.
    ///
    /// ### Returns
    /// The maximum value found in the `notes` list.
    /// If the list is empty, returns `0`.
    ///
    /// ### Example
    /// ```java
    /// int topNote = student.getTopNote();
    /// ```
    ///
    /// ### Notes
    /// This method uses `Collections.max()` to find the maximum grade efficiently.
    public int getTopNote() {

        // If there are no notes, return 0 as a default
        return notes.isEmpty() ? 0 : Collections.max(notes);
    }
}
