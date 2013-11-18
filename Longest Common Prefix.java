/*
Write a function to find the longest common prefix string amongst an array of strings. 
*/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (strs.length == 0) return "";
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < strs[0].length()) {
            char c = strs[0].charAt(i);
            for (String s : strs) {
                if (i >= s.length() || s.charAt(i) != c) return result.toString();
            }
            result.append(c);
            i++;
        }
        return result.toString();
    }
}
