package java_ebook_200_exercices;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Integer> getStudentTopNotes(List<Student> students) {
        List<Integer> topNotes = new ArrayList<>();

        for (Student student : students) {
            topNotes.add(student.getTopNote());
        }
        return topNotes;
    }

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
