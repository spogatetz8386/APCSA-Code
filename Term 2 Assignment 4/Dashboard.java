import java.lang.*;
import java.util.*;

class Dashboard implements Comparable{
     private int odometer;
     private int speedometer;
     private boolean checkEngineLight = false;
     public Dashboard(int milesTravelled, int speed){
          setMiles(milesTravelled);
          setSpeed(speed);
     }
     public Dashboard(){
          this(0, 0);
     }
     
     public void service(){
          this.checkEngineLight = true;
     }
     
     public void setMiles(int miles){
          if(miles >= 0 && miles <= 99999){
               this.odometer = miles;
          } else {
               this.odometer = 0;
               this.checkEngineLight = true;
          }
     }
     
     public String getEngine(){
          if(this.checkEngineLight){
               return "On";
          }
          return "Off";
     }
     
     public String getMiles(){
          String formatted = String.format("%05d", this.odometer);
          return formatted;
     }
     
     public int getNumberMiles(){
          return this.odometer;
     }
     
     public void setSpeed(int speed){
          if(speed >= 0 && speed <= 100){
               this.speedometer = speed;
          } else {
               this.speedometer = 0;
               this.checkEngineLight = true;
          }
     }
     
     public void drive(int numMinutes){
          int distance = (int)((this.getSpeed() / 60.0) * numMinutes);
          this.setMiles(this.getNumberMiles() + distance);
     }
     
     public void accelerate(){
          this.setSpeed(this.getSpeed() + 1);
     }
     
     public int getSpeed(){
          return this.speedometer;
     }
     
     public int getEngineInt(){
          if(checkEngineLight){
               return 1;
          }
          return 0;
     }
     
     public String toString(){
          return "Speedometer: " + this.getSpeed() + " MPH\nOdometer: " + this.getMiles() + "\nCheck Engine: " + this.getEngine();
     }
     
     public int compareTo(Object other){
          Dashboard o = (Dashboard) other;
          if(o.getNumberMiles() == getNumberMiles() && o.getSpeed() == getSpeed() && o.getEngine().equals(getEngine())){
               return 0;
          }
          if(getNumberMiles() > o.getNumberMiles()){
               return 1;
          }
          if(getNumberMiles() < o.getNumberMiles() || getSpeed() < o.getSpeed() || getEngineInt() < o.getEngineInt()){
               return -1;
          }
          return 1;
     }
     
     public String parseRaceResult(Dashboard other, boolean stall1, boolean stall2, int end1, int end2){
          StringBuilder resultText = new StringBuilder();
          if(stall1){
               resultText.append("First car stalled out!");
          }
          if(stall2){
               if(stall1){
                    resultText.append("\n");
               }
               resultText.append("Second car stalled out!");
          }
          if(!stall1 && !stall2){
               resultText.append("\n");
          }
          if(stall1 || stall2){
               resultText.append("\n\n");
          }
          resultText.append(this + "\n\n");
          resultText.append(other + "\n\n");
          if(stall1 && stall2){
               resultText.append("It's a tie!");
          }
          if(!stall1 && !stall2){
               if(getSpeed() == other.getSpeed()){
                    resultText.append("It's a tie!");
               }
               if(getSpeed() > other.getSpeed()){
                    resultText.append("Car 1 has won the race!");
               } 
               if(getSpeed() < other.getSpeed()){
                    resultText.append("Car 2 has won the race!");
               }
          }
          
          if(stall1 && !stall2){
               resultText.append("Car 2 has won the race!");
          }
          if(!stall1 && stall2){
               resultText.append("Car 1 has won the race!");
          }
          return resultText.toString();
     }
     
     public String race(Dashboard other, int acc1, int acc2){
          boolean stall1 = false;
          boolean stall2 = false;
          if((getSpeed() + acc1) > 100){
               stall1 = true;
               service();
               setSpeed(0);
          }
          if((other.getSpeed() + acc2) > 100){
               stall2 = true;
               other.service();
               other.setSpeed(0);
          }
          if(!stall1){
               setSpeed(getSpeed() + acc1);
          }
          if(!stall2){
               other.setSpeed(other.getSpeed() + acc2);
          }
          return parseRaceResult(other, stall1, stall2, getSpeed(), other.getSpeed());
     }
     
     public String difference(Dashboard other){
          int difference = getNumberMiles() - other.getNumberMiles();
          if(difference < 0){
               //car 2 is ahead
               double time = Math.abs(difference) / (getSpeed() * 1.0);
               time *= 60;
               return "First car will need to drive for " + (int)time + " minutes to catch second car.";
          }
          else if (difference > 0){
               //car 1 is ahead
               double time = Math.abs(difference) / (other.getSpeed() * 1.0);
               time *= 60;
               return "Second car will need to drive for " + (int)time + " minutes to catch first car.";
          }
          return "Equal";
     }
}