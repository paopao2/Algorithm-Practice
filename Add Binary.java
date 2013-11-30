/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/

public class Solution {
    public String addBinary(String a, String b) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (a == null || a.equals("")) return b;
        if (b == null || b.equals("")) return a;
        
        int length1 = a.length() - 1;
        int length2 = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(length1 >= 0 || length2 >= 0 || carry != 0) {
            char a1,b1;
            if (length1 < 0) a1 = '0';
            else a1 =  a.charAt(length1);
            if (length2 < 0) b1 = '0';
            else b1 = b.charAt(length2);
            int sum = (int) (a1 - '0' + b1 - '0' + carry);
            carry = sum / 2;
            sb.insert(0, sum % 2);
            length1--;
            length2--;
        }
        return sb.toString();
    }
}