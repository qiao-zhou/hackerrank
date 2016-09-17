package algorithms.dynamic_programming;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaximumSubArray {

    public static void main(String[] args) {
        /*
        2 
        4 
        1 2 3 4
        6
        2 -1 2 3 4 -5        
        */
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        
        for(int i =0; i < m; i++){
            int n=scanner.nextInt();
            int[] arr = new int[n];
            for(int j=0;j< n;j++){
                arr[j] = scanner.nextInt();
            }

            System.out.println(findMaxSubArrayContiguous(arr) + " " + findMaxSubArrayNoncontiguous(arr));            
        }

        
    }
    
    public static int findMaxSubArrayNoncontiguous(int[] arr){
        //If has at least a positive number, return sum of them
        //If no positive number, return the maximum non-positive number
        int sum = 0;
        
        boolean hasElement = false;
        boolean hasNeg = false;
        int maxNonPos = 0;
        
        for(int i=0; i < arr.length;i++){
            int num = arr[i];
            if(num>0){
               sum+= num; 
               hasElement= true;
            }else{
                if(!hasNeg){
                    maxNonPos = num;
                    hasNeg = true;
                }else{
                    maxNonPos = (num>maxNonPos)?num: maxNonPos;
                }
            }
            //sum += (num>0)? num:0;
        }
        //if still no element, add the maximum negative number or 0
        if(!hasElement){
            return maxNonPos;
        }
        
        return sum;
    }
    
    public static int findMaxSubArrayContiguous(int[] arr){
        //Empty subarrays/subsequences should not be considered.
        int max_so_far = arr[0];
        int max_till_now =arr[0];
        for(int i = 1; i < arr.length; i++){
            int num = arr[i];
            max_till_now = Math.max(num, max_till_now+num);
            max_so_far = Math.max(max_so_far, max_till_now);
        }
        return max_so_far;
    }
}