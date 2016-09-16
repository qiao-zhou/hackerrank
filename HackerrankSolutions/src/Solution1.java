import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);      
        System.out.println(fibo(N));
    }
    
    public static int fibo(int n){
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }else{
            return fibo(n-1) + fibo(n-2);
        }
        
    }
    
}