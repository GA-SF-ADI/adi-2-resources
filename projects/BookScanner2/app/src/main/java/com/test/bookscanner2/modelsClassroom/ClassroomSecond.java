package com.test.bookscanner2.modelsClassroom;

import java.util.ArrayList;

/**
 * Created by audreyeso on 8/8/16.
 */
public class ClassroomSecond {
    private ArrayList<Student> students;
    private String questionOne;
    private String questionTwo;
    private String questionThree;
    private String studentName;


    public ClassroomSecond(String studentName) {
        this.studentName = studentName;
        students = new ArrayList<>();
        this.questionOne = questionOne;
        this.questionTwo = questionTwo;
        this.questionThree = questionThree;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getQuestionOne() {
        questionOne ="Question 1 Second Grade";
        return questionOne;
    }

    public void setQuestionOne(String questionOne){
        this.questionOne = questionOne;
    }

    public String getQuestionTwo() {
        return questionOne;
    }

    public void setQuestionTwo(String questionTwo){
        questionOne ="Question 2 Second Grade";
        this.questionTwo = questionTwo;
    }

    public String getQuestionThree() {
        questionThree = "Question 3 Second Grade";
        return questionThree;
    }

    public void setQuestionThree(String questionThree){
        this.questionThree = questionThree;
    }
    
    public void addStudent(Student student) {
        students.add(student);
    }

    public ArrayList<Student>getStudents() {
        return students;
    }
}



