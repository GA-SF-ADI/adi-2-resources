package gg.patrickcummins.relationshiplab;

/**
 * Created by patrickcummins on 6/30/16.
 */
public class Employee {
    private String ssn;
    private String firstName;
    private String lastName;
    private String birthYear;
    private String city;

    public Employee(String ssn, String firstName, String lastName, String birthYear, String city) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.city = city;
    }

    public String getSsn() {
        return ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getCity() {
        return city;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
