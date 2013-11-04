public class Solution {
    //for each bar, find the max height bars on its left and right,
    //then it can hold min(leftMax, rightMax) - own height
    public int trap(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case
        
        int water = 0;
        int length = A.length;
        
        if (length == 0) {
            return 0;
        }
        
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];
        
        leftMax[0] = 0;
        rightMax[length - 1] = 0;
        
        for (int i = 1; i < length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], A[i - 1]);
        }
        
        for (int i = length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], A[i + 1]);
        }
        
        for (int i = 1; i < length - 1; i++) {
            int max = Math.min(rightMax[i], leftMax[i]);
            int temp = max - A[i];
            if (temp > 0) {
                water += temp;
            }
        }
        
        return water;
    }
}
