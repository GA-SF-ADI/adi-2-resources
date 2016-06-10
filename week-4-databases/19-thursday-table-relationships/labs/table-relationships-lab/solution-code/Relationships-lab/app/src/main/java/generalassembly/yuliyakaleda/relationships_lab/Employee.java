package generalassembly.yuliyakaleda.relationships_lab;

public class Employee {
  private String ssn;
  private String firstName;
  private String lastName;
  private int year;
  private String city;
  private String company;
  private int salary;
  private int experience;

  public Employee(String ssn, String firstName, String lastName, int year, String city) {
    this.ssn = ssn;
    this.firstName = firstName;
    this.lastName = lastName;
    this.year = year;
    this.city = city;
  }

  public String getSsn() {
    return ssn;
  }

  public void setSsn(String ssn) {
    this.ssn = ssn;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  public int getExperience() {
    return experience;
  }

  public void setExperience(int experince) {
    this.experience = experience;
  }
}

