import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * https://www.hackerrank.com/challenges/time-conversion?h_r=next-challenge&h_v=zen
 * Sample Input
 * 12:45:54PM
 * Expected Output:
 * 12:45:54
 * @author Zhou Qiao
 */

public class TimeConversion {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String time = in.next();
        
        String[] tokens = time.split(":");
        String hour_str = tokens[0];
        String minute_str = tokens[1];
        String second_str = tokens[2].substring(0, 2);
        String am_pm = tokens[2].substring(2, 4);
        
        if(am_pm.equalsIgnoreCase("PM")){
            int hour_int = Integer.valueOf(hour_str);
            if(hour_int<12){
                hour_int+=12;
            }
            
            hour_str = String.valueOf(hour_int);
        }else if(am_pm.equalsIgnoreCase("AM")){
            if(Integer.valueOf(hour_str)== 12){
                hour_str = "00";
            }
        }
        System.out.println(hour_str + ":" + minute_str + ":" + second_str);
    }
}
