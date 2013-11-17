/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].
*/

public class Solution {
    public int removeDuplicates(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (A.length == 0) return 0;
        if (A.length == 1) return 1;
        int pre = Integer.MAX_VALUE;
        int writeSeq = 1;
        for (int readSeq = 1; readSeq < A.length; readSeq++) {
            if (A[readSeq] != A[readSeq - 1]) {
                A[writeSeq++] = A[readSeq];
            } else {
                if (pre != A[readSeq]) {
                    pre = A[readSeq];
                    A[writeSeq++] = A[readSeq];
                }
            }
        }
        return writeSeq;
    }
}