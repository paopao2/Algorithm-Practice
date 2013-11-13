/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/


//BFS, can't pass large set, time limit exceeds
public class Solution {
    
    public boolean canJump(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        Stack<Integer> stack = new Stack<Integer>();
        HashSet<Integer> visited = new HashSet<Integer>();

        stack.push(0);
        visited.add(0);

        while (!stack.isEmpty()) {
            int index = stack.pop();
            int maxJump = A[index];
            if (index + maxJump >= A.length - 1) {
	            return true;
            }
            for (int i = 1; i <= maxJump; i++) {
	            if (!visited.contains(index + i)) {
	                visited.add(index + i);
	                stack.push(index + i);
                }
            }
        }
                
        return false;
    }
}

//brilliant solution
//use coverage to track how far you can try
public class Solution {
    
    public boolean canJump(int[] A) {

        int coverage = 0;
        for(int i = 0; i < A.length && i <= coverage; i++)
            coverage = Math.max(coverage, A[i] + i);
        return coverage >= A.length - 1;
    }

}