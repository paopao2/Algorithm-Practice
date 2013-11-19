/*
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
*/

public class Solution {
    public int firstMissingPositive(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (A.length == 0) return 1;
        
        int n = A.length;
        //find negative and set it to value impossible
        for (int i = 0; i < n; i++) {
            if (A[i] <= 0) A[i] = n + 2;
        }
        
        //if k is present, set A[k - 1] -> negative
        for (int i = 0; i < n; i++) {
            int k = A[i];
            k = Math.abs(k);
            if (k <= n && k > 0) {
                A[k - 1] = -Math.abs(A[k - 1]);
            }
        }
        
        //find the positive value and return
        for (int i = 0; i < n; i++) {
            if (A[i] > 0) return i + 1;
        }
        
        return n + 1;
    }
}