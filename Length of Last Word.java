/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
*/

public class Solution {
    public int lengthOfLastWord(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // if(s == null || s.equals("")) {
        //     return 0;
        // }
        
        // String[] words = s.split(" ");
        // int lastWordIndex = words.length - 1;
        // return words[lastWordIndex].length();
        int p = s.length()-1;
        int len=0;
        boolean trailing=true;
        while (p >= 0) {
            if (s.charAt(p) != ' ') {
                len ++;
                trailing=false;
                p --;
            } else if (trailing) {
                p--;
            } else {
                break;
            }
        }
        return len;

    }
}