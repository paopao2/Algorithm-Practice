/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
*/
public class Solution {
    public int maxArea(int[] height) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int max = 0;
        int length = height.length;
        
        //O(N2) exceeds time limit
        // for(int i = 0; i < length - 1; i++) {
        //     int leftHeight = height[i];
        //     for (int j = i + 1; j < length; j++) {
        //         int rightHeight = height[j];
        //         int width = j - i;
        //         int area = width * Math.min(rightHeight, leftHeight);
        //         max = Math.max(max, area);
        //     }
        // }
        // return max;
        
        
        //O(N)
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            max = Math.max(max, Math.min(rightHeight, leftHeight) * (right - left));
            if (leftHeight < rightHeight) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}