/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/

public class Solution {
    public int climbStairs(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // if (n < 0) {
        //     return 0;
        // }
        // else if (n == 0) {
        //     return 1;
        // }
        // else {
        //     return climbStairs(n - 1) + climbStairs(n - 2);
        // }
        int[] c = new int[n + 1];
        return climbStairsHelper(n, c);
    }
    
    public static int climbStairsHelper(int n, int[] count) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (count[n] != 0) {
            return count[n];
        } else {
            count[n] = climbStairsHelper(n - 1, count) + climbStairsHelper(n - 2, count); 
            return count[n];
        }
    }
}