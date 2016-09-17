/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Zhou Qiao
 */
public class NikitaAndTheGame {
    public static void main(String[] args){
    /*
    Input: 
    10
    42
    0 2 0 2 0 0 0 0 2 0 0 2 2 0 2 2 2 2 0 0 0 2 0 0 2 2 2 2 2 2 0 0 0 0 2 0 2 0 2 0 2 2
    24
    2 0 0 2 2 0 0 0 0 2 0 2 0 2 0 2 0 0 0 2 0 0 2 0
    64
    999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994 999999994
    70
    1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
    103
    4096 4096 1024 256 256 128 128 128 128 512 512 512 512 256 256 512 512 128 32 32 32 32 128 128 1024 1024 2048 512 512 1024 2048 2048 1024 512 512 2048 2048 2048 16384 16384 2048 256 128 128 512 256 256 512 2048 1024 1024 512 512 1024 1024 1024 2048 512 512 1024 4096 4096 4096 2048 2048 4096 2048 2048 2048 1024 512 256 16 16 32 64 128 2048 512 512 512 512 8192 8192 32768 32768 65536 16384 8192 4096 4096 16384 16384 32768 8192 8192 16384 65536 16384 16384 16384 8192 8192
    77
    2097152 1048576 1048576 2097152 1048576 262144 262144 524288 1048576 1048576 1048576 1048576 2097152 2097152 1048576 524288 524288 2097152 524288 524288 524288 524288 2097152 524288 262144 262144 524288 131072 131072 131072 131072 262144 65536 65536 32768 32768 65536 262144 262144 1048576 1048576 1048576 262144 262144 524288 524288 131072 65536 65536 32768 32768 65536 32768 32768 65536 2097152 2097152 131072 65536 65536 131072 131072 262144 65536 65536 131072 1048576 2097152 2097152 2097152 4194304 2097152 524288 524288 1048576 4194304 8388608
    8
    16384 8192 8192 16384 8192 8192 32768 32768
    11
    8760958 8760957 547560 547560 547560 273780 273780 2190239 4380479 4380479 4380478
    15
    21211 21211 21211 21211 21211 21211 21211 21211 21211 21211 21211 21211 21211 21211 21211
    55
    0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0    
        
    Expected output:
    0
    0
    6
    2
    15
    11
    4
    1
    0
    54        
    */
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        //solve for all T queries
        for(int i = 0; i < T;i++){
            // load up the array
            int n = scanner.nextInt();
            long[] arr = new long[n];
            for(int j = 0; j < n; j++){
                arr[j] = scanner.nextInt();
            }

            System.out.println(getMaxScore(arr));
        }
    }    
    
    public static long getMaxScore(long[] arr){
        //if arr is empty or has only one element, return 0
        if(arr.length == 1 || arr.length ==0)
            return 0;
        long total = sum(arr);
        
        if(total == 0){
            return arr.length - 1;
        }
        
        if(total % 2 == 1) return 0;
        total /=2;
        
        long sum_so_far = 0;
        int pivot = -1;
        for(int i=0; i<arr.length;i++){
            sum_so_far+= arr[i];
            if(sum_so_far == total){
                pivot = i;
                break;
            }
        }
        if(pivot==-1) return 0;
        long[] left_arr = Arrays.copyOfRange(arr, 0, pivot+1);
        long[] right_arr = Arrays.copyOfRange(arr,pivot+1,arr.length);
        //use recursion
        return 1+ Math.max(getMaxScore(left_arr), getMaxScore(right_arr));
        
    }
    
    //compute array sum of integers 
    public static long sum(long[] arr){
        long sum = 0;
        for(long ele: arr){
            sum+= ele;
        }
        return sum;
    }

}
