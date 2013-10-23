/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/

public class Solution {
    public void setZeroes(int[][] matrix) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] || column[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

public class Solution2 {
    public void setZeroes(int[][] matrix) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        boolean firstRowHasZero = false;
        boolean firstColumnHasZero = false;
        
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        
        for (int i = 0; i < columnLength; i++) {
            if (matrix[0][i] == 0) {
                firstRowHasZero = true;
            }
        }
        
        for (int j = 0; j < rowLength; j++) {
            if (matrix[j][0] == 0) {
                firstColumnHasZero = true;
            }
        }
        
        for (int i = 1; i < columnLength; i++) {
            for (int j = 1; j < rowLength; j++) {
                if (matrix[j][i] == 0) {
                    matrix[0][i] = 0;
                    matrix[j][0] = 0;
                }
            }
        }
        
        for (int i = 1; i < columnLength; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < rowLength; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        
        for (int j = 1; j < rowLength; j++) {
            if (matrix[j][0] == 0) {
                for (int i = 1; i < columnLength; i++) {
                    matrix[j][i] = 0;
                }
            }
        }
        
        if (firstRowHasZero) {
            for (int i = 0; i < columnLength; i++) {
                matrix[0][i] = 0;
            }
        }
        
        if (firstColumnHasZero) {
            for (int j = 0; j < rowLength; j++) {
                matrix[j][0] = 0;
            }
        }
    }
}