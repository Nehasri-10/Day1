import java.util.ArrayList;
import java.util.Scanner;
class Student {
    int id;
    String name;
    double marks;
    Student(int id,String name,double marks) {
        this.id=id;
        this.name=name;
        this.marks=marks;
    }
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
}
public class Day2 {
    ArrayList<Student> stuList=new ArrayList<>();
    Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice=sc.nextInt();
            switch (choice) {
                case 1: addStudent();
                case 2: viewStudents();
                case 3: updateStudent();
                case 4: deleteStudent();
                case 5: System.out.println("Exiting...");
                default: System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }
    static void addStudent() {
        System.out.println("Enter ID: ");
        int id=sc.nextInt();
        System.out.println("Enter Name: ");
        String name=sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks=sc.nextDouble();
        stuList.add(new Student(id, name, marks));
        System.out.println("Student added successfully.");
    }

    static void viewStudents() {
        if (stuList.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            System.out.println("Student List");
            for (Student s : studList) {
                System.out.println(s);
            }
        }
    }
    static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id=sc.nextInt();
        boolean found=false;
        for (Student s : stuList) {
            if (s.id == id) {
                System.out.println("Enter new name: ");
                s.name=sc.nextLine();
                System.out.println("Enter new marks: ");
                s.marks=sc.nextDouble();
                System.out.println("Student updated successfully.");
                found=true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student ID not found.");
        }
    }
    static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id=sc.nextInt();
        boolean removed=stuList.removeIf(s -> s.id == id);
        if (removed) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student ID not found.");
        }
    }
}
