import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        ArrayList<TeamMember> team = new ArrayList<TeamMember>();
        String input = "";
        while(!input.toUpperCase().equals("STOP")){
            String name;
            String id;
            System.out.println("Enter the next name: ");
            input = scan.nextLine();
            if(input.toUpperCase().equals("STOP")){
                break;
            }
            name = input;
            System.out.println("Enter the next ID: ");
            input = scan.nextLine();
            if(input.toUpperCase().equals("STOP")){
                break;
            }
            id = input;
            team.add(new TeamMember(name, id));
            
        }
        sortArray(team);
        System.out.println(team);
    }
    
    public static void sortArray(ArrayList<TeamMember> input){
         for(int i = 1; i < input.size();i++){
              int j = i - 1;
              TeamMember key = input.get(i);
              while(j >= 0 && input.get(j).compareTo(key) > 0){
                   input.set(j + 1, input.get(j));
                   j -= 1;
              }
              
              input.set(j + 1, key);
         }
    }
}