package ly.generalassemb.firebaserealtimedatabaseexample;

import java.util.ArrayList;

/**
 * Created by sterlinggerritz on 8/15/16.
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
