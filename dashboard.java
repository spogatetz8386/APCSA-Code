import java.lang.*;
import java.util.*;

class Dashboard{
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
     
     public String toString(){
          return "Speedometer: " + this.getSpeed() + " MPH\nOdometer: " + this.getMiles() + "\nCheck Engine: " + this.getEngine();
     }
}