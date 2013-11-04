/*
Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
*/

public class Solution {
    public boolean isScramble(String s1, String s2) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return isScrambleHelper(s1, s2);
    }
    //have to check it recursively, understand scramble doesn't equal permutation.
    public boolean isScrambleHelper(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        
        int size = s1.length();
        if (size == 0) {
            return true;
        } 
       
            char[] tmp1 = s1.toCharArray();
            char[] tmp2 = s2.toCharArray();
            Arrays.sort(tmp1);
            Arrays.sort(tmp2);
            if (!Arrays.equals(tmp1, tmp2)) {
                return false;
            }
            
        
        for (int i = 1; i < size; i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i);
            
            if (isScrambleHelper(s11, s21) && isScrambleHelper(s12, s22)) {
                return true;
            }
            
            s21 = s2.substring(size - i);
            s22 = s2.substring(0, size - i);
            
            if (isScrambleHelper(s11, s21) && isScrambleHelper(s12, s22)) {
                return true;
            }
        }
        return false;
    }
    
}