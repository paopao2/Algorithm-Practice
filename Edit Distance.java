/*
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
*/

/*
At the first glance, we might think this is a DFS problem, but if we see it is hard to find a quick DFS thought and the problem requires some optimal result (here is the minimum), DP is a good direction to consider.
Actually this is a classic DP problem:
The state is:   table[i][j]=minimum number steps convert word1[1:i] to word2[1:j] (here assume string starts from 1).

The optimal function is:  table[i+1][j+1] = min [table[i-1][j-1]+1 or 0 (+1 if word1[i+1]==word2[j+1], else +0),   table[i][j+1]+1, table[i+1][j]+1 ].

Initialization:
table[0][i] = i  i=1:|word1|          here 0 means "", any string convert to "" needs the length of string
table[j][0] = j  i=1:|word2|
table[0][0]=0    "" convert to  "" need 0 steps.
*/

public class Solution {
    public int minDistance(String word1, String word2) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int length1 = word1.length();
        int length2 = word2.length();
        
        if (length1 == 0 || length2 == 0) {
            return length1 > length2? length1 : length2;
        }
        
        int[][] dis = new int[length1 + 1][length2 + 1];
        
        for (int i = 1; i <= length1; i++) {
            dis[i][0] = i;
        }
        for (int j = 1; j <= length2; j++) {
            dis[0][j] = j;
        }
        
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dis[i][j] = min(dis[i - 1][j - 1], dis[i - 1][j] + 1, dis[i][j - 1] + 1);
                } else {
                    dis[i][j] = min(dis[i - 1][j - 1] + 1, dis[i - 1][j] + 1, dis[i][j - 1] + 1);
                }
            }
        }
        return dis[length1][length2];
    }
    
    public int min(int a, int b, int c) {
        int temp = Math.min(a, b);
        return Math.min(temp, c);
    }
}