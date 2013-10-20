/*Given an array of integers, every element appears twice except for one. Find that single one.*/
public class Solution {
    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        /*
        XOR each element in the array, the final result is the one that appears only once.
        */
        
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            result ^= A[i];
        }
        return result;
    }
}
