/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

public class Solution {
    public int maxProfit(int[] prices) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean bought = false;
        int profit = 0;
        
        if(prices.length == 0||prices.length == 1) {
            return 0;
        }
        
        for(int i = 0; i < prices.length - 1; i++) {
            if(!bought) {
                if(prices[i] <= min) {
                    min = prices[i];
                    if(prices[i+1] > min) {
                        bought = true;
                        profit -= min;
                    }
                }
                
            }
            else {
                if(prices[i] >= max) {
                    max = prices[i];
                    if(prices[i+1] < max) {
                        bought = false;
                        profit += max;
                        min = Integer.MAX_VALUE;
                        max = Integer.MIN_VALUE;
                    }
                }
                
            }
        }
        if(bought) {
            max = prices[prices.length - 1];
            profit += max;
        }
        
        return profit;
    }
}