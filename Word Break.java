/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        //TODO: 
        if (s.length() == 0) {
            return true;
        }
        else {
            int i;
            HashSet<String> currentWords = new HashSet<String>();
            for (i = 1; i <= s.length(); i++) {
                String current = s.substring(0, i);
                if (dict.contains(current)) {
                    currentWords.add(current);
                }
            }
            for (String temp : currentWords) {
                String left = s.substring(temp.length());
                if (dict.contains(left)) {
                    return true;
                } else {
                    return wordBreak(left, dict);
                }
            }
            return false;
        }
    }
}