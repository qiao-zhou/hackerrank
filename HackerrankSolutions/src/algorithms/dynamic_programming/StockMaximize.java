package algorithms.dynamic_programming;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/stockmax
 * @author Zhou Qiao
 */
public class StockMaximize {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        for (int i = 0; i < size; i++) {
            int numOfDays = scanner.nextInt();
            int[] prices = new int[numOfDays];
            for (int j = 0; j < numOfDays; j++) {
                prices[j] = scanner.nextInt();
            }
            System.out.println(maximizeProfit(prices));
        }
    }
    
    public static long maximizeProfit(int[] prices){
        /**
         * We loop backward from the end of the price series and keep updating the current 
         * maximum price. As long as the current price is below the maxPriceSoFar, we should buy and sell till 
         * the day when maxPriceSoFar is realized. The difference between maxPriceSoFar and currPrice will be 
         * the profit realized for this trade. 
         */
        long profit = 0;
        long maxPriceSoFar = 0;
        
        for(int i = prices.length-1;i>=0;i--){
            int currPrice = prices[i];
            if(currPrice>maxPriceSoFar){
                maxPriceSoFar = currPrice;
            }
            
            profit+= maxPriceSoFar - currPrice;
        }
        return profit;
    }
  
}
