/*
Divide two integers without using multiplication, division and mod operator.
*/

public class Solution {
    public int divide(int dividend, int divisor) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        boolean negative = false;
        //check if negative
        if (dividend == 0) {
            return 0;
        } 
        if ((dividend < 0 && divisor > 0) ||(dividend > 0 && divisor < 0)) {
            negative = true;
        }
        
        if (divisor == 1 || divisor == -1) {
            return negative? (0 - Math.abs(dividend)) : Math.abs(dividend);
        }
        
        long dividend1 = Math.abs((long)dividend);
        long divisor1 = Math.abs((long)divisor);
        
        long remainder = dividend1;
        int result = 0;
        
        while (remainder >= divisor1) {
            for (int i = 1; i * divisor1 <= remainder; i = i*2) {
                remainder = remainder - i * divisor1;
                result += i;
            }
            
        }
        
        return negative? (0 - result) : result;
        
    }
}