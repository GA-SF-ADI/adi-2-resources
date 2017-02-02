package com.test.bookscanner2.modelsClassroom;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by audreyeso on 8/6/16.
 */
public class Student implements Serializable{

    private static final long serialVersionUID = 7526472295622776147L;

    private String name;
    private int studentId;
    private ArrayList<String>students;

    public Student(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public ArrayList<String> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<String> students) {
        this.students = students;
    }
}
