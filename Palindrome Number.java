/*
Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
*/

public class Solution {
    public boolean isPalindrome(int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // if (x < 0) {
        //     x = 0 - x;
        // }
        
        if (x < 0) {
            return false;
        }
        
        int divide = 1;
        while (x / divide >= 10) {
            divide *= 10;
        }
        
        while (x > 9) {
            int firstDigit = x / divide;
            int lastDigit = x % 10;
            
            if (firstDigit != lastDigit) {
                return false;
            }
            
            x = x % divide / 10;
            divide /= 100;
        }
        
        return true;
    }
}