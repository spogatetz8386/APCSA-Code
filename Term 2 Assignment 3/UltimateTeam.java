import java.util.*;
import java.io.*;

public class UltimateTeam{
  private ArrayList<UltimatePlayer> players;
  private ArrayList<Coach> coaches;
  
  public UltimateTeam(ArrayList<UltimatePlayer> players, ArrayList<Coach> coaches){
    this.players = players;
    this.coaches = coaches;
  }
  
  public String getCutters(){
    StringBuilder temp = new StringBuilder();
    for(UltimatePlayer player : this.players){
      if(player.getPosition().equals("cutter")){
        temp.append(player.toString() + "\n");
      }
    }
    return temp.toString();
  }
  
  public String getHandlers(){
    StringBuilder temp = new StringBuilder();
    for(UltimatePlayer player : this.players){
      if(player.getPosition().equals("handler")){
        temp.append(player.toString() + "\n");
      }
    }
    return temp.toString();
  }
  
  public String toString(){
    StringBuilder temp = new StringBuilder();
    temp.append("COACHES\n");
    for(Coach coach : this.coaches){
      temp.append(coach.toString() + "\n");
    }
    temp.append("\nPLAYERS\n");
    for(UltimatePlayer player : this.players){
      temp.append(player.toString() + "\n");
    }
    return temp.toString();
  }
}