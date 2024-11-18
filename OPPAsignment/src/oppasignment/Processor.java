package oppasignment;

import java.util.*;

public class Processor {
    public static void main(String [] args) {
        int a;
        StudentList studentList = new StudentList(); 
        Scanner sc = new Scanner( System.in );
        do {
            System.out.println("1. Enter student information.");
            System.out.println("2. Display all student.");
            System.out.println("3. Find student by ID.");
            System.out.println("4. Delete student by ID.");
            System.out.println("5. Edit student by ID.");
            System.out.println("6. Exit.");
            System.out.print("Choice the option: ");
            a = sc.nextInt();
            
            switch (a) {
                case 1:
                    studentList.enterStudentList();
                    break;
                case 2:
                    studentList.displayAllStudents();
                    break;
                case 3:
                    System.out.print("Student ID: ");
                    String IDToFind = sc.next();
                    studentList.findStudentByID(IDToFind).displayStudentInfo();
                    break;
                case 4:
                    System.out.print("Student ID: ");
                    String IDToDelete = sc.next();
                    studentList.deleteStudentByID(IDToDelete);
                    break;
                case 5:
                    System.out.print("Student ID: ");
                    String IDToEdit = sc.next();
                    studentList.editStudentByID(IDToEdit);
                    break;
                default:
                    System.out.println("Invalid Option");
            }
            
        }while(a != 6);
    }
}
