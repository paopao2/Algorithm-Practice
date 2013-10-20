/*
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region .

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
*/

public class Solution {
    public void solve(char[][] board) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(board == null || board.length == 0) 
            return;
        
        int rowLength = board.length;
        int columnLength = board[0].length;
        
        for (int i = 0; i < rowLength; i++) {
            bfs(i, 0, board);
            bfs(i, columnLength - 1, board);
        }
        
        for (int j = 1; j < columnLength; j++) {
            bfs(0, j, board);
            bfs(rowLength - 1, j, board);
        }
        
        for(int i = 0; i < rowLength; i++) {
            for(int j = 0; j < columnLength; j++) {
                if(board[i][j] == '+') {
                    board[i][j] = 'O';
                }
                else if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    public void bfs(int i, int j, char[][] board) {
        Queue<Integer> q = new LinkedList<Integer>();
        visit(i, j, q, board);
        
        int rowLength = board.length;
        int columnLength = board[0].length;
        
        while(!q.isEmpty()) {
            int r = q.poll();
            int col = r % columnLength;
            int row = r / columnLength;
            
            visit(row, col - 1, q, board);
            visit(row, col + 1, q, board);
            visit(row - 1, col, q, board);
            visit(row + 1, col, q, board);
        }
        
    }
    
    public void visit(int i, int j, Queue<Integer> q, char[][] board) {
        int rowLength = board.length;
        int columnLength = board[0].length;
        if(i < 0 || i >= rowLength || j < 0 || j >= columnLength || board[i][j] == 'X')
            return;
        if(board[i][j] == 'O') {
            board[i][j] = '+';
            q.offer(i*columnLength + j);
            return;
        }
    }
}