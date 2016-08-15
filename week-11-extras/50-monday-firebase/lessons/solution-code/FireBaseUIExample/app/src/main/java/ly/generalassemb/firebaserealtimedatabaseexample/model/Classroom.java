package ly.generalassemb.firebaserealtimedatabaseexample.model;

import java.util.ArrayList;

/**
 * Created by alex on 8/14/16.
 */
public class Classroom {
    private ArrayList<Student> students;

    public Classroom() {
        this.students = new ArrayList<>();
    }

    /**
     * Add student to class
     *
     * @param student
     */
    public void addStudent(Student student){
        students.add(student);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
