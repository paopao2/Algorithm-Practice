/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

public class Solution {
    public String convert(String s, int nRows) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int size = 2 * nRows - 2;
        if (nRows >= s.length() || nRows == 1) {
            return s;
        }
        String result = "";
        
        for (int i = 0; i < nRows; i++) {
            for (int j = i; j < s.length(); j += size) {
                result += s.charAt(j);
                if (i != 0 && i != nRows - 1) {
                    int mid = j + (size - i) - i;
                    if (mid < s.length()) {
                        result += s.charAt(mid);
                    }
                    
                }
            }
        }
        return result;
    }
}