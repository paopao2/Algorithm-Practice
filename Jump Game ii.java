/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
*/


/*
 * We use "last" to keep track of the maximum distance that has been reached
 * by using the minimum steps "steps", whereas "curr" is the maximum distance
 * that can be reached by using "ret+1" steps. Thus,
 * curr = max(i+A[i]) where 0 <= i <= last.
 */

public class Solution {
    public int jump(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int last = 0;
        int curr = 0;
        int steps = 0;
        
        for (int i = 0; i < A.length; i++) {
            
            if (i > last) {
                last = curr;
                steps++;
            }
            if (last >= A.length - 1) {
                break;
            }
            curr = Math.max(curr, A[i] + i);
        }
        return steps;
    }
}