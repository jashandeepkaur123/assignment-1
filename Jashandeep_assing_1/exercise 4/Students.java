import java.util.LinkedList;



class Student {

    String name;

    float grade;



    public Student(String name, float grade) {

        this.name = name;

        this.grade = grade;

    }



    public String getName() {

        return name;

    }



    public float getGrade() {

        return grade;

    }

}



public class Students {

    public static void main(String[] args) {

        LinkedList<Student> studentList = new LinkedList<>();



        // Create three student objects

        Student student1 = new Student("John", 80.5f);

        Student student2 = new Student("Alice", 90.2f);

        Student student3 = new Student("Bob", 75.8f);



        // Add the students to the linked list

        studentList.add(student1);

        studentList.add(student2);

        studentList.add(student3);



        float gradeThreshold = 80.0f;

        LinkedList<Student> studentsAboveThreshold = retrieveStudents(studentList, gradeThreshold);



        System.out.println("Students with grades above " + gradeThreshold + ":");

        for (Student student : studentsAboveThreshold) {

            System.out.println("Name: " + student.getName() + ", Grade: " + student.getGrade());

        }

    }



    public static LinkedList<Student> retrieveStudents(LinkedList<Student> studentList, float gradeThreshold) {

        LinkedList<Student> studentsAboveThreshold = new LinkedList<>();



        for (Student student : studentList) {

            if (student.getGrade() > gradeThreshold) {

                studentsAboveThreshold.add(student);

            }

        }

        return studentsAboveThreshold;

    }

}