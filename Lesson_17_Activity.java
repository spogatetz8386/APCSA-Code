import java.util.*;
import java.io.*;

class Lesson_17_Activity{
  public static boolean isSorted(int[] a){
    for(int i = 0;i < a.length - 1;i++){
      if(a[i] > a[i + 1]){
      	return false;
      }
    }
    return true;
  }
  
  public static int binarySearch(int[] a, int b){
    int low = 0;;
    int high = a.length - 1;
    while(high >= low){
      int middle = (low + high) / 2;
      if(a[middle] == b){
      	return middle;
      }
      if(a[middle] > b){
      	high = middle - 1;
      }
      if(a[middle] < b){
      	low = middle + 1;
      }
     
    }
    return -1;
  }
}