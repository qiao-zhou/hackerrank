import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution4 {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line);       
        line = br.readLine();
                
        List<Integer> list = new ArrayList<>();
        
        
        
        //LinkedList<Integer> ll = new LinkedList<>();
        //String s = sc.nextLine();
        String[] s_arr = line.split(" ");
        for(String str: s_arr){
            list.add(Integer.valueOf(str));
        }
        
        int len = list.size();
        if(len-n>=0){
            System.out.println(list.get(len-n));
        }else{
            System.out.println("NIL");
        }
    }
}