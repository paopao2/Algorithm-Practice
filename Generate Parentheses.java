/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/

public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (n == 0) {
            return new ArrayList<String>();
        }
        return helper(n, 0, 0, new StringBuilder());
    }
    
    public ArrayList<String> helper(int n, int l, int r, StringBuilder s) {
        ArrayList<String> result = new ArrayList<String>();
        
        if (l > n || r > n) {
            return result;
        }
        
        if (r == n) {
            result.add(s.toString());
        }
        
        if (l < n) {
            StringBuilder ss = new StringBuilder(s);
            ss.append("(");
            result.addAll(helper(n, l + 1, r, ss));
        }
        
        if (r < l) {
            StringBuilder ss = new StringBuilder(s);
            ss.append(")");
            result.addAll(helper(n, l, r + 1, ss));
        }
        
        return result;
    }
}

/
public class Solution2 {
    public ArrayList<String> generateParenthesis(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<String> result = new ArrayList<String>();
        if (n == 0) {
            return result;
        }
        
        helper(n, 0, 0, "", result);
        return result;
    }
    
    public void helper(int n, int l, int r, String s, ArrayList<String> result) {
        if (l == n) {
            while (r < n) {
                s += ")";
                r++;
            }
            result.add(s);
            return;
        }
        
        if (l < n) {
            helper(n, l + 1, r, s+"(", result);
        }
        if (r < l) {
            helper(n, l, r + 1, s+")", result);
        }
    }
}