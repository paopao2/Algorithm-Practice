/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.

*/

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if (matrix.length == 0) {
            return 0;
        }
        
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int[] L = new int[colLength];
        int[] R = new int[colLength];
        int[] H = new int[colLength];
        
        for (int j = 0; j < colLength; j++) {
            R[j] = colLength;
        }
        
        int area = 0;
        
        for (int i = 0; i < rowLength; i++) {
            int left = 0;
            int right = colLength;
            
            //from left to right
            for (int j = 0; j < colLength; j++) {
                if (matrix[i][j] == '1') {
                    H[j]++;
                    L[j] = Math.max(L[j], left);
                } else {
                    H[j] = 0;
                    L[j] = 0;
                    R[j] = colLength;
                    left = j + 1;
                }
            }
            
            for (int j = colLength - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    R[j] = Math.min(R[j], right);
                    area = Math.max(area, H[j]*(R[j] - L[j]));
                } else {
                    right = j;
                }
            }
            
        }
        return area;
    }
}