/*
Given a number represented as an array of digits, plus one to the number.
*/

public class Solution {
    public int[] plusOne(int[] digits) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int length = digits.length;
        int carry = 0;
        digits[length - 1] += 1;
        for (int i = length - 1; i >= 0; i--) {
            digits[i] += carry;
            carry = 0;
            if (digits[i] >= 10) {
                digits[i] -= 10;
                carry = 1;
            }
        }
        if (carry == 1) {
            int[] result = new int[length + 1];
            result[0] = 1;
            for (int i = 1; i < length + 1; i++) {
                result[i] = digits[i - 1];
            }
            return result;
        }
        return digits;
    }
}