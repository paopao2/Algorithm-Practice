public class Solution {
    public int uniquePaths(int m, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        //recursive, exceeds time limit
        // if (m < 0 || n < 0) {
        //     return 0;
        // } else if (m == 0 && n == 0) {
        //     return 1;
        // } else {
        //     return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
        // }
        
        //math approach
        //in total m + n steps, choose m out of m + n
        double result = 1;
        int bigger = Math.max(m - 1, n - 1);
        for (int i = m + n - 2; i > bigger; i--) {
            result = result * i / (i - bigger);
        }
        return (int) (result + 0.5);
    }
}