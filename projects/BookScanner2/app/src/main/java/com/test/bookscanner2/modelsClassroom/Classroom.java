package com.test.bookscanner2.modelsClassroom;

import java.util.ArrayList;

/**
 * Created by audreyeso on 8/7/16.
 */
public class Classroom {

    private static Classroom classroom;

    private static ArrayList<Student>students;

    private Classroom() {
        students = new ArrayList<>();
    }

    public static Classroom getInstance() {
        if(classroom == null)
            classroom = new Classroom();
        return classroom;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public ArrayList<Student>getStudents() {
        return students;
    }
}
