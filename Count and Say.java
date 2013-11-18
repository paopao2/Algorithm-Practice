/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string. 
*/

public class Solution {
    public String countAndSay(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (n == 0) return "";
        String s = "1";
        if (n == 1) return s;
        
        int count = 1;
        int k = 1;
        while (k < n) {
            StringBuilder cur = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                if(i == s.length() - 1 || s.charAt(i + 1) != s.charAt(i)) {
                    cur.append(count);
                    cur.append(s.charAt(i));
                    count = 1;
                } else {
                    count++;
                }
            }
            s = cur.toString();
            k++;
        }
        
        return s;
    }
}
