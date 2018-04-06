import java.io.*;
import java.util.*;

public class TeamMember{
   public String fullName;
   public String idString;

   public TeamMember(String name, String id){
       idString = id;
       fullName = toTitleCase(name);
   }

   public static void main(String[] args){
       System.out.println(toTitleCase("hello my name is scott"));
       System.out.println(toTitleCase("hello my\tname is scott"));
   }

   public static String toTitleCase(String input){
       StringBuilder titleCase = new StringBuilder();
       boolean caps = true;
       titleCase.append(Character.toUpperCase(input.charAt(0)));
       for(int i = 1; i < input.length(); i++){
           caps = false;
           if(input.charAt(i - 1) == ' ' || (Character.toString(input.charAt(i - 1)).equals("\t"))){
                caps = true;
           }
           if(caps){
                titleCase.append(Character.toUpperCase(input.charAt(i)));
           } else {
                titleCase.append(Character.toLowerCase(input.charAt(i)));
           }
       }
       return titleCase.toString();
   }

   public String getId(){
       return this.idString;
   }

   public int compareTo(TeamMember other){
       String otherStr = other.getId();
       String str = this.getId();
       if(str.compareTo(otherStr) < 0){
            return -1;
       }
       if(str.compareTo(otherStr) > 0){
           return 1;
       }
       return 0;
   }

   public String toString(){
       return this.fullName;
   }
}