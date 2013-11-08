/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut. 
*/

public class Solution {
    public int minCut(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int length = s.length();
        boolean[][] isPal = new boolean[length][length];
        //dp[i] --> how many cuts from s.charAt(i) to the end of s.
        int[] dp = new int[length + 1];
        
        for (int i = 0; i < length - 1; i++) {
            //initial value of dp[i]: each char is palindrome
            dp[i] = length - i - 1;
            isPal[i][i] = true;
            isPal[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }
        isPal[length - 1][length - 1] = true;
        dp[length - 1] = 0;
        dp[length] = -1;
        
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 2; j < length; j++) {
                isPal[i][j] = isPal[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
            }
        }
        
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (isPal[i][j]) {
                    dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                }
            }
        }
        return dp[0];
        
    }
}
