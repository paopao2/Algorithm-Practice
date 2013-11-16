/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/

/*
Count[i] = Count[i-1]  if S[i-1] is a valid char
       or   = Count[i-1]+ Count[i-2]  if S[i-1] and S[i-2] together is still a valid char.

*/
public class Solution {
    public int numDecodings(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (s == null || s.length() == 0) return 0;
        int length = s.length();
        int[] count = new int[length + 1];
        count[0] = 1;
        if (s.charAt(0) != '0') count[1] = 1;
        else return 0;
        
        
        for (int i = 2; i <= length; i++) {
            if (s.charAt(i - 1) != '0') {
                int value = Integer.parseInt(s.substring(i - 2, i));
                if (value > 10 && value <= 26) {
                    count[i] = count[i - 2] + count[i - 1];
                } else {
                    count[i] = count[i - 1];
                }
            } else {
                if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2') {
                    count[i] = count[i - 2];
                } else {
                    return 0;
                }
            }
        }
        return count[length];
        
    }
}