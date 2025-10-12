package java_ebook_200_exercices;

import java.util.Collections;
import java.util.List;

public class Student {

    private int id;
    private String name;
    private List<Integer> notes;

    public Student(int id, String name, List<Integer> notes) {
        this.id = id;
        this.name = name;
        this.notes = notes;
    }

    public int getTopNote() {

        // If there are no notes, return 0 as a default
        return notes.isEmpty() ? 0 : Collections.max(notes);
    }
}
