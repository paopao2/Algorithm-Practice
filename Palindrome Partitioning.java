/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
*/

public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (s == null || s.length() == 0) {
            return new ArrayList<ArrayList<String>>();
        }
        
        int length = s.length();
        
        boolean[][] isPal = new boolean[length][length];
        
        for (int i = 0; i < length; i++) {
            isPal[i][i] = true;
        }
        
        for (int i = length - 2; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPal[i][i + 1] = true;
            }
            for (int j = i + 2; j < length; j++) {
                isPal[i][j] = isPal[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
            }
            
        }
        
        return partitionHelper(s, 0, isPal);
    }
    
    //recursively backtrack the palindrome list from startindex to the end
    public ArrayList<ArrayList<String>> partitionHelper(String s, int index, boolean[][] isPal) {
        
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if (index == s.length()) {
            result.add(new ArrayList<String>());
            return result;
        }
        
        for (int i = index; i < s.length(); i++) {
            if (isPal[index][i]) {
                for (ArrayList<String> temp : partitionHelper(s, i + 1, isPal)) {
                    temp.add(0, s.substring(index, i + 1));
                    result.add(temp);
                }
            }
        }
        
        return result;
        
    }
    
}