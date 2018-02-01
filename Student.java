import java.lang.*;
import java.util.*;

public class Student{
     String first;
     String last;
     int gradeLevel;
     double gpa;
     int id;
     static int nextId;
     
     public Student(){
          this("None", "None", 0, 0);
     }
     
     public Student(String first, String last, int grade, double gpa){
          this.nextId += 1;
          this.first = first;
          this.last = last;
          this.setGrade(grade);
          this.setGpa(gpa);
          this.id = nextId;
     }
     
     public void setGrade(int grade){
          this.gradeLevel = 0;
          if(grade >= 0 && grade <= 12){
               this.gradeLevel = grade;
          }
     }
     
     public void setGpa(double gpa){
          this.gpa = 0;
          if(gpa >= 0 && gpa <= 4.5){
               this.gpa = gpa;
          }
     }
     
     public String toString(){
          return this.last + ", " + this.first + "\nGPA: " + this.gpa + "\nGrade Level: " + this.gradeLevel + " id # " + this.id;
     }
}