import java.util.*;
import java.io.*;

public class UltimatePlayer extends Person{
  private static int nextNumber = 1;
  private int jerseyNumber;
  private String position; //handler or cutter
  
  UltimatePlayer(String firstName, String lastName, String position){
    super(firstName, lastName);
    this.setPosition(position);
    this.setJerseyNumber();
  }
  
  public void setPosition(String pos){
    if(pos.equals("cutter")){
      this.position = pos;
    } else {
      this.position = "handler";
    }
  }
  
  public void setJerseyNumber(){
    this.jerseyNumber = this.nextNumber;
    this.nextNumber += 1;
  }
  
  public String getPosition(){
    return this.position;
  }
  
  public int getNumber(){
    return this.jerseyNumber;
  }
  
  public String toString(){
    return super.toString() + "\n   Jersey #: " + this.getNumber() + "\n   Position: " + this.getPosition();
  }
}