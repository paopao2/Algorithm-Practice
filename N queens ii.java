public class Solution {
    int count;
    public int totalNQueens(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        count = 0;
        helper(0, new int[n]);
        return count;
    }
    
    public void helper(int cur, int[] row) {
        if (cur == row.length) {
            count++;
            return;
        }
        
        for (int i = 0; i < row.length; i++) {
            boolean ok = true;
            row[cur] = i;
            for (int j = 0; j < cur; j++) {
                if (row[cur] == row[j] || row[cur] - row[j] == cur - j || row[cur] - row[j] == j - cur) {
                    ok = false;
                    break;
                }
            }
            if (ok) helper(cur + 1, row);
        }
    }
}