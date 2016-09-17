import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution_IceCreamParlor {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//    2
//    4
//    5
//    1 4 5 3 2
//    4
//    4
//    2 2 4 3       
       Scanner scanner = new Scanner(System.in);
       int n = scanner.nextInt();
       
       for(int i=0; i<n;i++){
           int sum= scanner.nextInt();
           int l = scanner.nextInt();
           int[] arr = new int[l];
           for(int j = 0; j < arr.length;j++){
               arr[j] = scanner.nextInt();
           }
           
           for(int j = 0; j < l-1;j++){
               for(int k = j+1; k < l;k++){
                   if(arr[j] + arr[k] ==sum){
                       System.out.println(i + " " + j);
                   }
               }
           }
           
       }
    }
}