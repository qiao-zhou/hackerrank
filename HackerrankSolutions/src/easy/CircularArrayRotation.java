package easy;


/**
 * https://www.hackerrank.com/challenges/circular-array-rotation?h_r=next-challenge&h_v=zen
 * @author Zhou Qiao
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CircularArrayRotation {
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        /*
        Sample Input: 
        3 2 3
        1 2 3
        0
        1
        2        
        */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int q = scanner.nextInt();
        
        
        int[] arr = new int[n];
        for(int i=0; i < n;i++){
           arr[i] = scanner.nextInt();
        }
        
        for(int i=0; i < q; i++){
            int idx = scanner.nextInt();
            //find the number in the index=idx after performing rotation k times
            
            //rotate n times will result in the same array, thus we just need to care about the module %n
            int k_effective = k%n;
            if(idx-k_effective>=0){
                System.out.println(arr[idx-k_effective]);
            }else{
                System.out.println(arr[n-k_effective+idx]);
            }
            
        }
    }    
}
