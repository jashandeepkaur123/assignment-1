class Node {
    Student data;
    Node next; 

    public Node(Student student) {
        data = student;
        next = null;
    }
}

class Student {
    String name;
    int id;
    int grade;

    public Student(String name, int id, int grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }
}

class LinkedList {
    Node head; 

    public void addStudent(Student student) {
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void displayStudents() {
        Node current = head;
        while (current != null) {
            Student student = current.data;
            System.out.println("Name: " + student.name);
            System.out.println("ID: " + student.id);
            System.out.println("Grade: " + student.grade);
            System.out.println("----------------------");
            current = current.next;
        }
    }
}

public class student_objects{
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addStudent(new Student("Student 1", 1234, 97));
        ll.addStudent(new Student("Student 2", 1235, 95));
        ll.addStudent(new Student("Student 3", 1236, 98));
        ll.addStudent(new Student("Student 4", 1237, 92));

        ll.displayStudents();
    }
}