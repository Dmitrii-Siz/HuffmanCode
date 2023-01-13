import java.util.Arrays;
import java.util.Scanner;//to work with a scanner
import java.util.ArrayList;//ArrayList to store each student

public class StudentMain {
    public static void main(String[] args) {


        //array of all the students:
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Bert Smith", "computing", 21, "12345", true));
        students.add(new Student("Olivia Green", "computing", 19, "23464", true));
        students.add(new Student("Eloise Jones", "computing", 18, "34744", true));
        students.add(new Student("Ben Bird", "computing", 42, "34834", false));
        students.add(new Student("Karen Brown", "computing", 25, "45632", false));

        //adding grades to the students:
        //Bert's Grades
        Student.grades.add(new Grade("programing", 52.00));
        Student.grades.add(new Grade("web dev", 63.00));
        Student.grades.add(new Grade("maths", 76.00));
        Student.grades.add(new Grade("algorithms", 68.00));

        //Olivia's Grades:
        Student.grades.add(new Grade("programing", 73.00));
        Student.grades.add(new Grade("web dev", 82.00));
        Student.grades.add(new Grade("maths", 72.00));
        Student.grades.add(new Grade("algorithms", 66.00));

        //Eloise's Grades:
        Student.grades.add(new Grade("programing", 65.00));
        Student.grades.add(new Grade("web dev", 63.00));
        Student.grades.add(new Grade("maths", 37.00));
        Student.grades.add(new Grade("algorithms", 40.00));

        //Ben's Grades:
        Student.grades.add(new Grade("programing", 55.00));
        Student.grades.add(new Grade("web dev", 29.00));
        Student.grades.add(new Grade("maths", 56.00));
        Student.grades.add(new Grade("algorithms", 38.00));

        //Karen's Grades:
        Student.grades.add(new Grade("programing", 62.00));
        Student.grades.add(new Grade("web dev", 51.00));
        Student.grades.add(new Grade("maths", 43.00));
        Student.grades.add(new Grade("algorithms", 43.00));

        //Menu system, infinite loop until program exits
        while(true) {
            Scanner in = new Scanner(System.in);//keyboard input
            System.out.println("Enter 1 To: Print out a report of all students including lettered grades for " +
                    "each module score ");
            System.out.println("Enter 2: To Print the name of all students with a failed module");
            System.out.println("Enter 3: To Print out average grade for each student");
            System.out.println("Enter 4: To Add a new student to the system taking in name, department, age, student" +
                    "number and a grade for each of the four modules.");
            System.out.println("Enter 5: To quit the program");

            int choice = in.nextInt();//user input

            //Menu system code
            if (choice == 5){
                System.exit(0);
            }
            else if(choice == 4){
                //get all the required inputs:
                System.out.println("Please Enter your full name:");
                String name = in.next()+" "+in.next();
                System.out.println("Please Enter your department:");
                String department = in.next();
                System.out.println("Please Enter your age:");
                int age = in.nextInt();
                System.out.println("Please Enter your student number:");
                String studentNumber = in.next();

                //array to temporarily store the grades for each module for the new student
                ArrayList<Double> newGrades = new ArrayList<Double>();
                //grades obtained for each module:
                for(int i = 0; i < 4; i++){
                    System.out.println("Enter your grade for " + Student.grades.get(i).getSubject());
                    double grade = in.nextDouble();
                    newGrades.add(grade);
                }
                //adds a new Student
                students.add(new Student(name, department, age, studentNumber, true));
                for(int i = 0; i < 4; i++){
                    //adds the grades to the new student created
                    Student.grades.add(new Grade(Student.grades.get(i).getSubject(), newGrades.get(i)));
                }

            }
            //prints the average grade for each student
            else if(choice == 3){
                //array to store the average grades
                ArrayList<Double> averageGrades = new ArrayList<Double>();
                int count = 0;//everytime it hits 4 it resets
                double Total = 0;//total is initiated
                //adds up all the grades
                for(int i = 0; i < Student.grades.size(); i++){
                    //adds up all the scores
                    Total = Total + Student.grades.get(i).getScore();
                    count++;
                    if(count == 4){
                        count = 0;
                        averageGrades.add(Total);
                        Total = 0;
                    }
                }
                //Displays the average grades:
                for(int i = 0; i < students.size(); i++) {
                    System.out.println(students.get(i).getName() + " Has an Average Grade of " + averageGrades.get(i) / 4);

                }
            }
            //prints the students that have failed the module
            else if(choice == 2){
                for(int i = 0; i < Student.grades.size(); i++){
                    //if the grade is found to be F
                    if(Grade.getLetterGrade(Student.grades.get(i).getScore()) == 'F'){
             //the system returns the name of the person who failed the module and which module they failed
                        System.out.println(students.get((int)i/4).getName() + " " + Student.grades.get(i).getSubject());
                    }
                }
            }
            //prints a list of all students
            else if(choice == 1){
                for(int i = 0; i < Student.grades.size(); i++)
                {
                    //prints the first student in the student array
                    if(i == 0){
                        System.out.println(students.get(0));
                    }
                    //prints the grades for each student
                    else if(i%4 == 0){
                        System.out.println(students.get(i/4));
                    }
                    System.out.println(Student.grades.get(i));//prints the grades
                }
            }

        }


    }
}