package oppasignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Student {
    private String studentID, fullName, major;
    private Date dateOfBirth;
    private float GPA;
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
    
    String getStudentID() {
        return studentID;
    }
    
    String getFullName() {
        return studentID;
    }
}
