/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

public class Solution {
    public int[][] generateMatrix(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int[][] result = new int[n][n];
        if (n == 0) {
            return result;
        }
        return placement(0, 0, result, 1, n);
    }
    
    public int[][] placement(int row, int col, int[][] m, int number, int length) {
        
        while (number < length*length) {
            m[row][col] = number;
            //first right
        while (col < length - 1 && m[row][col + 1] == 0) {
            m[row][col++] = number++;
        }
        
        //down
        while (row < length - 1 && m[row + 1][col] == 0) {
            m[row++][col] = number++;
            
        }
        
        //left
        while (col > 0 && m[row][col - 1] == 0) {
            m[row][col--] = number++;
        }
        
        //up
        while (row > 0 && m[row - 1][col] == 0) {
            m[row--][col] = number++;
        }
        }
        m[row][col] = number;
        return m;
        
    }
}