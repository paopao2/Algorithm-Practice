/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/

public class Solution {
    public boolean isPalindrome(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (s == null || s.length() == 0) {
            return true;
        }
        
        StringBuilder sanitizedString = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            
            char cur = s.charAt(i);
            
            if ((cur >= 'a' && cur <= 'z') || (cur >= '0' && cur <= '9')) {
                sanitizedString.append(cur);
            }
            
            if (cur >= 'A' && cur <= 'Z') {
                cur = Character.toLowerCase(cur);
                sanitizedString.append(cur);
            }
            
        }
        
        int size = sanitizedString.length();
        for (int i = 0; i < size/2; i++) {
            if (sanitizedString.charAt(i) != sanitizedString.charAt(size - i - 1)) {
                return false; 
            }
        }
        
        return true;
    }
}