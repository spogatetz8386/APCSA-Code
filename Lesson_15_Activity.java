import java.util.*;
import java.io.*;

class Lesson_15_Activity{
     public static void main(String[] args){
          String[] list = {"d", "z", "b", "a"};
          Lesson_15_Activity.sortAndPrint(list);
     }
     
     public static void sortAndPrint(String[] list){
          for(int i = 0;i < list.length;i++){
               int current = i;
               int lowest = i;
               for(int j = i;j < list.length;j++){
                    if(list[j].compareTo(list[lowest]) < 0){
                         lowest = j;
                    }
               }
               String temp = list[current];
               list[current] = list[lowest];
               list[lowest] = temp;
          }
          for(int i = 0;i < list.length;i++){
               System.out.print(list[i] + " ");
          }
     }
     
}