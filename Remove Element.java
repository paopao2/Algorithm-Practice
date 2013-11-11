/*
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/

public class Solution {
    public int removeElement(int[] A, int elem) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (A.length == 0) {
            return 0;
        }
        int readSeq;
        int writeSeq = 0;
        for (readSeq = 0; readSeq < A.length; readSeq++) {
            if (A[readSeq] != elem) {
                A[writeSeq] = A[readSeq];
                writeSeq++;
            }
        }
        return writeSeq;
    }
}