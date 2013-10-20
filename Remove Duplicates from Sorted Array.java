/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].
*/

public class Solution {
    public int removeDuplicates(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        if(A.length == 0)
            return 0;
        else if(A.length == 1)
            return 1;
        else {
            int writeSeq = 0;
            for(int readSeq = 1; readSeq < A.length; readSeq++) {
                if(A[readSeq - 1] != A[readSeq]) {
                    A[++writeSeq] = A[readSeq];
                }
            }
            return writeSeq + 1;
        }
        
    }
}