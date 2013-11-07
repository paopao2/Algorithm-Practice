/*
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
*/

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        
        int[][] path = new int[row][col];
        
        //initialize
        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            path[i][0] = 1;
        }
        
        for (int j = 0; j < col; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            path[0][j] = 1;
        }
        
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    path[i][j] = 0;
                } else {
                    path[i][j] = path[i - 1][j] + path[i][j - 1];
                }
                
            }
        }
        return path[row - 1][col - 1];
    }
}