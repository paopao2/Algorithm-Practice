/*
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
*/

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int length1 = s1.length();
        int length2 = s2.length();
        int length3 = s3.length();
        if (length1 + length2 != length3) {
            return false;
        }
        boolean[][] isInter = new boolean[length1 + 1][length2 + 1];
        isInter[0][0] = true;
        for (int i = 1; i <= length1; i++) {
            isInter[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1);
            if (!isInter[i][0]) break;
        }
        for (int j = 1; j <= length2; j++) {
            isInter[0][j] = s2.charAt(j - 1) == s3.charAt(j - 1);
            if (!isInter[0][j]) break;
        }
        int k = 0;
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                k = i + j - 1;
                isInter[i][j] = (isInter[i][j - 1] && s3.charAt(k) == s2.charAt(j - 1)) || (isInter[i - 1][j] && s3.charAt(k) == s1.charAt(i - 1));
            }
        }
        return isInter[length1][length2];

    }
}