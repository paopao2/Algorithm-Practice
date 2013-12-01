/*
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
*/

public class Solution {
    public boolean isNumber(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (s == null || s.equals("")) return false;
        boolean canSign = true;
        boolean canE = false;
        boolean haveE = false;
        boolean canDot = true;
        boolean onlySpace = false;
        boolean haveNum = false;
        boolean numBegin = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                //space is allowed in the beginning when num doesn't begin
                if (numBegin) onlySpace = true;
                continue;
            } else if (onlySpace) {
                //space is allowed at the end of the string. if space is not followed by space, return false
                return false;
            }
            
            if (c == '+' || c == '-') {
                if (!canSign) return false;
                canSign = false;
                numBegin = true;
            } else if (c == 'e') {
                if (!canE) return false;
                canE = false;
                haveNum = false;
                numBegin = true;
                canSign = true;
                haveE = true;
                canDot = false;
            } else if (c == '.') {
                if (!canDot) return false;
                canDot = false;
                numBegin = true;
                canSign = false;
            } else if (c >= '0' && c <= '9') {
                haveNum = true;
                numBegin = true;
                canSign = false;
                if (!haveE) canE = true;
            } else {
                return false;
            }
        }
        return haveNum;
    }
}