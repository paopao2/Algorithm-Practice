/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/

public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<String> result = new ArrayList<String>();
        if (s == null || s.equals("")) return result;
        helper(s, 0, 0, new StringBuilder(), result);
        return result;
    }
    public void helper(String s, int index, int k, StringBuilder sb, ArrayList<String> result) {
        if (index == s.length() && k == 4) {
            result.add(sb.toString());
            return;
        }
        
        if (s.length() - index > (4 - k) * 3) return;
        if (s.length() - index < 4 - k) return;
        
        int num = 0;
        for (int i = index; i < index + 3 && i < s.length(); i++) {
            num = num * 10 + s.charAt(i) - '0';
            if (num <= 255) {
                StringBuilder cur = new StringBuilder(sb);
                if (cur.length() == 0) cur.append(num);
                else {
                    cur.append(".");
                    cur.append(num);
                }
                
                helper(s, i + 1, k + 1, cur, result);
            }
            if (num == 0) break;
        }
    }
}