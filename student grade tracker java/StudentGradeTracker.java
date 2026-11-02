
import java.util.ArrayList;
import java.util.Scanner;

// Student Class
class Student {

    String name;
    int marks;

    // Constructor
    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    // Display student details
    void displayDetails() {
        System.out.println("Name: " + name + " | Marks: " + marks);
    }
}

// Main Class
public class StudentGradeTracker {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add Student
    static void addStudent() {

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Name cannot be empty!");
            return;
        }

        int marks = readMarks();

        Student s = new Student(name, marks);

        students.add(s);

        System.out.println("Student added successfully!");
    }

    // Read and validate marks
    static int readMarks() {

        while (true) {

            System.out.print("Enter Marks (0-100): ");

            if (sc.hasNextInt()) {

                int marks = sc.nextInt();
                sc.nextLine();

                if (marks >= 0 && marks <= 100) {
                    return marks;
                }

                System.out.println("Marks must be between 0 and 100!");

            } else {

                System.out.println("Please enter a valid number!");
                sc.nextLine();
            }
        }
    }

    // View All Students
    static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        System.out.println("\n===== STUDENT DETAILS =====");

        for (Student s : students) {
            s.displayDetails();
        }
    }

    // Calculate Average
    static void calculateAverage() {

        if (students.isEmpty()) {
            System.out.println("No student data available!");
            return;
        }

        int total = 0;

        for (Student s : students) {
            total += s.marks;
        }

        double average = (double) total / students.size();

        System.out.println("Average Marks: " + average);
    }

    // Find Highest Marks
    static void findHighest() {

        if (students.isEmpty()) {
            System.out.println("No student data available!");
            return;
        }

        Student highest = students.get(0);

        for (Student s : students) {

            if (s.marks > highest.marks) {
                highest = s;
            }
        }

        System.out.println("Highest Scorer: " + highest.name);
        System.out.println("Highest Marks: " + highest.marks);
    }

    // Find Lowest Marks
    static void findLowest() {

        if (students.isEmpty()) {
            System.out.println("No student data available!");
            return;
        }

        Student lowest = students.get(0);

        for (Student s : students) {

            if (s.marks < lowest.marks) {
                lowest = s;
            }
        }

        System.out.println("Lowest Scorer: " + lowest.name);
        System.out.println("Lowest Marks: " + lowest.marks);
    }

    // Main Method
    public static void main(String[] args) {

        int choice = 0;

        do {

            System.out.println("\n===== STUDENT GRADE TRACKER =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Calculate Average Marks");
            System.out.println("4. Find Highest Marks");
            System.out.println("5. Find Lowest Marks");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid choice!");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    calculateAverage();
                    break;

                case 4:
                    findHighest();
                    break;

                case 5:
                    findLowest();
                    break;

                case 6:
                    System.out.println("Thank you for using Student Grade Tracker!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}
