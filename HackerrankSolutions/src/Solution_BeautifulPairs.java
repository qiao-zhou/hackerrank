import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution_BeautifulPairs {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        /*
        3
        1 2 2
        1 2 3        
        */
       Scanner scanner = new Scanner(System.in);
       int n = scanner.nextInt();
       int[] A = new int[n];
       int[] B = new int[n];
       for(int i = 0; i< n; i++){
           A[i] = scanner.nextInt();
       }
       for(int i = 0; i< n; i++){
           B[i] = scanner.nextInt();
       }       
       
       
       //for each element in A, find a match in B; 
       //If total match is k==n, then return k-1 (since we have to alter one element in B)
       //If total match is k<n, then return k+1
       int numPairs = 0;
       //boolean[] paired_A = new boolean[n];
       boolean[] paired_B = new boolean[n];
       for(int i=0; i< n;i++){
           for(int j=0; j<n; j++){
               if(!paired_B[j] && A[i]== B[j]){
                   paired_B[j] = true;
                   numPairs++;
                   break;
               }
           }
       }
       
       if(numPairs==n){
           System.out.println(numPairs-1);
       }else{
           System.out.println(numPairs+1);
       }
    }
}
