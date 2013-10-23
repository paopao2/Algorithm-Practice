/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        
        boolean found = false;
        
        int low = 0, high = rowLength * columnLength;
        
        
        while(low <= high) {
            int cur = (low + high)/2;
            int row = cur / columnLength;
            int column = cur % columnLength;
            if(row > rowLength - 1 || column > columnLength - 1) {
                break;
            }
            if(matrix[row][column] == target) {
                found = true;
                break;
            }
            else if(matrix[row][column] > target) {
                high = cur - 1;
            }
            else {
                low = cur + 1;
            }
        }
        
        return found;
    }
}