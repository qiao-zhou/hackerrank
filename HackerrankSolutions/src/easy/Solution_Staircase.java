/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easy;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 *
 * @author Zhou Qiao
 */
public class Solution_Staircase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        for(int i=0; i < n; i++){
            //num space: n-i-1
            //num #: i+1
            for(int j=0; j < n-i-1; j++){
                System.out.print(" ");
            }
            for(int j=0; j < i+1; j++){
                System.out.print("#");
            }
            
            System.out.println();
        }
    }
    
}
