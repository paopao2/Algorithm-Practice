/*
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/

public class Solution {
    public String longestPalindrome(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int length = s.length();
        if (length == 0 || length == 1) {
            return s;
        }
        if (length == 2 && s.charAt(0) == s.charAt(1)) {
            return s;
        }
        int max = 0;
        int start = 0;
        int end = 1;
        boolean[][] isPal = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            isPal[i][i] = true;
        }
        for (int i = 0; i < length - 1; i++) {
            isPal[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (max < 2 && isPal[i][i + 1]) {
                max = 2;
                start = i;
                end = i + 2;
            }
        }
        
        for (int i = length - 3; i >= 0; i--) {
            for (int j = i + 2; j < length; j++) {
                isPal[i][j] = isPal[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                if (isPal[i][j] && (j - i >= max)) {
                    max = j - i;
                    start = i;
                    end = j + 1;
                }
            }
        }
        return s.substring(start, end);
        
    }
}