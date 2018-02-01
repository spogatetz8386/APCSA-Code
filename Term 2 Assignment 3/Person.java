import java.util.*;
import java.io.*;

public class Person{
  private String firstName;
  private String lastName;
  
  Person(String firstName, String lastName){
    this.setFirst(firstName);
    this.setLast(lastName);
  }
  
  public void setFirst(String first){
    this.firstName = first;
  }
  
  public void setLast(String last){
    this.lastName = last;
  }
  
  public String getFirst(){
    return this.firstName;
  }
  
  public String getLast(){
    return this.lastName;
  }
  
  public String toString(){
    return this.getLast() + ", " + this.getFirst();
  }
}