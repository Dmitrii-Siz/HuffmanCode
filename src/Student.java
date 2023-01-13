//library required to add an ArrayList
import java.util.ArrayList;
public class Student {

    //private properties:
    private String name;
    private String department;
    private int age;
    private String userName;
    private String studentNumber;
    private boolean fullTime;


    //constructor:
    public Student(String name, String department, int age, String studentNumber, boolean fullTime) {
        this.name = name;
        this.department = department;
        this.age = age;
        this.studentNumber = studentNumber;
        this.fullTime = fullTime;
        this.userName = (name.substring(0,1)+(name.split(" ")[1]).substring(0,4)+studentNumber.substring(0,3)).toLowerCase();

    }

    //getters and setters:
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public boolean isFullTime() {
        return fullTime;
    }

    public void setFullTime(boolean fullTime) {
        this.fullTime = fullTime;
    }

    //array List with the type Grade:

    public static ArrayList<Grade> grades = new ArrayList<Grade>();

    @Override
    public String toString() {
        return "Student: " + name + " " + department + " " + age + " " + userName + " " + studentNumber;
    }

    //to add:
    //grades.add(new Grade(subject, score));//subject and score are just variables you can pass
}
