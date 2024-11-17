package oppasignment;

import java.util.*;
import java.text.*;

class Student {
    String studentID, fullName, major;
    Date dateOfBirth;
    float GPA;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Scanner sc = new Scanner( System.in );
    void enterStudentInfo() {
        System.out.print("Student ID: ");
        studentID = sc.next();
        sc.nextLine();
        System.out.print("Full name: ");
        fullName = sc.nextLine();
        System.out.print("Major: ");
        major = sc.nextLine();
        System.out.print("Date of birth (dd/MM/yyyy) : ");
        String date = sc.nextLine();
        try{
            dateOfBirth = sdf.parse(date);
        }catch (ParseException e) {       
            System.out.println("Error: " + e.getMessage());
        }
        System.out.print("GPA: ");
        GPA = sc.nextFloat();
        
    }
    void displayStudentInfo() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Full name: " + fullName);
        System.out.println("Major: " + major);
        System.out.println("Date of birth (dd/MM/yyyy) : " + sdf.format(dateOfBirth));
        System.out.println("GPA: " + GPA);
    }
}

class StudentList {
    ArrayList<Student> studentList = new ArrayList<>();
    Scanner sc = new Scanner( System.in );
    void enterStudentList() {
        System.out.print("How many student you want enter: ");
        int n = sc.nextInt();
        for ( int i = 0; i < n; i++ ){
            System.out.println("Student " + (i + 1));
            Student a = new Student();
            a.enterStudentInfo();
            studentList.add(a);
        }
    }
    void displayAllStudents(){
        for (int i = 0; i < studentList.size(); i++ ) {
            System.out.println("Student " + (i + 1));
            studentList.get(i).displayStudentInfo();
        }
    }
    
    Student findStudentByID(String IDToFind) {
        for (int i = 0; i < studentList.size(); i++ ){
            if (studentList.get(i).studentID.equals(IDToFind)){
                return studentList.get(i);
            }
        }
        System.out.println("Wrong ID.");
        return null;
    }
    
    boolean deleteStudentByID(String IDToDelete) {
        for (int i = 0; i < studentList.size(); i++ ){
            if (studentList.get(i).studentID.equals(IDToDelete)){
                System.out.println(studentList.remove(i).fullName + " has been Deleted");
                return true;
            }
        }
        System.out.println("Wrong ID.");
        return false;
    }
    
    boolean editStudentByID(String IDToEdit){
        for (int i = 0; i < studentList.size(); i++){
            if (studentList.get(i).studentID.equals(IDToEdit)){
                Student a = new Student();
                a.enterStudentInfo();
                studentList.set(i, a);
                System.out.println("Student has been update.");
                return true;
            }
        }
        System.out.println("Wrong ID.");
        return false;
    }
}

class Processor {
    int a;
    StudentList studentList = new StudentList(); 
    Scanner sc = new Scanner( System.in );
    void menu() {
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
            }
            
        }while(a != 6);
    }
}



public class OPPAsignment {
    public static void main(String[] args) {
       Processor main = new Processor();
       main.menu();
    }
    
}
