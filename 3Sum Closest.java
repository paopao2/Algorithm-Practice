/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(num.length < 3)
            return 0;
        
        Arrays.sort(num);
        int res = num[0] + num[1] + num[2];
        for(int i = 0; i < num.length; i++) {
            int start = i + 1;
            int end = num.length - 1;
            while(start < end) {
                int temp = num[i] + num[start] + num[end];
                if(temp == target) {
                    return temp;
                }
                
                if(Math.abs(temp - target) < Math.abs(res - target)) {
                    res = temp;
                }
                
                if(temp < target)
                    start++;
                else
                    end--;
            }
        }
        return res;
    }
}