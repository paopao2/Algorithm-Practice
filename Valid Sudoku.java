/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.
*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int rowLength = board.length;
        int columnLength = board[0].length;
        
        if (rowLength != 9 || columnLength != 9) {
            return false;
        }
        
        int row = 0;
        //check rows
        while (row < rowLength) {
            boolean[] nums = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[row][j] == '.') {
                } else {
                    int number = board[row][j] - '1';
                    if (nums[number] == true) {
                        return false;
                    } else {
                        nums[number] = true;
                    }
                }
                
            }
            row++;
        }
        //check columns
        int col = 0;
        while (col < columnLength) {
            boolean[] nums = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[j][col] == '.') {
                } else {
                    int number = board[j][col] - '1';
                    if (nums[number] == true) {
                        return false;
                    } else {
                        nums[number] = true;
                    }
                }
                
            }
            col++;
        }
        
        //check square
        for (row = 0; row < 9; row += 3) {
            for (col = 0; col < 9; col += 3) {
                boolean[] nums = new boolean[9];
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        if (board[i][j] == '.') {
                            
                        } else {
                            int number = board[i][j] - '1';
                            if (nums[number] == true) {
                                return false;
                            } else {
                                nums[number] = true;
                            }
                        }
                        
                    }
                }
            }
        }
        
        return true;
    }
}