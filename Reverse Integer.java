/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
*/

public class Solution {
    public int reverse(int x) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        boolean neg = false;
        if(x < 0) {
            neg = true;
        }
        
        String[] numbers = Integer.toString(Math.abs(x)).split("");

        StringBuffer bf = new StringBuffer();
        for (int i = numbers.length - 1; i >= 0 ; i--) {
            bf.append(numbers[i]);
        }
        
        String temp = bf.toString();
        int result = Integer.parseInt(temp);
        
        if(result >= 1073741824)
            return -1;
        else {
            return neg? (0 - result) : result;
        }
    }

    public int reverse2(int x) {
        int result = 0
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }

        return result;
    }
}