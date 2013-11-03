/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

public class Solution {
    public boolean exist(char[][] board, String word) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int rowLength = board.length;
        int colLength = board[0].length;
        
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (existsHelper(board, i, j, word.substring(1))) {
                        return true;
                    }
                }  
            }
        }
        
        return false;
        
    }
    
    public boolean existsHelper(char[][] board, int r, int c, String word) {
        
        if (word.length() == 0) {
            return true;
        }
        
        //left
        if (c > 0 && board[r][c - 1] == word.charAt(0)) {
            char cur = board[r][c];
            board[r][c] = '*';
            if (existsHelper(board, r, c - 1, word.substring(1))) {
                return true;
            }
            board[r][c] = cur;
        }
        
        //up
        if (r > 0 && board[r - 1][c] == word.charAt(0)) {
            char cur = board[r][c];
            board[r][c] = '*';
            if (existsHelper(board, r - 1, c, word.substring(1))) {
                return true;
            }
            board[r][c] = cur;
        }
        
        //down
        if (r < board.length - 1 && board[r + 1][c] == word.charAt(0)) {
            char cur = board[r][c];
            board[r][c] = '*';
            if (existsHelper(board, r + 1, c, word.substring(1))) {
                return true;
            }
            board[r][c] = cur;
        }
        
        //right
        if (c < board[0].length - 1 && board[r][c + 1] == word.charAt(0)) {
            char cur = board[r][c];
            board[r][c] = '*';
            if (existsHelper(board, r, c + 1, word.substring(1))) {
                return true;
            }
            board[r][c] = cur;
        }
        
        return false;
    }
}