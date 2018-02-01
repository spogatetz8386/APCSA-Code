import java.util.*;
import java.io.*;

class Coach extends Person{
  private String role;
  
  public Coach(String firstName, String lastName, String role){
    super(firstName, lastName);
    this.role = role;
  }
  
  public String getRole(){
    return this.role;
  }
  
  public String toString(){
    return super.toString() + "\n   Role: " + this.role;
  }
}