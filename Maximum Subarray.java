/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

public class Solution {
    public int maxSubArray(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int length = A.length;
        int[] maxSoFar = new int[length];
        
        int max = A[0];
        maxSoFar[0] = A[0];
        
        for (int i = 1; i < length; i++) {
            
            if (maxSoFar[i - 1] > 0) {
                maxSoFar[i] = maxSoFar[i - 1] + A[i];
            } else {
                maxSoFar[i] = A[i];
            }
            
            if (maxSoFar[i] > max) {
                max = maxSoFar[i];
            }

        }
        
        return max;
    }
}

public class Solution {
    public int maxSubArray(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.

        return maxSubArrayHelper(0, A.length - 1, A);
    }
    
    public int maxSubArrayHelper(int start, int end, int[]A) {
        if (start > end) {
            return Integer.MIN_VALUE;
        }
        if (start == end) {
            return A[start];
        }
        
        int mid = (start + end)/2;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        
        //count contiguously
        for(int i = mid - 1, curSum = 0; i >= 0; i--) {
            curSum += A[i];
            leftMax = Math.max(leftMax, curSum);
        }
        
        for (int i = mid + 1, curSum = 0; i <= end; i++) {
            curSum += A[i];
            rightMax = Math.max(rightMax, curSum);
        }
        
        int midMax = A[mid] + Math.max(leftMax, 0) + Math.max(rightMax, 0);
        
        return Math.max(Math.max(maxSubArrayHelper(start, mid - 1, A), maxSubArrayHelper(mid + 1, end, A)), midMax);
    }
}