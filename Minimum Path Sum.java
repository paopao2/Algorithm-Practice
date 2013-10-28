/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/

public class Solution {
    public int minPathSum(int[][] grid) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int rowLength = grid.length;
        if (rowLength == 0) {
            return 0;
        }
        int colLength = grid[0].length;
        int[][] sum = new int[rowLength][colLength];
        sum = grid.clone();
        
        //initialize the first row and first column
        for (int i = 1; i < colLength; i++) {
        	sum[0][i] += sum[0][i - 1];
        }
        for (int i = 1; i < rowLength; i++) {
        	sum[i][0] += sum[i - 1][0];
        }
        
        //build the rest using the base columns and rows
        for (int i = 1; i < rowLength; i++) {
        	for (int j = 1; j < colLength; j++) {
        		int left = sum[i][j - 1];
        		int up = sum[i - 1][j];
        		
        		int preSum = left < up ? left : up;
        		sum[i][j] += preSum;
        	}
        }
        return sum[rowLength - 1][colLength - 1];
    }
}