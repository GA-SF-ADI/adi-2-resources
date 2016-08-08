package com.test.bookscanner2.modelsClassroom;

import java.util.ArrayList;

/**
 * Created by audreyeso on 8/8/16.
 */
public class ClassroomFirst {
    private ArrayList<Student> students;
    private String questionOne;
    private String questionTwo;
    private String studentName;

    public ClassroomFirst(String studentName) {
        this.studentName = studentName;
        students = new ArrayList<>();
        this.questionOne = questionOne;
        this.questionTwo = questionTwo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getQuestionOne() {
        questionOne ="Question 1 First Grade";
        return questionOne;
    }

    public void setQuestionOne(String questionOne){
        this.questionOne = questionOne;
    }

    public String getQuestionTwo() {
        return questionOne;
    }

    public void setQuestionTwo(String questionTwo){
        questionOne ="Question 2 First Grade";
        this.questionTwo = questionTwo;
    }


    public void addStudent(Student student) {
        students.add(student);
    }

    public ArrayList<Student>getStudents() {
        return students;
    }
}


