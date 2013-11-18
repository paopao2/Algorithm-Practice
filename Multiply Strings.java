/*
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
*/

public class Solution {
    public String multiply(String num1, String num2) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (num1 == null || num2 == null) return null;
        int length1 = num1.length();
        int length2 = num2.length();
        
        int[] result = new int[length1 + length2];
        for (int i = 0; i < length1; i++) {
            int a = num1.charAt(length1 - i - 1) - '0';
            int carry = 0;
            for (int j = 0; j < length2; j++) {
                int b = num2.charAt(length2 - j - 1) - '0';
                result[i + j] += a * b + carry;
                carry = result[i + j] / 10;
                result[i + j] %= 10;
            }
            result[i + length2] += carry;
        }
        
        StringBuilder s = new StringBuilder();
        for (int i = length1 + length2 - 1; i >= 0; i--) {
            if (i != 0 && result[i] == 0 && s.length() == 0) continue;
            s.append(result[i]);
        }
        return s.toString();
    }
}
