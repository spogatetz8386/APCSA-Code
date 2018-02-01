import java.util.*;
import java.io.*;

class Captain extends UltimatePlayer{
  private boolean type;
  
  public Captain(String firstName, String lastName, String position, boolean type){
    super(firstName, lastName, position);
    this.type = type;
  }
  
  public String getType(){
    if(this.type){
      return "offense";
    }
    return "defense";
  }
  
  public String toString(){
    return super.toString() + "\n   Captain: " + this.getType();
  }
}