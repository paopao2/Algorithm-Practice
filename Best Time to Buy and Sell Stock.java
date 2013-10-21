/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/

public class Solution {
    public int maxProfit(int[] prices) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int min = 0;
        int maxDiff = 0;
        for(int sell = 1; sell < prices.length; sell++) {
            if(prices[sell] < prices[min]) {
                min = sell;
                continue;
            }
            
            int temp = prices[sell] - prices[min];
            if(temp > maxDiff) {
                maxDiff = temp;
            }
        }
        
        return maxDiff;
    }
}