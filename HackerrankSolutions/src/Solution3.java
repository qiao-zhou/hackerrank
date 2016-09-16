import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution3 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        
        LinkedList<Integer> ll = new LinkedList<>();
        String s = sc.nextLine();
        String[] s_arr = s.split(" ");
        for(String str: s_arr){
            ll.add(Integer.valueOf(str));
        }
        
        
        Iterator<Integer> iter = ll.descendingIterator();
        
        
        for(int i=1; i<=n;i++){
            if(i==n){
                if(iter.hasNext()){
                    System.out.println(iter.next());
                }else{
                    System.out.println("NIL");
                    break;
                }
            }else{
                if(iter.hasNext()){
                    iter.next();
                }                
            }
        }
    }
}