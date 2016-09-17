package algorithm.search;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * https://www.hackerrank.com/challenges/sherlock-and-array
 * @author Zhou Qiao
 */
public class SherlockandArray {
/*
    Input: 
2
3
1 2 3
4
1 2 3 3    
    Output: 
NO
YES    
*/ 
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        
        for(int i = 0; i < m; i++){
            int N = scanner.nextInt();
            //int[] arr = new int[N];
            int[] arr_cumsum = new int[N];
            for(int j = 0; j < N; j++){
                int num = scanner.nextInt();
                //arr[j] = scanner.nextInt();
                if(j==0){
                    arr_cumsum[j] = num;
                }else{
                    arr_cumsum[j] = arr_cumsum[j-1] + num;
                }
            }
            //
            boolean found = false;
            for(int j=0; j < N; j++){
                if(j==0){
                    if(arr_cumsum[arr_cumsum.length-1]-arr_cumsum[0] == 0){
                        found = true; 
                        break;
                    }
                    continue;
                }
                int leftSum = arr_cumsum[j-1];
                int num = arr_cumsum[j] - arr_cumsum[j-1];
                int rightSum = arr_cumsum[arr_cumsum.length-1]-leftSum - num;
                
                if(leftSum == rightSum){
                    found = true;  
                    break;
                }
            }
            if(found){
                System.out.println("YES");  
            }else{
                System.out.println("NO");  
            }
        }
    }
}
