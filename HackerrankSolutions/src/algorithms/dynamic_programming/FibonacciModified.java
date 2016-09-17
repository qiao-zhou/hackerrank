package algorithms.dynamic_programming;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FibonacciModified {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named FibonacciModified. */
        Scanner scanner = new Scanner(System.in);
        
        //0 1 5
        int t1 = scanner.nextInt();
        int t2 = scanner.nextInt();
        int n = scanner.nextInt();
        
        BigInteger res = fibo2(t1,t2,n);
        
        System.out.println(res);
    }
    
    public static long fibo1(long t1, long t2, int n){
        long[] fibo = new long[n];
        fibo[0] = t1;//n=1
        fibo[1] = t2;//n=2
        
        for(int i=2; i< n;i++){
            fibo[i] = fibo[i-1]*fibo[i-1] + fibo[i-2];
        }        
        return fibo[n-1];
    }
    
    public static BigInteger fibo2(long t1, long t2, int n){
        BigInteger fn_minus_1 = BigInteger.valueOf(t2);
        BigInteger fn_minus_2 = BigInteger.valueOf(t1);
        BigInteger fn = BigInteger.valueOf(0);
                
        for(int i=2; i<n;i++){ 
            fn = fn_minus_1.multiply(fn_minus_1).add(fn_minus_2);
            fn_minus_2 = fn_minus_1;
            fn_minus_1 = fn;
        }
        
        return fn;
    }
}