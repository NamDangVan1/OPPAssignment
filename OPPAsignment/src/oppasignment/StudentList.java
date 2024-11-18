package oppasignment;

import java.util.ArrayList;
import java.util.Scanner;

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
            if (studentList.get(i).getStudentID().equals(IDToFind)){
                return studentList.get(i);
            }
        }
        System.out.println("Wrong ID.");
        return null;
    }
    
    boolean deleteStudentByID(String IDToDelete) {
        for (int i = 0; i < studentList.size(); i++ ){
            if (studentList.get(i).getStudentID().equals(IDToDelete)){
                System.out.println(studentList.remove(i).getFullName() + " has been Deleted");
                return true;
            }
        }
        System.out.println("Wrong ID.");
        return false;
    }
    
    boolean editStudentByID(String IDToEdit){
        for (int i = 0; i < studentList.size(); i++){
            if (studentList.get(i).getStudentID().equals(IDToEdit)){
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