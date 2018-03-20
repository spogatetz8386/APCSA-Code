import java.util.*;
import java.io.*;

class Lesson_15_Activity{
     public static void main(String[] args){
          String[] list = {"d", "z", "b", "a"};
          Lesson_15_Activity.sortAndPrint(list);
     }
     
     public static void sortAndPrint(String[] list){
          for(int i = 0;i < list.length;i++){
               int pos = i;
               for(int j = i;j < list.length;j++){
                    if(list[j].compareTo(list[i]) < 0){
                         pos = j;
                    }
               }
               Lesson_15_Activity.swap(list, i, pos);
          }
          for(int i = 0;i < list.length;i++){
               System.out.print(list[i] + " ");
          }
     }
     
     public static void swap(String[] array, int first, int second){
          String temp = array[second];
          array[second] = array[first];
          array[first] = temp;
     }
}