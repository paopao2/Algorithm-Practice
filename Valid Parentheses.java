/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

public class Solution {
    public boolean isValid(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        HashMap<Character, Character> parenthese = new HashMap<Character, Character>();
        parenthese.put(')', '(');
        parenthese.put('}', '{');
        parenthese.put(']', '[');
        
        ArrayList<Character> toBeClosed = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!parenthese.containsKey(cur)) {
                toBeClosed.add(cur);
            } else {
                if (toBeClosed.isEmpty()) {
                    return false;
                } else {
                    int length = toBeClosed.size();
                    if (toBeClosed.get(length - 1) == parenthese.get(cur)) {
                        toBeClosed.remove(length - 1);
                    } else {
                        return false;
                    }
                }
            }
        }
        
        if (toBeClosed.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}