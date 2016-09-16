import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution5 {

public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int valueToSearch = in.nextInt();
    int size = in.nextInt();
    int ar[] = new int[size];
    for(int i = 0 ; i < size; i++){
        ar[i] = in.nextInt();;
    }
    for(int i =0; i<size;i++){
        if(ar[i]== valueToSearch){
            System.out.println(i);
        }
    }
  }
}