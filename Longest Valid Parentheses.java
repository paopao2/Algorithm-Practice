/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

*/


public class Solution {
    public int longestValidParentheses(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int maxLen = 0;
        
        //the position of the last ')'
        //so when left stack is empty(all matched), use this to calculate the length
        int last = -1;
        
        Stack<Integer> left = new Stack<Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left.push(i);
            } else {
                if (left.isEmpty()) {
                    last = i;
                } else {
                    left.pop();
                    if (left.isEmpty()) {
                        //all matched by now
                        maxLen = Math.max(maxLen, i - last);
                    } else {
                        maxLen = Math.max(maxLen, i - left.peek());
                    }
                }
                
            }
        }
        
        return maxLen;
        
    }
}
Submit Solution
