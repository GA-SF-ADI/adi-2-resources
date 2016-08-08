package com.test.bookscanner2.modelsClassroom;

import java.util.ArrayList;

/**
 * Created by audreyeso on 8/8/16.
 */
public class ClassroomKinderToSecond {
    private String classroomName;
    private String questionOneKinder;
    private String questionTwoKinder;
    private String questionOneFirstGrade;
    private String questionTwoFirstGrade;
    private ArrayList<Student> students;
    private String questionOneSecondGrade;
    private String questionTwoSecondGrade;
    private String questionThreeSecondGrade;
    private String gradeLevel;
    private String studentName;


    public ClassroomKinderToSecond(String studentName, String gradeLevel) {
        this.studentName = studentName;
        this.gradeLevel = gradeLevel;
        students = new ArrayList<>();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getQuestionOne() {
        questionOneSecondGrade ="Question 1 Second Grade";
        return questionOneSecondGrade;
    }

    public void setQuestionOne(String questionOne){
        this.questionOneSecondGrade = questionOne;
    }

    public String getQuestionTwoSecondGrade() {
        questionTwoSecondGrade = "Question 2 Second Grade";
        return questionTwoSecondGrade;
    }

    public void setQuestionTwoSecondGrade(String questionTwoSecondGrade) {
        this.questionTwoSecondGrade = questionTwoSecondGrade;
    }

    public String getQuestionThree() {
        questionThreeSecondGrade = "Question 3 Second Grade";
        return questionThreeSecondGrade;
    }

    public void setQuestionThree(String questionThree){
        this.questionThreeSecondGrade = questionThree;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public ArrayList<Student>getStudents() {
        return students;
    }

    public void setStudents (ArrayList<Student> students){
        this.students = students;
    }

    public String getQuestionOneKinder() {
        questionOneKinder = "Question 1 Kinder";
        return questionOneKinder;
    }

    public void setQuestionOneKinder(String questionOneKinder) {
        this.questionOneKinder = questionOneKinder;
    }

    public String getQuestionTwoKinder() {
        questionTwoKinder = "Question 2 Kinder";
        return questionTwoKinder;
    }

    public void setQuestionTwoKinder(String questionTwoKinder) {
        this.questionTwoKinder = questionTwoKinder;
    }

    public String getQuestionOneFirstGrade() {
        questionOneFirstGrade = "Question 1 First Grade";
        return questionOneFirstGrade;
    }

    public void setQuestionOneFirstGrade(String questionOneFirstGrade) {
        this.questionOneFirstGrade = questionOneFirstGrade;
    }

    public String getQuestionTwoFirstGrade() {
        questionTwoFirstGrade = "Question 2 First Grade";
        return questionTwoFirstGrade;
    }

    public void setQuestionTwoFirstGrade(String questionTwoFirstGrade) {
        this.questionTwoFirstGrade = questionTwoFirstGrade;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }


    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }
}
