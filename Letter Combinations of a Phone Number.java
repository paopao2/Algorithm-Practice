/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/

public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        char[] digitChars = digits.toCharArray();
        ArrayList<String> result = new ArrayList<String>();
        StringBuilder s = new StringBuilder();
        letterCombinationHelper(0, digitChars, s, result);
        return result;
    }
    
    private char[][] map = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
    
    private void letterCombinationHelper(int index, char[] digits, StringBuilder s, ArrayList<String> result) {
        if (index >= digits.length) {
            result.add(s.toString());
        }
        else {
            int curNum = digits[index] - '1' - 1;
            char[] digitString = map[curNum];
            for (int i = 0; i < digitString.length; i++) {
                s.append(digitString[i]);
                letterCombinationHelper(index + 1, digits, s, result);
                //important
                s.deleteCharAt(s.length() - 1);
            }
        }
    }
}