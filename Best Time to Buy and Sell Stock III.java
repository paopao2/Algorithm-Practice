/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/
public class Solution {
    public int maxProfit(int[] prices) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int length = prices.length;
        if (length == 0) {
            return 0;
        }
        int[] historyProfit = new int[length];
        int[] futureProfit = new int[length];
        
        int valley = prices[0];
        int peak = prices[length - 1];
        int max = 0;
        
        for (int i = 1; i < length; i++) {
            if (valley > prices[i]) {
                valley = prices[i];
            }
            historyProfit[i] = Math.max(historyProfit[i - 1], prices[i] - valley);
        }
        
        for (int j = length - 2; j >= 0; j--) {
            if (peak < prices[j]) {
                peak = prices[j];
            }
            futureProfit[j] = Math.max(futureProfit[j + 1], peak - prices[j]);
            max = Math.max(max, futureProfit[j] + historyProfit[j]);
        }
        
        return max;
     }
}