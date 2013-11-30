/*
http://oj.leetcode.com/problems/sudoku-solver/
Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.


A sudoku puzzle...


...and its solution numbers marked in red.
*/

public class Solution {
    public void solveSudoku(char[][] board) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        solveSudokuHelper(board);
    }
    
    public boolean solveSudokuHelper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int k = 0; k < 9; k++) {
                        board[i][j] = (char) ('1' + k);
                        if (isValid(board, i, j) && solveSudokuHelper(board)) return true;
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isValid(char[][] board, int row, int col) {
        char c = board[row][col];
        
        //check row
        for (int j = 0; j < 9; j++) {
            if (j == col) continue;
            if (board[row][j] == c) return false;
        }
        
        //check column
        for (int i = 0; i < 9; i++) {
            if (i == row) continue;
            if (board[i][col] == c) return false;
        }
        
        //check square
        int baseRow = row / 3;
        int baseCol = col / 3;
        for (int i = baseRow * 3; i < baseRow * 3 + 3; i++) {
            for (int j = baseCol * 3; j < baseCol * 3 + 3; j++) {
                if (i == row && j == col) continue;
                if (board[i][j] == c) return false;
            }
        }
        return true;
    }
}