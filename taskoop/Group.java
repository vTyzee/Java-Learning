package org.example.taskoop;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private final int year;
    private final String groupName; // e.g. "NPTV23"
    private final List<Student> students;

    public Group(int year, String groupName) {
        this.year = year;
        this.groupName = groupName;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public int getYear() {
        return year;
    }

    public String getGroupName() {
        return groupName;
    }

    public List<Student> getStudents() {
        return students;
    }
}
