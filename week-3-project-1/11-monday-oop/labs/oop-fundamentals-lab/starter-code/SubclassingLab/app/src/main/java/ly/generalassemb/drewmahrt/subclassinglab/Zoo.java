package ly.generalassemb.drewmahrt.subclassinglab;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by michaeljeffress on 6/20/16.
 */
public class Zoo {
    private static Zoo zoo;
    private static ArrayList<String> zooAnimals;

//    ArrayList<Animal> zooAnimals = new ArrayList<>();

    public Zoo(ArrayList zooAnimals) {
        zooAnimals = new ArrayList<>();
    }

    public static Zoo getZooInstance() {  // Singleton get method
            if(zoo == null) {
                zoo = new Zoo();
            }
            return zoo;
        }

//    public void setZooAnimals(ArrayList zooAnimals) {
//        this.zooAnimals = zooAnimals;
//    }
//}


//public class School{
//private static School school = null;
//    private static LinkedList<String> teachers;
//    private static LinkedList<String> students;
//
//    private School(){
//        teachers = new LinkedList<String>();
//        students = new LinkedList<String>();
//    }
//
//    public static School getInstance(){
//        if(school == null){
//            school = new School();
//        }
//        return school;
//    }
//
//    public void addTeacher(String teacher){
//        teachers.add(teacher);
//    }
//
//    public void addStudent(String student){
//        students.add(student);
//    }
//
//    public LinkedList<String> getStudents(){
//        return students;
//    }
//
//    public LinkedList<String> getTeachers(){
//        return teachers;
//    }
//}