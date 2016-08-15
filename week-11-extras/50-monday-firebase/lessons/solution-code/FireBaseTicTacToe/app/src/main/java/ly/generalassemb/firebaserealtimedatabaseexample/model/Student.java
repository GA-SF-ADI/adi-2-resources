package ly.generalassemb.firebaserealtimedatabaseexample.model;

/**
 * Created by alex on 8/14/16.
 */
public class Student {
    private String name;
    private String lastName;

    public Student() {
    }

    public Student(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
