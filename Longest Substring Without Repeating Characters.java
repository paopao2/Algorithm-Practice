/*
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int maxLength = 0;
        
        for(int i = 0; i < s.length(); i++) {
            HashSet<Character> chars = new HashSet<Character>();
            chars.add(s.charAt(i));
            int j = i + 1;
            while(j < s.length()) {
                if(chars.contains(s.charAt(j))) {
                    break;
                }
                else {
                    chars.add(s.charAt(j));
                    j++;
                }
            }
            if(chars.size() > maxLength) {
                maxLength = chars.size();
            }
        }
        
        return maxLength;
    }
}